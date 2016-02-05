package io.github.zanella.nomad.v1;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.github.zanella.nomad.v1.nodes.NodeApi;
import io.github.zanella.nomad.v1.nodes.models.EvalResult;
import io.github.zanella.nomad.v1.nodes.models.NodeInfo;
import io.github.zanella.nomad.v1.nodes.models.Resources;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.*;

public class NodeApiTest extends AbstractCommon {

    private static Map<String, String> makeAttributes() {
        return ImmutableMap.<String, String>builder()
                .put("arch", "amd64")
                .put("cpu.frequency", "1300.000000")
                .put("cpu.modelname", "Intel(R) Core(TM) i5-4250U CPU @ 1.30GHz")
                .put("cpu.numcores", "2")
                .put("cpu.totalcompute", "2600.000000")
                .put("driver.exec", "1")
                .put("driver.java", "1")
                .put("driver.java.runtime", "Java(TM) SE Runtime Environment (build 1.8.0_05-b13)")
                .put("driver.java.version", "1.8.0_05")
                .put("driver.java.vm", "Java HotSpot(TM) 64-Bit Server VM (build 25.5-b02, mixed mode)")
                .put("hostname", "Armons-MacBook-Air.local")
                .put("kernel.name", "darwin")
                .put("kernel.version", "14.4.0")
                .put("memory.totalbytes", "8589934592")
                .put("network.ip-address", "127.0.0.1")
                .put("os.name", "darwin")
                .put("os.version", "14.4.0")
                .put("storage.bytesfree", "35888713728")
                .put("storage.bytestotal", "249821659136")
                .put("storage.volume", "/dev/disk1")
                .build();
    }

    private static Resources makeResources() {
        final Resources resources = new Resources();

        resources.setCpu(2600);
        resources.setMemoryMB(8192);
        resources.setDiskMB(34226);
        resources.setIops(0);

        return resources;
    }

    public static NodeInfo newNodeInfo() {
        final NodeInfo nodeInfo = new NodeInfo();
        nodeInfo.setId("c9972143-861d-46e6-df73-1d8287bc3e66");
        nodeInfo.setDatacenter("dc1");
        nodeInfo.setName("Armons-MacBook-Air.local");

        nodeInfo.setAttributes( makeAttributes() );
        nodeInfo.setResources( makeResources() );
        nodeInfo.setReserved(null);
        nodeInfo.setLinks( ImmutableMap.builder().build() );
        nodeInfo.setMeta( ImmutableMap.builder().build() );

        nodeInfo.setNodeClass("");
        nodeInfo.setDrain(false);
        nodeInfo.setStatus("ready");
        nodeInfo.setStatusDescription("");
        nodeInfo.setCreateIndex(3);
        nodeInfo.setModifyIndex(4);

        return nodeInfo;
    }

    private final NodeInfo expectedNodeInfo = newNodeInfo();

    private final static String rawEvaluate = "{" +
            "\"EvalIDs\": [\"d092fdc0-e1fd-2536-67d8-43af8ca798ac\"]," +
            "\"EvalCreateIndex\": 35," +
            "\"NodeModifyIndex\": 34" +
            "}";

    private EvalResult expectedEvalResult;

    @Before
    public void setup() {
        expectedEvalResult = new EvalResult();
        expectedEvalResult.setEvalIDs(ImmutableList.of("d092fdc0-e1fd-2536-67d8-43af8ca798ac"));
        expectedEvalResult.setEvalCreateIndex(35);
        expectedEvalResult.setNodeModifyIndex(34);
    }

    @Test
    public void getNodeTest() {
        final String rawNodeSummary = "{" +
                "\"ID\": \"c9972143-861d-46e6-df73-1d8287bc3e66\"," +
                "\"Datacenter\": \"dc1\"," +
                "\"Name\": \"Armons-MacBook-Air.local\"," +
                "\"Attributes\": {" +
                "    \"arch\": \"amd64\"," +
                "    \"cpu.frequency\": \"1300.000000\"," +
                "    \"cpu.modelname\": \"Intel(R) Core(TM) i5-4250U CPU @ 1.30GHz\"," +
                "    \"cpu.numcores\": \"2\"," +
                "    \"cpu.totalcompute\": \"2600.000000\"," +
                "    \"driver.exec\": \"1\"," +
                "    \"driver.java\": \"1\"," +
                "    \"driver.java.runtime\": \"Java(TM) SE Runtime Environment (build 1.8.0_05-b13)\"," +
                "    \"driver.java.version\": \"1.8.0_05\"," +
                "    \"driver.java.vm\": \"Java HotSpot(TM) 64-Bit Server VM (build 25.5-b02, mixed mode)\"," +
                "    \"hostname\": \"Armons-MacBook-Air.local\"," +
                "    \"kernel.name\": \"darwin\"," +
                "    \"kernel.version\": \"14.4.0\"," +
                "    \"memory.totalbytes\": \"8589934592\"," +
                "    \"network.ip-address\": \"127.0.0.1\"," +
                "    \"os.name\": \"darwin\"," +
                "    \"os.version\": \"14.4.0\"," +
                "    \"storage.bytesfree\": \"35888713728\"," +
                "    \"storage.bytestotal\": \"249821659136\"," +
                "    \"storage.volume\": \"/dev/disk1\"" +
                "}," +
                "\"Resources\": {" +
                "    \"CPU\": 2600," +
                "    \"MemoryMB\": 8192," +
                "    \"DiskMB\": 34226," +
                "    \"IOPS\": 0," +
                "    \"Networks\": null" +
                "}," +
                "\"Reserved\": null," +
                "\"Links\": {}," +
                "\"Meta\": {}," +
                "\"NodeClass\": \"\"," +
                "\"Drain\": false," +
                "\"Status\": \"ready\"," +
                "\"StatusDescription\": \"\"," +
                "\"CreateIndex\": 3," +
                "\"ModifyIndex\": 4" +
                "}";

        stubFor(get(urlEqualTo(NodeApi.nodeUrl + "/42"))
                        .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawNodeSummary))
        );

        assertEquals(expectedNodeInfo, nomadClient.v1.node.getNode("42"));
    }

    @Test
    public void putEvaluateTest() {
        stubFor(put(urlEqualTo(NodeApi.nodeUrl + "/42" + NodeApi.evaluateUrl))
                        .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawEvaluate))
        );

        assertEquals(expectedEvalResult, nomadClient.v1.node.putEvaluate("42"));
    }

    @Test
    public void putDrainTest() {
        stubFor(put(urlEqualTo(NodeApi.nodeUrl + "/42" + NodeApi.drainUrl + "?enable=true"))
                        .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawEvaluate))
        );

        assertEquals(expectedEvalResult, nomadClient.v1.node.putDrain("42", true));
    }
}
