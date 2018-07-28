package br.com.multcare.bean;

import java.util.ArrayList;

public class LaboratoryExams {
	private String id;
	private String code;
	protected ArrayList <String> content;
        
	public void setId(String id) {
		this.id= id;
	}
	public String getId() {
		return id;
	}
	public void setCode(String code) {
		this.code= code;
	}
	public String getCode() {
		return code;
	}
	public void setContent(ArrayList <String> content) {
		this.content = content;
	}
	public ArrayList <String> getContent() {
		return content;
	}
}