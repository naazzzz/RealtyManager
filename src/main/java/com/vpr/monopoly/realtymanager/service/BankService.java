package com.vpr.monopoly.realtymanager.service;

import com.vpr.monopoly.realtymanager.model.ActionDto;

public interface BankService extends MonopolyService {

    ActionDto playerToBankInteraction(ActionDto action);

    Boolean isPlayerToBankInteraction(ActionDto action);

    ActionDto playerToPlayerInteraction(ActionDto action);

    Boolean isPlayerToPlayerInteraction(ActionDto action);
}