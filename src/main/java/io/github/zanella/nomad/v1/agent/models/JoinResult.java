package io.github.zanella.nomad.v1.agent.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class JoinResult {
    @JsonProperty("num_joined") Integer numJoined;
    @JsonProperty("error") String error;
}
