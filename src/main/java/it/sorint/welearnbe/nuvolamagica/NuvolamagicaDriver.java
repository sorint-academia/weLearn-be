package it.sorint.welearnbe.nuvolamagica;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import it.sorint.welearnbe.nuvolamagica.objects.NewWorkspaceResponse;

@Service
public class NuvolamagicaDriver {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Optional<String> createWorkspace() {
		//Make the request
		ResponseEntity<NewWorkspaceResponse> newWorkspace = restTemplate.postForEntity("/api/workspace", null, NewWorkspaceResponse.class);
		//Check if it has returned 200 OK
		if (newWorkspace.getStatusCode() != HttpStatus.OK) {
			System.err.println(newWorkspace.toString());
			return Optional.empty();
		} else {
			//Return the WorkspaceID
			return Optional.of(newWorkspace.getBody().getWorkspaceID());
		}
	} 
}
