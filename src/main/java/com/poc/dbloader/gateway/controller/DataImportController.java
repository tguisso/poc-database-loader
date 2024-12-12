package com.poc.dbloader.gateway.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.poc.dbloader.domain.File;
import com.poc.dbloader.usecase.DataImportUseCase;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("files")
@Slf4j
public class DataImportController {

	@Autowired
	private DataImportUseCase dataImportUseCase; 
	
	@PostMapping
	public void importData(@RequestPart("file") MultipartFile multipartFile) throws IOException {
		log.trace("Start");

		File file = File.builder()
				.bytes(multipartFile.getBytes())
				.build();

		dataImportUseCase.importData(file);

		log.trace("End");

	}

}
