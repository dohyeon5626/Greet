package com.dohyeon5626.greet.controller;

import com.dohyeon5626.greet.service.SvgService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = "image/svg+xml")
public class SvgController {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");

    private final SvgService service;

    @GetMapping("/svg")
    public ResponseEntity<byte[]> getSvg() {
        return ResponseEntity.ok()
                        .cacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS))
                                .body(service.getSvg(LocalDate.now().format(formatter)));
    }

    @PostMapping("/svg")
    public void setSvg() {
        service.update();
    }

}
