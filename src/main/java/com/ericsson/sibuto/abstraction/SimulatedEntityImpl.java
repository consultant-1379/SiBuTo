package com.ericsson.sibuto.abstraction;


import com.ericsson.sibuto.network.NetworkSpecification;

public class SimulatedEntityImpl implements SimulatedEntity {

    private SimulatedEntitySpecification simulatedEntitySpecification;
    private int instanceNumberOfSimulatedEntitiesOfThisSpecification;
    private int instanceNumberOfSimulatedEntitiesOfThisStrategy;

    public SimulatedEntityImpl(SimulatedEntitySpecification simulatedEntitySpecification) {
        this.simulatedEntitySpecification = simulatedEntitySpecification;
        this.instanceNumberOfSimulatedEntitiesOfThisSpecification =
                SimulatedEntities.incrementInstanceNumberOfSimulatedEntitiesOfThisSpecification(simulatedEntitySpecification);
        this.instanceNumberOfSimulatedEntitiesOfThisStrategy =
                SimulatedEntities.incrementInstanceNumberOfSimulatedEntitiesOfThisStrategy(simulatedEntitySpecification);
    }

    public SimulatedEntitySpecification getSpecification() {
        return this.simulatedEntitySpecification;
    }

    public int getInstanceNumberOfThisSpecification() {
        return instanceNumberOfSimulatedEntitiesOfThisSpecification;
    }

    public int getInstanceNumberOfThisStrategy() {
        return instanceNumberOfSimulatedEntitiesOfThisStrategy;
    }

    public int getTotalNumberOfInstancesUsingThisSpecification() {
        return SimulatedEntities.getTotalNumberOfSimulatedEntitiesOfThisSpecification(simulatedEntitySpecification);
    }

    public int getTotalNumberOfInstancesUsingThisStrategy() {
        return SimulatedEntities.getTotalNumberOfSimulatedEntitiesUsingThisStrategy(simulatedEntitySpecification);
    }

}
