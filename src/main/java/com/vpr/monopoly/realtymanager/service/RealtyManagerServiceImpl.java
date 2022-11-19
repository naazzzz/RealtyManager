package com.vpr.monopoly.realtymanager.service;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vpr.monopoly.realtymanager.model.ActionDto;
import com.vpr.monopoly.realtymanager.model.PlayerDto;
import com.vpr.monopoly.realtymanager.model.RealtyCardDto;
import com.vpr.monopoly.realtymanager.model.enam.ActionType;
import com.vpr.monopoly.realtymanager.service.client.BankClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@RequiredArgsConstructor
public class RealtyManagerServiceImpl implements RealtyManagerService {
    private final ObjectMapper objectMapper;
    private final RealtyCardService rc;

    private final BankClient bankClient;

    @Override
    public PlayerDto testColorMonopoly(PlayerDto player){
         int yellow=0;
         int orange=0;
         int green=0;
         int utilities=0;
         int lightgreen=0;
         int red=0;
         int pink=0;
         int blue=0;
         int lightblue=0;
        List<RealtyCardDto> realtyList =player.getRealtyList();
        for (int i=0;i<realtyList.size();i++){
            switch (realtyList.get(i).getColor()){
                case "yellow"://2
                    yellow++;
                    if((yellow==2)&&(!player.getMonopolies().contains("yellow"))){
                        player.getMonopolies().add("yellow");
                    }
                    break;
                case "orange":
                    orange++;
                    if((orange==3)&&(!player.getMonopolies().contains("orange"))){
                        player.getMonopolies().add("orange");
                    }
                    break;
                case "green":
                    green++;
                    if((green==3)&&(!player.getMonopolies().contains("green"))){
                        player.getMonopolies().add("green");
                    }
                    break;
                case "utilities":
                    utilities++;
                    if((utilities==2)&&(!player.getMonopolies().contains("utilities"))){
                        player.getMonopolies().add("utilities");
                    }
                    break;
                case "lightgreen":
                    lightgreen++;
                    if((lightgreen==3)&&(!player.getMonopolies().contains("lightgreen"))){
                        player.getMonopolies().add("lightgreen");
                    }
                    break;
                case "red":
                    red++;
                    if((red==3)&&(!player.getMonopolies().contains("red"))){
                        player.getMonopolies().add("red");
                    }
                    break;
                case "pink":
                    pink++;
                    if((pink==3)&&(!player.getMonopolies().contains("pink"))){
                        player.getMonopolies().add("pink");
                    }
                    break;
                case "blue":
                    blue++;
                    if((blue==3)&&(!player.getMonopolies().contains("blue"))){
                        player.getMonopolies().add("blue");
                    }
                    break;
                case "lightblue"://2
                    lightblue++;
                    if((lightblue==2)&&(!player.getMonopolies().contains("lightblue"))){
                        player.getMonopolies().add("lightblue");
                    }
                    break;
            }
        }
        return player;
    }
    @Override
    public ActionDto playerToBankInteraction(ActionDto action) {
        String type=action.getActionType();
        Map<String,Object> act= action.getActionBody();
        PlayerDto player= (PlayerDto) act.get("player");
        RealtyCardDto realty = (RealtyCardDto) act.get("realty");
        List<PlayerDto> list = new ArrayList<>();
        switch (type){
            case "BuyRealty":
                realty.setOwner(player.getPlayerFigure());
                List<RealtyCardDto> realtyList =player.getRealtyList();
                realtyList.add(realty);
                player.setRealtyList(realtyList);
                player=testColorMonopoly(player);
                act.clear();
                list.add(player);
                type= ActionType.MONEY_OPERATION.toString();
                act.put("player",list);
                act.put("money",realty.getCostCard());
                ActionDto request = ActionDto.builder()
                        .actionType(type)
                        .actionBody(act)
                        .build();
                ActionDto response = bankClient.playerToBankInteraction(request);
                type=response.getActionType();
                act= response.getActionBody();
                List<?> players= objectMapper.convertValue(act.get("player"),List.class);
                player=(PlayerDto) players.get(0);
                act.clear();
                act.put("player",player);
                type=ActionType.BUY_REALTY.toString();
                return ActionDto.builder()
                        .actionType(type)
                        .actionBody(act)
                        .build();

            case "BuyHouse":
                RealtyCardDto minCountHouseCard=new RealtyCardDto();
                List<RealtyCardDto> realtyList1 =player.getRealtyList();
                Long min=5L;
                List<String> monopoly = player.getMonopolies();
                if(monopoly.contains(realty.getColor())){
                    for(int i=0;i<realtyList1.size();i++) {
                        if(realtyList1.get(i).getColor().equals(realty.getColor()) && realtyList1.get(i).getCountHouse()<min) {
                            min=realtyList1.get(i).getCountHouse();
                            minCountHouseCard=realtyList1.get(i);
                        }
                    }
                    if(min==5L){
                        act.clear();
                        act.put("player", player);
                        return ActionDto.builder()
                                .actionType(type)
                                .actionBody(act)
                                .build();
                    }
                    else {
                        minCountHouseCard.setCountHouse(realty.getCountHouse() + 1);
                        player.setRealtyList(realtyList1);
                        act.clear();
                        list = new ArrayList<>();
                        list.add(player);
                        act.put("player",list);
                        act.put("money",realty.getCostCard());
                        request = ActionDto.builder()
                                .actionType(type)
                                .actionBody(act)
                                .build();
                        return bankClient.playerToBankInteraction(request);             //НЕПРАВИЛЬНО
                    }
                }
            case "SellHouse":
                List<RealtyCardDto> realtyList2 =player.getRealtyList();
                RealtyCardDto itsRealty1 = realtyList2.get(realtyList2.indexOf(realty));
                itsRealty1.setCountHouse(realty.getCountHouse()-1);
                player.setRealtyList(realtyList2);
                act.clear();
                act.put("player",player);
                break;
            case "SellRealty":
                List<RealtyCardDto> realtyList3 =player.getRealtyList();
                RealtyCardDto sellRealty = realtyList3.get(realtyList3.indexOf(realty));
                sellRealty.setCountHouse(-1L);
                player.setRealtyList(realtyList3);
                act.clear();
                act.put("player",player);
                break;
        }

        return ActionDto.builder()
                .actionType(type)
                .actionBody(act)
                .build();
    }

    @Override
    public boolean isPlayerToBankInteraction(ActionDto action) {
        return false;
    }

    @Override
    public ActionDto playerToPlayerInteraction(ActionDto action) {

        String type = action.getActionType();
        Map<String, Object> act = action.getActionBody();
        PlayerDto player1 = (PlayerDto) act.get("player1");
        PlayerDto player2 = (PlayerDto) act.get("player2");
        List<?> offerOfPlayer1 = objectMapper.convertValue(act.get("offerOfPlayer1"),List.class);
        List<?> offerOfPlayer2 =  objectMapper.convertValue(act.get("offerOfPlayer2"),List.class);
        Long money=(Long) act.get("money");

        if (type.equals("SWAP")) {
            //удаление из списка игрока1

            // 1 игрок
            List<RealtyCardDto> realtyPlayer1 = player1.getRealtyList();
            List<RealtyCardDto> realtyCardDtos = new ArrayList<>();
            for (int i=0;i<offerOfPlayer1.size();i++){
                realtyPlayer1.remove((RealtyCardDto)offerOfPlayer1.get(offerOfPlayer1.indexOf(i)));

                //добавление в списки игроков нового имущества и изменение значения owner

                RealtyCardDto realtyCardDto = (RealtyCardDto)offerOfPlayer1.get(i);
                realtyCardDto.setOwner(player2.getPlayerFigure());
                realtyCardDtos.add(realtyCardDto);
            }
            player1.setRealtyList(realtyPlayer1);
            player1.getRealtyList().addAll(realtyCardDtos);


            realtyCardDtos = new ArrayList<>();
            //удаление из списка игрока2
            List<RealtyCardDto> realtyPlayer2 = player2.getRealtyList();
            for (int i=0;i<offerOfPlayer2.size();i++){
                realtyPlayer2.remove((RealtyCardDto)offerOfPlayer2.get(offerOfPlayer2.indexOf(i)));

                //добавление в списки игроков нового имущества и изменение значения owner

                RealtyCardDto realtyCardDto = (RealtyCardDto)offerOfPlayer2.get(i);
                realtyCardDto.setOwner(player1.getPlayerFigure());
                realtyCardDtos.add(realtyCardDto);
            }
            player2.setRealtyList(realtyPlayer2);
            player2.getRealtyList().addAll(realtyCardDtos);

        }

        player1=testColorMonopoly(player1);
        player2=testColorMonopoly(player2);
        act.clear();
        act.put("player1",player1);
        act.put("player2",player2);
            return ActionDto.builder()
                    .actionType(type)
                    .actionBody(act)
                    .build();

    }

    @Override
    public boolean isPlayerToPlayerInteraction(ActionDto action) {
        return false;
    }

    @Override
    public List<RealtyCardDto> getAllRealtyCards() {
            return rc.setАllRealtyCardService();
    }
}
