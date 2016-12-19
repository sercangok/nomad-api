package io.github.zanella.nomad.v1.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class AllocationStats {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(suppressConstructorProperties = true)
    public static class ResourceUsage {
        @JsonProperty("CpuStats") CpuStats cpuStats;

        @JsonProperty("MemoryStats") MemoryStats memoryStats;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(suppressConstructorProperties = true)
    public static class CpuStats {
        @JsonProperty("Measured") List<String> measured;

        @JsonProperty("Percent") Double percent;

        @JsonProperty("SystemMode") Double systemMode;

        @JsonProperty("ThrottledPeriods") Long throttledPeriods;

        @JsonProperty("ThrottledTime") Long throttledTime;

        @JsonProperty("TotalTicks") Double totalTicks;

        @JsonProperty("UserMode") Double userMode;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(suppressConstructorProperties = true)
    public static class MemoryStats {
        @JsonProperty("Measured") List<String> measured;

        @JsonProperty("Cache") Long cache;

        @JsonProperty("KernelMaxUsage") Long kernelMaxUsage;

        @JsonProperty("KernelUsage") Long kernelUsage;

        @JsonProperty("MaxUsage") Long maxUsage;

        @JsonProperty("RSS") Long rss;

        @JsonProperty("Swap") Long swap;
    }

    @JsonProperty("ResourceUsage") ResourceUsage resourceUsage;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(suppressConstructorProperties = true)
    public static class Task {
        @JsonProperty("Pids") Map<String, ResourceUsage> pids;

        @JsonProperty("ResourceUsage") ResourceUsage resourceUsage;

        @JsonProperty("Timestamp") Long timestamp;
    }

    @JsonProperty("Tasks") Map<String, Task> tasks;

    @JsonProperty("Timestamp") Long timestamp;
}
