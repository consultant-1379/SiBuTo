package com.ericsson.sibuto.managedobject;

import com.ericsson.sibuto.abstraction.SimulatedEntity;
import com.ericsson.sibuto.node.Node;

import java.util.List;

/**
 * Created by lmieody on 18/07/16.
 */
public interface ManagedObject extends SimulatedEntity {

    int getInstanceNumberOfManagedObjectUnderParent();

    String getId();

    ManagedObject getParent();

    Node getNode();

    String getType();

    void createChildren();

    List<ManagedObject> getChildren();

    String getFDN();
}
