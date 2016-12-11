package io.github.zanella.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zanella.nomad.v1.common.models.Constraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
public class Task {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(suppressConstructorProperties = true)
    @Builder
    public static class Config {
        @JsonProperty("port_map") List<Map<String, Integer>> portMap;

        @JsonProperty("image") String image;

        @JsonProperty("command") String command;

        @JsonProperty("args") List<String> args;

        @JsonProperty("volumes") List<String> volumes;

        @JsonProperty("jar_path") String jarPath;

        @JsonProperty("jvm_options") List<String> jvmOptions;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(suppressConstructorProperties = true)
    public static class LogConfig {
        @JsonProperty("MaxFiles") Integer maxFiles;

        @JsonProperty("MaxFileSizeMB") Integer maxFileSize;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(suppressConstructorProperties = true)
    public static class Artifacts {
        @JsonProperty("GetterSource") String source;

        @JsonProperty("RelativeDest") String destination;

        @JsonProperty("GetterOptions") Map<String, String> options;
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

    @JsonProperty("Artifacts") List<Artifacts> artifacts;
}
