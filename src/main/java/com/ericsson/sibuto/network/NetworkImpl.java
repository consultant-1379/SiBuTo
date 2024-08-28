package com.ericsson.sibuto.network;

import com.ericsson.sibuto.abstraction.SimulatedEntityImpl;
import com.ericsson.sibuto.node.Node;
import com.ericsson.sibuto.node.NodeImpl;
import com.ericsson.sibuto.node.NodeSpecification;
import com.ericsson.sibuto.node.NodeStrategy;

import java.util.ArrayList;
import java.util.List;

public class NetworkImpl extends SimulatedEntityImpl implements Network {
    private String name;
    private NetworkSpecification networkSpecification;
    private List<Node> nodes = new ArrayList<>();

    public NetworkImpl(NetworkSpecification networkSpecification, String name) {
        super(networkSpecification);
        this.networkSpecification = networkSpecification;
        this.name = name;
    }

    @Override
    public void create() {
        List<NodeSpecification> nodeSpecificationList = networkSpecification.getNodeSpecificationList();
        for (NodeSpecification nodeSpecification : nodeSpecificationList) {
            createNodesOfThisSpecification(nodeSpecification);
        }
    }

    private void createNodesOfThisSpecification(NodeSpecification nodeSpecification) {
        int numberOfNodesToCreate = networkSpecification.getStrategy().getNumberOfNodes(nodeSpecification);
        for (int i=0; i<numberOfNodesToCreate; i++) {
            Node node = new NodeImpl(this, nodeSpecification);
            node.createNode();
            nodes.add(node);
        }
    }

    @Override
    public void output() {
        for (Node node : nodes) {
            node.output();
        }
    }

    @Override
    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public NetworkSpecification getSpecification() {
        return networkSpecification;
    }


}
