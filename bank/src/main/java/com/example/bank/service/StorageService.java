package com.example.bank.service;

import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.example.bank.model.AnalyticsOfStatements;

public interface StorageService {
	Path store(MultipartFile file);
	AnalyticsOfStatements loadAnalyticOfStatements(Path path);
	Resource loadFile(String filename);
	void deleteAll();
	void init();
}
