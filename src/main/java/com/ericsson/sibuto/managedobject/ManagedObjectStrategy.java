package com.ericsson.sibuto.managedobject;

import com.ericsson.sibuto.abstraction.SimulatedEntityStrategy;

/**
 * Created by lmieody on 18/07/16.
 */
public interface ManagedObjectStrategy extends SimulatedEntityStrategy {
    int getCardinality(ManagedObjectSpecification managedObjectSpecification, ManagedObject parentManagedObject);
    String getId(ManagedObjectSpecification managedObjectSpecification, ManagedObject managedObject);
}
