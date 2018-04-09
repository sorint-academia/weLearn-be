package it.sorint.welearnbe.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.sorint.welearnbe.repository.entity.ProjectBE;

public interface ProjectRepository extends MongoRepository<ProjectBE, UUID> {

}
