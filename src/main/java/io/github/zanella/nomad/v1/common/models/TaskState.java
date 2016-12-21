package io.github.zanella.nomad.v1.common.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class TaskState {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(suppressConstructorProperties = true)
    public static class Event {
        @JsonProperty("KillError") String killError;

        @JsonProperty("KillReason") String killReason;

        @JsonProperty("KillTimeout") Long killTimeout;

        @JsonProperty("Message") String message;

        @JsonProperty("Signal") Integer signal;

        @JsonProperty("ExitCode") Integer exitCode;

        @JsonProperty("DriverError") String driverError;

        @JsonProperty("Time") Long time;

        @JsonProperty("Type") String type;

        @JsonProperty("FailsTask") boolean failsTask;

        @JsonProperty("TaskSignalReason") String taskSignalReason;

        @JsonProperty("TaskSignal") String taskSignal;

        @JsonProperty("ValidationError") String validationError;

        @JsonProperty("DownloadError") String downloadError;
    }

    @JsonProperty("Events") List<Event> events;

    @JsonProperty("State") String state;

    @JsonProperty("Failed") boolean failed;
}
