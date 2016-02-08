package io.github.zanella.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zanella.nomad.v1.common.models.AllocationSummary;
import io.github.zanella.nomad.v1.common.models.Job;
import io.github.zanella.nomad.v1.common.models.TaskState;
import lombok.*;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class NodeAllocation extends AllocationSummary {

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

    @JsonProperty("Resources") Resources resources;

    @JsonProperty("Job") Job job;

    @JsonProperty("TaskResources") Map<String, Resources> taskResources;

    @JsonProperty("Metrics") Metrics metrics;

    @JsonProperty("TaskStates") Map<String,TaskState> taskStates;
}