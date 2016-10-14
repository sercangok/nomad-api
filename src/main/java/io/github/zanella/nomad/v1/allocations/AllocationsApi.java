package io.github.zanella.nomad.v1.allocations;

import feign.Param;
import feign.RequestLine;
import io.github.zanella.nomad.v1.allocations.models.Allocation;
import io.github.zanella.nomad.v1.common.models.AllocationSummary;

import java.util.List;

public interface AllocationsApi {
    String allocationsUrl = "/v1/allocations";

    @RequestLine("GET " + allocationsUrl)
    List<Allocation> getAllocations();

    @RequestLine("GET " + allocationsUrl + "?region={region}")
    String getAllocationsOfRegion(@Param("region") String region);
}
