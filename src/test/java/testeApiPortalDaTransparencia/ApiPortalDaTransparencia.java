package testeApiPortalDaTransparencia;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ApiPortalDaTransparencia {	

	@Test
	public void testePortalDaTransparenciaAuxilioEmergencialPorCidade() {
		String token = "Inserir Token"; 
		
		Map<String, String> queryParams = new HashMap();
		Map<String, String> headerMap = new HashMap();
		String url = "http://api.portaldatransparencia.gov.br"; 
		String path = "/api-de-dados/auxilio-emergencial-beneficiario-por-municipio";
		headerMap.put("chave-api-dados",token);
		queryParams.put("codigoIbge", "3515004"); 
		queryParams.put("mesAno", "202012"); 
		queryParams.put("pagina", "1"); 


		given()
			.headers(headerMap)
			.queryParams(queryParams)
			.log().all()
		.when()
			.get(url+path)
			.then().assertThat()
			.log().all()
			.statusCode(200)
			.body(containsString("KATIA"));
			
			
	}

}