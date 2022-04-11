package com.dohyeon5626.greet.client;

import com.dohyeon5626.greet.dto.TreeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "svgBranchInfoClient", url = "https://api.github.com/repos/dohyeon5626/greet/git/trees/svg")
public interface SvgBranchInfoClient {

    @GetMapping
    TreeDto getBranchInfo(@RequestHeader(HttpHeaders.AUTHORIZATION) String token);

}
