package io.github.zanella.nomad.v1.agent;

import feign.Param;
import feign.RequestLine;
import io.github.zanella.nomad.v1.agent.models.JoinResult;
import io.github.zanella.nomad.v1.agent.models.Self;

import java.util.List;

public interface AgentApi {
    String selfUrl = "/v1/agent/self";

    @RequestLine("GET " + selfUrl)
    Self getSelf();

    String joinUrl = "/v1/agent/join";

    @RequestLine("POST " + joinUrl)
    JoinResult postJoin(String address);

    String membersUrl = "/v1/agent/members";

    @RequestLine("GET " + membersUrl)
    List<Self.Member> getMembers();

    String forceLeaveUrl = "/v1/agent/force-leave";

    @RequestLine("POST " + forceLeaveUrl)
    Void postForceLeave(@Param("node") String nodeName);

    String serversUrl = "/v1/agent/servers";

    @RequestLine("GET " + serversUrl)
    List<String> getServers();

    @RequestLine("POST " + serversUrl)
    Void postServers(@Param("address") String address);
}
