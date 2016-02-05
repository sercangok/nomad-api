package io.github.zanella.nomad.v1.nodes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class TaskState {
    @Data
    static class Event {
        @JsonProperty("KillError") String killError;

        @JsonProperty("Message") String message;

        @JsonProperty("Signal") Integer signal;

        @JsonProperty("ExitCode") Integer exitCode;

        @JsonProperty("DriverError") String driverError;

        @JsonProperty("Time") BigInteger time;

        @JsonProperty("Type") String type;
    }

    @JsonProperty("Events") List<Event> events;

    @JsonProperty("State") String state;
}
