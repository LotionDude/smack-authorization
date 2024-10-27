package org.smack.authorization.domain.authorization;

import lombok.RequiredArgsConstructor;
import org.smack.authorization.domain.opa.OpaClient;
import org.smack.authorization.domain.opa.request.OpaAdvancedRequest;
import org.smack.authorization.domain.opa.request.OpaUser;
import org.smack.authorization.domain.opa.response.OpaResponse;
import org.smack.authorization.domain.roles.RolesService;
import org.smack.authorization.presentation.request.AuthRequest;
import org.smack.authorization.presentation.response.AuthorizationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class AuthorizationService {
    private final OpaClient opaClient;
    private final RolesService rolesService;

    public AuthorizationResponse authorizeRequest(AuthRequest request) {
        OpaAdvancedRequest opaRequest = OpaAdvancedRequest.builder()
                .user(this.buildOpaUser(request.getUsername()))
                .action(request.getAction())
                .resourceType(request.getResourceType())
                .author(this.buildOpaUser(request.getResourceAuthor()))
                .build();

        OpaResponse response = this.opaClient.authorizeRequest(opaRequest);

        return new AuthorizationResponse(response.getResult());
    }

    private OpaUser buildOpaUser(String username) {
        List<String> roles = this.rolesService.getUserRoles(username);
        return new OpaUser(username, roles);
    }
}
