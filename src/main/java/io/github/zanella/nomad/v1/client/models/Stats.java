package io.github.zanella.nomad.v1.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class Stats {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(suppressConstructorProperties = true)
    public static class CPU {
        @JsonProperty("CPU") String cpu;

        @JsonProperty("Idle") Double idle;

        @JsonProperty("System") Double system;

        @JsonProperty("Total") Double total;

        @JsonProperty("User") Double user;
    }

    @JsonProperty("CPU") List<CPU> cpu;

    @JsonProperty("CPUTicksConsumed") Double cpuTicksConsumed;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(suppressConstructorProperties = true)
    public static class DiskStats {
        @JsonProperty("Available") Long available;

        @JsonProperty("Device") String device;

        @JsonProperty("InodesUsedPercent") Double inodesUsedPercent;

        @JsonProperty("Mountpoint") String mountpoint;

        @JsonProperty("Size") Long size;

        @JsonProperty("Used") Long used;

        @JsonProperty("UsedPercent") Double usedPercent;
    }

    @JsonProperty("DiskStats") List<DiskStats> diskStats;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(suppressConstructorProperties = true)
    public static class Memory {
        @JsonProperty("Available") Long available;

        @JsonProperty("Free") Long free;

        @JsonProperty("Total") Long total;

        @JsonProperty("Used") Long used;
    }

    @JsonProperty("Memory") Memory memory;

    @JsonProperty("Timestamp") Long timestamp;

    @JsonProperty("Uptime") Long uptime;
}
