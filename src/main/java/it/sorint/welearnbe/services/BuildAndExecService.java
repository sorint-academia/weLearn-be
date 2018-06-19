package it.sorint.welearnbe.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sorint.welearnbe.nuvolamagica.NuvolamagicaDriver;
import it.sorint.welearnbe.nuvolamagica.objects.BuildRequest;
import it.sorint.welearnbe.nuvolamagica.objects.BuildResponse;
import it.sorint.welearnbe.nuvolamagica.objects.ExecutionRequest;
import it.sorint.welearnbe.repository.entity.ExecutionConfigBE;

@Service
public class BuildAndExecService {

	private final ProgressService progressService;
	private final FileService fileService;
	private final NuvolamagicaDriver nuvolamagicaDriver;
	private final ProjectService projectService;
	private final HashMap<String, String> sessionIDs; //FIXME: it's the best solution?
	private final HashMap<String, String> processIDs; //FIXME: it's the best solution
	
	public BuildAndExecService(@Autowired ProgressService progressService, @Autowired FileService fileService,
		@Autowired NuvolamagicaDriver nuvolamagicaDriver, @Autowired ProjectService projectService) {
		super();
		this.progressService = progressService;
		this.fileService = fileService;
		this.nuvolamagicaDriver = nuvolamagicaDriver;
		this.projectService = projectService;
		this.sessionIDs = new HashMap<>();
		this.processIDs = new HashMap<>();
	}
	
	private String getSession(String username) {
		if (sessionIDs.containsKey(username)) {
			return sessionIDs.get(username);
		} else {
			sessionIDs.put(username, nuvolamagicaDriver.createSession(nuvolamagicaDriver.createWorkspace().get()).get());
			return sessionIDs.get(username);
		}
	}
	
	public Optional<BuildResponse> build(String username, String student, UUID projectID, String executionConfig) {
		Optional<ProgressAndProgressProject> progressProject = progressService.getOrCreateProgressProject(student, projectID);
		if (!progressProject.isPresent())
			return Optional.empty();
		String session = getSession(username);
		
		//UPLOAD files
		progressProject.get().getProgressProject().getFiles().forEach(f -> {
			try {
				nuvolamagicaDriver.putFile(session, projectID.toString() + "/" + fileService.getFilename(f).get(), fileService.loadFileById(f).get());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		//Create request
		BuildRequest req = new BuildRequest();
		Optional<ExecutionConfigBE> config = projectService.getExecutionConfig(username, projectID, executionConfig);
		if (!config.isPresent())
			return Optional.empty();
		req.setLangType(config.get().getLang());
		req.setMainFile(config.get().getMainFile());
		req.setChrootDir(projectID.toString());
		req.setOptions("");
		//Build
		return nuvolamagicaDriver.build(session, req);
	}

	public boolean exec(String username, String student, UUID projectID, String executionConfig) {
		Optional<ProgressAndProgressProject> progressProject = progressService.getOrCreateProgressProject(student, projectID);
		if (!progressProject.isPresent())
			return false;
		String session = getSession(username);
		Optional<ExecutionConfigBE> config = projectService.getExecutionConfig(student, projectID, executionConfig);
		if (!config.isPresent())
			return false;
		ExecutionRequest req = new ExecutionRequest();
		req.setLangType(config.get().getLang());
		req.setMainFile(config.get().getMainFile());
		req.setChrootDir(projectID.toString());
		req.setOptions("");
		
		Optional<String> process = nuvolamagicaDriver.exec(session, req);
		if (!process.isPresent())
			return false;
		processIDs.put(username, process.get());
		return true;
	}

	public Optional<byte[]> pullStdout(String username, String student, UUID projectID) {
		if (!processIDs.containsKey(username))
			return Optional.empty();
		
		return nuvolamagicaDriver.pullStdout(processIDs.get(username));
	}

	public Optional<byte[]> pullStderr(String username, String student, UUID projectID) {
		if (!processIDs.containsKey(username))
			return Optional.empty();
		
		return nuvolamagicaDriver.pullStderr(processIDs.get(username));
	}
	
}
