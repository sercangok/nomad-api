package net.allenaz.nomad.v1.nodes;

import feign.Param;
import feign.RequestLine;
import net.allenaz.nomad.v1.nodes.models.NodeInfo;

public interface NodeApi {
    @RequestLine("GET /v1/node/{nodeId}")
    NodeInfo getNode(@Param("nodeId") String nodeId);
}
