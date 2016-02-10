package io.github.zanella.nomad.v1.agent;

import feign.RequestLine;
import io.github.zanella.nomad.v1.agent.models.Self;

public interface AgentApi {
    String selfUrl = "/v1/agent/self";

    @RequestLine("GET " + selfUrl)
    Self getSelf();
}
