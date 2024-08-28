package com.ericsson.sibuto.managedobject;


import com.ericsson.sibuto.node.Node;
import com.ericsson.sibuto.node.NodeImpl;
import com.ericsson.sibuto.strategies.managedobjects.TheDefaultManagedObjectStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

/**
 * Created by lmieody on 27/07/16.
 */
public class ManagedObjectImplTest {

    private ManagedObject managedObjectUnderTest;

    @Before
    public void setup() {
        ManagedObjectSpecification mockedRootManagedObjectSpecification = mock(ManagedObjectSpecification.class);
        when(mockedRootManagedObjectSpecification.getParent()).thenReturn(null);
        when(mockedRootManagedObjectSpecification.getType()).thenReturn("ManagedElement");
        when(mockedRootManagedObjectSpecification.getStrategy()).thenReturn(new TheDefaultManagedObjectStrategy());
        ManagedObjectSpecification mockedManagedObjectSpecification = mock(ManagedObjectSpecification.class);
        when(mockedManagedObjectSpecification.getType()).thenReturn("ENodeBFunction");
        when(mockedManagedObjectSpecification.getStrategy()).thenReturn(new TheDefaultManagedObjectStrategy());
        ManagedObjectSpecification mockedChildManagedObjectSpecification = mock(ManagedObjectSpecification.class);
        when(mockedChildManagedObjectSpecification.getType()).thenReturn("EUtranCellFDD");
        when(mockedChildManagedObjectSpecification.getStrategy()).thenReturn(new TestManagedObjectStrategy());
        List<ManagedObjectSpecification> childMOSpecs = new ArrayList<>();
        childMOSpecs.add(mockedChildManagedObjectSpecification);
        when(mockedManagedObjectSpecification.getChildren()).thenReturn(childMOSpecs);
        Node node = mock(Node.class);
        ManagedObject rootManagedObject = new ManagedObjectImpl(node, null, mockedRootManagedObjectSpecification, 1);
        managedObjectUnderTest = new ManagedObjectImpl(node, rootManagedObject, mockedManagedObjectSpecification, 1);
        managedObjectUnderTest.createChildren();
    }



    @Test
    public void getFDN() throws Exception {
        assertEquals("ManagedElement=1,ENodeBFunction=1", managedObjectUnderTest.getFDN());
    }

    @Test
    public void createAndGetChildren() throws Exception {
        assertEquals(5, managedObjectUnderTest.getChildren().size());
        assertEquals("EUtranCellFDD=1", managedObjectUnderTest.getChildren().get(0).toString());
        assertEquals("EUtranCellFDD=5", managedObjectUnderTest.getChildren().get(4).toString());
    }

    @Test
    public void toStringShouldReturnMOTypeAndMOId() throws Exception {
        assertEquals("ENodeBFunction=1", managedObjectUnderTest.toString());
    }

    @Test
    public void getInstanceOfManagedObjectUnderParent() throws Exception {
        for (int i=0; i<managedObjectUnderTest.getChildren().size(); i++) {
            assertEquals(i+1, managedObjectUnderTest.getChildren().get(i).getInstanceNumberOfManagedObjectUnderParent());
        }
    }

    @Test
    public void getInstanceOfManagedObjectOfThisSpecification() throws Exception {
        assertEquals(2, managedObjectUnderTest.getChildren().get(1).getInstanceNumberOfThisSpecification());
    }

    @Test
    public void getTotalNumberOfManagedObjectsOfThisSpecificationCreated() throws Exception {
        assertEquals(5, managedObjectUnderTest.getChildren().get(1).getTotalNumberOfInstancesUsingThisSpecification());
    }

}