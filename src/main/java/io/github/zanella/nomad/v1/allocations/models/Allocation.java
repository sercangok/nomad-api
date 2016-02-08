package io.github.zanella.nomad.v1.allocations.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zanella.nomad.v1.common.models.AllocationSummary;
import io.github.zanella.nomad.v1.common.models.TaskState;
import lombok.*;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Allocation extends AllocationSummary {
    @JsonProperty("TaskStates")
    Map<String,TaskState> taskStates;
}
