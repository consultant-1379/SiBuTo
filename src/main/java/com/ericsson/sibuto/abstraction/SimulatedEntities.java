package com.ericsson.sibuto.abstraction;

import java.util.HashMap;
import java.util.Map;

public abstract class SimulatedEntities {

    private static Map<SimulatedEntitySpecification, Integer> simulatedEntitiesOfSpecificationCount =
            new HashMap<>();

    private static Map<SimulatedEntityStrategy, Integer> simulatedEntitiesOfStrategyCount =
            new HashMap<>();

    public static Integer incrementInstanceNumberOfSimulatedEntitiesOfThisSpecification(SimulatedEntitySpecification simulatedEntitySpecification) {
        Integer countOfSimulatedEntitiesOfThisSpecification;
        if (simulatedEntitiesOfSpecificationCount.containsKey(simulatedEntitySpecification)) {
            countOfSimulatedEntitiesOfThisSpecification =
                    simulatedEntitiesOfSpecificationCount.get(simulatedEntitySpecification) + 1;
        } else {
            countOfSimulatedEntitiesOfThisSpecification = 1;
        }
        simulatedEntitiesOfSpecificationCount.put(simulatedEntitySpecification, countOfSimulatedEntitiesOfThisSpecification);
        return countOfSimulatedEntitiesOfThisSpecification;
    }

    public static Integer getTotalNumberOfSimulatedEntitiesOfThisSpecification(SimulatedEntitySpecification simulatedEntitySpecification) {
        return simulatedEntitiesOfSpecificationCount.get(simulatedEntitySpecification);
    }

    public static Integer incrementInstanceNumberOfSimulatedEntitiesOfThisStrategy(SimulatedEntitySpecification simulatedEntitySpecification) {
        SimulatedEntityStrategy simulatedEntityStrategy = simulatedEntitySpecification.getStrategy();
        Integer countOfSimulatedEnntitiesOfThisStrategy;
        if (simulatedEntitiesOfStrategyCount.containsKey(simulatedEntityStrategy)) {
            countOfSimulatedEnntitiesOfThisStrategy =
                    simulatedEntitiesOfStrategyCount.get(simulatedEntityStrategy) + 1;
        } else {
            countOfSimulatedEnntitiesOfThisStrategy = 1;
        }
        simulatedEntitiesOfStrategyCount.put(simulatedEntityStrategy, countOfSimulatedEnntitiesOfThisStrategy);
        return countOfSimulatedEnntitiesOfThisStrategy;
    }

    public static Integer getTotalNumberOfSimulatedEntitiesUsingThisStrategy(SimulatedEntitySpecification simulatedEntitySpecification) {
        SimulatedEntityStrategy simulatedEntityStrategy = simulatedEntitySpecification.getStrategy();
        return simulatedEntitiesOfStrategyCount.get(simulatedEntityStrategy);
    }

}
