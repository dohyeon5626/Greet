package com.dohyeon5626.greet.client;

import com.dohyeon5626.greet.dto.FolderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "folderInfoClient", url = "https://api.github.com/repos/dohyeon5626/greet/git/trees")
public interface FolderInfoClient {

    @GetMapping("/{sha}")
    FolderDto getFileName(@PathVariable("sha") String sha);

}
