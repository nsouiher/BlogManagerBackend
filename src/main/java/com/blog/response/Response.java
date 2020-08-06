package com.blog.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response<T> {
	
	private String status;

	@Builder.Default
	private String message = "Success!";

	private T body;

}
