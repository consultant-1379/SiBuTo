package com.ericsson.sibuto.node;

import com.ericsson.sibuto.abstraction.SimulatedEntities;
import com.ericsson.sibuto.abstraction.SimulatedEntity;
import com.ericsson.sibuto.abstraction.SimulatedEntityImpl;
import com.ericsson.sibuto.kertayle.KertayleFile;
import com.ericsson.sibuto.managedobject.ManagedObject;
import com.ericsson.sibuto.managedobject.ManagedObjectImpl;
import com.ericsson.sibuto.managedobject.ManagedObjectSpecification;
import com.ericsson.sibuto.output.NodeOutput;
import com.ericsson.sibuto.network.Network;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lmieody on 26/07/16.
 */
public class NodeImpl extends SimulatedEntityImpl implements Node {

    private Network network;
    private ManagedObject rootManagedObject;
    private NodeSpecification nodeSpecification;
    private String name;

    public NodeImpl(Network network, NodeSpecification nodeSpecification) {
        super(nodeSpecification);
        this.network = network;
        this.nodeSpecification = nodeSpecification;
        this.name = nodeSpecification.getStrategy().getName(this);
        ManagedObjectSpecification rootManagedObjectSpecification = this.nodeSpecification.getRootManagedObjectSpecification();
        this.rootManagedObject = new ManagedObjectImpl(this, null, rootManagedObjectSpecification, 1);
    }

    public Network getNetwork() {
        return network;
    }

    public String getName() {
        return name;
    }

    public void createNode() {
        List<ManagedObject> rootManagedObjectInAList = new ArrayList<>();
        rootManagedObjectInAList.add(rootManagedObject);
        createManagedObjectsRecursively(rootManagedObjectInAList);
    }

    private static void createManagedObjectsRecursively(List<ManagedObject> managedObjects) {
        for (ManagedObject managedObject : managedObjects) {
            managedObject.createChildren();
            createManagedObjectsRecursively(managedObject.getChildren());
        }
    }

    public void output() {
        NodeOutput nodeOutput = new KertayleFile();
        nodeOutput.output(this);
    }

    public ManagedObject getRootManagedObject() {
        return rootManagedObject;
    }

    public NodeSpecification getSpecification() {
        return nodeSpecification;
    }
}


