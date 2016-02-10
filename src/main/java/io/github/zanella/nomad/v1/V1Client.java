package io.github.zanella.nomad.v1;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import io.github.zanella.nomad.v1.agent.AgentApi;
import io.github.zanella.nomad.v1.allocations.AllocationApi;
import io.github.zanella.nomad.v1.allocations.AllocationsApi;
import io.github.zanella.nomad.v1.evaluations.EvaluationsApi;
import io.github.zanella.nomad.v1.jobs.JobApi;
import lombok.Getter;
import io.github.zanella.nomad.v1.jobs.JobsApi;
import io.github.zanella.nomad.v1.nodes.NodeApi;
import io.github.zanella.nomad.v1.nodes.NodesApi;
import io.github.zanella.nomad.v1.regions.RegionsApi;
import io.github.zanella.nomad.v1.status.StatusApi;

public final class V1Client {
    @Getter
    private final String agentAddress;

    public final StatusApi status;
    public final RegionsApi regions;

    public final NodesApi nodes;
    public final NodeApi node;

    public final JobsApi jobs;
    public final JobApi job;

    public final AllocationsApi allocations;
    public final AllocationApi allocation;

    public final EvaluationsApi evaluations;

    public final AgentApi agent;

    public V1Client(String agentHost, int agentPort) {
        this.agentAddress = agentHost + ":" + agentPort;

        final Feign.Builder feignBuilder = Feign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .logger(new Logger.ErrorLogger());
                //.logLevel(Logger.Level.FULL)

        this.status = feignBuilder.target(StatusApi.class, agentAddress);

        this.regions = feignBuilder.target(RegionsApi.class, agentAddress);

        this.nodes = feignBuilder.target(NodesApi.class, agentAddress);

        this.node = feignBuilder.target(NodeApi.class, agentAddress);

        this.jobs = feignBuilder.target(JobsApi.class, agentAddress);

        this.job = feignBuilder.target(JobApi.class, agentAddress);

        this.allocations = feignBuilder.target(AllocationsApi.class, agentAddress);

        this.allocation = feignBuilder.target(AllocationApi.class, agentAddress);

        this.evaluations = feignBuilder.target(EvaluationsApi.class, agentAddress);

        this.agent = feignBuilder.target(AgentApi.class, agentAddress);
    }
}
