package net.allenaz.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import net.allenaz.nomad.v1.jobs.models.Job;

import java.util.List;

@Data
public class NodeJob extends Job {
    @Data
    static class Update {
        @JsonProperty("MaxParallel") Integer maxParallel;

        @JsonProperty("Stagger") Double stagger;
    }

    @Data
    static class Constraint {
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
