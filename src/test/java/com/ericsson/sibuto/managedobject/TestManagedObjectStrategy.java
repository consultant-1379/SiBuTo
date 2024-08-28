package com.ericsson.sibuto.managedobject;

/**
 * Created by lmieody on 29/07/16.
 */
public class TestManagedObjectStrategy implements ManagedObjectStrategy {

    @Override
    public int getCardinality(ManagedObjectSpecification managedObjectSpecification, ManagedObject parentManagedObject) {
        return 5;
    }

    @Override
    public String getId(ManagedObjectSpecification managedObjectSpecification, ManagedObject managedObject) {
        return Integer.toString(managedObject.getInstanceNumberOfManagedObjectUnderParent());
    }
}
