package com.ericsson.sibuto.node;

import com.ericsson.sibuto.managedobject.ManagedObjectSpecification;
import com.ericsson.sibuto.mimconverter.MimFileToMOSpecConverter;

import java.io.File;

/**
 * Created by lmieody on 26/07/16.
 */
public class NodeSpecificationImpl implements NodeSpecification {

    private File mimFileName;
    private ManagedObjectSpecification rootManagedObjectSpecification;
    private NodeStrategy nodeStrategy;

    public NodeSpecificationImpl(File mimFileName) {
        this.mimFileName = mimFileName;
        this.rootManagedObjectSpecification =
                new MimFileToMOSpecConverter(mimFileName).
                        generateManagedObjectSpecifications();
        this.nodeStrategy = NodeStrategyFactory.getStrategy(this);
    }

    public ManagedObjectSpecification getRootManagedObjectSpecification() {
        return this.rootManagedObjectSpecification;
    }

    @Override
    public File getMimFileName() {
        return this.mimFileName;
    }

    public NodeStrategy getStrategy() {
        return nodeStrategy;
    }
}