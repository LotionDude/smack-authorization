package org.smack.authorization.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.smack.authorization.domain.authorization.AuthorizationService;
import org.smack.authorization.presentation.request.AuthRequest;
import org.smack.authorization.presentation.response.AuthorizationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authorize")
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class AuthorizationController {
    private final AuthorizationService authorizationService;

    @PostMapping
    public AuthorizationResponse authorizeRequest(@Valid @RequestBody AuthRequest request) {
        return this.authorizationService.authorizeRequest(request);
    }
}
