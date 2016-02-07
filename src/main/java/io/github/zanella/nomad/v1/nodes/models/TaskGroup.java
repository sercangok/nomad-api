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
@AllArgsConstructor
public class TaskGroup {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RestartPolicy {
        @JsonProperty("Delay") Double delay;

        @JsonProperty("Interval") Double interval;

        @JsonProperty("Attempts") Integer attempts;
    }

    @JsonProperty("Meta") Map<String, String> meta;

    @JsonProperty("Tasks") List<Task> tasks;

    @JsonProperty("RestartPolicy") RestartPolicy restartPolicy;

    @JsonProperty("Constraints") List<Constraint> constraints;

    @JsonProperty("Count") Integer count;

    @JsonProperty("Name") String name;
}