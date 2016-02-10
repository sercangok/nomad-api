package io.github.zanella.nomad.v1.agent;

import feign.RequestLine;
import io.github.zanella.nomad.v1.agent.models.JoinResult;
import io.github.zanella.nomad.v1.agent.models.Self;

public interface AgentApi {
    String selfUrl = "/v1/agent/self";

    @RequestLine("GET " + selfUrl)
    Self getSelf();

    String joinUrl = "/v1/agent/join";

    @RequestLine("POST " + joinUrl)
    JoinResult postJoin(String address);
}
