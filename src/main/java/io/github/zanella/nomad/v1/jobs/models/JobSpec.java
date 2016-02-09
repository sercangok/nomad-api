package io.github.zanella.nomad.v1.jobs.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zanella.nomad.v1.common.models.UpdateStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSpec {
    @JsonProperty("Region") String region;

    @JsonProperty("Datacenters") List<String> datacenters;

    @JsonProperty("Type") String type;

    @JsonProperty("Update") UpdateStrategy update;
}
