package io.github.zanella.nomad.v1.allocations;

import io.github.zanella.nomad.v1.nodes.models.NodeAllocation;

import feign.Param;
import feign.RequestLine;

public interface AllocationApi {
    String allocationUrl = "/v1/allocation/{allocationId}";

    @RequestLine("GET " + allocationUrl)
    NodeAllocation getAllocation(@Param("allocationId") String allocationId);

    String allocationForRegionUrl = "/v1/allocation/{allocationId}?region={region}";

    @RequestLine("GET " + allocationForRegionUrl)
    NodeAllocation getAllocationForRegion(@Param("allocationId") String allocationId, @Param("region") String region);
}
