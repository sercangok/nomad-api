package net.allenaz.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

public class Job {
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

    @JsonProperty("ModifyIndex") Integer modifyIndex;

    @JsonProperty("CreateIndex") Integer createIndex;

    @JsonProperty("StatusDescription") String statusDescription;

    @JsonProperty("Status") String status;

    @JsonProperty("Meta") Object meta;

    @JsonProperty("Update") Update update;

    @JsonProperty("TaskGroups") List<TaskGroup> taskGroup;

    @JsonProperty("Region") String region;

    @JsonProperty("ID") String id;

    @JsonProperty("Name") String name;

    @JsonProperty("Type") String type;

    @JsonProperty("Priority") Integer priority;

    @JsonProperty("AllAtOnce") Boolean allAtOnce;

    @JsonProperty("Datacenters") List<String> datacenters;

    @JsonProperty("Constraints") List<Constraint> constraints;
}
