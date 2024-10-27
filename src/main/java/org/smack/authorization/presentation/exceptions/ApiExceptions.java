package org.smack.authorization.presentation.exceptions;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ApiExceptions {
    private final HttpStatus status;

    private final List<String> messages;

    @JsonGetter("status")
    private int getStatusCode() {
        return this.status.value();
    }
}
