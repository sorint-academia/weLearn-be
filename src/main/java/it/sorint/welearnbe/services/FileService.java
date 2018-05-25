package it.sorint.welearnbe.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	
	
	public List<String> cloneFiles(List<String> files) {
		return files.stream().map(id -> {
			//Load the file data
			GridFSDBFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
			try {
				return simpleSave(file.getFilename(), loadFileById(id).get(), new FileMetadataBE(
						(Boolean) file.getMetaData().get("hidden"), 
						(Boolean) file.getMetaData().get("locked")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "THE_STRANGE_ERROR";
			}
		}).collect(Collectors.toList());
	}

	public Optional<byte[]> loadFileByFilenameAndAnyOfIds(List<String> files, String filename) {
		//Find the correct file
		return files.stream().filter(id -> {
			GridFSDBFile f = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
			return f != null;
		}).map(id -> {
			try {
				return loadFileById(id).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "FAILED_TO_LOAD_FILE".getBytes();
			}
		}).findFirst();
		
		
	}

	public Optional<OldNewFileId> saveFileByFilenameAndAnyOfIds(List<String> files, String filename, byte[] content) {
		//Find the correct file
		Optional<GridFSDBFile> oldFile = files.stream().filter(id -> {
			GridFSDBFile f = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
			return f != null;
		}).map(id -> {
			GridFSDBFile f = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
			gridFsTemplate.delete(new Query(Criteria.where("_id").is(id)));
			return f;
		}).findFirst();
		
		if (oldFile.isPresent()) {
			String newFile = simpleSave(filename, content, new FileMetadataBE (
					(Boolean) oldFile.get().getMetaData().get("hidden"), 
					(Boolean) oldFile.get().getMetaData().get("locked")));
			return Optional.of(new OldNewFileId(oldFile.get().getId().toString(), newFile));			
		} else {
			return Optional.empty();
		}

	}
	
	public Optional<String> getFilename(String id) {
		GridFSDBFile f = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
		if (f == null)
			return Optional.empty();
		else
			return Optional.of(f.getFilename());
	}
}
