package io.github.zanella.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zanella.nomad.v1.jobs.models.Job;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class NodeJob extends Job {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Update {
        @JsonProperty("MaxParallel") Integer maxParallel;

        @JsonProperty("Stagger") Double stagger;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Constraint {
        @JsonProperty("Operand") String operand;

        @JsonProperty("RTarget") String rTarget;

        @JsonProperty("LTarget") String lTarget;
    }

    @JsonProperty("Meta") Object meta;

    @JsonProperty("Update") Update update;

    @JsonProperty("TaskGroups") List<TaskGroup> taskGroup;

    @JsonProperty("Region") String region;

    @JsonProperty("AllAtOnce") Boolean allAtOnce;

    @JsonProperty("Datacenters") List<String> datacenters;

    @JsonProperty("Constraints") List<Constraint> constraints;
}
