package io.github.zanella.nomad.v1.client;

import io.github.zanella.nomad.v1.client.models.AllocationStats;
import io.github.zanella.nomad.v1.client.models.Stats;

import feign.Param;
import feign.RequestLine;

public interface ClientApi {
    String statsUrl = "/v1/client/stats";

    @RequestLine("GET " + statsUrl)
    Stats getStats();

    String allocationStatsUrl = "/v1/client/allocation/{allocationId}/stats";

    @RequestLine("GET " + allocationStatsUrl)
    AllocationStats getAllocationStats(@Param("allocationId") String allocationId);
}
