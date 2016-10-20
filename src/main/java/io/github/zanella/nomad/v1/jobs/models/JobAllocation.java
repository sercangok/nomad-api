package io.github.zanella.nomad.v1.jobs.models;

import io.github.zanella.nomad.v1.common.models.AllocationSummary;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor(suppressConstructorProperties = true)
public class JobAllocation extends AllocationSummary {
}
