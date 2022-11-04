package com.vpr.monopoly.realtymanager.service;


import com.vpr.monopoly.realtymanager.model.ActionDto;
import com.vpr.monopoly.realtymanager.model.RealtyCardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RealtyManagerClient implements RealtyManagerService {


    @Override
    public ActionDto playerToBankInteraction(ActionDto action) {
        return null;
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
    public List<RealtyCardDto> getAllRealtyCards(RealtyCardClient rc) {
        if(rc.list_all_cards==null) {
            rc.set_all_RealtyCardService();
            return rc.list_all_cards;
        }
        else
            return rc.list_all_cards;
    }
}
