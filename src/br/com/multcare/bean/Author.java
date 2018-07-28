package br.com.multcare.bean;

public class Author extends Patient{
	private String crm;
        
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getCrm() {
		return crm;
	}
}
