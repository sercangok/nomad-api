package io.github.zanella.nomad.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.github.zanella.nomad.NomadClient;
import org.junit.Rule;

public class AbstractCommon {
    @Rule
    public final WireMockRule wireMockRule = new WireMockRule(NomadClient.DEFAULT_PORT);

    protected final NomadClient nomadClient = new NomadClient();

    protected final ObjectMapper objectMapper = new ObjectMapper();
}
