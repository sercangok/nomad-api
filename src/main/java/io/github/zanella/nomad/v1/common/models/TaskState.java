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

        @JsonProperty("Message") String message;

        @JsonProperty("Signal") Integer signal;

        @JsonProperty("ExitCode") Integer exitCode;

        @JsonProperty("DriverError") String driverError;

        @JsonProperty("Time") Long time;

        @JsonProperty("Type") String type;
    }

    @JsonProperty("Events") List<Event> events;

    @JsonProperty("State") String state;
}
