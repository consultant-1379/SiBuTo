package com.ericsson.sibuto.node;

import java.util.HashMap;
import java.util.Map;

public class NodeStrategyFactory {

    private static String strategiesPackage = "com.ericsson.sibuto.strategies.nodes.";
    private static Map<String, NodeStrategy> instantiatedStrategies = new HashMap<>();

    public static NodeStrategy getStrategy(NodeSpecification nodeSpecification) {
        String className = strategiesPackage + nodeSpecification.getMimFileName().getName() + "Strategy";
        if (instantiatedStrategies.containsKey(className)) {
            return instantiatedStrategies.get(className);
        } else {
            return instantiateStrategy(className);
        }
    }

    private static NodeStrategy instantiateStrategy(String className) {
        NodeStrategy nodeStrategy = null;
        try {
            Class strategyClass = Class.forName(className);
            nodeStrategy = (NodeStrategy) strategyClass.newInstance();
            instantiatedStrategies.put(className, nodeStrategy);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return nodeStrategy;
    }
}
