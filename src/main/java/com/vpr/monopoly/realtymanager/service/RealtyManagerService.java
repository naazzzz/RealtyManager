package com.vpr.monopoly.realtymanager.service;

import com.vpr.monopoly.realtymanager.model.ActionDto;
import com.vpr.monopoly.realtymanager.model.RealtyCardDto;


import java.util.List;

public interface RealtyManagerService {
    ActionDto playerToBankInteraction(ActionDto action);

    boolean isPlayerToBankInteraction(ActionDto action);

    ActionDto playerToPlayerInteraction(ActionDto action);

    boolean isPlayerToPlayerInteraction(ActionDto action);

    List<RealtyCardDto> getAllRealtyCards(RealtyCardClient rc);
}
