package com.dnastack.dos.client.repository;

import com.dnastack.dos.client.model.DataNode;
import com.dnastack.dos.client.repository.dto.Ga4ghDataNodesResponseDto;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The service class to CRUD data from downstream services/databases
 *
 * @Author: marchuang <br/>
 * @since: 1.0.0 <br/>
 */
@Service
public class DataNodeRepository {

    @Value("${dos.registry.service.endpoint}")
    private String dosRegistryServiceEndpoint;

    @Autowired
    public KeycloakRestTemplate keycloakRestTemplate;

    //Tihs is the model to dto converter
    @Autowired
    private ModelMapper modelMapper;

    public Collection<DataNode> findAll(){

        //demo only!
        /*
        Collection<DataNode> dataNodes = new ArrayList<>();

        DataNode dataNode1 = new DataNode();
        dataNode1.setId("data001");
        dataNode1.setName("Foo DOS node");
        dataNode1.setUrl("http://foo.dos.com");
        dataNode1.setMetaData(new HashMap<String, String>(){{put("category", "Autism");}});
        dataNodes.add(dataNode1);

        DataNode dataNode2 = new DataNode();
        dataNode2.setId("data002");
        dataNode2.setName("Bar DOS node");
        dataNode2.setUrl("http://bar.dos.com");
        dataNode2.setMetaData(new HashMap<String, String>(){{put("category", "Autism");}});
        dataNodes.add(dataNode2);

        DataNode dataNode3 = new DataNode();
        dataNode3.setId("data003");
        dataNode3.setName("FooBar DOS node");
        dataNode3.setUrl("http://foobar.dos.com");
        dataNode3.setMetaData(new HashMap<String, String>(){{put("category", "Autism");}});
        dataNodes.add(dataNode3);
        */

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.add("Authorization", "Bearer " + tokenInfo.getJwtToken());
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<Ga4ghDataNodesResponseDto> dataNodesDto = keycloakRestTemplate.exchange(dosRegistryServiceEndpoint+"nodes",
                HttpMethod.GET, entity, Ga4ghDataNodesResponseDto.class);

        List<DataNode> dataNodes = dataNodesDto.getBody().getDosNodes().stream()
                .map(dto -> {
                    return modelMapper.map(dto, DataNode.class);
                })
                .collect(Collectors.toList());

        return dataNodes;
    }

}
