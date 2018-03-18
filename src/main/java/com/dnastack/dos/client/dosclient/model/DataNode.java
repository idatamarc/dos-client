package com.dnastack.dos.client.dosclient.model;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;

/**
 * Model class for the backend data
 *
 * @Author: marchuang <br/>
 * @since: 1.0.0 <br/>
 */
@Data
public class DataNode {

    private String id = null;

    private String name = null;

    private String url = null;

    private Map<String, String> metaData = null;

    private String healthStatus = null;

    private DateTime created = null;

    private DateTime lastHealthUpdated = null;

    private String description = null;

    private List<String> aliases = null;
}
