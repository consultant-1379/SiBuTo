package com.ericsson.sibuto;

import com.ericsson.sibuto.network.Network;
import com.ericsson.sibuto.network.NetworkImpl;
import com.ericsson.sibuto.network.NetworkSpecification;
import com.ericsson.sibuto.network.NetworkSpecificationImpl;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        File mimFileDir = new File("/home/lmieody/workspace/SiBuTo/resources");
        NetworkSpecification networkSpecification = new NetworkSpecificationImpl("NetworkZero", mimFileDir);
        Network network = new NetworkImpl(networkSpecification, "NetworkZero");
        network.create();
        network.output();
    }
}