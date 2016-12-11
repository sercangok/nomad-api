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
public class TaskGroup {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(suppressConstructorProperties = true)
    public static class RestartPolicy {
        @JsonProperty("Delay") Long delay;

        @JsonProperty("Interval") Long interval;

        @JsonProperty("Attempts") Integer attempts;

        @JsonProperty("Mode") String mode;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(suppressConstructorProperties = true)
    public static class EphemeralDisk {
        @JsonProperty("Sticky") Boolean sticky;

        @JsonProperty("Migrate") Boolean migrate;

        @JsonProperty("SizeMB") Integer size;
    }

    @JsonProperty("Meta") Map<String, String> meta;

    @JsonProperty("Tasks") List<Task> tasks;

    @JsonProperty("RestartPolicy") RestartPolicy restartPolicy;

    @JsonProperty("Constraints") List<Constraint> constraints;

    @JsonProperty("EphemeralDisk") EphemeralDisk ephemeralDisk;

    @JsonProperty("Count") Integer count;

    @JsonProperty("Name") String name;

}
