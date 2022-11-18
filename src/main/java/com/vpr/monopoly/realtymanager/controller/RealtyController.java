package com.vpr.monopoly.realtymanager.controller;

import com.vpr.monopoly.realtymanager.model.ActionDto;
import com.vpr.monopoly.realtymanager.model.PlayerDto;
import com.vpr.monopoly.realtymanager.model.RealtyCardDto;
import com.vpr.monopoly.realtymanager.service.RealtyCardService;
import com.vpr.monopoly.realtymanager.service.RealtyManagerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@Tag(name = "REALTY CONTROLLER", description = "API для управления медежером недвижимости")
@RestController
@RequestMapping("/api/realtymanager")
@Validated
@RequiredArgsConstructor
@Slf4j
public class RealtyController {

    private final RealtyManagerService realtyservice;


    @GetMapping("/allcards")
    public ResponseEntity<List<RealtyCardDto>> allCard(){
        List<RealtyCardDto> all_cards = realtyservice.getAllRealtyCards();
        log.info("get all cards");
        return ResponseEntity.ok(all_cards);
    }
    @PostMapping("/tobank")
    public ResponseEntity<ActionDto> toBank(@RequestBody ActionDto actionDto)
    {
        ActionDto action =realtyservice.playerToBankInteraction(actionDto);
        return ResponseEntity.ok(action);
    }

    @PostMapping("/toplayer")
    public ResponseEntity<ActionDto> toPlayer(@RequestBody ActionDto actionDto)
    {
        ActionDto action =realtyservice.playerToPlayerInteraction(actionDto);
        return ResponseEntity.ok(action);
    }

}
