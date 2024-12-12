package com.poc.dbloader.usecase;

import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

import com.poc.dbloader.domain.File;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DataImportUseCase {

	public void importData(File file) {
		log.trace("file={}", file);
		
        
        byte[] bytes = file.getBytes();
        log.trace("Bytes para String={}", bytes);
        String csvData = new String(bytes, StandardCharsets.UTF_8);
        
        csvData = csvData.replace("\r\n", ";").replace("\n", ";");

        String[] fields = csvData.split(";\\s*");

        StringBuilder sql = new StringBuilder("INSERT INTO sua_tabela (campo1, campo2, ...) VALUES ");

        int length = fields.length;
        for (int i = 0; i < length; i += 8) {
            sql.append("(");
            for (int j = i; j < i + 8; j++) {
                sql.append("'").append(fields[j]).append("',");
            }
            sql.deleteCharAt(sql.length() - 1);
            sql.append("),");
        }

        sql.deleteCharAt(sql.length() - 1);
        sql.append(";");

        log.trace(sql.toString());
        
	}
}
