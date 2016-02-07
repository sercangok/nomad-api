package io.github.zanella.nomad.v1;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.github.zanella.nomad.v1.common.models.Constraint;
import io.github.zanella.nomad.v1.common.models.Job;
import io.github.zanella.nomad.v1.jobs.JobApi;
import io.github.zanella.nomad.v1.nodes.models.Resources;
import io.github.zanella.nomad.v1.nodes.models.Task;
import io.github.zanella.nomad.v1.nodes.models.TaskGroup;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class JobApiTest extends AbstractCommon {
    @Test
    public void getJobTest() {
        final String rawJobResponse = "{" +
                "\"Region\": \"global\"," +
                "\"ID\": \"binstore-storagelocker\"," +
                "\"Name\": \"binstore-storagelocker\"," +
                "\"Type\": \"service\"," +
                "\"Priority\": 50," +
                "\"AllAtOnce\": false," +
                "\"Datacenters\": [\"us2\", \"eu1\"]," +
                "\"Constraints\": [ {\"LTarget\": \"kernel.os\",\"RTarget\": \"windows\",\"Operand\": \"=\"} ]," +
                "\"TaskGroups\": [" +
                "    {" +
                "        \"Name\": \"binsl\"," +
                "        \"Count\": 5," +
                "        \"Constraints\": [ {\"LTarget\": \"kernel.os\",\"RTarget\": \"linux\",\"Operand\": \"=\"} ]," +
                "        \"Tasks\": [" +
                "            {" +
                "                \"Name\": \"binstore\", \"Driver\": \"docker\"," +
                "                \"Config\": {\"image\": \"hashicorp/binstore\"}," +
                "                \"Constraints\": null," +
                "                \"Resources\": {" +
                "                    \"CPU\": 500,\"MemoryMB\": 0,\"DiskMB\": 0,\"IOPS\": 0," +
                "                    \"Networks\": [ {" +
                "                        \"Device\": \"\", \"CIDR\": \"\", \"IP\": \"\", \"MBits\": 100," +
                "                        \"ReservedPorts\": null,\"DynamicPorts\": null" +
                "                    } ]" +
                "                }," +
                "                \"Meta\": null" +
                "            }," +
                "            {" +
                "                \"Name\": \"storagelocker\",\"Driver\": \"java\"," +
                "                \"Config\": {\"image\": \"hashicorp/storagelocker\"}," +
                "                \"Constraints\": [" +
                "                    {\"LTarget\": \"kernel.arch\",\"RTarget\": \"amd64\",\"Operand\": \"=\"}" +
                "                ]," +
                "                \"Resources\": {\"CPU\": 500,\"MemoryMB\": 0,\"DiskMB\": 0,\"IOPS\": 0,\"Networks\": null}," +
                "                \"Meta\": null" +
                "            }" +
                "        ]," +
                "        \"Meta\": {\"elb_checks\": \"3\",\"elb_interval\": \"10\",\"elb_mode\": \"tcp\"}" +
                "    }" +
                "]," +
                "\"Update\": {\"Stagger\": 0,\"MaxParallel\": 0}," +
                "\"Meta\": {\"foo\": \"bar\"}," +
                "\"Status\": \"\"," +
                "\"StatusDescription\": \"\"," +
                "\"CreateIndex\": 14," +
                "\"ModifyIndex\": 14" +
                "}";

        stubFor(get(urlEqualTo(JobApi.jobUrl + "/42"))
                        .willReturn(aResponse()
                                        .withHeader("Content-Type", "application/json")
                                        .withBody(rawJobResponse.replace("'", "\""))
                        )
        );

        final Job expectedJob = new Job();

        expectedJob.setRegion("global");
        expectedJob.setId("binstore-storagelocker");
        expectedJob.setName("binstore-storagelocker");
        expectedJob.setType("service");
        expectedJob.setPriority(50);
        expectedJob.setAllAtOnce(false);
        expectedJob.setDatacenters( ImmutableList.of("us2", "eu1") );
        expectedJob.setConstraints( ImmutableList.of(new Constraint("=", "windows", "kernel.os")) );

        final TaskGroup taskGroup = new TaskGroup(
                ImmutableMap.of("elb_checks", "3", "elb_interval", "10", "elb_mode", "tcp"),
                ImmutableList.of(
                        new Task(null,
                                new Resources(500, 0, 0, 0, ImmutableList.of(new Resources.Network(null, null, 100, "", "", ""))),
                                null, null, null, new Task.Config(null, "hashicorp/binstore"), "docker", "binstore"),
                        new Task(null, new Resources(500, 0, 0, 0, null),
                                ImmutableList.of(new Constraint("=", "amd64", "kernel.arch")), null, null,
                                new Task.Config(null, "hashicorp/storagelocker"), "java", "storagelocker")),
                null,
                ImmutableList.of(new Constraint("=", "linux", "kernel.os")),
                4,
                "binsl");

        expectedJob.setTaskGroup( ImmutableList.of(taskGroup) );

        expectedJob.setUpdate( new Job.Update(0, 0d) );
        expectedJob.setMeta( ImmutableMap.of("foo", "bar"));
        expectedJob.setStatus("");
        expectedJob.setStatusDescription("");
        expectedJob.setCreateIndex(14);
        expectedJob.setModifyIndex(14);

        final Job actualJobResult = nomadClient.v1.job.getJob("42");

        assertNotEquals(expectedJob, actualJobResult);

        taskGroup.setCount(5);

        assertEquals(expectedJob, actualJobResult);
    }
}
