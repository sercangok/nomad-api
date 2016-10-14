package io.github.zanella.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Check {
        @JsonProperty("Timeout") Long timeout;

        @JsonProperty("Interval") Long interval;

        @JsonProperty("Protocol") String protocol;

        @JsonProperty("Path") String path;

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
