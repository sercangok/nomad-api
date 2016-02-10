package io.github.zanella.nomad.v1;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.github.zanella.nomad.v1.agent.AgentApi;
import io.github.zanella.nomad.v1.agent.models.JoinResult;
import io.github.zanella.nomad.v1.agent.models.Self;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

public class AgentApiTest extends AbstractCommon {
    @Test
    public void getSelfTest() {
        final String rawSelf = "{" +
                "\"config\": {" +
                "    \"Region\": \"global\"," +
                "    \"Datacenter\": \"dc1\"," +
                "    \"NodeName\": \"\"," +
                "    \"DataDir\": \"\"," +
                "    \"LogLevel\": \"DEBUG\"," +
                "    \"BindAddr\": \"127.0.0.1\"," +
                "    \"EnableDebug\": true," +
                "    \"Ports\": {\"HTTP\": 4646, \"RPC\": 4647, \"Serf\": 4648}," +
                "    \"Addresses\": {\"HTTP\": \"\", \"RPC\": \"\", \"Serf\": \"\"}," +
                "    \"AdvertiseAddrs\": {\"RPC\": \"\", \"Serf\": \"\"}," +
                "    \"Client\": {" +
                "        \"Enabled\": true, \"StateDir\": \"\", \"AllocDir\": \"\", \"Servers\": null," +
                "        \"NodeID\": \"\", \"NodeClass\": \"\", \"Meta\": null" +
                "    }," +
                "    \"Server\": {" +
                "        \"Enabled\": true, \"Bootstrap\": false, \"BootstrapExpect\": 0," +
                "        \"DataDir\": \"\", \"ProtocolVersion\": 0, \"NumSchedulers\": 0, \"EnabledSchedulers\": null" +
                "    }," +
                "    \"Telemetry\": null," +
                "    \"LeaveOnInt\": false," +
                "    \"LeaveOnTerm\": false," +
                "    \"EnableSyslog\": false," +
                "    \"SyslogFacility\": \"\"," +
                "    \"DisableUpdateCheck\": false," +
                "    \"DisableAnonymousSignature\": true," +
                "    \"Revision\": \"\"," +
                "    \"Version\": \"0.1.0\"," +
                "    \"VersionPrerelease\": \"dev\"," +
                "    \"DevMode\": true," +
                "    \"Atlas\": null" +
                "}," +
                "\"member\": {" +
                "    \"Name\": \"Armons-MacBook-Air.local.global\"," +
                "    \"Addr\": \"127.0.0.1\"," +
                "    \"Port\": 4648," +
                "    \"Tags\": {" +
                "        \"bootstrap\": \"1\", \"build\": \"0.1.0dev\", \"dc\": \"dc1\", \"port\": \"4647\"," +
                "        \"region\": \"global\", \"role\": \"nomad\", \"vsn\": \"1\", \"vsn_max\": \"1\"," +
                "        \"vsn_min\": \"1\"" +
                "    }," +
                "    \"Status\": \"alive\"," +
                "    \"ProtocolMin\": 1," +
                "    \"ProtocolMax\": 3," +
                "    \"ProtocolCur\": 2," +
                "    \"DelegateMin\": 2," +
                "    \"DelegateMax\": 4," +
                "    \"DelegateCur\": 4" +
                "}," +
                "\"stats\": {" +
                "    \"client\": {" +
                "        \"heartbeat_ttl\": \"19116443712\", \"known_servers\": \"0\"," +
                "        \"last_heartbeat\": \"8222075779\", \"num_allocations\": \"0\"" +
                "    }," +
                "    \"nomad\": {" +
                "        \"bootstrap\": \"false\", \"known_regions\": \"1\", \"leader\": \"true\", \"server\": \"true\"" +
                "    }," +
                "    \"raft\": {" +
                "        \"applied_index\": \"91\", \"commit_index\": \"91\", \"fsm_pending\": \"0\"," +
                "        \"last_contact\": \"never\", \"last_log_index\": \"91\", \"last_log_term\": \"1\"," +
                "        \"last_snapshot_index\": \"0\", \"last_snapshot_term\": \"0\", \"num_peers\": \"0\"," +
                "        \"state\": \"Leader\", \"term\": \"1\"" +
                "    }," +
                "    \"runtime\": {" +
                "        \"arch\": \"amd64\", \"cpu_count\": \"4\", \"goroutines\": \"58\"," +
                "        \"kernel.name\": \"darwin\", \"max_procs\": \"1\", \"version\": \"go1.4.2\"" +
                "    }," +
                "    \"serf\": {" +
                "        \"encrypted\": \"false\", \"event_queue\": \"0\", \"event_time\": \"1\"," +
                "        \"failed\": \"0\", \"intent_queue\": \"0\", \"left\": \"0\", \"member_time\": \"1\"," +
                "        \"members\": \"1\", \"query_queue\": \"0\", \"query_time\": \"1\"" +
                "    }" +
                "}" +
                "}";

        stubFor(get(urlEqualTo(AgentApi.selfUrl))
                .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawSelf)));

        final Self expectedSelf = new Self(
                new Self.Config(
                        "global", "dc1", "", "", "DEBUG", "127.0.0.1", true,
                        new Self.Config.Ports(4646, 4647, 4648),
                        new Self.Config.Addresses("", "", ""),
                        new Self.Config.AdvertiseAddrs("", ""),
                        new Self.Config.Client(true, "", "", null, "", "", null),
                        new Self.Config.Server(true, false, 0, "", 0, 0, null),
                        null, false, false, false, "", false, true, "", "0.1.0", "dev", true, null),

                new Self.Member(
                        "Armons-MacBook-Air.local.global", "127.0.0.1", 4648,
                        ImmutableMap.<String, String>builder()
                                .put("bootstrap", "1")
                                .put("build", "0.1.0dev")
                                .put("dc", "dc1")
                                .put("port", "4647")
                                .put("region", "global")
                                .put("role", "nomad")
                                .put("vsn", "1")
                                .put("vsn_max", "1")
                                .put("vsn_min", "1")
                                .build(),
                        "alive", 1, 3, 2, 2, 4, 4),

                new Self.Stats(
                        new Self.Stats.Client("19116443712", "0", "8222075779", "0"),
                        new Self.Stats.Nomad("false", "1", "true", "true"),
                        new Self.Stats.Raft("91", "91", "0", "never", "91", "1", "0", "0", "0", "Leader", "1"),
                        new Self.Stats.Runtime("amd64", "4", "58", "darwin", "1", "go1.4.2"),
                        new Self.Stats.Serf("false", "0", "1", "0", "0", "0", "1", "1", "0", "1"))
        );

        assertEquals(expectedSelf, nomadClient.v1.agent.getSelf());
    }

    @Test
    public void postJoinTest() {
        final String rawJoinResult = "{\"num_joined\": 1, \"error\": \"\"}";

        final String address = "BLAH";

        // TODO - address definition
        stubFor(post(urlEqualTo(AgentApi.joinUrl))
                //.withRequestBody(equalTo(address))  //equalToJson(objectMapper.writeValueAsString(address)))
                // TODO - .withRequestBody(matchingJsonPath("$.Type == 'system'"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(rawJoinResult)));

        assertEquals(new JoinResult(1, ""), nomadClient.v1.agent.postJoin(address));
    }

    @Test
    public void getMembersTest() {
        final String rawMembers = "[ {" +
                "    \"Name\": \"Armons-MacBook-Air.local.global\"," +
                "    \"Addr\": \"127.0.0.1\"," +
                "    \"Port\": 4648," +
                "    \"Tags\": {" +
                "        \"bootstrap\": \"1\", \"build\": \"0.1.0dev\", \"dc\": \"dc1\", \"port\": \"4647\"," +
                "        \"region\": \"global\", \"role\": \"nomad\", \"vsn\": \"1\", \"vsn_max\": \"1\"," +
                "        \"vsn_min\": \"1\"" +
                "    }," +
                "    \"Status\": \"alive\"," +
                "    \"ProtocolMin\": 1," +
                "    \"ProtocolMax\": 3," +
                "    \"ProtocolCur\": 2," +
                "    \"DelegateMin\": 2," +
                "    \"DelegateMax\": 4," +
                "    \"DelegateCur\": 4" +
                "} ]";

        stubFor(get(urlEqualTo(AgentApi.membersUrl))
                .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawMembers)));

        final Self.Member expectedMember = new Self.Member(
                "Armons-MacBook-Air.local.global", "127.0.0.1", 4648,
                ImmutableMap.<String, String>builder()
                        .put("bootstrap", "1").put("build", "0.1.0dev").put("dc", "dc1").put("port", "4647")
                        .put("region", "global").put("role", "nomad").put("vsn", "1").put("vsn_max", "1")
                        .put("vsn_min", "1").build(),
                "alive", 1, 3, 2, 2, 4, 4);

        assertEquals(ImmutableList.of(expectedMember), nomadClient.v1.agent.getMembers());
    }

    @Test
    public void getServersTest() {
        final String server1 = "server1.local:4647";
        final String server2 = "server2.local:4647";
        final String rawServers = "[\"" + server1 + "\", \"" + server2 + "\"]";

        stubFor(get(urlEqualTo(AgentApi.serversUrl))
                .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawServers)));

        assertEquals(ImmutableList.of(server1, server2), nomadClient.v1.agent.getServers());
    }
}
