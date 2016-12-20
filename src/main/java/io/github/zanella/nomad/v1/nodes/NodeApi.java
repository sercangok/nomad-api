package io.github.zanella.nomad.v1.nodes;

import io.github.zanella.nomad.v1.nodes.models.NodeAllocation;
import io.github.zanella.nomad.v1.nodes.models.NodeDrainEvalResult;
import io.github.zanella.nomad.v1.nodes.models.NodeEvalResult;
import io.github.zanella.nomad.v1.nodes.models.NodeInfo;

import java.util.List;

import feign.Param;
import feign.RequestLine;

public interface NodeApi {
    String nodeUrl = "/v1/node/{nodeId}";

    @RequestLine("GET " + nodeUrl)
    NodeInfo getNode(@Param("nodeId") String nodeId);

    String nodeOfRegionUrl = "/v1/node/{nodeId}?region={region}";

    @RequestLine("GET " + nodeOfRegionUrl)
    NodeInfo getNodeOfRegion(@Param("nodeId") String nodeId, @Param("region") String region);

    String allocationsUrl = nodeUrl + "/allocations";

    @RequestLine("GET " + allocationsUrl)
    List<NodeAllocation> getNodeAllocations(@Param("nodeId") String nodeId);

    String evaluateUrl = nodeUrl + "/evaluate";

    @RequestLine("PUT " + evaluateUrl)
    NodeEvalResult putEvaluate(@Param("nodeId") String nodeId);

    String drainUrl = nodeUrl + "/drain?enable={enableSwitch}";

    @RequestLine("PUT " + drainUrl)
    NodeDrainEvalResult putDrain(@Param("nodeId") String nodeId, @Param("enableSwitch") Boolean enableSwitch);
}
