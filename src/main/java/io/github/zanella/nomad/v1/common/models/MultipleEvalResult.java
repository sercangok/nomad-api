package io.github.zanella.nomad.v1.common.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultipleEvalResult extends EvalResult {
    public MultipleEvalResult(List<String> evalIDs, Integer evalCreateIndex, Integer nodeModifyIndex) {
        this.evalIDs = evalIDs;
        this.evalCreateIndex = evalCreateIndex;
        this.nodeModifyIndex = nodeModifyIndex;
    }

    @JsonProperty("EvalIDs") List<String> evalIDs;
}
