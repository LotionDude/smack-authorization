package org.smack.authorization.domain.opa.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class InputWrapper<T> {
    private final T input;
}
