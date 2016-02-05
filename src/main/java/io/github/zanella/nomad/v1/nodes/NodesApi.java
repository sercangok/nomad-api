package io.github.zanella.nomad.v1.nodes;

import feign.Param;
import feign.RequestLine;
import io.github.zanella.nomad.v1.nodes.models.NodeSummary;

import java.util.List;

public interface NodesApi {
    String nodesUrl = "/v1/nodes";

    @RequestLine("GET " + nodesUrl)
    List<NodeSummary> getNodes();

    @RequestLine("GET " + nodesUrl + "?region={region}")
    List<NodeSummary> getNodesOfRegion(@Param("region") String region);
}
