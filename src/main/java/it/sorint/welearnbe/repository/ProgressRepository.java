package it.sorint.welearnbe.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import it.sorint.welearnbe.repository.entity.ProgressBE;

public interface ProgressRepository extends MongoRepository<ProgressBE, UUID> {

}
