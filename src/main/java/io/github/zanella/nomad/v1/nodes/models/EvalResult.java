package io.github.zanella.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class EvalResult {
    @JsonProperty("EvalIDs") List<String> evalIDs;

    @JsonProperty("EvalCreateIndex") Integer evalCreateIndex;

    @JsonProperty("NodeModifyIndex") Integer nodeModifyIndex;
}
