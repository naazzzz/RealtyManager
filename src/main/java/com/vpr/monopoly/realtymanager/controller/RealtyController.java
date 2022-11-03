package com.vpr.monopoly.realtymanager.controller;

import com.vpr.monopoly.realtymanager.model.RealtyCardDto;
import com.vpr.monopoly.realtymanager.service.RealtyCardService;
import com.vpr.monopoly.realtymanager.service.RealtyManagerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "REALTY CONTROLLER", description = "API для управления медежером недвижимости")
@RestController
@RequestMapping("/api/realtymanager")
@Validated
@RequiredArgsConstructor
@Slf4j
public class RealtyController {

    private final RealtyManagerService realtyservice;

    private final RealtyCardService rc;

    @GetMapping("/allcards")
    public ResponseEntity<List<RealtyCardDto>> endGame(){
        List<RealtyCardDto> all_cards = realtyservice.getAllRealtyCards(rc);
        log.info("get all cards");
        return ResponseEntity.ok(all_cards);
    }
}
