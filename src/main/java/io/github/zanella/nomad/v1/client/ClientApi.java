package io.github.zanella.nomad.v1.client;

import io.github.zanella.nomad.v1.client.models.Stats;

import feign.RequestLine;

public interface ClientApi {
    String statsfUrl = "/v1/client/stats";

    @RequestLine("GET " + statsfUrl)
    Stats getStats();
}
