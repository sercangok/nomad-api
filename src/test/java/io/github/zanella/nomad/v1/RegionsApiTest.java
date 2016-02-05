package io.github.zanella.nomad.v1;

import io.github.zanella.nomad.v1.regions.RegionsApi;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

public class RegionsApiTest extends AbstractCommon {
    @Test
    public void getRegionsTest() {
        final String region1 = "region1";
        final String rawRegions = "[\"" + region1 + "\", \"region2\"]";

        stubFor(get(urlEqualTo(RegionsApi.regionsUrl))
                        .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawRegions))
        );

        assertEquals(region1, nomadClient.v1.regions.getRegions().get(0));
    }
}
