package org.smack.authorization.domain.opa;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.smack.authorization.configuration.OpenPolicyAgentConfiguration;
import org.smack.authorization.domain.opa.request.InputWrapper;
import org.smack.authorization.domain.opa.request.OpaAdvancedRequest;
import org.smack.authorization.domain.opa.response.OpaResponse;
import org.smack.authorization.utility.RestRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class OpaClient {
    private final OpenPolicyAgentConfiguration configuration;
    private final RestRequestService restRequestService;
    private final ObjectMapper objectMapper;

    public OpaResponse authorizeRequest(OpaAdvancedRequest request) {
        URI uri = this.buildUri(request);

        return this.restRequestService.post(uri, new InputWrapper<>(request), OpaResponse.class);
    }

    private URI buildUri(OpaAdvancedRequest request) {
        String resourceType = request.getResourceType();
        String baseUrl = this.configuration.getBaseUrl();

        String formattedUri = String.format("%s/data/authz/%s/allow", baseUrl, resourceType);

        return URI.create(formattedUri);
    }
}
