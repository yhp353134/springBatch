package com.test.batch.entry;


import java.io.Serializable;

public class RequestModel implements Serializable{

	private String requestId;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
}
