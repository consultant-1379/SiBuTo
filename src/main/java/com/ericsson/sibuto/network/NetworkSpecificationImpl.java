package com.ericsson.sibuto.network;

import com.ericsson.sibuto.abstraction.SimulatedEntitySpecification;
import com.ericsson.sibuto.node.NodeSpecification;
import com.ericsson.sibuto.node.NodeSpecificationImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NetworkSpecificationImpl implements NetworkSpecification {

    private File mimFileDirPath;
    private String name;
    private List<NodeSpecification> nodeSpecificationList;
    private NetworkStrategy networkStrategy;

    public NetworkSpecificationImpl(String name, File mimFileDirPath) {
        this.mimFileDirPath = mimFileDirPath;
        this.name = name;
        this.nodeSpecificationList = new ArrayList<>();
        setNodeSpecificationList(mimFileDirPath);
        this.networkStrategy = NetworkStrategyFactory.getStrategy(this);
    }

    private void setNodeSpecificationList(File mimFileDirPath) {
        File[] mimFileDirListing = mimFileDirPath.listFiles();
        for (File mimFile : mimFileDirListing) {
            NodeSpecification nodeSpecification = new NodeSpecificationImpl(mimFile);
            nodeSpecificationList.add(nodeSpecification);
        }
    }

    public String getName() {
        return this.name;
    }

    public List<NodeSpecification> getNodeSpecificationList() {
        return nodeSpecificationList;
    }

    public NetworkStrategy getStrategy() {
        return this.networkStrategy;
    }
}
