package io.github.zanella.nomad.v1;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.github.zanella.nomad.v1.allocations.AllocationsApi;
import io.github.zanella.nomad.v1.allocations.models.Allocation;
import io.github.zanella.nomad.v1.common.models.TaskState;
import org.junit.Test;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AllocationsApiTest extends AbstractCommon {
    @Test
    public void getAllocationsTest() {
        final String rawAllocations = "[ {" +
                "  \"ID\": \"203266e5-e0d6-9486-5e05-397ed2b184af\"," +
                "  \"EvalID\": \"e68125ed-3fba-fb46-46cc-291addbc4455\"," +
                "  \"Name\": \"example.cache[0]\"," +
                "  \"NodeID\": \"e02b6169-83bd-9df6-69bd-832765f333eb\"," +
                "  \"JobID\": \"example\"," +
                "  \"TaskGroup\": \"cache\"," +
                "  \"DesiredStatus\": \"run\"," +
                "  \"DesiredDescription\": \"\"," +
                "  \"ClientDescription\": \"\"," +
                "  \"ClientStatus\": \"running\"," +
                "  \"TaskStates\": {" +
                "    \"redis\": {" +
                "      \"Events\": [ {" +
                "          \"KillError\": \"\",\"Message\": \"\", \"Signal\": 0, \"ExitCode\": 0, " +
                "          \"DriverError\": \"\", \"Time\": 1447806038427841000, \"Type\": \"Started\"" +
                "        } ]," +
                "      \"State\": \"running\"" +
                "    }" +
                "  }," +
                "  \"CreateIndex\": 7," +
                "  \"ModifyIndex\": 9" +
                "} ]";

        stubFor(get(urlEqualTo(AllocationsApi.allocationsUrl))
                        .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawAllocations))
        );

        final Allocation expectedAllocation = new Allocation();
        expectedAllocation.setId("203266e5-e0d6-9486-5e05-397ed2b184af");
        expectedAllocation.setEvalId("e68125ed-3fba-fb46-46cc-291addbc4455");
        expectedAllocation.setName("example.cache[0]");
        expectedAllocation.setNodeId("e02b6169-83bd-9df6-69bd-832765f333eb");
        expectedAllocation.setJobId("example");
        expectedAllocation.setTaskGroup("cache");
        expectedAllocation.setDesiredStatus("run");
        expectedAllocation.setDesiredDescription("");
        expectedAllocation.setClientDescription("");
        expectedAllocation.setClientStatus("running");
        expectedAllocation.setTaskStates(ImmutableMap.of(
                "redis",
                new TaskState(
                        ImmutableList.of(new TaskState.Event("", "", 0, 0, "", 1447806038427841000L, "Started")),
                        "running")));
        expectedAllocation.setCreateIndex(7);
        expectedAllocation.setModifyIndex(2);

        final List<Allocation> expectedAllocationList = ImmutableList.of(expectedAllocation);
        final List<Allocation> actualAllocationsList = nomadClient.v1.allocations.getAllocations();

        assertNotEquals(expectedAllocationList, actualAllocationsList);

        expectedAllocation.setModifyIndex(9);
        assertEquals(expectedAllocationList, actualAllocationsList);
    }
}
