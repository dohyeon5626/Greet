package com.dohyeon5626.greet.service;

import com.dohyeon5626.greet.client.FolderInfoClient;
import com.dohyeon5626.greet.client.SvgBranchInfoClient;
import com.dohyeon5626.greet.client.SvgContentClient;
import com.dohyeon5626.greet.dto.FolderInfoDto;
import com.dohyeon5626.greet.dto.TreeInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@RequiredArgsConstructor
public class SvgService {

    private final Map<String, List<byte[]>> svgList = new HashMap<>();
    private final Random random = new Random();

    private final SvgBranchInfoClient svgBranchInfoClient;
    private final FolderInfoClient folderInfoClient;
    private final SvgContentClient svgContentClient;

    @PostConstruct
    public void setSvg() {
        update();
    }

    public byte[] getDate(String date) {
        return ("<svg width=\"620\" height=\"140\" viewBox=\"0 0 620 140\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n" +
                "<text \n" +
                "x=\"30\" y=\"90\" \n" +
                "fill=\"black\" font-size=\"10\" font-family=\"'Roboto'\" font-weight=\"bold\">\n" +
                date + "\n" +
                "</text>\n" +
                "</svg>").getBytes();
    }

    public byte[] getSentence(String date) {
        if (svgList.containsKey(date)) {
            List<byte[]> svgs = svgList.get(date);
            return svgs.get(random.nextInt(svgs.size()));
        } else {
            List<byte[]> svgs = svgList.get("random");
            return svgs.get(random.nextInt(svgs.size()));
        }
    }

    public void update() {
        svgList.clear();
        for (TreeInfoDto treeInfoDto : svgBranchInfoClient.getBranchInfo().getTree()) {
            List<FolderInfoDto> folderInfoDtos = folderInfoClient.getFileName(treeInfoDto.getSha()).getTree();
            List<byte[]> svgContents = new ArrayList<>(folderInfoDtos.size());

            for (FolderInfoDto folderInfoDto : folderInfoDtos) {
                svgContents.add(svgContentClient.getSvg(treeInfoDto.getPath() + "/" + folderInfoDto.getPath()));
            }
            svgList.put(treeInfoDto.getPath(), svgContents);
        }
    }

}
