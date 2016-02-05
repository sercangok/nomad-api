package net.allenaz.nomad.v1;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import net.allenaz.nomad.NomadClient;
import net.allenaz.nomad.v1.jobs.models.Job;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import static org.junit.Assert.*;

public class JobsTest {
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(NomadClient.DEFAULT_PORT);

    NomadClient nomadClient;

    @Before
    public void setup() throws Exception {
        nomadClient = new NomadClient();
    }

    @Test
    public void getJobsTest() {
        final String jobsRawResponse = "[{'Status': '', 'ModifyIndex': 14, 'Priority': 50, 'Type': 'service', " +
                "'ID': 'binstore-storagelocker', 'StatusDescription': '', 'Name': 'binstore-storagelocker', " +
                "'CreateIndex': 14}]";
        stubFor(get(urlEqualTo("/v1/jobs"))
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
