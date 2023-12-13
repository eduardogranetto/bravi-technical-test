package test.bravi.bravitechnicaltest.service;

import org.springframework.stereotype.Service;

@Service
public class BracketValidationService {
    public boolean isBalanced(String expression) {
        while (hasBalancedBrackets(expression)) {
            expression = expression.replaceAll("\\(\\)", "")
                    .replaceAll("\\[]", "")
                    .replaceAll("\\{\\}", "");
        }
        return expression.isEmpty();
    }

    private static boolean hasBalancedBrackets(String expression) {
        return expression.contains("()") || expression.contains("[]") || expression.contains("{}");
    }
}
