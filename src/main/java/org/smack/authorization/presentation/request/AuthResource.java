package org.smack.authorization.presentation.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Valid
@Getter
@RequiredArgsConstructor
public class AuthResource {

    @Valid
    @NotNull
    @Schema(description = "The author of the resource.")
    private final String authorName;

    @NotNull
    @Schema(description = "The type of resource being modified.", example = "post")
    private final String type;
}
