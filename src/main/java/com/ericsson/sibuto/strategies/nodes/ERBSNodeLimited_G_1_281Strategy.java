package com.ericsson.sibuto.strategies.nodes;

import com.ericsson.sibuto.node.Node;
import com.ericsson.sibuto.node.NodeSpecification;
import com.ericsson.sibuto.node.NodeStrategy;
import com.ericsson.sibuto.simulation.Simulation;

/**
 * Created by lmieody on 18/08/16.
 */
public class ERBSNodeLimited_G_1_281Strategy implements NodeStrategy {

    private String LTE = "LTE";
    private String ERBS = "ERBS";

    @Override
    public String getName(Node node) {
        int nodeNumber = node.getInstanceNumberOfThisStrategy();
        int numberOfNodesPerSimulation = getNumberOfNodesPerSimulation(node);
        String lteNumber = String.format("%02d", (nodeNumber - 1)/numberOfNodesPerSimulation + 1);
        String erbsNumber = String.format("%05d", (nodeNumber - 1)%numberOfNodesPerSimulation + 1);
        String nodeName = LTE + lteNumber + ERBS + erbsNumber;
        return nodeName;
    }

    @Override
    public int getNumberOfNodesPerSimulation(Node node) {
        return 160;
    }
}
