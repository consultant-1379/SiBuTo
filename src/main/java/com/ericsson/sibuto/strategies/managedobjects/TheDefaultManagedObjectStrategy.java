package com.ericsson.sibuto.strategies.managedobjects;

import com.ericsson.sibuto.managedobject.ManagedObject;
import com.ericsson.sibuto.managedobject.ManagedObjectSpecification;
import com.ericsson.sibuto.managedobject.ManagedObjectStrategy;

/**
 * Created by lmieody on 18/07/16.
 */
public class TheDefaultManagedObjectStrategy implements ManagedObjectStrategy {

    @Override
    public int getCardinality(ManagedObjectSpecification managedObjectSpecification, ManagedObject parentManagedObject) {
        return 1;
    }

    @Override
    public String getId(ManagedObjectSpecification managedObjectSpecification, ManagedObject managedObject) {
        return Integer.toString(managedObject.getInstanceNumberOfManagedObjectUnderParent());
    }
}
