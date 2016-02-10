package io.github.zanella.nomad.v1.agent;

import feign.RequestLine;

public interface AgentApi {
    String selfUrl = "/v1/agent/self";

    @RequestLine("GET " + selfUrl)
    Self getSelf();
}
