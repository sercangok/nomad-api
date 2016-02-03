package net.allenaz.nomad.v1.status;

import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface StatusApi {
    @RequestLine("GET /v1/status/leader")
    String getStatusLeader();

    @RequestLine("GET /v1/status/leader?region={region}")
    String getStatusLeaderOfRegion(@Param("region") String region);

    @RequestLine("GET /v1/status/peers")
    List<String> getStatusPeers();
}
