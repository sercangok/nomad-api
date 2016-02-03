package net.allenaz.nomad.v1.nodes;

import feign.Param;
import feign.RequestLine;
import net.allenaz.nomad.v1.nodes.models.NodeSummary;

import java.util.List;

public interface NodesApi {
    @RequestLine("GET /v1/nodes")
    List<NodeSummary> getNodes();

    @RequestLine("GET /v1/nodes?region={region}")
    List<NodeSummary> getNodesOfRegion(@Param("region") String region);
}
