package com.ericsson.sibuto.kertayle;

import com.ericsson.sibuto.managedobject.ManagedObject;

/**
 * Created by lmieody on 25/07/16.
 */
public class KertayleMO {

    public static String create(ManagedObject managedObject) {
        KertayleCreateCommand.Builder builder = new KertayleCreateCommand.Builder();
        builder.parent(managedObject.getParent().getFDN());
        builder.identity(managedObject.getId());
        builder.moType(managedObject.getType());
        KertayleCreateCommand kertayleCreateCommand = builder.build();
        return kertayleCreateCommand.toString();
    }

}
