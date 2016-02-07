package io.github.zanella.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Config {
        @JsonProperty("port_map") List<Map<String, Integer>> portMap;

        @JsonProperty("image") String image;
    }

    @JsonProperty("Meta") Object meta;
    
    @JsonProperty("Resources") Resources resources;

    @JsonProperty("Constraints") Object constraints;

    @JsonProperty("Services") List<Service> services;

    @JsonProperty("Env") Object env;

    @JsonProperty("Config") Config config;

    @JsonProperty("Driver") String driver;

    @JsonProperty("Name") String name;
}
