package com.ericsson.sibuto.mimconverter;

/**
 * Created by lmieody on 25/07/16.
 */
public class MimVersion {
    private String name;
    private int version;
    private int release;

    public MimVersion(String name, int version, int release) {
        this.name = name;
        this.version = version;
        this.release = release;
    }

    public String getName() {
        return name;
    }

    public int getVersion() {
        return version;
    }

    public int getRelease() {
        return release;
    }
}
