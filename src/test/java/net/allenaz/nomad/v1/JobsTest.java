package net.allenaz.nomad.v1;

import net.allenaz.nomad.v1.jobs.JobsApi;
import net.allenaz.nomad.v1.jobs.models.Job;
import org.junit.Test;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import static org.junit.Assert.*;

public class JobsTest extends AbstractCommon {
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
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(jobsRawResponse.replace("'", "\""))
                )
        );

        final List<Job> jobList = nomadClient.v1.jobs.getJobs();

        final Job job = new Job();
        job.setStatus("");
        job.setPriority(50);
        job.setName("binstore-storagelocker");
        job.setType("service");
        job.setStatusDescription("");
        job.setId("binstore-storagelocker");
        job.setModifyIndex(14);
        job.setCreateIndex(14);

        assertEquals(job, jobList.get(0));
    }
}
