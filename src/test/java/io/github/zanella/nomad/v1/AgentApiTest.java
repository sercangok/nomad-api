package io.github.zanella.nomad.v1;

import com.google.common.collect.ImmutableMap;
import io.github.zanella.nomad.v1.agent.AgentApi;
import io.github.zanella.nomad.v1.agent.Self;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

public class AgentApiTest extends AbstractCommon {
    @Test
    public void getSelfTest() {
        final String rawSelf = "{\n" +
                "\"config\": {\n" +
                "    \"Region\": \"global\",\n" +
                "    \"Datacenter\": \"dc1\",\n" +
                "    \"NodeName\": \"\",\n" +
                "    \"DataDir\": \"\",\n" +
                "    \"LogLevel\": \"DEBUG\",\n" +
                "    \"BindAddr\": \"127.0.0.1\",\n" +
                "    \"EnableDebug\": true,\n" +
                "    \"Ports\": {\n" +
                "        \"HTTP\": 4646,\n" +
                "        \"RPC\": 4647,\n" +
                "        \"Serf\": 4648\n" +
                "    },\n" +
                "    \"Addresses\": {\n" +
                "        \"HTTP\": \"\",\n" +
                "        \"RPC\": \"\",\n" +
                "        \"Serf\": \"\"\n" +
                "    },\n" +
                "    \"AdvertiseAddrs\": {\n" +
                "        \"RPC\": \"\",\n" +
                "        \"Serf\": \"\"\n" +
                "    },\n" +
                "    \"Client\": {\n" +
                "        \"Enabled\": true,\n" +
                "        \"StateDir\": \"\",\n" +
                "        \"AllocDir\": \"\",\n" +
                "        \"Servers\": null,\n" +
                "        \"NodeID\": \"\",\n" +
                "        \"NodeClass\": \"\",\n" +
                "        \"Meta\": null\n" +
                "    },\n" +
                "    \"Server\": {\n" +
                "        \"Enabled\": true,\n" +
                "        \"Bootstrap\": false,\n" +
                "        \"BootstrapExpect\": 0,\n" +
                "        \"DataDir\": \"\",\n" +
                "        \"ProtocolVersion\": 0,\n" +
                "        \"NumSchedulers\": 0,\n" +
                "        \"EnabledSchedulers\": null\n" +
                "    },\n" +
                "    \"Telemetry\": null,\n" +
                "    \"LeaveOnInt\": false,\n" +
                "    \"LeaveOnTerm\": false,\n" +
                "    \"EnableSyslog\": false,\n" +
                "    \"SyslogFacility\": \"\",\n" +
                "    \"DisableUpdateCheck\": false,\n" +
                "    \"DisableAnonymousSignature\": true,\n" +
                "    \"Revision\": \"\",\n" +
                "    \"Version\": \"0.1.0\",\n" +
                "    \"VersionPrerelease\": \"dev\",\n" +
                "    \"DevMode\": true,\n" +
                "    \"Atlas\": null\n" +
                "},\n" +
                "\"member\": {\n" +
                "    \"Name\": \"Armons-MacBook-Air.local.global\",\n" +
                "    \"Addr\": \"127.0.0.1\",\n" +
                "    \"Port\": 4648,\n" +
                "    \"Tags\": {\n" +
                "        \"bootstrap\": \"1\",\n" +
                "        \"build\": \"0.1.0dev\",\n" +
                "        \"dc\": \"dc1\",\n" +
                "        \"port\": \"4647\",\n" +
                "        \"region\": \"global\",\n" +
                "        \"role\": \"nomad\",\n" +
                "        \"vsn\": \"1\",\n" +
                "        \"vsn_max\": \"1\",\n" +
                "        \"vsn_min\": \"1\"\n" +
                "    },\n" +
                "    \"Status\": \"alive\",\n" +
                "    \"ProtocolMin\": 1,\n" +
                "    \"ProtocolMax\": 3,\n" +
                "    \"ProtocolCur\": 2,\n" +
                "    \"DelegateMin\": 2,\n" +
                "    \"DelegateMax\": 4,\n" +
                "    \"DelegateCur\": 4\n" +
                "},\n" +
                "\"stats\": {\n" +
                "    \"client\": {\n" +
                "        \"heartbeat_ttl\": \"19116443712\",\n" +
                "        \"known_servers\": \"0\",\n" +
                "        \"last_heartbeat\": \"8222075779\",\n" +
                "        \"num_allocations\": \"0\"\n" +
                "    },\n" +
                "    \"nomad\": {\n" +
                "        \"bootstrap\": \"false\",\n" +
                "        \"known_regions\": \"1\",\n" +
                "        \"leader\": \"true\",\n" +
                "        \"server\": \"true\"\n" +
                "    },\n" +
                "    \"raft\": {\n" +
                "        \"applied_index\": \"91\",\n" +
                "        \"commit_index\": \"91\",\n" +
                "        \"fsm_pending\": \"0\",\n" +
                "        \"last_contact\": \"never\",\n" +
                "        \"last_log_index\": \"91\",\n" +
                "        \"last_log_term\": \"1\",\n" +
                "        \"last_snapshot_index\": \"0\",\n" +
                "        \"last_snapshot_term\": \"0\",\n" +
                "        \"num_peers\": \"0\",\n" +
                "        \"state\": \"Leader\",\n" +
                "        \"term\": \"1\"\n" +
                "    },\n" +
                "    \"runtime\": {\n" +
                "        \"arch\": \"amd64\",\n" +
                "        \"cpu_count\": \"4\",\n" +
                "        \"goroutines\": \"58\",\n" +
                "        \"kernel.name\": \"darwin\",\n" +
                "        \"max_procs\": \"1\",\n" +
                "        \"version\": \"go1.4.2\"\n" +
                "    },\n" +
                "    \"serf\": {\n" +
                "        \"encrypted\": \"false\",\n" +
                "        \"event_queue\": \"0\",\n" +
                "        \"event_time\": \"1\",\n" +
                "        \"failed\": \"0\",\n" +
                "        \"intent_queue\": \"0\",\n" +
                "        \"left\": \"0\",\n" +
                "        \"member_time\": \"1\",\n" +
                "        \"members\": \"1\",\n" +
                "        \"query_queue\": \"0\",\n" +
                "        \"query_time\": \"1\"\n" +
                "    }\n" +
                "}\n" +
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
}
