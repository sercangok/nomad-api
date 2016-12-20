package io.github.zanella.nomad.v1.nodes;

import io.github.zanella.nomad.v1.nodes.models.NodeSummary;

import java.util.List;

import feign.Param;
import feign.RequestLine;

public interface NodesApi {
    String nodesUrl = "/v1/nodes";

    @RequestLine("GET " + nodesUrl)
    List<NodeSummary> getNodes();

    String nodesForRegionUrl = nodesUrl + "?region={region}";

    @RequestLine("GET " + nodesForRegionUrl)
    List<NodeSummary> getNodesForRegion(@Param("region") String region);
}
