package io.github.zanella.nomad.v1;

import com.google.common.collect.ImmutableList;
import io.github.zanella.nomad.v1.regions.RegionsApi;
import org.junit.Test;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

public class RegionsApiTest extends AbstractCommon {
    @Test
    public void getRegionsTest() {
        final List<String> expectedRegions = ImmutableList.of("region1", "region2");
        final String rawRegions = "[\"" + expectedRegions.get(0) + "\", \"" + expectedRegions.get(1) + "\"]";

        stubFor(get(urlEqualTo(RegionsApi.regionsUrl))
                        .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawRegions))
        );

        assertEquals(expectedRegions, nomadClient.v1.regions.getRegions());
    }
}
