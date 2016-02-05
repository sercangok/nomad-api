package io.github.zanella.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Resources {
    @Data
    public static class Network {
        @Data
        static class DynamicPort {
            @JsonProperty("Value") Integer value;

            @JsonProperty("Label") String label;
        }

        @JsonProperty("DynamicPorts") List<DynamicPort> dynamicPorts;

        @JsonProperty("ReservedPorts") Object reservedPorts;

        @JsonProperty("MBits") Integer mBits;

        @JsonProperty("IP") String ip;

        @JsonProperty("CIDR") String cidr;

        @JsonProperty("Device") String device;
    }

    @JsonProperty("CPU")
    Integer cpu;

    @JsonProperty("MemoryMB")
    Integer memoryMB;

    @JsonProperty("DiskMB")
    Integer diskMB;

    @JsonProperty("IOPS")
    Integer iops;

    @JsonProperty("Networks")
    List<Network> networks;
}
