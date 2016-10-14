package io.github.zanella.nomad.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.xebia.jacksonlombok.JacksonLombokAnnotationIntrospector;
import io.github.zanella.nomad.NomadClient;
import org.junit.Rule;

public class AbstractCommon {
    @Rule
    public final WireMockRule wireMockRule = new WireMockRule(NomadClient.DEFAULT_PORT);

    protected final NomadClient nomadClient = new NomadClient();

    protected final ObjectMapper objectMapper;

    public AbstractCommon() {
        objectMapper = new ObjectMapper()
                .setAnnotationIntrospector(new JacksonLombokAnnotationIntrospector())
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(SerializationFeature.WRAP_ROOT_VALUE, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
