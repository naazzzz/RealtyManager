package com.vpr.monopoly.realtymanager.model.enam;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "Тип действия")
@Getter
public enum ActionType {

    BUY_REALTY("BuyRealty"),

    BUY_HOUSE("BuyHouse"),

    SELL_HOUSE("SellHouse"),

    SELL_REALTY("SellRealty"),

    MONEY_OPERATION("MoneyOperation"),

    SWAP("Swap"),//СПРОСИТЬ У ДИМЫ

    WAITING("Waiting");//И НАСЧЕТ ЭТОГО

    private final String label;

    ActionType(String label) {
        this.label = label;
    }
}
