package io.github.zanella.nomad.v1.common.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zanella.nomad.v1.jobs.models.JobSummary;
import io.github.zanella.nomad.v1.nodes.models.TaskGroup;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class Job extends JobSummary {
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
