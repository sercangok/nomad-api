package io.github.zanella.nomad.v1.common.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllocationSummary {
    @JsonProperty("ID") String id;

    @JsonProperty("EvalID") String evalId;

    @JsonProperty("Name") String name;

    @JsonProperty("NodeID") String nodeId;

    @JsonProperty("JobID") String jobId;

    @JsonProperty("TaskGroup") String taskGroup;

    @JsonProperty("DesiredStatus") String desiredStatus;

    @JsonProperty("DesiredDescription") String desiredDescription;

    @JsonProperty("ClientStatus") String clientStatus;

    @JsonProperty("ClientDescription") String clientDescription;

    @JsonProperty("CreateIndex") Integer createIndex;

    @JsonProperty("ModifyIndex") Integer modifyIndex;
}
