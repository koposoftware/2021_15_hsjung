package com.javamodeling.common;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONValue;


public class ResultValue implements Serializable{
	
	private final static String RESULT_CODE = "resultCode";
	private final static String RESULT_MESSAGE = "resultMessage";

	/**
	 * 
	 */
	private static final long serialVersionUID = 4583938099559973634L;
	
	private Long resultCode = new Long(-100);
	private String resultMessage = "";
	
	public Long getResultCode() {
		return resultCode;
	}
	public void setResultCode(Long resultCode) {
		this.resultCode = resultCode;
	}
	
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	
	public void setResultCodeZero() {
		setResultCode(new Long(0));
	}
	
	public void setResultCodePlus() {
		setResultCode(new Long(1));
	}
	
	public void setResultCodeMinus() {
		setResultCode(new Long(-1));
	}
	
	public void setResultCodeMinusTwo() {
		setResultCode(new Long(-2));
	}

	public void setResultCodeMinusThree() {
		setResultCode(new Long(-3));
	}

	public void reset() {
		this.resultCode = null;
		this.resultMessage = null;
	}

	public String toResultJsonString() {

		Map<String, Object> object = new LinkedHashMap<String, Object>();

		object.put(RESULT_CODE, getResultCode());
		object.put(RESULT_MESSAGE, getResultMessage());

		return JSONValue.toJSONString(object);
	}

	public String toResultJsonString(long resultCode) {

		setResultCode(new Long(resultCode));

		return toResultJsonString();
	}


	public String toResultJsonString(String resultMessage) {

		setResultMessage(resultMessage);

		return toResultJsonString();
		
	}

	public String toResultJsonString(long resultCode, String resultMessage) {

		setResultCode(new Long(resultCode));
		setResultMessage(resultMessage);

		return toResultJsonString();
	}
	
	public String toResultJsonStringAddition(String name, String value) {
		
		Map<String, Object> object = new LinkedHashMap<String, Object>();

		object.put(RESULT_CODE, getResultCode());
		object.put(RESULT_MESSAGE, getResultMessage());
		object.put(name, value);

		return JSONValue.toJSONString(object);
		
	}
	
	public String toResultJsonStringAddition(Map<String, Object> values) {
		
		Map<String, Object> object = new LinkedHashMap<String, Object>();

		object.put(RESULT_CODE, getResultCode());
		object.put(RESULT_MESSAGE, getResultMessage());

		for (Map.Entry<String, Object> entry : values.entrySet()) {
	      
			if (!object.containsKey(entry.getKey())) {
				
				object.put(entry.getKey().toString(), entry.getValue());
			}

		}
		
		return JSONValue.toJSONString(object);
		
	}
}
