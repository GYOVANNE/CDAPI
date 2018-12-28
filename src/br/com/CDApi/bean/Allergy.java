package br.com.CDApi.bean;

import java.util.ArrayList;

/**
 *
 * @author Gyovanne
 */
public class Allergy {

    /**
     *
     */
    protected ArrayList <String> content;
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