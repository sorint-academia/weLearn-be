package it.sorint.welearnbe.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import it.sorint.welearnbe.repository.entity.SessionBE;

public interface SessionRepository extends MongoRepository<SessionBE, UUID>{
	public List<SessionBE> findAllByTeacher(String teacher);
}
