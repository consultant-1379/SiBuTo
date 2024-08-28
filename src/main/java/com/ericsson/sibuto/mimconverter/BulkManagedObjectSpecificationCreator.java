package com.ericsson.sibuto.mimconverter;

import com.ericsson.sibuto.managedobject.ManagedObjectSpecification;
import com.ericsson.sibuto.managedobject.ManagedObjectSpecificationImpl;

import java.util.*;

/**
 * Created by lmieody on 22/07/16.
 */
public class BulkManagedObjectSpecificationCreator {

    private Map<String, ManagedObjectSpecification> managedObjectSpecificationMap =
            new HashMap<>();

    public BulkManagedObjectSpecificationCreator(List<ClassFromMim> mimClassList, List<RelationshipFromMim> mimRelationshipList, MimVersion mimVersion) {
        createManagedObjectSpecificationsAndSetNames(mimClassList);
        setParentsAndChildren(mimRelationshipList);
        setMimVersion(mimVersion);
        setStrategy();
    }

    private void createManagedObjectSpecificationsAndSetNames(List<ClassFromMim> mimClassList) {
        for (ClassFromMim mimClass: mimClassList) {
            ManagedObjectSpecification managedObjectSpecification = new ManagedObjectSpecificationImpl();
            managedObjectSpecification.setType(mimClass.getName());
            managedObjectSpecificationMap.put(managedObjectSpecification.getType(), managedObjectSpecification);
        }
    }

    private void setParentsAndChildren(List<RelationshipFromMim> mimRelationshipList) {
        for (RelationshipFromMim mimRelationship: mimRelationshipList) {
            String parent = mimRelationship.getParent();
            String child = mimRelationship.getChild();
            managedObjectSpecificationMap.get(child).setParent(managedObjectSpecificationMap.get(parent));
            managedObjectSpecificationMap.get(parent).addChild(managedObjectSpecificationMap.get(child));
        }
    }

    private void setMimVersion(MimVersion mimVersion) {
        managedObjectSpecificationMap.values().forEach(managedObjectSpecification ->
                managedObjectSpecification.setVersion(mimVersion));

    }

    private void setStrategy() {
        managedObjectSpecificationMap.values().forEach(managedObjectSpecification ->
                managedObjectSpecification.setStrategy());
    }

    public ManagedObjectSpecification getRootManagedObjectSpecification() {
        ManagedObjectSpecification rootManagedObjectSpecification = new ManagedObjectSpecificationImpl();
        for (ManagedObjectSpecification managedObjectSpecification : managedObjectSpecificationMap.values()) {
            if (managedObjectSpecification.getParent() == null) {
                rootManagedObjectSpecification = managedObjectSpecification;
            }
        }
        return rootManagedObjectSpecification;
    }
}
