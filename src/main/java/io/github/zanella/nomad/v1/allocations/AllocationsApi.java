package io.github.zanella.nomad.v1.allocations;

import io.github.zanella.nomad.v1.allocations.models.Allocation;

import java.util.List;

import feign.Param;
import feign.RequestLine;

public interface AllocationsApi {
    String allocationsUrl = "/v1/allocations";

    @RequestLine("GET " + allocationsUrl)
    List<Allocation> getAllocations();

    String allocationsForRegionUrl = allocationsUrl + "?region={region}";

    @RequestLine("GET " + allocationsForRegionUrl)
    List<Allocation> getAllocationsForRegion(@Param("region") String region);
}
