package br.com.multcare.bean;

import java.util.ArrayList;

/**
 *
 * @author Gyovanne
 */
public class LaboratoryExams {
	private String id;
	private String code;

    /**
     *
     */
    protected ArrayList <String> content;

    public LaboratoryExams() {
        this.id = null;
        this.code = null;
        this.content = null;
    }
    
    /**
     *
     * @param id
     */
    public void setId(String id) {
		this.id= id;
	}

    /**
     *
     * @return
     */
    public String getId() {
		return id;
	}

    /**
     *
     * @param code
     */
    public void setCode(String code) {
		this.code= code;
	}

    /**
     *
     * @return
     */
    public String getCode() {
		return code;
	}

    /**
     *
     * @param content
     */
    public void setContent(ArrayList <String> content) {
		this.content = content;
	}

    /**
     *
     * @return
     */
    public ArrayList <String> getContent() {
		return content;
	}
}