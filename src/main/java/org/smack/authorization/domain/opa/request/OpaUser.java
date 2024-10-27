package org.smack.authorization.domain.opa.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.smack.authorization.annotations.JsonSnakeCase;

import java.util.List;

@Getter
@JsonSnakeCase
@RequiredArgsConstructor
public class OpaUser {
    private final String id;
    private final List<String> roles;
}
