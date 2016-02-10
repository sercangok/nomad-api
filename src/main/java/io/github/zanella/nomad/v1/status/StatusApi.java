package io.github.zanella.nomad.v1.status;

import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface StatusApi {
    String leaderUrl = "/v1/status/leader";

    @RequestLine("GET " + leaderUrl)
    String getLeader();

    @RequestLine("GET " + leaderUrl + "?region={region}")
    String getLeaderOfRegion(@Param("region") String region);

    String peersUrl = "/v1/status/peers";

    @RequestLine("GET " + peersUrl)
    List<String> getPeers();
}
