package com.ericsson.sibuto.network;

import com.ericsson.sibuto.abstraction.SimulatedEntity;
import com.ericsson.sibuto.node.Node;

import java.util.List;

public interface Network extends SimulatedEntity {
    void create();
    void output();
    List<Node> getNodes();

}
