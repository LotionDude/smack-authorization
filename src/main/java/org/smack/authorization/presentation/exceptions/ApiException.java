package org.smack.authorization.presentation.exceptions;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class ApiException {
    private final HttpStatus status;

    @Getter
    private final String message;

    @JsonGetter("status")
    private int getStatusCode() {
        return this.status.value();
    }
}
