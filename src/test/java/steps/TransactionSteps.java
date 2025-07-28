package steps;


import io.cucumber.java.pt.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.InputStream;

public class TransactionSteps {

    private Response response;
    private String payload;

    @Dado("o payload do lançamento")
    public void dadoPayload() {
        payload = """
        {
            "description": "Venda teste",
            "amount": 100,
            "dueDate": "2025-07-20",
            "type": "INCOME",
            "status": "PENDING",
            "bankAccountId": 1,
            "companyId": 1,
            "userId": 1
        }
        """;
    }

    @Quando("eu enviar uma requisição POST para {string}")
    public void enviarPost(String endpoint) {
        response = RestAssured.given()
                .contentType("application/json")
                .body(payload)
                .when()
                .post("http://localhost:8080" + endpoint);
    }

    @Então("a resposta deve ter status 200")
    public void validarStatus() {
        response.then().statusCode(200);
    }

    @E("o corpo deve conter o campo {string}")
    public void corpoDeveConterCampo(String campo) {
        assertThat(response.jsonPath().get(campo), is(notNullValue()));
    }

    @E("o JSON deve seguir o contrato definido")
    public void jsonSegueContrato() {
        try (InputStream schemaStream = getClass().getResourceAsStream("/schemas/TransactionResponse.schema.json")) {
            JSONObject jsonSchema = new JSONObject(new JSONTokener(schemaStream.toString()));
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(new JSONObject(response.getBody().asString()));
        } catch (Exception e) {
            throw new AssertionError("Validação de schema falhou: " + e.getMessage());
        }
    }
}