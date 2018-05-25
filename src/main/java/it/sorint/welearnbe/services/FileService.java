package it.sorint.welearnbe.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.gridfs.GridFSDBFile;

import it.sorint.welearnbe.repository.entity.FileMetadataBE;

@Service
public class FileService {
	
	@Autowired
	private GridFsTemplate gridFsTemplate;
	
	public String simpleSave(String filename, byte[] content, FileMetadataBE metadata) {
		return gridFsTemplate.store(new ByteArrayInputStream(content), filename, metadata).getId().toString();
	}
	
	public HashMap<String, FileMetadataBE> getFileMetadatas() {
		List<GridFSDBFile> files = gridFsTemplate.find(new Query());
		HashMap<String, FileMetadataBE> metadatas = new HashMap<>();
		files.forEach(
				item -> metadatas.put(item.getId().toString(), new FileMetadataBE(
							item.getId().toString(), 
							item.getFilename(), 
							(Boolean)item.getMetaData().get("hidden"), 
							(Boolean)item.getMetaData().get("locked"))
						)
				);
		
		return metadatas;
	}
	public HashMap<String, String> getFilenames() {
		List<GridFSDBFile> files = gridFsTemplate.find(new Query());
		HashMap<String, String> filenames = new HashMap<>();
		files.forEach(
				item -> filenames.put(item.getId().toString(), item.getFilename())
		);
		return filenames;
	}
	
	public Optional<byte[]> loadFileById(String id) throws IOException {
		//FIXME: check if file exist
		GridFSDBFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		file.writeTo(out);
		return Optional.of(out.toByteArray());
	}
}
