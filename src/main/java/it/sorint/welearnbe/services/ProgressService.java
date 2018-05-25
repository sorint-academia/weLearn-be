package it.sorint.welearnbe.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.sorint.welearnbe.repository.ProgressRepository;
import it.sorint.welearnbe.repository.entity.ProgressBE;
import it.sorint.welearnbe.repository.entity.ProgressProjectBE;

@Service
public class ProgressService {

	@Autowired
	ProgressRepository progressRepository;

	public List<ProgressBE> getProgresses(String username) {
		//FIXME: limit visibility
		return progressRepository.findAll();
	}
	
	public Optional<ProgressBE> getProgress(String student, String username) {
		//FIXME: limit visibility
		return Optional.ofNullable(progressRepository.findOne(student));
	}
	
	public Optional<ProgressProjectBE> getProgressProject(String student, UUID projectID, String username) {
		Optional<ProgressBE> progress = getProgress(student, username);
		if (!progress.isPresent())
			return Optional.empty();
		
		return progress.get().getProjects().stream().filter(pr -> pr.getId()==projectID).findFirst();
	}

	public Optional<Byte[]> getFileOfProgressProject(String student, UUID projectID, String filename, String name) {
		//TODO: implement this!
		return Optional.empty();
	}
}
