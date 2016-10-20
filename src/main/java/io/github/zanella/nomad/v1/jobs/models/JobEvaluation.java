package io.github.zanella.nomad.v1.jobs.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class JobEvaluation {
    @JsonProperty("ID") String id;

    @JsonProperty("Priority") Integer priority;

    @JsonProperty("Type") String type;

    @JsonProperty("TriggeredBy") String triggeredBy;

    @JsonProperty("JobID") String jobId;

    @JsonProperty("JobModifyIndex") Integer jobModifyIndex;

    @JsonProperty("NodeID") String nodeId;

    @JsonProperty("NodeModifyIndex") Integer nodeModifyIndex;

    @JsonProperty("Status") String status;

    @JsonProperty("StatusDescription") String statusDescription;

    @JsonProperty("Wait") Integer wait;

    @JsonProperty("NextEval") String nextEval;

    @JsonProperty("PreviousEval") String previousEval;

    @JsonProperty("CreateIndex") Integer createIndex;

    @JsonProperty("ModifyIndex") Integer modifyIndex;
}
