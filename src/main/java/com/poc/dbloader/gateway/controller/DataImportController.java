package com.poc.dbloader.gateway.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.poc.dbloader.domain.File;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("files")
@Slf4j
public class DataImportController {

	@PostMapping
	public void importData(@RequestPart("file") MultipartFile multipartFile) throws IOException {
		log.trace("Start multipartFile={}", multipartFile);

		File file = File.builder()
				.bytes(multipartFile.getBytes())
				.build();

		log.trace("file={}", file);

		log.trace("End");

	}

}
