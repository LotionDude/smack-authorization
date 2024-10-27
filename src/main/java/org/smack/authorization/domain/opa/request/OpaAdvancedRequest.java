package org.smack.authorization.domain.opa.request;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.smack.authorization.annotations.JsonSnakeCase;

@Getter
@Builder
@JsonSnakeCase
@RequiredArgsConstructor
public class OpaAdvancedRequest {
    private final OpaUser user;
    private final String action;
    private final String resourceType;
    private final OpaUser author;
}
