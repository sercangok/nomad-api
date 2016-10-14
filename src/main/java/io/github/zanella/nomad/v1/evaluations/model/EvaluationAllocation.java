package io.github.zanella.nomad.v1.evaluations.model;

import io.github.zanella.nomad.v1.common.models.AllocationSummary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
public class EvaluationAllocation extends AllocationSummary {}
