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

    private final DateTimeFormatter MonthDay = DateTimeFormatter.ofPattern("MM-dd");
    private final DateTimeFormatter YearMonthDay = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final SvgService service;

    @GetMapping("/date")
    public ResponseEntity<byte[]> getDate() {
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES))
                .body(service.getDate(LocalDate.now().format(YearMonthDay)));
    }

    @GetMapping("/sentence")
    public ResponseEntity<byte[]> getSentence() {
        return ResponseEntity.ok()
                        .cacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS))
                                .body(service.getSentence(LocalDate.now().format(MonthDay)));
    }

    @PostMapping("/svg")
    public void setSvg() {
        service.update();
    }

}
