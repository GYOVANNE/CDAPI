package br.com.multcare.bean;

import java.util.ArrayList;

/**
 *
 * @author android
 */
public class Allergy extends LaboratoryExams{

    /**
     *
     * @param content
     */
    @Override
    	public void setContent(ArrayList <String> content) {
		this.content = content;
	}

    /**
     *
     * @return
     */
    @Override
	public ArrayList <String> getContent() {
		return content;
	}
}
