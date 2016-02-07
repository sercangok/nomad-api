package io.github.zanella.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zanella.nomad.v1.common.models.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NodeAllocation {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Metrics {
        @JsonProperty("CoalescedFailures") Integer coalescedFailures;

        @JsonProperty("AllocationTime") Integer AllocationTime;

        @JsonProperty("NodesEvaluated") Integer nodesEvaluated;

        @JsonProperty("NodesFiltered") Integer nodesFiltered;

        @JsonProperty("ClassFiltered") Object classFiltered;

        @JsonProperty("ConstraintFiltered") Object constraintFiltered;

        @JsonProperty("NodesExhausted") Integer nodesExhausted;

        @JsonProperty("ClassExhausted") Object classExhausted;

        @JsonProperty("DimensionExhausted") Object dimensionExhausted;

        @JsonProperty("Scores") Map<String, Double> scores;
    }

    @JsonProperty("ID") String id;

    @JsonProperty("EvalID") String evalId;

    @JsonProperty("Name") String name;

    @JsonProperty("NodeID") String nodeId;

    @JsonProperty("JobID") String jobId;

    @JsonProperty("ModifyIndex") Integer modifyIndex;

    @JsonProperty("Resources") Resources resources;

    @JsonProperty("TaskGroup") String taskGroup;

    @JsonProperty("Job")
    Job job;

    @JsonProperty("TaskResources") Map<String, Resources> taskResources;

    @JsonProperty("Metrics") Metrics metrics;

    @JsonProperty("DesiredStatus") String desiredStatus;

    @JsonProperty("DesiredDescription") String desiredDescription;

    @JsonProperty("ClientStatus") String clientStatus;

    @JsonProperty("ClientDescription") String clientDescription;

    @JsonProperty("TaskStates") Map<String,TaskState> taskStates;

    @JsonProperty("CreateIndex") Integer createIndex;
}