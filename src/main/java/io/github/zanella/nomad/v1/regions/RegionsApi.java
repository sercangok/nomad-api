package io.github.zanella.nomad.v1.regions;

import feign.RequestLine;

import java.util.List;

public interface RegionsApi {
    @RequestLine("GET /v1/regions")
    List<String> getRegions();
}
