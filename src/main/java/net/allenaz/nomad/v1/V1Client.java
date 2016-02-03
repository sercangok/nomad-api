package net.allenaz.nomad.v1;

import feign.Feign;
import feign.Logger;
import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import lombok.Getter;
import net.allenaz.nomad.v1.nodes.NodesApi;
import net.allenaz.nomad.v1.regions.RegionsApi;
import net.allenaz.nomad.v1.status.StatusApi;

public final class V1Client {
    @Getter
    private final String agentAddress;

    public final StatusApi status;
    public final RegionsApi regions;
    public final NodesApi nodes;

    public V1Client(String agentHost, int agentPort) {
        this.agentAddress = agentHost + ":" + agentPort;

        final Decoder decoder = new JacksonDecoder();

        this.status = Feign.builder()
                .decoder(decoder)
                //.errorDecoder(new GitHubErrorDecoder(decoder))
                .logger(new Logger.ErrorLogger())
                //.logLevel(Logger.Level.BASIC)
                .target(StatusApi.class, agentAddress);
                ////////retrofit.create(StatusApi.class);

        this.regions = Feign.builder()
                .decoder(decoder)
                .logger(new Logger.ErrorLogger())
                .target(RegionsApi.class, agentAddress);

        this.nodes = Feign.builder()
                .decoder(decoder)
                .logger(new Logger.ErrorLogger())
                .target(NodesApi.class, agentAddress);
    }
}
