package com.dohyeon5626.greet.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "svgContentClient", url = "https://raw.githubusercontent.com/dohyeon5626/greet/svg")
public interface SvgContentClient {

    @GetMapping("/{path}")
    byte[] getSvg(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable("path") String path);

}
