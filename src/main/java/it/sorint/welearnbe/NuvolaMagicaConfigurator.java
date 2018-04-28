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
	
	@Bean()
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.basicAuthorization(USERNAME, PASSWORD).build();
	}
}
