package com.ericsson.sibuto.managedobject;

import com.ericsson.sibuto.AttributeSpecification;
import com.ericsson.sibuto.mimconverter.MimVersion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lmieody on 18/07/16.
 */
public class ManagedObjectSpecificationImpl implements ManagedObjectSpecification {

    private ManagedObjectSpecification parent;
    private String type;
    private MimVersion version;
    private List<AttributeSpecification> attributes;
    private List<ManagedObjectSpecification> children = new ArrayList<>();
    private ManagedObjectStrategy strategy;

    @Override
    public void setParent(ManagedObjectSpecification parent) {
        this.parent = parent;
    }

    @Override
    public ManagedObjectSpecification getParent() {
        return parent;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setVersion(MimVersion version) {
        this.version = version;
    }

    @Override
    public MimVersion getVersion() {
        return version;
    }

    @Override
    public void setAttributes(List<AttributeSpecification> attributes) {
        this.attributes = attributes;
    }

    @Override
    public List<AttributeSpecification> getAttributes() {
        return attributes;
    }


    @Override
    public void addChild(ManagedObjectSpecification child) { this.children.add(child); }

    @Override
    public void setChildren(List<ManagedObjectSpecification> children) {
        this.children = children;
    }

    @Override
    public List<ManagedObjectSpecification> getChildren() {
        return children;
    }

    @Override
    public void setStrategy() {
        this.strategy = ManagedObjectStrategyFactory.getStrategy(this);
    }

    @Override
    public ManagedObjectStrategy getStrategy() {
        return strategy;
    }

}
