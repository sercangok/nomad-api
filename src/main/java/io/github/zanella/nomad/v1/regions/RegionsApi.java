package io.github.zanella.nomad.v1.regions;

import feign.RequestLine;

import java.util.List;

public interface RegionsApi {
    String regionsUrl = "/v1/regions";

    @RequestLine("GET " + regionsUrl)
    List<String> getRegions();
}
