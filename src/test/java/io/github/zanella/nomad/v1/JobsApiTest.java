package io.github.zanella.nomad.v1;

import com.google.common.collect.ImmutableList;
import io.github.zanella.nomad.v1.jobs.JobsApi;
import io.github.zanella.nomad.v1.jobs.models.Job;
import org.junit.Test;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import static org.junit.Assert.*;

public class JobsApiTest extends AbstractCommon {
    @Test
    public void getJobsTest() {
        final String jobsRawResponse = "[{" +
                "    \"ID\": \"binstore-storagelocker\"," +
                "    \"Name\": \"binstore-storagelocker\"," +
                "    \"Type\": \"service\"," +
                "    \"Priority\": 50," +
                "    \"Status\": \"\"," +
                "    \"StatusDescription\": \"\"," +
                "    \"CreateIndex\": 14," +
                "    \"ModifyIndex\": 14" +
                "}]";

        stubFor(get(urlEqualTo(JobsApi.jobsUrl))
                //.withHeader("Accept", equalTo("text/xml"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(jobsRawResponse.replace("'", "\""))
                )
        );

        final List<Job> expectedJobList = ImmutableList.of(
                new Job("binstore-storagelocker", "binstore-storagelocker", "service", 50, "" , "", 14, 14));

        assertEquals(expectedJobList, nomadClient.v1.jobs.getJobs());
    }
}
