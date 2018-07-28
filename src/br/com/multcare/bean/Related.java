package br.com.multcare.bean;

public class Related {
	private String code;
	private String id;
	private String extension;
	private String version;
	
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setID(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setExtension(String extension) {
		this.extension= extension;
	}
	public String getExtension() {
		return extension;
	}
	public void setVersion(String version) {
		this.version= version;
	}
	public String getVersion() {
		return version;
	}
}
