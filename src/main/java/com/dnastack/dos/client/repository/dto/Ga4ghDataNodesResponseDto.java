package com.dnastack.dos.client.repository.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Ga4ghDataNodesResponseDto {

    @JsonProperty("dos_nodes")
    private List<Ga4ghDataNodeDto> dosNodes;

    @JsonProperty("next_page_token")
    private String nextPageToken;
}
