package com.ericsson.sibuto.managedobject;

import com.ericsson.sibuto.abstraction.SimulatedEntitySpecification;
import com.ericsson.sibuto.AttributeSpecification;
import com.ericsson.sibuto.mimconverter.MimVersion;

import java.util.List;

/**
 * Created by lmieody on 18/07/16.
 */
public interface ManagedObjectSpecification extends SimulatedEntitySpecification {
    void setParent(ManagedObjectSpecification parent);

    ManagedObjectSpecification getParent();

    void setType(String type);

    String getType();

    void setVersion(MimVersion version);

    MimVersion getVersion();

    void setAttributes(List<AttributeSpecification> attributes);

    List<AttributeSpecification> getAttributes();

    void addChild(ManagedObjectSpecification child);

    void setChildren(List<ManagedObjectSpecification> children);

    List<ManagedObjectSpecification> getChildren();

    void setStrategy();

    ManagedObjectStrategy getStrategy();

}
