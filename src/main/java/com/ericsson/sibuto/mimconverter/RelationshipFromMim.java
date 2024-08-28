package com.ericsson.sibuto.mimconverter;

/**
 * Created by lmieody on 22/07/16.
 */
public class RelationshipFromMim {
    private String parent;
    private String child;

    public RelationshipFromMim(String parent, String child) {
        this.parent = parent;
        this.child = child;
    }

    public String getParent() {
        return parent;
    }

    public String getChild() {
        return child;
    }
}
