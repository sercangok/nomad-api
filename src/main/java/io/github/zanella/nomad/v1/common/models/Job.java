package io.github.zanella.nomad.v1.common.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zanella.nomad.v1.jobs.models.JobSummary;
import io.github.zanella.nomad.v1.nodes.models.TaskGroup;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class Job extends JobSummary {
    @JsonProperty("Meta") Map<String, String> meta;

    @JsonProperty("Update") UpdateStrategy update;

    @JsonProperty("TaskGroups") List<TaskGroup> taskGroups;

    @JsonProperty("Region") String region;

    @JsonProperty("AllAtOnce") Boolean allAtOnce;

    @JsonProperty("Datacenters") List<String> datacenters;

    @JsonProperty("Constraints") List<Constraint> constraints;
}
