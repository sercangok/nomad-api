package io.github.zanella.nomad;

import io.github.zanella.nomad.v1.nodes.models.NodeAllocation;

import java.util.List;

public class App {
    public static void main( String[] args ) throws Exception {
        final NomadClient nomadClient = new NomadClient("virtual.box.c7");

        final String nodeId = nomadClient.v1.nodes.getNodesOfRegion("global").get(0).getId();

        ///
        final List<NodeAllocation> nodeAllocationList = nomadClient.v1.node.getNodeAllocations(nodeId);
        for (NodeAllocation nodeAllocation : nodeAllocationList) {
            System.out.println("\n\t(DBG) nodeAllocation: " + nodeAllocation);

            System.out.println("\n\t *** nodeAllocation.getNodeJob(): " + nodeAllocation.getNodeJob());
        }
    }
}
