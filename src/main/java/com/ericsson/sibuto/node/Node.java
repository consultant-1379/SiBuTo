package com.ericsson.sibuto.node;

import com.ericsson.sibuto.abstraction.SimulatedEntity;
import com.ericsson.sibuto.managedobject.ManagedObject;
import com.ericsson.sibuto.network.Network;

/**
 * Created by lmieody on 26/07/16.
 */
public interface Node extends SimulatedEntity {
    void createNode();
    void output();
    ManagedObject getRootManagedObject();
    String getName();
    Network getNetwork();
}
