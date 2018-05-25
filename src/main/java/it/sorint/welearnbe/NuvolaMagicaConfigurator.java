package it.sorint.welearnbe;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class NuvolaMagicaConfigurator {

	@Value("${nuvola-magica.username:nuvolamagica}")
	private String USERNAME;
	@Value("${nuvola-magica.password:Nuvolamag!c4}")
	private String PASSWORD;
	@Value("${nuvola-magica.base_url:http://127.0.0.1:8090}")
	private String BASE_URL;
	
	@Bean()
	public RestTemplate restTemplate(RestTemplateBuilder builder) {

		return builder.rootUri(BASE_URL).basicAuthorization(USERNAME, PASSWORD).build();
	}
}
