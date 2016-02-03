package net.allenaz.nomad;

import net.allenaz.nomad.v1.V1Client;

public class NomadClient {
    public final V1Client v1;

    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 4646;

    public NomadClient() { this(DEFAULT_HOST); }

    public NomadClient(final String agentHost) { this(agentHost, DEFAULT_PORT); }

    public NomadClient(final String agentHost, final int agentPort) {
        String agentHostWithScheme = agentHost;

        // check that agentHost has scheme or not
        final String agentHostLowercase = agentHost.toLowerCase();
        if (!agentHostLowercase.startsWith("https://") && !agentHostLowercase.startsWith("http://")) {
            // no scheme in host, use default 'http'
            agentHostWithScheme = "http://" + agentHost;
        }

        v1 = new V1Client(agentHostWithScheme, agentPort);
    }
}
