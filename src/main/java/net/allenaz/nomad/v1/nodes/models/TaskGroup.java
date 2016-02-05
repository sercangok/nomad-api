package net.allenaz.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TaskGroup {
    @Data
    static class RestartPolicy {
        @JsonProperty("Delay") Double delay;

        @JsonProperty("Interval") Double interval;

        @JsonProperty("Attempts") Integer Attempts;
    }

    @JsonProperty("Meta") Object meta;

    @JsonProperty("Tasks") List<Task> tasks;

    @JsonProperty("RestartPolicy") RestartPolicy restartPolicy;

    @JsonProperty("Constraints") Object Constraints;

    @JsonProperty("Count") Integer count;

    @JsonProperty("Name") String name;
}