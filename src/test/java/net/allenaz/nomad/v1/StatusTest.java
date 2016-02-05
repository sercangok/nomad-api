package net.allenaz.nomad.v1;

import net.allenaz.nomad.v1.status.StatusApi;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

public class StatusTest extends AbstractCommon {

    final static String rawLeader = "\"127.0.0.1:4647\"";

    final static String resultLeader = rawLeader.substring(1, rawLeader.length() - 1);

    @Test
    public void getLeaderTest() {
        stubFor(get(urlEqualTo(StatusApi.statusLeaderUrl))
                        .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawLeader))
        );

        assertEquals(resultLeader, nomadClient.v1.status.getStatusLeader());
    }

    @Test
    public void getPeersTest() {
        stubFor(get(urlEqualTo(StatusApi.statusPeersUrl))
                        .willReturn(aResponse().withHeader("Content-Type", "application/json")
                                .withBody("[" + rawLeader + "]"))
        );

        assertEquals(resultLeader, nomadClient.v1.status.getStatusPeers().get(0));
    }
}
