package com.vpr.monopoly.realtymanager.service.impl;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vpr.monopoly.realtymanager.model.ActionDto;
import com.vpr.monopoly.realtymanager.model.PlayerDto;
import com.vpr.monopoly.realtymanager.model.RealtyCardDto;
import com.vpr.monopoly.realtymanager.model.enam.ActionType;
import com.vpr.monopoly.realtymanager.service.RealtyManagerService;
import com.vpr.monopoly.realtymanager.service.ServicesManager;
import com.vpr.monopoly.realtymanager.service.client.BankClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@RequiredArgsConstructor
@Slf4j
public class RealtyManagerServiceImpl implements RealtyManagerService {
    private final ObjectMapper objectMapper;
    private final RealtyCardService rc;
    private final ServicesManager servicesManager;
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
        PlayerDto player = objectMapper.convertValue(action.getActionBody().get("player"), PlayerDto.class);
        RealtyCardDto realty = objectMapper.convertValue(action.getActionBody().get("realtyCard"), RealtyCardDto.class);
        List<PlayerDto> list = new ArrayList<>();
        switch (type){
            case "BuyRealty":
                if(player.getRealtyList().contains(realty)){
                    return ActionDto.builder()
                            .actionType(type)
                            .actionBody(act)
                            .build();
                }
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

                if (servicesManager.getBankService().isPlayerToBankInteraction(action)!=null && servicesManager.getBankService().isPlayerToBankInteraction(action)) {
                    ActionDto response = bankClient.playerToBankInteraction(request);
                    type = response.getActionType();
                    act = response.getActionBody();
                    List<?> players = objectMapper.convertValue(act.get("player"), List.class);
                    player = (PlayerDto) players.get(0);
                    act.clear();
                    act.put("player", player);
                    type = ActionType.BUY_REALTY.toString();
                    return ActionDto.builder()
                            .actionType(type)
                            .actionBody(act)
                            .build();
                }
                else{
                    log.info("due to the lack of connection with the bank, the money transaction is performed in realtymanager.");
                    player.setMoney(player.getMoney()-realty.getCostCard());
                    act.clear();
                    act.put("player", player);
                    type="BuyRealty";
                    return ActionDto.builder()
                            .actionType(type)
                            .actionBody(act)
                            .build();
                }
            case "BuyHouse":
                RealtyCardDto minCountHouseCard=new RealtyCardDto();
                List<RealtyCardDto> realtyList1 =player.getRealtyList();
                Long min=5L;
                List<String> monopoly = player.getMonopolies();
                if(monopoly.contains(realty.getColor())) {          //Покупка дома только если есть монополия из этого цвета
                    for (int i = 0; i < realtyList1.size(); i++) {
                        if (realtyList1.get(i).getColor().equals(realty.getColor()) && realtyList1.get(i).getCountHouse() < min) {
                            min = realtyList1.get(i).getCountHouse();
                            minCountHouseCard = realtyList1.get(i);
                        }
                    }
                    if (min == 5L) {
                        log.error("The player {} has the maximum number of houses",player);
                        act.clear();
                        act.put("player", player);
                        return ActionDto.builder()
                                .actionType(type)
                                .actionBody(act)
                                .build();
                    }
                    if (servicesManager.getBankService().isPlayerToBankInteraction(action) != null && servicesManager.getBankService().isPlayerToBankInteraction(action)) {
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
                        return bankClient.playerToBankInteraction(request);
                        }
                    else{
                        log.info("due to the lack of connection with the bank, the money transaction is performed in realtymanager.");
                        minCountHouseCard.setCountHouse(realty.getCountHouse() + 1);
                        Long price=realty.getPriceMap().get(realty.getCountHouse()+1);
                        player.setMoney(player.getMoney()-price);
                        act.clear();
                        act.put("player", player);
                        type="BuyHouse";
                        return ActionDto.builder()
                                .actionType(type)
                                .actionBody(act)
                                .build();
                    }
                }
                break;
            case "SellHouse":
                List<RealtyCardDto> realtyList2 =player.getRealtyList();
                RealtyCardDto itsRealty1 = realtyList2.get(realtyList2.indexOf(realty));
                itsRealty1.setCountHouse(realty.getCountHouse()-1);
                player.setRealtyList(realtyList2);
                act.clear();
                if (servicesManager.getBankService().isPlayerToBankInteraction(action) != null && servicesManager.getBankService().isPlayerToBankInteraction(action)) {
                    list = new ArrayList<>();
                    list.add(player);
                    act.put("player",list);
                    act.put("money",realty.getPriceMap().get(realty.getCountHouse()+1));
                    request = ActionDto.builder()
                            .actionType(type)
                            .actionBody(act)
                            .build();
                    return bankClient.playerToBankInteraction(request);
                }else{
                    log.info("due to the lack of connection with the bank, the money transaction is performed in realtymanager.");
                    Long price=realty.getPriceMap().get(realty.getCountHouse()+1);
                    player.setMoney(player.getMoney()+price);
                    act.clear();
                    act.put("player", player);
                    type="SellHouse";
                    return ActionDto.builder()
                            .actionType(type)
                            .actionBody(act)
                            .build();
                }
            case "SellRealty":
                List<RealtyCardDto> realtyList3 =player.getRealtyList();
                RealtyCardDto sellRealty = realtyList3.get(realtyList3.indexOf(realty));
                sellRealty.setCountHouse(-1L);
                player.setRealtyList(realtyList3);
                if (servicesManager.getBankService().isPlayerToBankInteraction(action) != null && servicesManager.getBankService().isPlayerToBankInteraction(action)) {
                    list = new ArrayList<>();
                    list.add(player);
                    act.put("player",list);
                    act.put("money",realty.getPriceMap().get(realty.getCostCard()/2));
                    request = ActionDto.builder()
                            .actionType(type)
                            .actionBody(act)
                            .build();
                    return bankClient.playerToBankInteraction(request);
                }
                else {
                    log.info("due to the lack of connection with the bank, the money transaction is performed in realtymanager.");
                    Long price=realty.getCostCard()/2;
                    player.setMoney(player.getMoney()+price);
                    act.clear();
                    act.put("player", player);
                    type="SellHouse";
                    return ActionDto.builder()
                            .actionType(type)
                            .actionBody(act)
                            .build();
                }
            default:
                log.error("incorrectly entered actionType {}",type);
                return ActionDto.builder()
                    .actionType(type)
                    .actionBody(act)
                    .build();
        }

        return ActionDto.builder()
                .actionType(type)
                .actionBody(act)
                .build();
    }

    @Override
    public boolean isPlayerToBankInteraction(ActionDto action) {
        log.info("Requesting... to {}", "Game Progress Service");
        ActionDto resultAction = this.playerToBankInteraction(action);

        PlayerDto player = objectMapper.convertValue(resultAction.getActionBody().get("player"), PlayerDto.class);
        Boolean result = player.getMoney() >= 0;

        log.info("Response {} ==> {}", "Game Progress Service", result);
        return result;
    }

    @Override
    public ActionDto playerToPlayerInteraction(ActionDto action) {

        String type = action.getActionType();
        Map<String, Object> act = action.getActionBody();
         PlayerDto player1 = objectMapper.convertValue(action.getActionBody().get("player1"), PlayerDto.class);
         PlayerDto player2 = objectMapper.convertValue(action.getActionBody().get("player2"), PlayerDto.class);
        List<RealtyCardDto> offerOfPlayer1 = objectMapper.convertValue(act.get("offerOfPlayer1"), new TypeReference<>() {
        });
        List<RealtyCardDto> offerOfPlayer2 = objectMapper.convertValue(act.get("offerOfPlayer2"), new TypeReference<>() {
        });
        Long money = objectMapper.convertValue(action.getActionBody().get("money"), Long.class);

        if (type.equals("SWAP")) {

            final String figure1 = player1.getPlayerFigure();
            final String figure2 = player2.getPlayerFigure();
            // 1 игрок
            List<RealtyCardDto> realtyPlayer1 = player1.getRealtyList();
            realtyPlayer1.removeAll(offerOfPlayer1);
            offerOfPlayer1.forEach(realtyCardDto -> {
                realtyCardDto.setOwner(figure2);
            });

            player1.getRealtyList().addAll(offerOfPlayer2);


            // 2 игрок
            List<RealtyCardDto> realtyPlayer2 = player2.getRealtyList();
            realtyPlayer2.removeAll(offerOfPlayer2);
            offerOfPlayer2.forEach(realtyCardDto -> {
                realtyCardDto.setOwner(figure1);
            });
            player2.getRealtyList().addAll(offerOfPlayer1);

            player1 = testColorMonopoly(player1);
            player2 = testColorMonopoly(player2);

            if (servicesManager.getBankService().isPlayerToPlayerInteraction(action) != null && servicesManager.getBankService().isPlayerToPlayerInteraction(action)) {
                act.clear();
                act.put("player1", player1);
                act.put("player2", player2);
                act.put("offerOfPlayer1", offerOfPlayer1);
                act.put("offerOfPlayer2", offerOfPlayer2);
                act.put("money", money);
                ActionDto request = ActionDto.builder()
                        .actionType(type)
                        .actionBody(act)
                        .build();
                return bankClient.playerToPlayerInteraction(request);
            } else {
                log.info("due to the lack of connection with the bank, the money transaction is performed in realtymanager.");
                player1.setMoney(player1.getMoney() + money);
                player2.setMoney(player2.getMoney() - money);
                act.clear();
                act.put("player1", player1);
                act.put("player2", player2);
                return ActionDto.builder()
                        .actionType(type)
                        .actionBody(act)
                        .build();
            }

        }
        return ActionDto.builder()
                .actionType(type)
                .actionBody(act)
                .build();
    }

    @Override
    public boolean isPlayerToPlayerInteraction(ActionDto action) {
        log.info("Requesting... to {}", "Game Progress Service");
        ActionDto resultAction = this.playerToBankInteraction(action);

        PlayerDto player1 = objectMapper.convertValue(resultAction.getActionBody().get("player1"), PlayerDto.class);
        PlayerDto player2 = objectMapper.convertValue(resultAction.getActionBody().get("player2"), PlayerDto.class);
        Boolean result = (player1.getMoney() >= 0)&&(player2.getMoney() >= 0);

        log.info("Response {} ==> {}", "Game Progress Service", result);
        return result;
    }

    @Override
    public List<RealtyCardDto> getAllRealtyCards() {
            return rc.setАllRealtyCardService();
    }
}
