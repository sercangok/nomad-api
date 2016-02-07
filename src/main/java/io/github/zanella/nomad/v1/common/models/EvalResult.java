package io.github.zanella.nomad.v1.common.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvalResult {
    @JsonProperty("EvalIDs") List<String> evalIDs;

    @JsonProperty("EvalCreateIndex") Integer evalCreateIndex;

    @JsonProperty("NodeModifyIndex") Integer nodeModifyIndex;
}
