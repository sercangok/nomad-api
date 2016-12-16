package io.github.zanella.nomad.v1.common.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class AllocationSummary {
    @JsonProperty("ID") protected String id;

    @JsonProperty("EvalID") protected String evalId;

    @JsonProperty("Name") protected String name;

    @JsonProperty("NodeID") protected String nodeId;

    @JsonProperty("JobID") protected String jobId;

    @JsonProperty("TaskGroup") protected String taskGroup;

    @JsonProperty("DesiredStatus") protected String desiredStatus;

    @JsonProperty("DesiredDescription") protected String desiredDescription;

    @JsonProperty("ClientStatus") protected String clientStatus;

    @JsonProperty("ClientDescription") protected String clientDescription;

    @JsonProperty("CreateIndex") protected Integer createIndex;

    @JsonProperty("ModifyIndex") protected Integer modifyIndex;

    @JsonProperty("CreateTime") protected Long createTime;
}
