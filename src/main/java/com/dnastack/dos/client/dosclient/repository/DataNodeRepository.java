package com.dnastack.dos.client.dosclient.repository;

import com.dnastack.dos.client.dosclient.model.DataNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * The service class to CRUD data from downstream services/databases
 *
 * @Author: marchuang <br/>
 * @since: 1.0.0 <br/>
 */
@Service
public class DataNodeRepository {

    public Collection<DataNode> findAll(){

        //demo only!
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

        return dataNodes;
    }
}
