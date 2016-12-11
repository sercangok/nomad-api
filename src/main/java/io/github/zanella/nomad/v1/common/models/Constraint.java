package io.github.zanella.nomad.v1.common.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class Constraint {
    @JsonProperty("Operand") String operand;

    @JsonProperty("RTarget") String attribute;

    @JsonProperty("LTarget") String value;
}

