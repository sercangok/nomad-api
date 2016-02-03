package net.allenaz.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
public class NodeSummary {
    @JsonProperty("ID")
    String id;

    @JsonProperty("Datacenter")
    String datacenter;

    @JsonProperty("Name")
    String name;

    @JsonProperty("NodeClass")
    String nodeClass;

    @JsonProperty("Drain")
    Boolean drain;

    @JsonProperty("Status")
    String status;

    @JsonProperty("StatusDescription")
    String statusDescription;

    @JsonProperty("CreateIndex")
    Integer createIndex;

    @JsonProperty("ModifyIndex")
    Integer modifyIndex;
}
