package com.ericsson.sibuto.node;

import com.ericsson.sibuto.abstraction.SimulatedEntitySpecification;
import com.ericsson.sibuto.managedobject.ManagedObjectSpecification;

import java.io.File;

/**
 * Created by lmieody on 26/07/16.
 */
public interface NodeSpecification extends SimulatedEntitySpecification {
    File getMimFileName();
    ManagedObjectSpecification getRootManagedObjectSpecification();
    NodeStrategy getStrategy();
}
