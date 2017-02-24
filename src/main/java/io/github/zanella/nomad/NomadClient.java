package io.github.zanella.nomad;

import io.github.zanella.nomad.v1.V1Client;
import io.github.zanella.nomad.v1.nodes.models.NodeInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NomadClient {
    public final V1Client v1;

    private static final String DEFAULT_HOST = "localhost";

    private static final Pattern HOST_PATTERN = Pattern.compile("\\s*(.*?):(\\d+)\\s*");

    public static final int DEFAULT_PORT = 4646;

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

    public NomadClient node(String nodeId) {
        final NodeInfo node = v1.node.getNode(nodeId);
        if (node != null) {
            final Matcher matcher = HOST_PATTERN.matcher(node.getHttpAddr());
            if (matcher.matches()) {
                return new NomadClient(matcher.group(1), Integer.parseInt(matcher.group(2)));
            }
        }

        return this;
    }
}
