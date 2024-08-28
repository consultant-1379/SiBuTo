package com.ericsson.sibuto.mimconverter;

import com.ericsson.sibuto.managedobject.ManagedObjectSpecification;

import java.io.File;
import java.util.*;

/**
 * Created by lmieody on 21/07/16.
 */
public class MimFileToMOSpecConverter {

    private MimReader mimReader;
    public MimFileToMOSpecConverter(File mimFile) {
        mimReader = new MimReader(mimFile);
    }

    public ManagedObjectSpecification generateManagedObjectSpecifications() {
        List<ClassFromMim> mimClassList = mimReader.getClasses();
        List<RelationshipFromMim> mimRelationshipList = mimReader.getRelationships();
        MimVersion mimVersion = mimReader.getMimVersion();

        BulkManagedObjectSpecificationCreator bulkManagedObjectSpecificationCreator =
                new BulkManagedObjectSpecificationCreator(mimClassList, mimRelationshipList, mimVersion);

        return bulkManagedObjectSpecificationCreator.getRootManagedObjectSpecification();
    }

}
