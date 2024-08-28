package com.ericsson.sibuto.network;

import com.ericsson.sibuto.abstraction.SimulatedEntitySpecification;
import com.ericsson.sibuto.node.NodeSpecification;

import java.util.List;

public interface NetworkSpecification extends SimulatedEntitySpecification {
    List<NodeSpecification> getNodeSpecificationList();
    NetworkStrategy getStrategy();
    String getName();
}
