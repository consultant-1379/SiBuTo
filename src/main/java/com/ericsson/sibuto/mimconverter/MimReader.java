package com.ericsson.sibuto.mimconverter;

import com.sun.org.apache.xerces.internal.dom.DocumentImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lmieody on 22/07/16.
 */
public class MimReader {

    private Document dom = new DocumentImpl();

    public MimReader(File mimFile) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            dom = documentBuilder.parse(mimFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ClassFromMim> getClasses() {
        List<ClassFromMim> classesFromMim = new ArrayList<>();
        List<Element> classElementList = getElementsInDocument("class");
        for (Element classElement: classElementList) {
            String className = classElement.getAttribute("name");
            if (!className.equals("ManagedObject")) {
                classesFromMim.add(new ClassFromMim(className));
            }
        }
        return classesFromMim;
    }

    public List<RelationshipFromMim> getRelationships() {
        List<RelationshipFromMim> relationshipsFromMim= new ArrayList<>();
        List<Element> relationshipElementList = getElementsInDocument("relationship");
        for (Element relationshipElement: relationshipElementList) {
            if (relationshipElement.getElementsByTagName("containment").getLength() > 0) {
                String parentClassName = getParentClassName(relationshipElement);
                String childClassName = getChildClassName(relationshipElement);
                RelationshipFromMim relationshipFromMim = new RelationshipFromMim(parentClassName, childClassName);
                relationshipsFromMim.add(relationshipFromMim);
            }
        }
        return relationshipsFromMim;
    }

    public MimVersion getMimVersion() {
        List<Element> mimElements = getElementsInDocument("mim");
        Element mimElement = mimElements.get(0);
        String name = mimElement.getAttribute("name");
        int version = Integer.parseInt(mimElement.getAttribute("version"));
        int release = Integer.parseInt(mimElement.getAttribute("release"));
        return new MimVersion(name, version, release);
    }

    private String getParentClassName(Element relationshipElement) {
        String parentClassName = getClassName(relationshipElement, "parent");
        return parentClassName;
    }

    private String getChildClassName(Element relationshipElement) {
        String childClassName = getClassName(relationshipElement, "child");
        return childClassName;
    }

    private String getClassName(Element relationshipElement, String parentOrChild) {
        NodeList parentOrChildNodes = relationshipElement.getElementsByTagName(parentOrChild);
        Element parentOrChildElement = (Element) parentOrChildNodes.item(0);
        NodeList hasClassNodes = parentOrChildElement.getElementsByTagName("hasClass");
        Element parentOrChildHasClassElement = (Element) hasClassNodes.item(0);
        String parentOrChildClassName = parentOrChildHasClassElement.getAttribute("name");
        return parentOrChildClassName;
    }

    private List<Element> getElementsInDocument(String tagName) {
        List<Element> elementList = new ArrayList<>();
        NodeList nodeList = dom.getElementsByTagName(tagName);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                elementList.add(element);
            }
        }
        return elementList;
    }
}