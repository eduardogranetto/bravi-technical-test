package test.bravi.bravitechnicaltest.model;

import jakarta.validation.constraints.Pattern;
import org.springframework.web.bind.annotation.RequestBody;

public record BracketValidationRequest(
        String expression
) {
}
