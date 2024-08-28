package com.ericsson.sibuto.network;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NetworkStrategyFactory {

    private static String strategiesPackage = "com.ericsson.sibuto.strategies.networks";
    private static Map<Class, NetworkStrategy> instantiatedStrategies = new HashMap<>();

    public static NetworkStrategy getStrategy(NetworkSpecification networkSpecification) {
        Class networkStrategyClass = findStrategyClass(networkSpecification);
        if (instantiatedStrategies.containsKey(networkStrategyClass)) {
            return instantiatedStrategies.get(networkStrategyClass);
        } else {
            return instantiateStrategy(networkStrategyClass);
        }
    }

    private static Class<?> findStrategyClass(NetworkSpecification networkSpecification) {
        Reflections reflections = new Reflections(strategiesPackage);
        Class foundNetworkStrategyClass = null;
        Set<Class<?>> networkStrategyClasses = reflections.getTypesAnnotatedWith(ANetworkStrategy.class);
        for ( Class<?> networkStrategyClass : networkStrategyClasses) {
            String networkName = networkStrategyClass.getAnnotation(ANetworkStrategy.class).networkName();
            if (networkName.equals(networkSpecification.getName())) {
                foundNetworkStrategyClass = networkStrategyClass;
            }
        }
        return foundNetworkStrategyClass;
    }

    private static NetworkStrategy instantiateStrategy(Class networkStrategyClass) {
        NetworkStrategy networkStrategy = null;
        try {
            networkStrategy = (NetworkStrategy) networkStrategyClass.newInstance();
            instantiatedStrategies.put(networkStrategyClass, networkStrategy);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return networkStrategy;
    }







}
