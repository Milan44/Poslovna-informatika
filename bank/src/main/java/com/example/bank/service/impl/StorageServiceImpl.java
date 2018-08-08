package com.example.bank.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.bank.model.AnalyticsOfStatements;
import com.example.bank.service.StorageService;

@Service
public class StorageServiceImpl implements StorageService{
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("upload-dir");
	
	public Path store(MultipartFile file){
		Path path = Paths.get(rootLocation + "/" + file.getOriginalFilename());
		if(!Files.exists(path)){
			try{
				Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
				return this.rootLocation.resolve(file.getOriginalFilename());
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	public AnalyticsOfStatements loadAnalyticOfStatements(Path path) {
		File file = path.toFile();
		JAXBContext jaxbContext;
		try {
			
			jaxbContext = JAXBContext.newInstance(AnalyticsOfStatements.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    	AnalyticsOfStatements analyticParsed = (AnalyticsOfStatements) jaxbUnmarshaller.unmarshal(file);
	    	return  analyticParsed;
		} catch (JAXBException e) {					 
			e.printStackTrace();
			return null;
		}
	}
	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}
 
	public Resource loadFileWithRoot(Path rootLocation,String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}
	
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}
 
	public void init() {
		try {
			Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}
}
