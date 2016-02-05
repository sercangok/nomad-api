package net.allenaz.nomad.v1;

import feign.Feign;
import feign.Logger;
import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import lombok.Getter;
import net.allenaz.nomad.v1.jobs.JobsApi;
import net.allenaz.nomad.v1.nodes.NodeApi;
import net.allenaz.nomad.v1.nodes.NodesApi;
import net.allenaz.nomad.v1.regions.RegionsApi;
import net.allenaz.nomad.v1.status.StatusApi;

public final class V1Client {
    @Getter
    private final String agentAddress;

    public final StatusApi status;
    public final RegionsApi regions;

    public final NodesApi nodes;
    public final NodeApi node;

    public final JobsApi jobs;

    public V1Client(String agentHost, int agentPort) {
        this.agentAddress = agentHost + ":" + agentPort;

        final Decoder decoder = new JacksonDecoder();

        final Feign.Builder feignBuilder = Feign.builder()
                .decoder(decoder)
                .logger(new Logger.ErrorLogger());
                //.logLevel(Logger.Level.FULL)

        this.status = feignBuilder.target(StatusApi.class, agentAddress);

        this.regions = feignBuilder.target(RegionsApi.class, agentAddress);

        this.nodes = feignBuilder.target(NodesApi.class, agentAddress);

        this.node = feignBuilder.target(NodeApi.class, agentAddress);

        this.jobs = feignBuilder.target(JobsApi.class, agentAddress);
    }
}
