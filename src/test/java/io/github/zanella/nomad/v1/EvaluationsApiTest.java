package io.github.zanella.nomad.v1;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.damnhandy.uri.template.UriTemplate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import io.github.zanella.nomad.v1.evaluations.EvaluationsApi;
import io.github.zanella.nomad.v1.jobs.models.JobEvaluation;

import org.junit.Test;

import java.util.List;

public class EvaluationsApiTest extends AbstractCommon {
    private static final String rawEvaluations = "[ {" +
        "    \"ID\": \"151accaa-1ac6-90fe-d427-313e70ccbb88\"," +
        "    \"Priority\": 50," +
        "    \"Type\": \"service\"," +
        "    \"TriggeredBy\": \"job-register\"," +
        "    \"JobID\": \"binstore-storagelocker\"," +
        "    \"JobModifyIndex\": 14," +
        "    \"NodeID\": \"\"," +
        "    \"NodeModifyIndex\": 0," +
        "    \"Status\": \"complete\"," +
        "    \"StatusDescription\": \"\"," +
        "    \"Wait\": 0," +
        "    \"NextEval\": \"\"," +
        "    \"PreviousEval\": \"\"," +
        "    \"CreateIndex\": 15," +
        "    \"ModifyIndex\": 17" +
        "} ]";

    @Test
    public void getEvaluationsTest() {
        stubFor(get(urlEqualTo(EvaluationsApi.evaluationsUrl))
                        .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawEvaluations))
        );

        final List<JobEvaluation> expectedEvaluations = ImmutableList.of(
                new JobEvaluation("151accaa-1ac6-90fe-d427-313e70ccbb88", 50, "service", "job-register",
                        "binstore-storagelocker", 14, "", 0, "complete", "", 0, "", "", 15, 2));

        final List<JobEvaluation> actualEvaluations = nomadClient.v1.evaluations.getEvaluations();

        assertNotEquals(expectedEvaluations, actualEvaluations);

        expectedEvaluations.get(0).setModifyIndex(17);

        assertEquals(expectedEvaluations, actualEvaluations);
    }

    @Test
    public void getEvaluationsForRegionTest() {
        stubFor(get(urlEqualTo(UriTemplate.fromTemplate(EvaluationsApi.evaluationsForRegionUrl).expand(ImmutableMap.of("region", "region"))))
            .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawEvaluations))
        );

        final List<JobEvaluation> expectedEvaluations = ImmutableList.of(
            new JobEvaluation("151accaa-1ac6-90fe-d427-313e70ccbb88", 50, "service", "job-register",
                "binstore-storagelocker", 14, "", 0, "complete", "", 0, "", "", 15, 2));

        final List<JobEvaluation> actualEvaluations = nomadClient.v1.evaluations.getEvaluationsForRegion("region");

        assertNotEquals(expectedEvaluations, actualEvaluations);

        expectedEvaluations.get(0).setModifyIndex(17);

        assertEquals(expectedEvaluations, actualEvaluations);
    }
}
