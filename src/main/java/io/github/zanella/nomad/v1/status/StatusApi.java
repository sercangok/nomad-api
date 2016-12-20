package io.github.zanella.nomad.v1.status;

import java.util.List;

import feign.Param;
import feign.RequestLine;

public interface StatusApi {
    String leaderUrl = "/v1/status/leader";

    @RequestLine("GET " + leaderUrl)
    String getLeader();

    String leaderForRegionUrl = leaderUrl + "?region={region}";

    @RequestLine("GET " + leaderForRegionUrl)
    String getLeaderForRegion(@Param("region") String region);

    String peersUrl = "/v1/status/peers";

    @RequestLine("GET " + peersUrl)
    List<String> getPeers();
}
