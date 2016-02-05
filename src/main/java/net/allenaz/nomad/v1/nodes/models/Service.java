package net.allenaz.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Service {
    @Data
    static class Check {
        @JsonProperty("Timeout") Double timeout;

        @JsonProperty("Interval") Double interval;

        @JsonProperty("Protocol") String protocol;

        @JsonProperty("Http") String http;

        @JsonProperty("Script") String script;

        @JsonProperty("Type") String type;

        @JsonProperty("Name") String name;

        @JsonProperty("Id") String id;
    }

    @JsonProperty("Checks") List<Check> checks;

    @JsonProperty("PortLabel") String portLabel;

    @JsonProperty("Tags") List<String> tags;

    @JsonProperty("Name") String name;

    @JsonProperty("Id") String id;
}
