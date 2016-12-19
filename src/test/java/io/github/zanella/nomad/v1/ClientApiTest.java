package io.github.zanella.nomad.v1;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;

import io.github.zanella.nomad.v1.client.ClientApi;
import io.github.zanella.nomad.v1.client.models.Stats;

import org.junit.Test;

public class ClientApiTest extends AbstractCommon {
    @Test
    public void getStatsTest() {
        final String rawSelf = "{\n" +
            "  \"CPU\": [\n" +
            "    {\n" +
            "      \"CPU\": \"cpu0\",\n" +
            "      \"Idle\": 89.2156862745098,\n" +
            "      \"System\": 4.901960784313726,\n" +
            "      \"Total\": 10.784313725490197,\n" +
            "      \"User\": 5.88235294117647\n" +
            "    },\n" +
            "    {\n" +
            "      \"CPU\": \"cpu1\",\n" +
            "      \"Idle\": 100,\n" +
            "      \"System\": 0,\n" +
            "      \"Total\": 0,\n" +
            "      \"User\": 0\n" +
            "    },\n" +
            "    {\n" +
            "      \"CPU\": \"cpu2\",\n" +
            "      \"Idle\": 94.05940594059405,\n" +
            "      \"System\": 2.9702970297029703,\n" +
            "      \"Total\": 5.9405940594059405,\n" +
            "      \"User\": 2.9702970297029703\n" +
            "    },\n" +
            "    {\n" +
            "      \"CPU\": \"cpu3\",\n" +
            "      \"Idle\": 99.00990099009901,\n" +
            "      \"System\": 0,\n" +
            "      \"Total\": 0.9900990099009901,\n" +
            "      \"User\": 0.9900990099009901\n" +
            "    }\n" +
            "  ],\n" +
            "  \"CPUTicksConsumed\": 119.5762958648806,\n" +
            "  \"DiskStats\": [\n" +
            "    {\n" +
            "      \"Available\": 16997969920,\n" +
            "      \"Device\": \"/dev/disk1\",\n" +
            "      \"InodesUsedPercent\": 85.84777164286838,\n" +
            "      \"Mountpoint\": \"/\",\n" +
            "      \"Size\": 120108089344,\n" +
            "      \"Used\": 102847975424,\n" +
            "      \"UsedPercent\": 85.62951586835626\n" +
            "    }\n" +
            "  ],\n" +
            "  \"Memory\": {\n" +
            "    \"Available\": 3724746752,\n" +
            "    \"Free\": 2446233600,\n" +
            "    \"Total\": 8589934592,\n" +
            "    \"Used\": 4865187840\n" +
            "  },\n" +
            "  \"Timestamp\": 1465839167993064200,\n" +
            "  \"Uptime\": 101149\n" +
            "}";

        stubFor(get(urlEqualTo(ClientApi.statsfUrl))
                .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody(rawSelf)));

        final Stats expectedStats = new Stats(
            ImmutableList.of(
                new Stats.CPU("cpu0", 89.2156862745098D, 4.901960784313726D, 10.784313725490197D, 5.88235294117647D),
                new Stats.CPU("cpu1", 100D, 0D, 0D, 0D),
                new Stats.CPU("cpu2", 94.05940594059405D, 2.9702970297029703D, 5.9405940594059405D, 2.9702970297029703D),
                new Stats.CPU("cpu3", 99.00990099009901, 0D, 0.9900990099009901, 0.9900990099009901D)
            ),
            119.5762958648806D,
            ImmutableList.of(
                new Stats.DiskStats(16997969920L, "/dev/disk1", 85.84777164286838D, "/", 120108089344L, 102847975424L, 85.62951586835626D)
            ),
            new Stats.Memory(3724746752L, 2446233600L, 8589934592L, 4865187840L),
            1465839167993064200L,
            101149L
        );

        assertEquals(expectedStats, nomadClient.v1.client.getStats());
    }
}
