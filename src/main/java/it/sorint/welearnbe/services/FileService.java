package it.sorint.welearnbe.services;

import java.util.HashMap;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import it.sorint.welearnbe.repository.entity.FileMetadataBE;

@Service
public class FileService {
	public HashMap<ObjectId, FileMetadataBE> getFileMetadatas() {
		//TODO: IMPLEMENT THIS!
		return null;
	}
	public HashMap<ObjectId, String> getFilenames() {
		//TODO: IMPLEMENT THIS!
		return null;
	}
}
