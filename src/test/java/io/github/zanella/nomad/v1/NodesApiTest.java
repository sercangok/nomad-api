package io.github.zanella.nomad.v1;

import io.github.zanella.nomad.v1.nodes.NodesApi;
import io.github.zanella.nomad.v1.nodes.models.NodeSummary;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

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

        final NodeSummary nodeSummary = new NodeSummary();
        nodeSummary.setId("c9972143-861d-46e6-df73-1d8287bc3e66");
        nodeSummary.setDatacenter("dc1");
        nodeSummary.setName("web-8e40e308");
        nodeSummary.setNodeClass("");
        nodeSummary.setDrain(false);
        nodeSummary.setStatus("ready");
        nodeSummary.setStatusDescription("");
        nodeSummary.setCreateIndex(3);
        nodeSummary.setModifyIndex(4);

        assertEquals(nodeSummary, nomadClient.v1.nodes.getNodes().get(0));
    }
}
