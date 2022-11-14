package com.vpr.monopoly.realtymanager.service;


import com.vpr.monopoly.realtymanager.model.ActionDto;
import com.vpr.monopoly.realtymanager.model.PlayerDto;
import com.vpr.monopoly.realtymanager.model.RealtyCardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class RealtyManagerServiceImpl implements RealtyManagerService {

    private final RealtyCardService rc;
    @Override
    public ActionDto playerToBankInteraction(ActionDto action) {

        String type=action.getActionType();
        Map<String,Object> act= action.getActionBody();
        PlayerDto player= (PlayerDto) act.get("player");
        RealtyCardDto realty = (RealtyCardDto) act.get("realty");
        switch (type){
            case "BuyRealty":
                List<RealtyCardDto> realtyList =player.getRealtyList();
                realtyList.add(realty);
                player.setRealtyList(realtyList);
                act.clear();
                act.put("player",player);
                break;
            case "BuyHouse":
                List<RealtyCardDto> realtyList1 =player.getRealtyList();
                RealtyCardDto itsRealty = realtyList1.get(realtyList1.indexOf(realty));//ВОПРОС НАСЧЕТ ЭТОЙ ЗАЛУПЫ ПО ИДЕЕ ЖЕ МОЖЕТ НЕ НАХОДИТЬ и смены цены кто первый получает этот лист
                itsRealty.setCountHouse(realty.getCountHouse()+1);
                player.setRealtyList(realtyList1);
                act.clear();
                act.put("player",player);
                break;
            case "SellHouse":
                List<RealtyCardDto> realtyList2 =player.getRealtyList();
                RealtyCardDto itsRealty1 = realtyList2.get(realtyList2.indexOf(realty));//ВОПРОС НАСЧЕТ ЭТОЙ ЗАЛУПЫ ПО ИДЕЕ ЖЕ МОЖЕТ НЕ НАХОДИТЬ и смены цены кто первый получает этот лист
                itsRealty1.setCountHouse(realty.getCountHouse()-1);
                player.setRealtyList(realtyList2);
                act.clear();
                act.put("player",player);
                break;
            case "SellRealty":
                List<RealtyCardDto> realtyList3 =player.getRealtyList();
                realtyList3.remove(realty);
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
        return null;
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
