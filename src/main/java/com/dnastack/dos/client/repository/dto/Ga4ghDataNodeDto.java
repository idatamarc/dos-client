package com.dnastack.dos.client.repository.dto;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;

/**
 * Ga4ghDataNodeDto
 */
@Data
public class Ga4ghDataNodeDto {
    private String id = null;
    private String name = null;
    private String url = null;
    private Map<String, String> metaData = null;
    private String healthStatus = null;
    private String created = null;
    private String lastHealthUpdated = null;
    private String description = null;
    private List<String> aliases = null;
}

