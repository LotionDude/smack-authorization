package org.smack.authorization.domain.opa.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.*;

import java.util.Map;

@Data
@RequiredArgsConstructor
public class OpaResponse {
    private Boolean result;

    @JsonAnySetter
    protected void setAllowValue(Map<String, Boolean> values) {
        this.result = values.get("allow");
    }
}
