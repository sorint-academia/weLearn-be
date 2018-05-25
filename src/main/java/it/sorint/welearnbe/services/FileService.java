package it.sorint.welearnbe.services;

import java.io.ByteArrayInputStream;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import it.sorint.welearnbe.repository.entity.FileMetadataBE;

@Service
public class FileService {
	
	@Autowired
	private GridFsTemplate gridFsTemplate;
	
	public String simpleSave(String filename, byte[] content, FileMetadataBE metadata) {
		return gridFsTemplate.store(new ByteArrayInputStream(content), filename, metadata).getId().toString();
	}
	
	public HashMap<String, FileMetadataBE> getFileMetadatas() {
		//TODO: IMPLEMENT THIS!
		return null;
	}
	public HashMap<String, String> getFilenames() {
		//TODO: IMPLEMENT THIS!
		return null;
	}
}
