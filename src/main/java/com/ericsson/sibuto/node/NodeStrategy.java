package com.ericsson.sibuto.node;

import com.ericsson.sibuto.abstraction.SimulatedEntityStrategy;
import com.ericsson.sibuto.simulation.Simulation;

/**
 * Created by lmieody on 26/07/16.
 */
public interface NodeStrategy extends SimulatedEntityStrategy {
    String getName(Node node);
    int getNumberOfNodesPerSimulation(Node node);
}
