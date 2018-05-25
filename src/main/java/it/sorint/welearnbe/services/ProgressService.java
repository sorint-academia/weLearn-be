package it.sorint.welearnbe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.sorint.welearnbe.repository.ProgressRepository;
import it.sorint.welearnbe.repository.entity.ProgressBE;

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
}
