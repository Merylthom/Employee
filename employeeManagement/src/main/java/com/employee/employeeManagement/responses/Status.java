package com.employee.employeeManagement.responses;

public class Status
{
	public static final int OK = 200;
	
	public static final int NO_EMPLOYEE = 10004;
	public static final int INVALID_REQUEST = 10011;
	public static final int EMPTY_REQUEST = 10012;
	
	public static final int DATABASE_ERROR = 50001;
	public static final int GENERAL_ERROR = 50002;
	
	//Messages
	public static final String OK_MSG = "OK";
	public static final String NO_EMPLOYEE_MSG = "No employee found for this ID";
	public static final String DATABASE_ERROR_MSG = "General database error";
	public static final String GENERAL_ERROR_MSG = "General transaction error";
	public static final String EMPTY_REQUEST_MSG = "Request is empty";
	public static final String INVALID_REQUEST_MSG = "Invalid Request";
	public static final String UNKNOWN_ERROR_MSG = "Unknown Error";
	
	
	private int code = OK;

	public Status(int code)
	{
		this.code = code;
	}


	public int getCode()
	{
		return code;
	}

	public String getMessage()
	{
		switch (code)
		{
			case OK:
				return OK_MSG;
			case NO_EMPLOYEE:
				return NO_EMPLOYEE_MSG;
			case DATABASE_ERROR:
				return DATABASE_ERROR_MSG;
			case GENERAL_ERROR:
				return GENERAL_ERROR_MSG;
			case INVALID_REQUEST:
				return INVALID_REQUEST_MSG;
			case EMPTY_REQUEST:
				return EMPTY_REQUEST_MSG;
		}
		return "UNKNOWN ERROR";
	}

	
	
	@Override
	public String toString()
	{
		switch (code)
		{
			case OK:
				return "Code="+OK+", Message="+OK_MSG;
			case NO_EMPLOYEE:
				return "Code="+NO_EMPLOYEE+", Message="+NO_EMPLOYEE_MSG;
			case INVALID_REQUEST:
				return "Code="+INVALID_REQUEST+", Message="+INVALID_REQUEST_MSG;
			case EMPTY_REQUEST:
				return "Code="+EMPTY_REQUEST+", Message="+EMPTY_REQUEST_MSG;
			case DATABASE_ERROR:
				return "Code="+DATABASE_ERROR+", Message="+DATABASE_ERROR_MSG;
			case GENERAL_ERROR:
				return "Code="+GENERAL_ERROR+", Message="+GENERAL_ERROR_MSG;
		}
		return "UNKNOWN ERROR";
	}
}
