package com.poc.dbloader.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class File {
	
	private byte[] bytes;

}
