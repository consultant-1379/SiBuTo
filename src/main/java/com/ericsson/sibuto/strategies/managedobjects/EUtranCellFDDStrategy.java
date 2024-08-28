package com.ericsson.sibuto.strategies.managedobjects;

import com.ericsson.sibuto.managedobject.MOStrategy;
import com.ericsson.sibuto.managedobject.ManagedObject;
import com.ericsson.sibuto.managedobject.ManagedObjectSpecification;
import com.ericsson.sibuto.managedobject.ManagedObjectStrategy;
import com.ericsson.sibuto.node.NodeType;

/**
 * Created by lmieody on 28/07/16.
 */
@MOStrategy(nodeType = NodeType.ERBS, moTypes = {"EUtranCellFDD"})
public class EUtranCellFDDStrategy implements ManagedObjectStrategy {

    @Override
    public int getCardinality(ManagedObjectSpecification managedObjectSpecification, ManagedObject parentManagedObject) {
        return 4;
    }

    @Override
    public String getId(ManagedObjectSpecification managedObjectSpecification, ManagedObject managedObject) {
        String nodeName = managedObject.getNode().getName();
        return nodeName + "-" + Integer.toString(managedObject.getInstanceNumberOfManagedObjectUnderParent());
    }
}
