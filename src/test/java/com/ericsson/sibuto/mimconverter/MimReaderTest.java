package com.ericsson.sibuto.mimconverter;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lmieody on 22/07/16.
 */
public class MimReaderTest {

    private File mimFile = new File("src/test/resources/ERBS_Test_Mim.xml");
    private MimReader mimReader = new MimReader(mimFile);

    @Test
    public void getClasses() throws Exception {
        List<ClassFromMim> classesFromMim = mimReader.getClasses();
        assertEquals(2, classesFromMim.size());
        List<String> classNames = new ArrayList<>();
        classNames.add("ManagedElement");
        classNames.add("ENodeBFunction");
        for (ClassFromMim classFromMim: classesFromMim) {
            assertTrue(classNames.contains(classFromMim.getName()));
        }
    }

    @Test
    public void getRelationships() throws Exception {
        List<RelationshipFromMim> relationshipsFromMim = mimReader.getRelationships();
        assertEquals(1, relationshipsFromMim.size());
        RelationshipFromMim relationshipFromMim = relationshipsFromMim.get(0);
        assertEquals("ManagedElement", relationshipFromMim.getParent());
        assertEquals("ENodeBFunction", relationshipFromMim.getChild());
    }

    @Test
    public void getMimVersion() throws Exception {
        MimVersion mimVersion = mimReader.getMimVersion();
        assertEquals("ERBS_NODE_MODEL_G", mimVersion.getName());
        assertEquals(1, mimVersion.getVersion());
        assertEquals(281, mimVersion.getRelease());
    }

}