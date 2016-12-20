package io.github.zanella.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NodeInfo extends NodeSummary {

    @JsonProperty("HTTPAddr") String httpAddr;

    @JsonProperty("TLSEnabled") boolean tlsEnabled;

    @JsonProperty("Attributes") Map<String, String> attributes;

    @JsonProperty("Resources") Resources resources;

    @JsonProperty("Reserved") Resources reserved;

    @JsonProperty("Links") Map<String, String> links;

    @JsonProperty("Meta") Object meta;

    public String superToString() { return super.toString(); }

    public boolean superEquals(NodeSummary nodeSummary) { return super.equals(nodeSummary); }
}
