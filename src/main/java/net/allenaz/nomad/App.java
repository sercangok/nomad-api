package net.allenaz.nomad;

import net.allenaz.nomad.v1.nodes.models.NodeSummary;

public class App {
    public static void main( String[] args ) throws Exception {
        final NomadClient nomadClient = new NomadClient("virtual.box.c7");

        ///
        System.out.println("\n\t(DBG) leader: " + nomadClient.v1.statusApi.getStatusLeader());

        System.out.println("\n\t(DBG) peers: " + nomadClient.v1.statusApi.getStatusPeers());

        System.out.println("\n\t(DBG) peers: " + nomadClient.v1.statusApi.getStatusLeaderOfRegion("global"));

        ///
        System.out.println("\n\t(DBG) regions: " + nomadClient.v1.regionsApi.getRegions());

        ///
        for (NodeSummary nodeSummary : nomadClient.v1.nodesApi.getNodes()) {
            System.out.println("\n\t(DBG) nodeSummary: " + nodeSummary);
        }

        nomadClient.v1.nodesApi.getNodesOfRegion("global");
    }
}
