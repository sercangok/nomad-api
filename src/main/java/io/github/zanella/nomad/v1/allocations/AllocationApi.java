package io.github.zanella.nomad.v1.allocations;

import feign.Param;
import feign.RequestLine;
import io.github.zanella.nomad.v1.nodes.models.NodeAllocation;

public interface AllocationApi {
    String allocationUrl = "/v1/allocation";

    @RequestLine("GET " + allocationUrl + "/{allocationId}")
    NodeAllocation getAllocation(@Param("allocationId") String allocationId);

    @RequestLine("GET " + allocationUrl + "/{allocationId}" + "?region={region}")
    NodeAllocation getAllocationForRegion(@Param("allocationId") String allocationId, @Param("region") String region);
}
