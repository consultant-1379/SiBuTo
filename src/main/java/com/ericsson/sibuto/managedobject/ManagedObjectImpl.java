package com.ericsson.sibuto.managedobject;

import com.ericsson.sibuto.abstraction.SimulatedEntityImpl;
import com.ericsson.sibuto.node.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lmieody on 18/07/16.
 */
public class ManagedObjectImpl extends SimulatedEntityImpl implements ManagedObject {

    private int instanceNumberOfManagedObjectUnderParent;
    private String Id;
    private ManagedObject parent;
    private List<ManagedObject> children;
    private ManagedObjectSpecification managedObjectSpecification;
    private Node node;

    public ManagedObjectImpl(Node node, ManagedObject parent, ManagedObjectSpecification managedObjectSpecification, int instanceOfMOUnderParent) {
        super(managedObjectSpecification);
        this.instanceNumberOfManagedObjectUnderParent = instanceOfMOUnderParent;
        this.node = node;
        this.parent = parent;
        this.children = new ArrayList<>();
        this.managedObjectSpecification = managedObjectSpecification;
        this.Id = managedObjectSpecification.
                getStrategy().
                getId(managedObjectSpecification, this);
    }

    @Override
    public int getInstanceNumberOfManagedObjectUnderParent() {
        return this.instanceNumberOfManagedObjectUnderParent;
    }

    @Override
    public String getId() {
        return this.Id;
    }


    public ManagedObject getParent() {
        return this.parent;
    }

    public Node getNode() {
        return this.node;
    }

    @Override
    public String getType() {
        return this.managedObjectSpecification.getType();
    }

    @Override
    public String getFDN() {
        StringBuilder fdn = new StringBuilder();
        fdn.insert(0, this.toString());
        ManagedObject ancestor = this.parent;
        while (ancestor != null) {
            fdn.insert(0, ancestor.toString() + ",");
            ancestor = ancestor.getParent();
        }
        return fdn.toString();
    }

    public void createChildren() {
        for (ManagedObjectSpecification childManagedObjectOSpecification : managedObjectSpecification.getChildren()) {
            createChildrenBasedOnSpecification(childManagedObjectOSpecification);
        }
    }

    private void createChildrenBasedOnSpecification(ManagedObjectSpecification childManagedObjectSpecification) {
        ManagedObjectStrategy childManagedObjectStrategy = childManagedObjectSpecification.getStrategy();
        int cardinality = childManagedObjectStrategy.getCardinality(childManagedObjectSpecification, this);
        for (int moInstance = 1; moInstance <= cardinality; moInstance++) {
            children.add(new ManagedObjectImpl(this.node, this, childManagedObjectSpecification, moInstance));
        }
    }

    public List<ManagedObject> getChildren() {
        return this.children;
    }

    @Override
    public String toString() {
        return this.managedObjectSpecification.getType() + "=" + this.Id;
    }

    @Override
    public ManagedObjectSpecification getSpecification() {
        return managedObjectSpecification;
    }
}
