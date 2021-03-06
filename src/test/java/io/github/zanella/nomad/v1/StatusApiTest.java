package io.github.zanella.nomad.v1;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertEquals;

import com.damnhandy.uri.template.UriTemplate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import io.github.zanella.nomad.v1.status.StatusApi;

import org.junit.Test;

public class StatusApiTest extends AbstractCommon {
    final static String rawLeader = "\"127.0.0.1:4647\"";

    final static String resultLeader = rawLeader.substring(1, rawLeader.length() - 1);

    @Test
    public void getLeaderTest() {
        stubFor(get(urlEqualTo(StatusApi.leaderUrl))
                        .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawLeader))
        );

        assertEquals(resultLeader, nomadClient.v1.status.getLeader());
    }

    @Test
    public void getLeaderForRegionTest() {
        stubFor(get(urlEqualTo(UriTemplate.fromTemplate(StatusApi.leaderForRegionUrl).expand(ImmutableMap.of("region", "region"))))
            .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawLeader))
        );

        assertEquals(resultLeader, nomadClient.v1.status.getLeaderForRegion("region"));
    }

    @Test
    public void getPeersTest() {
        stubFor(get(urlEqualTo(StatusApi.peersUrl))
                        .willReturn(aResponse().withHeader("Content-Type", "application/json")
                                .withBody("[" + rawLeader + "]"))
        );

        assertEquals(ImmutableList.of(resultLeader), nomadClient.v1.status.getPeers());
    }
}
