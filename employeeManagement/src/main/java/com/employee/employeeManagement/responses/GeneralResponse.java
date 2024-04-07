package com.employee.employeeManagement.responses;

public class GeneralResponse {
	private int status;
	private String statusMessage;

	public GeneralResponse() {
		status = Status.OK;
		statusMessage = Status.OK_MSG;
	}

	public GeneralResponse(Status status) {
		this.status = status.getCode();
		this.statusMessage = status.getMessage();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public void setStatusObject(Status status) {
		this.setStatus(status.getCode());
		this.setStatusMessage(status.getMessage());
	}
}