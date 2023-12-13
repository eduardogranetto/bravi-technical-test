package test.bravi.bravitechnicaltest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.bravi.bravitechnicaltest.model.BracketValidationRequest;
import test.bravi.bravitechnicaltest.model.BracketValidationResponse;
import test.bravi.bravitechnicaltest.service.BracketValidationService;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/v1/brackets")
public class BracketController {

    private final BracketValidationService bracketService;

    public BracketController(BracketValidationService bracketService) {
        this.bracketService = bracketService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/validate")
    public ResponseEntity<?> balanced(@RequestBody BracketValidationRequest bracket){
        Boolean isBalanced = bracketService.isBalanced(bracket.expression());
        return ok(new BracketValidationResponse(isBalanced, bracket.expression()));
    }

}
