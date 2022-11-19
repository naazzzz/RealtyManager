package com.vpr.monopoly.realtymanager.service.client;

import com.vpr.monopoly.realtymanager.model.ActionDto;
import com.vpr.monopoly.realtymanager.model.PlayerDto;
import com.vpr.monopoly.realtymanager.service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import static com.vpr.monopoly.realtymanager.model.enam.ActionType.MONEY_OPERATION;

@Component
@Slf4j
public class BankClient implements BankService {

    @Value("http://localhost:8081/api/bank")
    private String baseUrl;

    private WebClient webClient;

    @PostConstruct
    private void init(){
        webClient = WebClient.create(baseUrl);
    }

    @Override
    public ActionDto playerToBankInteraction(ActionDto action) {
        String uri = "/tobank";
        return this.connectByAction(webClient, baseUrl, uri, HttpMethod.PUT, action, log);
    }

    @Override
    public Boolean isPlayerToBankInteraction(ActionDto action) {
        String uri = "/istobank";
        return this.connectByIsAction(webClient, baseUrl, uri, HttpMethod.PUT, action, log);
    }

    @Override
    public ActionDto playerToPlayerInteraction(ActionDto action) {
        String uri = "/toplayer";
        return this.connectByAction(webClient, baseUrl, uri, HttpMethod.PUT, action, log);
    }

    @Override
    public Boolean isPlayerToPlayerInteraction(ActionDto action) {
        String uri = "/istoplayer";
        return this.connectByIsAction(webClient, baseUrl, uri, HttpMethod.PUT, action, log);
    }

    @Override
    public Boolean checkConnection() {
        List<PlayerDto> playerList = List.of(PlayerDto.builder().build());
        Long money = 100L;
        ActionDto action = ActionDto.builder()
                .actionType(MONEY_OPERATION.toString())
                .actionBody(Map.of(
                        "playerList", playerList,
                        "money", money
                ))
                .build();

        return this.isPlayerToBankInteraction(action) != null;
    }
}
