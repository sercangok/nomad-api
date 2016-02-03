package net.allenaz.nomad;

public class App {
    public static void main( String[] args ) throws Exception {
        final NomadClient nomadClient = new NomadClient("virtual.box.c7");

        ///
        System.out.println("\n\t(DBG) leader: " + nomadClient.v1.statusApi.getStatusLeader());

        System.out.println("\n\t(DBG) peers: " + nomadClient.v1.statusApi.getStatusPeers());

        System.out.println("\n\t(DBG) peers: " + nomadClient.v1.statusApi.getStatusLeaderOfRegion("global"));

        ///
        System.out.println("\n\t(DBG) regions: " + nomadClient.v1.regionsApi.getRegions());
    }
}
