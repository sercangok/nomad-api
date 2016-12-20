package io.github.zanella.nomad.v1;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.damnhandy.uri.template.UriTemplate;
import com.google.common.collect.ImmutableMap;

import io.github.zanella.nomad.v1.nodes.NodesApi;
import io.github.zanella.nomad.v1.nodes.models.NodeInfo;
import io.github.zanella.nomad.v1.nodes.models.NodeSummary;

import org.junit.Test;

public class NodesApiTest extends AbstractCommon {

    private static String rawNodes = "[ {" +
        "    \"ID\": \"c9972143-861d-46e6-df73-1d8287bc3e66\"," +
        "    \"Datacenter\": \"dc1\"," +
        "    \"Name\": \"web-8e40e308\"," +
        "    \"NodeClass\": \"\"," +
        "    \"Drain\": false," +
        "    \"Status\": \"ready\"," +
        "    \"StatusDescription\": \"\"," +
        "    \"CreateIndex\": 3," +
        "    \"ModifyIndex\": 4" +
        "} ]";

    @Test
    public void getNodesTest() {
        stubFor(get(urlEqualTo(NodesApi.nodesUrl))
                        .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawNodes))
        );

        final NodeInfo nodeInfo = NodeApiTest.newNodeInfo();

        final NodeSummary actualNodeSummary = nomadClient.v1.nodes.getNodes().get(0);

        assertFalse(nodeInfo.superEquals(actualNodeSummary));

        //
        nodeInfo.setName("web-8e40e308");

        assertTrue(nodeInfo.superEquals(actualNodeSummary));
    }

    @Test
    public void getNodesForRegionTest() {
        stubFor(get(urlEqualTo(UriTemplate.fromTemplate(NodesApi.nodesForRegionUrl).expand(ImmutableMap.of("region", "region"))))
            .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawNodes))
        );

        final NodeInfo nodeInfo = NodeApiTest.newNodeInfo();

        final NodeSummary actualNodeSummary = nomadClient.v1.nodes.getNodesForRegion("region").get(0);

        assertFalse(nodeInfo.superEquals(actualNodeSummary));

        //
        nodeInfo.setName("web-8e40e308");

        assertTrue(nodeInfo.superEquals(actualNodeSummary));
    }
}
