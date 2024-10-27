package org.smack.authorization.presentation.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AuthRequest {

    @Valid
    @NotNull
    @Schema(description = "The user making the request to modify the resource.")
    private final String username;

    @NotNull
    @Schema(description = "The action performed on the resource.")
    private final String action;

    @NotNull
    @Schema(description = "The type of resource the action is performing on.", example = "post")
    private final String resourceType;

    @Valid
    @NotNull
    @Schema(description = "The author of the resource.")
    private final String resourceAuthor;
}
