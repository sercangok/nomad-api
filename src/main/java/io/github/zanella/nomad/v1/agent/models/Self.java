package io.github.zanella.nomad.v1.agent.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Self {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Config {
        @JsonProperty("Region") String region;

        @JsonProperty("Datacenter") String datacenter;

        @JsonProperty("NodeName") String nodeName;

        @JsonProperty("DataDir") String dataDir;

        @JsonProperty("LogLevel") String logLevel;

        @JsonProperty("BindAddr") String bindAddr;

        @JsonProperty("EnableDebug") Boolean enableDebug;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Ports {
            @JsonProperty("HTTP") Integer http;
            @JsonProperty("RPC") Integer rpc;
            @JsonProperty("Serf") Integer serf;
        }

        @JsonProperty("Ports") Ports ports;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Addresses {
            @JsonProperty("HTTP") String http;
            @JsonProperty("RPC") String rpc;
            @JsonProperty("Serf") String serf;
        }

        @JsonProperty("Addresses") Addresses addresses;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class AdvertiseAddrs {
            @JsonProperty("RPC") String rpc;
            @JsonProperty("Serf") String serf;
        }

        @JsonProperty("AdvertiseAddrs") AdvertiseAddrs advertiseAddrs;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Client{
            @JsonProperty("Enabled") Boolean enabled;
            @JsonProperty("StateDir") String stateDir;
            @JsonProperty("AllocDir") String allocDir;
            @JsonProperty("Servers") Object servers;
            @JsonProperty("NodeID") String nodeId;
            @JsonProperty("NodeClass") String nodeClass;
            @JsonProperty("Meta") Object meta;
        }

        @JsonProperty("Client") Client client;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Server {
            @JsonProperty("Enabled") Boolean enabled;
            @JsonProperty("Bootstrap") Boolean bootstrap;
            @JsonProperty("BootstrapExpect") Integer bootstrapExpect;
            @JsonProperty("DataDir") String dataDir;
            @JsonProperty("ProtocolVersion") Integer protocolVersion;
            @JsonProperty("NumSchedulers") Integer numSchedulers;
            @JsonProperty("EnabledSchedulers") Object enabledSchedulers;
        }

        @JsonProperty("Server") Server server;

        @JsonProperty("Telemetry") Object telemetry;

        @JsonProperty("LeaveOnInt") Boolean leaveOnInt;

        @JsonProperty("LeaveOnTerm") Boolean leaveOnTerm;

        @JsonProperty("EnableSyslog") Boolean enableSyslog;

        @JsonProperty("SyslogFacility") String syslogFacility;

        @JsonProperty("DisableUpdateCheck") Boolean disableUpdateCheck;

        @JsonProperty("DisableAnonymousSignature") Boolean disableAnonymousSignature;

        @JsonProperty("Revision") String revision;

        @JsonProperty("Version") String version;

        @JsonProperty("VersionPrerelease") String versionPrerelease;

        @JsonProperty("DevMode") Boolean devMode;

        @JsonProperty("Atlas") Object atlas;
    }

    @JsonProperty("config") Config config;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Member {
        @JsonProperty("Name") String name;
        @JsonProperty("Addr") String addr;
        @JsonProperty("Port") Integer port;
        @JsonProperty("Tags") Map<String, String> tags;
        @JsonProperty("Status") String status;
        @JsonProperty("ProtocolMin") Integer protocolMin;
        @JsonProperty("ProtocolMax") Integer protocolMax;
        @JsonProperty("ProtocolCur") Integer protocolCur;
        @JsonProperty("DelegateMin") Integer delegateMin;
        @JsonProperty("DelegateMax") Integer delegateMax;
        @JsonProperty("DelegateCur") Integer delegateCur;
    }

    @JsonProperty("member") Member member;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Stats {
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Client {
            @JsonProperty("heartbeat_ttl") String heartbeat_ttl;
            @JsonProperty("known_servers") String knownServers;
            @JsonProperty("last_heartbeat") String lastHeartbeat;
            @JsonProperty("num_allocations") String numAllocations;
        }

        @JsonProperty("client") Client client;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Nomad {
            @JsonProperty("bootstrap") String bootstrap;
            @JsonProperty("known_regions") String knownRegions;
            @JsonProperty("leader") String leader;
            @JsonProperty("server") String server;
        }

        @JsonProperty("nomad") Nomad nomad;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Raft {
            @JsonProperty("applied_index") String appliedIndex;
            @JsonProperty("commit_index") String commitIndex;
            @JsonProperty("fsm_pending") String fsmPending;
            @JsonProperty("last_contact") String lastContact;
            @JsonProperty("last_log_index") String lastLogIndex;
            @JsonProperty("last_log_term") String lastLogTerm;
            @JsonProperty("last_snapshot_index") String lastSnapshotIndex;
            @JsonProperty("last_snapshot_term") String lastSnapshotTerm;
            @JsonProperty("num_peers") String numPeers;
            @JsonProperty("state") String state;
            @JsonProperty("term") String term;
        }

        @JsonProperty("raft") Raft raft;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Runtime {
            @JsonProperty("arch") String arch;
            @JsonProperty("cpu_count") String cpuCount;
            @JsonProperty("goroutines") String goRoutines;
            @JsonProperty("kernel.name") String kernelName;
            @JsonProperty("max_procs") String maxProcs;
            @JsonProperty("version") String version;
        }

        @JsonProperty("runtime") Runtime runtime;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Serf {
            @JsonProperty("encrypted") String encrypted;
            @JsonProperty("event_queue") String eventQueue;
            @JsonProperty("event_time") String eventTime;
            @JsonProperty("failed") String failed;
            @JsonProperty("intent_queue") String intentQueue;
            @JsonProperty("left") String left;
            @JsonProperty("member_time") String memberTime;
            @JsonProperty("members") String members;
            @JsonProperty("query_queue") String queryQueue;
            @JsonProperty("query_time") String queryTime;
        }

        @JsonProperty("serf") Serf serf;
     }

    @JsonProperty("stats") Stats stats;
}
