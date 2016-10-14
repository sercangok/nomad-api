package io.github.zanella.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resources {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Network {

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class DynamicPort {
            @JsonProperty("Value") Integer value;

            @JsonProperty("Label") String label;
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class ReservedPort {
            @JsonProperty("Value") Integer value;

            @JsonProperty("Label") String label;
        }

        @JsonProperty("DynamicPorts") List<DynamicPort> dynamicPorts = new ArrayList<DynamicPort>();

        @JsonProperty("ReservedPorts") List<ReservedPort> reservedPorts;

        @JsonProperty("MBits") Integer mBits;

        @JsonProperty("IP") String ip;

        @JsonProperty("CIDR") String cidr;

        @JsonProperty("Device") String device;
    }

    @JsonProperty("CPU") Integer cpu;

    @JsonProperty("MemoryMB") Integer memoryMB;

    @JsonProperty("DiskMB") Integer diskMB;

    @JsonProperty("IOPS") Integer iops;

    @JsonProperty("Networks") List<Network> networks = new ArrayList<Network>();
}
