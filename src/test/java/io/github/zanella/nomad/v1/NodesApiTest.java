package io.github.zanella.nomad.v1;

import io.github.zanella.nomad.v1.nodes.NodesApi;
import io.github.zanella.nomad.v1.nodes.models.NodeInfo;
import io.github.zanella.nomad.v1.nodes.models.NodeSummary;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NodesApiTest extends AbstractCommon {
    @Test
    public void getNodesTest() {
        final String rawNodes = "[ {" +
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
}
