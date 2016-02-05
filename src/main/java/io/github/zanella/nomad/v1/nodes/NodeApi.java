package io.github.zanella.nomad.v1.nodes;

import feign.Param;
import feign.RequestLine;
import io.github.zanella.nomad.v1.nodes.models.EvalResult;
import io.github.zanella.nomad.v1.nodes.models.NodeAllocation;
import io.github.zanella.nomad.v1.nodes.models.NodeInfo;

import java.util.List;

public interface NodeApi {
    String nodeUrl = "/v1/node";

    @RequestLine("GET " + nodeUrl + "/{nodeId}")
    NodeInfo getNode(@Param("nodeId") String nodeId);

    @RequestLine("GET " + nodeUrl + "/{nodeId}?region={region}")
    NodeInfo getNodeForRegion(@Param("nodeId") String nodeId, @Param("region") String region);

    String allocationsUrl = "/allocations";

    @RequestLine("GET " + nodeUrl + "/{nodeId}" + allocationsUrl)
    List<NodeAllocation> getNodeAllocations(@Param("nodeId") String nodeId);

    String evaluateUrl = "/evaluate";
    @RequestLine("PUT " + nodeUrl + "/{nodeId}" + evaluateUrl)
    EvalResult putEvaluate(@Param("nodeId") String nodeId);

    String drainUrl = "/drain";
    @RequestLine("PUT " + nodeUrl + "/{nodeId}" + drainUrl + "?enable={enableSwitch}")
    EvalResult putDrain(@Param("nodeId") String nodeId, @Param("enableSwitch") Boolean enableSwitch);
}
