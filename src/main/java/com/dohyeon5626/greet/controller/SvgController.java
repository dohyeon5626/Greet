package com.dohyeon5626.greet.controller;

import com.dohyeon5626.greet.service.SvgService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = "image/svg+xml")
public class SvgController {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final SvgService service;

    @GetMapping("/svg")
    public byte[] getSvg() {
        return service.getSvg(LocalDate.now().format(formatter));
    }

}