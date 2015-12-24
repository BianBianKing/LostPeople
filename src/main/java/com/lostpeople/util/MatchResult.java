package com.lostpeople.util;

public class MatchResult {
	public MatchResult(Object object, double result) {
		super();
		this.object = object;
		this.result = result;
	}
	public MatchResult(){};
	private Object object;
	private Long person_id;
	
	public Long getPerson_id() {
		return person_id;
	}
	public void setPerson_id(Long person_id) {
		this.person_id = person_id;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	private double result;
}
