package net.allenaz.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class NodeResources {
    @JsonProperty("CPU")
    Integer cpu;

    @JsonProperty("MemoryMB")
    Integer memoryMB;

    @JsonProperty("DiskMB")
    Integer diskMB;

    @JsonProperty("IOPS")
    Integer iops;

    @JsonProperty("Networks")
    List<Map<String, String>> networks;
}
