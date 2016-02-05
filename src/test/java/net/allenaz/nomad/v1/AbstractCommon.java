package net.allenaz.nomad.v1;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import net.allenaz.nomad.NomadClient;
import org.junit.Before;
import org.junit.Rule;

public class AbstractCommon {
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(NomadClient.DEFAULT_PORT);

    NomadClient nomadClient;

    @Before
    public void setup() throws Exception {
        nomadClient = new NomadClient();
    }
}
