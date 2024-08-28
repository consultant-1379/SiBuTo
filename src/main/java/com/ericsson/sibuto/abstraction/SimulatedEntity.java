package com.ericsson.sibuto.abstraction;

/**
 * Created by lmieody on 19/08/16.
 */
public interface SimulatedEntity {
    SimulatedEntitySpecification getSpecification();
    int getInstanceNumberOfThisSpecification();
    int getInstanceNumberOfThisStrategy();
    int getTotalNumberOfInstancesUsingThisSpecification();
    int getTotalNumberOfInstancesUsingThisStrategy();
}
