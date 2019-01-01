package br.com.CDApi.bean;

import java.util.ArrayList;

/**
 *
 * @author Gyovanne Cavalcanti
 */
public class Component {

    private final ArrayList <Object> content;
    private final String title;

    /**
     *
     * @param title
     * @param content
     */
    public Component(String title, ArrayList<Object> content) {
        this.content = content;
        this.title = title;
    }

    /**
     *
     * @return
     */
    public ArrayList<Object> getContent() {
        return content;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        String cont = "";
        for(int i =0; i < content.size();i++){
            cont += content.get(i).toString() + "\n";
        }
        return title+"\n"+cont;
    }
    
}
