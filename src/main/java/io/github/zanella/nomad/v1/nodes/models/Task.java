package io.github.zanella.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zanella.nomad.v1.common.models.Constraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class Task {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Config {
        @JsonProperty("port_map") List<Map<String, Integer>> portMap;

        @JsonProperty("image") String image;

        @JsonProperty("command") String command;

        @JsonProperty("args") List<String> args;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LogConfig {
        @JsonProperty("MaxFiles") Integer maxFiles;

        @JsonProperty("MaxFileSizeMB") Integer maxFileSize;
    }

    @JsonProperty("Meta") Object meta;
    
    @JsonProperty("Resources") Resources resources;

    @JsonProperty("Constraints") List<Constraint> constraints;

    @JsonProperty("Env") Map<String, String> env;

    @JsonProperty("Driver") String driver;

    @JsonProperty("Name") String name;

    @JsonProperty("Config") Config config;

    @JsonProperty("Services") List<Service> services;

    @JsonProperty("LogConfig") LogConfig logConfig;
}
