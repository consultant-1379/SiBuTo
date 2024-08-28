package com.ericsson.sibuto.network;

import com.ericsson.sibuto.node.NodeSpecification;
import com.ericsson.sibuto.abstraction.SimulatedEntityStrategy;

import java.util.Map;

public interface NetworkStrategy extends SimulatedEntityStrategy {
    int getNumberOfNodes(NodeSpecification nodeSpecification);
}
