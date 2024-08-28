package com.ericsson.sibuto.managedobject;

import com.ericsson.sibuto.strategies.managedobjects.TheDefaultManagedObjectStrategy;
import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by lmieody on 18/07/16.
 */
public class ManagedObjectStrategyFactory {

    private static String strategiesPackage = "com.ericsson.sibuto.strategies.managedobjects.";
    private static Map<String, ManagedObjectStrategy> instantiatedStrategies = new HashMap<>();

    public static ManagedObjectStrategy getStrategy(ManagedObjectSpecification managedObjectSpecification) {
        String className = strategiesPackage + managedObjectSpecification.getType() + "Strategy";
        if (instantiatedStrategies.containsKey(className)) {
            return instantiatedStrategies.get(className);
        } else {
            return instantiateStrategy(className);
        }
    }

    private static ManagedObjectStrategy instantiateStrategy(String className) {
        ManagedObjectStrategy managedObjectStrategy = null;
        try {
            Class strategyClass = Class.forName(className);
            managedObjectStrategy = (ManagedObjectStrategy) strategyClass.newInstance();
            instantiatedStrategies.put(className, managedObjectStrategy);
        } catch (ClassNotFoundException e) {
            managedObjectStrategy = new TheDefaultManagedObjectStrategy();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return managedObjectStrategy;
    }

    Reflections reflections = new Reflections(
            new ConfigurationBuilder().
                    setUrls(ClasspathHelper.forPackage(strategiesPackage)).
                    setScanners( new TypeAnnotationsScanner())
    );

    Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(MOStrategy.class);
    Set<Class<? extends ManagedObjectStrategy>> strategyClasses = reflections.getSubTypesOf(ManagedObjectStrategy.class);

}