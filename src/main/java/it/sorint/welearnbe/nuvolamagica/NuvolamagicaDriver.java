package it.sorint.welearnbe.nuvolamagica;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.sorint.welearnbe.nuvolamagica.objects.BuildRequest;
import it.sorint.welearnbe.nuvolamagica.objects.BuildResponse;
import it.sorint.welearnbe.nuvolamagica.objects.ExecutionRequest;
import it.sorint.welearnbe.nuvolamagica.objects.ExecutionResponse;
import it.sorint.welearnbe.nuvolamagica.objects.NewSessionResponse;
import it.sorint.welearnbe.nuvolamagica.objects.NewWorkspaceResponse;
import it.sorint.welearnbe.nuvolamagica.objects.ProcessStatusResponse;

@Service
public class NuvolamagicaDriver {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Optional<String> createWorkspace() {
		//Make the request
		ResponseEntity<NewWorkspaceResponse> newWorkspace = restTemplate.postForEntity("/api/workspace", null, NewWorkspaceResponse.class);
		//Check if it has returned 200 OK
		if (newWorkspace.getStatusCode() != HttpStatus.OK) {
			return Optional.empty();
		} else {
			//Return the WorkspaceID
			return Optional.of(newWorkspace.getBody().getWorkspaceID());
		}
	} 
	
	public Optional<String> createSession(String workspaceID) {
		//Make the request
		ResponseEntity<NewSessionResponse> newSession = restTemplate.postForEntity(workspaceID+"/sessions", null, NewSessionResponse.class);
		//Check if it has returned 200 OK
		if (newSession.getStatusCode() != HttpStatus.OK) {
			return Optional.empty();
		} else {
			//Return the WorkspaceID
			return Optional.of(newSession.getBody().getSessionID());
		}
	} 
	
	public Boolean wakeUpSession(String sessionID) {
		//Make the request
		return restTemplate.getForEntity(sessionID + "/wakeup", null).getStatusCode() == HttpStatus.OK;
	}
	
	public Boolean putFile(String sessionID, String filename, byte[] content) {
		restTemplate.put(sessionID+"/files/"+filename, content);
		return true;
	}
	
	public Optional<BuildResponse> build(String sessionID, BuildRequest request) {
		//Make the request
		ResponseEntity<BuildResponse> buildResponse = restTemplate.postForEntity(sessionID + "/compilation", request, BuildResponse.class);
		//Check if it has returned 200 OK
		if (buildResponse.getStatusCode() != HttpStatus.OK) {
			return Optional.empty();
		} else {
			//Return the WorkspaceID
			return Optional.of(buildResponse.getBody());
		}
	}
	
	public Optional<String> build(String sessionID, ExecutionRequest request) {
		//Make the request
		ResponseEntity<ExecutionResponse> executionResponse = restTemplate.postForEntity(sessionID + "/processes", request, ExecutionResponse.class);
		//Check if it has returned 200 OK
		if (executionResponse.getStatusCode() != HttpStatus.OK) {
			return Optional.empty();
		} else {
			//Return the WorkspaceID
			return Optional.of(executionResponse.getBody().getProcessID());
		}
	}
	
	public Optional<byte[]> pullStdout(String processID) {
		//Make the request
		ResponseEntity<byte[]> pullStdoutResponse = restTemplate.getForEntity(processID+"/stdout", null, byte[].class);
		//Check if it has returned 200 OK
		if (pullStdoutResponse.getStatusCode() != HttpStatus.OK) {
			return Optional.empty();
		} else {
			//Return the WorkspaceID
			return Optional.of(pullStdoutResponse.getBody());
		}
	}
	public Optional<byte[]> pullStderr(String processID) {
		//Make the request
		ResponseEntity<byte[]> pullStderrResponse = restTemplate.getForEntity(processID+"/stderr", null, byte[].class);
		//Check if it has returned 200 OK
		if (pullStderrResponse.getStatusCode() != HttpStatus.OK) {
			return Optional.empty();
		} else {
			//Return the WorkspaceID
			return Optional.of(pullStderrResponse.getBody());
		}
	}
	
	public Optional<ProcessStatusResponse> getStatus(String processID) {
		//Make the request
		ResponseEntity<ProcessStatusResponse> getStatusResponse = restTemplate.getForEntity(processID+"/status", null, ProcessStatusResponse.class);
		//Check if it has returned 200 OK
		if (getStatusResponse.getStatusCode() != HttpStatus.OK) {
			return Optional.empty();
		} else {
			//Return the WorkspaceID
			return Optional.of(getStatusResponse.getBody());
		}
	}
}
