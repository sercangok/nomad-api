package io.github.zanella.nomad.v1.status;

import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface StatusApi {
    String statusLeaderUrl = "/v1/status/leader";

    @RequestLine("GET " + statusLeaderUrl)
    String getStatusLeader();

    @RequestLine("GET " + statusLeaderUrl + "?region={region}")
    String getStatusLeaderOfRegion(@Param("region") String region);

    String statusPeersUrl = "/v1/status/peers";

    @RequestLine("GET " + statusPeersUrl)
    List<String> getStatusPeers();
}
