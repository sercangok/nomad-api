package net.allenaz.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class NodeInfo extends NodeSummary {
    @JsonProperty("Attributes")
    Map<String, String> attributes;

    @JsonProperty("Resources")
    NodeResources nodeResources;

    @JsonProperty("Reserved")
    String reserved;

    @JsonProperty("Links")
    Object links; //"Links": {},

    @JsonProperty("Meta")
    Object meta; //"Meta": {},
}
