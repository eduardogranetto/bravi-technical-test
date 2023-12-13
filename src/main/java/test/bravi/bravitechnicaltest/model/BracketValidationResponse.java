package test.bravi.bravitechnicaltest.model;

public record BracketValidationResponse(
  Boolean balanced,
  String expression
){}
