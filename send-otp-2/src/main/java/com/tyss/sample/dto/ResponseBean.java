package com.tyss.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBean {

	StringBuffer message;

	public StringBuffer getMessage() {
		return message;
	}

	public void setMessage(StringBuffer message) {
		this.message = message;
	}

	public ResponseBean(StringBuffer message) {
		super();
		this.message = message;
	}
	
	
}
