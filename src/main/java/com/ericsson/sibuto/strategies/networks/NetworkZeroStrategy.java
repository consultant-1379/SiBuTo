package com.ericsson.sibuto.strategies.networks;

import com.ericsson.sibuto.network.ANetworkStrategy;
import com.ericsson.sibuto.network.NetworkStrategy;
import com.ericsson.sibuto.node.NodeSpecification;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

@ANetworkStrategy(networkName = "NetworkZero")
public class NetworkZeroStrategy implements NetworkStrategy {

    private Map<File, Integer> numberOfNodesPerMim;

    public NetworkZeroStrategy() {
        numberOfNodesPerMim = new HashMap<>();
        File mimFile = new File("/home/lmieody/workspace/SiBuTo/resources/ERBSNodeLimited_G_1_281");
        numberOfNodesPerMim.put(mimFile, 2);
    }

    @Override
    public int getNumberOfNodes(NodeSpecification nodeSpecification) {
        return numberOfNodesPerMim.get(nodeSpecification.getMimFileName());
    }
}
