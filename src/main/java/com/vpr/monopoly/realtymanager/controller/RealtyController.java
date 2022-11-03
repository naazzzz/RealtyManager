package com.vpr.monopoly.realtymanager.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "REALTY CONTROLLER", description = "API для управления медежером недвижимости")
@RestController
@RequestMapping("/api/realtymanager")
@Validated
@RequiredArgsConstructor
@Slf4j
public class RealtyController {

}
