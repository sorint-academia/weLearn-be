package it.sorint.welearnbe.repository;

import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import it.sorint.welearnbe.repository.entity.SessionBE;

public interface SessionRepository extends MongoRepository<SessionBE, UUID>{

}
