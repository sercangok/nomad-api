package io.github.zanella.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class NodeEvalResult {
    @JsonProperty("EvalIDs") List<String> evalIDs;

    @JsonProperty("EvalCreateIndex") protected Integer evalCreateIndex;

    @JsonProperty("NodeModifyIndex") protected Integer nodeModifyIndex;
}
