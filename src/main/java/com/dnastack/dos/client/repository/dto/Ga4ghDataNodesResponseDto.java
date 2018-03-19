package com.dnastack.dos.client.repository.dto;

import lombok.Data;

import java.util.List;

@Data
public class Ga4ghDataNodesResponseDto {

    private List<Ga4ghDataNodeDto> dosNodes;

    private String nextPageToken;
}
