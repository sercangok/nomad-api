package io.github.zanella.nomad.v1.jobs.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Job {
    @JsonProperty("ID") protected String id;

    @JsonProperty("Name") protected String name;

    @JsonProperty("Type") protected String type;

    @JsonProperty("Priority") protected Integer priority;

    @JsonProperty("Status") protected String status;

    @JsonProperty("StatusDescription") protected String statusDescription;

    @JsonProperty("CreateIndex") protected Integer createIndex;

    @JsonProperty("ModifyIndex") protected Integer modifyIndex;
}
