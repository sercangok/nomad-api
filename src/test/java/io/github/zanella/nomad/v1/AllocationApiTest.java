package io.github.zanella.nomad.v1;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertEquals;

import com.damnhandy.uri.template.UriTemplate;
import com.google.common.collect.ImmutableMap;

import io.github.zanella.nomad.v1.allocations.AllocationApi;

import org.junit.Test;

public class AllocationApiTest extends AbstractCommon {
    private static final String rawAllocation = "{" +
        "  \"ID\": \"203266e5-e0d6-9486-5e05-397ed2b184af\"," +
        "  \"EvalID\": \"e68125ed-3fba-fb46-46cc-291addbc4455\"," +
        "  \"Name\": \"example.cache[0]\"," +
        "  \"NodeID\": \"e02b6169-83bd-9df6-69bd-832765f333eb\"," +
        "  \"JobID\": \"example\"," +
        "  \"ModifyIndex\": 9," +
        "  \"Resources\": {" +
        "    \"Networks\": [" +
        "      {\n" +
        "        \"DynamicPorts\": [ {\"Value\": 20802, \"Label\": \"db\"} ]," +
        "        \"ReservedPorts\": null,\n" +
        "        \"MBits\": 10,\n" +
        "        \"IP\": \"\",\n" +
        "        \"CIDR\": \"\",\n" +
        "        \"Device\": \"\"\n" +
        "      }\n" +
        "    ],\n" +
        "    \"IOPS\": 0,\n" +
        "    \"DiskMB\": 0,\n" +
        "    \"MemoryMB\": 256,\n" +
        "    \"CPU\": 500\n" +
        "  },\n" +
        "  \"TaskGroup\": \"cache\",\n" +
        "  \"Job\": {\n" +
        "    \"ModifyIndex\": 5,\n" +
        "    \"CreateIndex\": 5,\n" +
        "    \"StatusDescription\": \"\",\n" +
        "    \"Status\": \"\",\n" +
        "    \"Meta\": null,\n" +
        "    \"Update\": { \"MaxParallel\": 1, \"Stagger\": 1e+10}," +
        "    \"TaskGroups\": [\n" +
        "      {\n" +
        "        \"Meta\": null,\n" +
        "        \"Tasks\": [\n" +
        "          {\n" +
        "            \"Meta\": null,\n" +
        "            \"Resources\": {\n" +
        "              \"Networks\": [\n" +
        "                {\n" +
        "                  \"DynamicPorts\": [ {\"Value\": 20802, \"Label\": \"db\" } ]," +
        "                  \"ReservedPorts\": null,\n" +
        "                  \"MBits\": 0,\n" +
        "                  \"IP\": \"127.0.0.1\",\n" +
        "                  \"CIDR\": \"\",\n" +
        "                  \"Device\": \"lo\"\n" +
        "                }\n" +
        "              ],\n" +
        "              \"IOPS\": 0,\n" +
        "              \"DiskMB\": 0,\n" +
        "              \"MemoryMB\": 256,\n" +
        "              \"CPU\": 500\n" +
        "            },\n" +
        "            \"Constraints\": null,\n" +
        "            \"Services\": [\n" +
        "              {\n" +
        "                \"Checks\": [\n" +
        "                  {\n" +
        "                    \"Timeout\": 2e+09,\n" +
        "                    \"Interval\": 1e+10,\n" +
        "                    \"Protocol\": \"\",\n" +
        "                    \"Http\": \"\",\n" +
        "                    \"Script\": \"\",\n" +
        "                    \"Type\": \"tcp\",\n" +
        "                    \"Name\": \"alive\",\n" +
        "                    \"Id\": \"\",\n" +
        "                    \"Path\": \"\"\n" +
        "                  }\n" +
        "                ],\n" +
        "                \"PortLabel\": \"db\",\n" +
        "                \"Tags\": [\"global\", \"cache\"]," +
        "                \"Name\": \"example-cache-redis\"," +
        "                \"Id\": \"\"" +
        "              }" +
        "            ]," +
        "            \"Env\": null,\n" +
        "            \"Config\": {\n" +
        "              \"port_map\": [\n" +
        "                {\n" +
        "                  \"db\": 6379\n" +
        "                }\n" +
        "              ],\n" +
        "              \"image\": \"redis:latest\"\n" +
        "            },\n" +
        "            \"Driver\": \"docker\",\n" +
        "            \"Name\": \"redis\"\n" +
        "          }\n" +
        "        ],\n" +
        "        \"RestartPolicy\": {\"Delay\": 2.5e+10, \"Interval\": 3e+11,\"Attempts\": 10, \"Mode\": \"fail\"}," +
        "        \"Constraints\": null,\n" +
        "        \"Count\": 1,\n" +
        "        \"Name\": \"cache\"\n" +
        "      }\n" +
        "    ],\n" +
        "    \"Region\": \"global\",\n" +
        "    \"ID\": \"example\",\n" +
        "    \"Name\": \"example\",\n" +
        "    \"Type\": \"service\",\n" +
        "    \"Priority\": 50,\n" +
        "    \"AllAtOnce\": false,\n" +
        "    \"Datacenters\": [\"dc1\"]," +
        "    \"Constraints\": [" +
        "      {\"Operand\": \"=\", \"RTarget\": \"linux\", \"LTarget\": \"$attr.kernel.name\"}" +
        "    ]" +
        "  }," +
        "  \"TaskResources\": {\n" +
        "    \"redis\": {\n" +
        "      \"Networks\": [\n" +
        "        {\n" +
        "          \"DynamicPorts\": [ {\"Value\": 20802, \"Label\": \"db\"} ]," +
        "          \"ReservedPorts\": null,\n" +
        "          \"MBits\": 0,\n" +
        "          \"IP\": \"127.0.0.1\",\n" +
        "          \"CIDR\": \"\",\n" +
        "          \"Device\": \"lo\"\n" +
        "        }\n" +
        "      ],\n" +
        "      \"IOPS\": 0,\n" +
        "      \"DiskMB\": 0,\n" +
        "      \"MemoryMB\": 256,\n" +
        "      \"CPU\": 500\n" +
        "    }\n" +
        "  },\n" +
        "  \"Metrics\": {" +
        "    \"CoalescedFailures\": 0,\n" +
        "    \"AllocationTime\": 1590406,\n" +
        "    \"NodesEvaluated\": 1,\n" +
        "    \"NodesFiltered\": 0,\n" +
        "    \"ClassFiltered\": null,\n" +
        "    \"ConstraintFiltered\": null,\n" +
        "    \"NodesExhausted\": 0,\n" +
        "    \"ClassExhausted\": null,\n" +
        "    \"DimensionExhausted\": null,\n" +
        "    \"Scores\": {\"e02b6169-83bd-9df6-69bd-832765f333eb.binpack\": 6.133651487695705}" +
        "  }," +
        "  \"DesiredStatus\": \"run\",\n" +
        "  \"DesiredDescription\": \"\",\n" +
        "  \"ClientStatus\": \"running\",\n" +
        "  \"ClientDescription\": \"\",\n" +
        "  \"TaskStates\": {\n" +
        "    \"redis\": {\n" +
        "      \"Events\": [\n" +
        "        {\n" +
        "          \"KillError\": \"\",\n" +
        "          \"Message\": \"\",\n" +
        "          \"Signal\": 0,\n" +
        "          \"ExitCode\": 0,\n" +
        "          \"DriverError\": \"\",\n" +
        "          \"Time\": 1447806038427841000,\n" +
        "          \"Type\": \"Started\"\n" +
        "        }\n" +
        "      ],\n" +
        "      \"State\": \"running\"" +
        "    }" +
        "  }," +
        "  \"CreateIndex\": 7" +
        "}";

    @Test
    public void getAllocationTest() {
        stubFor(get(urlEqualTo(UriTemplate.fromTemplate(AllocationApi.allocationUrl).expand(ImmutableMap.of("allocationId", "allocationId"))))
                        .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawAllocation)));

        assertEquals(NodeApiTest.createNodeAllocation(), nomadClient.v1.allocation.getAllocation("allocationId"));
    }

    @Test
    public void getAllocationOfRegionTest() {
        stubFor(get(urlEqualTo(UriTemplate.fromTemplate(AllocationApi.allocationForRegionUrl).expand(ImmutableMap.of("allocationId", "allocationId", "region", "region"))))
            .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawAllocation)));

        assertEquals(NodeApiTest.createNodeAllocation(), nomadClient.v1.allocation.getAllocationForRegion("allocationId", "region"));
    }
}
