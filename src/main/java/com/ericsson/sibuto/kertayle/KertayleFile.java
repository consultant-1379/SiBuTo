package com.ericsson.sibuto.kertayle;

import com.ericsson.sibuto.managedobject.ManagedObject;
import com.ericsson.sibuto.node.Node;
import com.ericsson.sibuto.output.NodeOutput;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by lmieody on 25/07/16.
 */
public class KertayleFile implements NodeOutput {

    public void output(Node node) {
        String nodeName = node.getName();
        File kertayleFile = new File(nodeName);
        try {
            BufferedWriter kertayleOut = new BufferedWriter(new FileWriter(kertayleFile));
            outputManagedObjectsRecursively(node.getRootManagedObject().getChildren(), kertayleOut);
            kertayleOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void outputManagedObjectsRecursively(List<ManagedObject> managedObjects, BufferedWriter kertayleOut) throws IOException {
        for (ManagedObject managedObject: managedObjects) {
            kertayleOut.write(KertayleMO.create(managedObject));
            outputManagedObjectsRecursively(managedObject.getChildren(), kertayleOut);
        }
    }
}
