package io.github.zanella.nomad.v1;

import com.google.common.collect.ImmutableList;
import io.github.zanella.nomad.v1.jobs.JobsApi;
import io.github.zanella.nomad.v1.jobs.models.JobEvalResult;
import io.github.zanella.nomad.v1.jobs.models.JobSpec;
import io.github.zanella.nomad.v1.jobs.models.JobSummary;
import io.github.zanella.nomad.v1.common.models.UpdateStrategy;
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
                .willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withBody(jobsRawResponse.replace("'", "\""))
                )
        );

        final List<JobSummary> expectedJobList = ImmutableList.of(
                new JobSummary("binstore-storagelocker", "binstore-storagelocker", "service", 50, "" , "", 14, 14));

        assertEquals(expectedJobList, nomadClient.v1.jobs.getJobs());
    }

    @Test
    public void postJobTest() throws Exception {
        final String rawEvalResult = "{ \"EvalID\": \"d092fdc0-e1fd-2536-67d8-43af8ca798ac\"," +
                "\"EvalCreateIndex\": 35,\"JobModifyIndex\": 34 }";

        final JobSpec jobSpec = new JobSpec(); {
            jobSpec.setRegion("us");
            jobSpec.setDatacenters(ImmutableList.of("us-west-1", "us-east-1"));
            jobSpec.setType("system");
            jobSpec.setUpdate(new UpdateStrategy(1, 30d));
        }

        /* XXX - TODO
        wireMockRule.addMockServiceRequestListener(new RequestListener() {
            public void requestReceived(Request request, Response response) {
                System.out.println("\n\t *** (DBG) " + request.getBodyAsString());
            }
        }); */

        stubFor(post(urlEqualTo(JobsApi.jobsUrl))
                .withRequestBody(equalToJson(objectMapper.writeValueAsString(jobSpec)))
                //TODO - .withRequestBody(matchingJsonPath("$.Type == 'system'"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(rawEvalResult.replace("'", "\""))));

        assertEquals(
                new JobEvalResult("d092fdc0-e1fd-2536-67d8-43af8ca798ac", 35, 34),
                nomadClient.v1.jobs.postJob(jobSpec));
    }
}
