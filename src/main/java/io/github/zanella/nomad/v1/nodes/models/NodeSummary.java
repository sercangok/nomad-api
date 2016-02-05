package io.github.zanella.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class NodeSummary {
    @JsonProperty("ID")
    protected String id;

    @JsonProperty("Datacenter")
    protected String datacenter;

    @JsonProperty("Name")
    protected String name;

    @JsonProperty("NodeClass")
    protected String nodeClass;

    @JsonProperty("Drain")
    protected Boolean drain;

    @JsonProperty("Status")
    protected String status;

    @JsonProperty("StatusDescription")
    protected String statusDescription;

    @JsonProperty("CreateIndex")
    protected Integer createIndex;

    @JsonProperty("ModifyIndex")
    protected Integer modifyIndex;
}
