package test.bravi.bravitechnicaltest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import test.bravi.bravitechnicaltest.model.BracketValidationRequest;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BracketControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @ParameterizedTest
    @CsvFileSource(resources = {"/expressions.csv"})
    public void test(Boolean balanced, String expression) throws Exception {
        mvc.perform(
                put("/v1/brackets/validate")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new BracketValidationRequest(expression))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("expression", equalTo(expression)))
                .andExpect(jsonPath("balanced", is(balanced)))
        ;
    }

}
