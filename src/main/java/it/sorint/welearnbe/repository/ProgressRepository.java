package it.sorint.welearnbe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import it.sorint.welearnbe.repository.entity.ProgressBE;

public interface ProgressRepository extends MongoRepository<ProgressBE, String> {

}
