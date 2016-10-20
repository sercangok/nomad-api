package io.github.zanella.nomad.v1.jobs.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class JobEvalResult {
    @JsonProperty("EvalID") String evalID;

    @JsonProperty("EvalCreateIndex") Integer evalCreateIndex;

    @JsonProperty("JobModifyIndex") Integer nodeModifyIndex;

    @JsonProperty("Index") Integer index;

    @JsonProperty("LastContact") Integer lastContact;

    @JsonProperty("KnownLeader") Boolean knownLeader;
}
