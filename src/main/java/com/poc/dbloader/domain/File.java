package com.poc.dbloader.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class File {
	
	private byte[] bytes;

}
