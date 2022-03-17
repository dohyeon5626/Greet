package com.dohyeon5626.greet.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class FolderDto {

    private List<FolderInfoDto> tree;

}
