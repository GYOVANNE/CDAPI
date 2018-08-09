package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Gyovanne
 */
public class XMLConstruction {

    public XMLConstruction() {

    }

    /**
     *
     */
    private int tagSpace;
    private String space;
    
    private void setSpace(String line){
        this.space = line;
    }
    private String getSpace(){
        return space;
    }
    private int getTagSpace(){
        return tagSpace;
    }
    
    private void setTagSpace(int tagSpace) {
        this.tagSpace = tagSpace;
        String newline="";
        for(int i = 0 ; i < getTagSpace() ; i++)
            newline += "   ";
        setSpace(newline);
    }
    
    public class TAG{
    private String info;
    private String content;
    private TAG first;
    private TAG next;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public TAG getFirst() {
            return first;
        }

        public void setFirst(TAG first) {
            this.first = first;
        }

        public TAG getNext() {
            return next;
        }

        public void setNext(TAG next) {
            this.next = next;
        }
    }

    /**
     * Cria uma nova TAG na árvore
     * ao passar como parâmetros o nome da TAG seguido de seu conteúdo
     * @param TAG_NAME
     * @param TAG_CONTENT
     * @return
     */
    public TAG xml_CREATE(String TAG_NAME,String TAG_CONTENT) {
            TAG n = new TAG();
            n.setInfo(TAG_NAME);
            n.setContent(TAG_CONTENT);
            n.setFirst(null);
            n.setNext(null);
            return n;
    }

    /**
     * Deleta o arquivo ao qual foi passado como nome no parâmetro do método.
     * @param xml
     */
    public void xml_CLEAN(File xml) {
            try {
                boolean del = xml.delete();
            }catch(Exception ex) {
                System.out.println("ErroR: "+ex);
            }
    }

    /**
     * Organização dos nós para contrução da árvore.
     * Essa inserção se dá por inserir a sub-TAG na TAG pai.
     * @param TAG
     * @param SUB_TAG
     */
    public void xml_INSERT(TAG TAG,TAG SUB_TAG) {
            SUB_TAG.setNext(TAG.getFirst());
            TAG.setFirst(SUB_TAG);
    }
    
    /**
     * Impressão da árvore XML.
     * Na chamada desse método, é necessário passar como parâmetro
     * a TAG principal, a qual está contida todo o conteúdo da árvore.
     * @param TAG
     * @param fw
     */    
    public void xml_PRINT(TAG TAG,FileWriter fw) {
        try {
        setTagSpace(getTagSpace());
        if(TAG.getFirst() == null && TAG.getContent().equals("")) {
            //WRITE JUST ONE LINE <CONTENT/>
            fw.write(String.format("\n"+getSpace()+"<%s/>",TAG.getInfo()));
        }else if(TAG.getFirst() == null && TAG.getInfo().equals("")) {
            fw.write(String.format("\n%s",TAG.getInfo()));
        }else {
            fw.write(String.format("\n"+getSpace()+"<%s>",TAG.getInfo()));
        }
        //WRITE CONTENT
        fw.write(String.format("%s",TAG.getContent()));
        setTagSpace(getTagSpace()+1);//advance row
        
        }catch(IOException ex) {
            System.out.println("ErroR: "+ex);
        }

        for(TAG p = TAG.getFirst();p != null; p = p.getNext())
            xml_PRINT(p,fw);

        int pos = TAG.getInfo().indexOf(' ');//CHECKS SPACE IN <TAG>

        try {
            setTagSpace(getTagSpace()-1);//back row
            if(TAG.getFirst() != null) {
                if(pos!=-1) // SPACE IN THE </TAG_>
                    fw.write(String.format("\n"+getSpace()+"</%s>",TAG.getInfo().substring(0,pos)));
                else //NO SPACE IN THE </TAG>
                    fw.write(String.format("\n"+getSpace()+"</%s>",TAG.getInfo()));
            }else if(TAG.getFirst() == null && TAG.getInfo().equals("")){
                fw.write(String.format("%s",TAG.getInfo()));
            }else if(TAG.getFirst() == null && !TAG.getContent().equals(""))
                if(pos!=-1) // SPACE IN THE </TAG_>
                    fw.write(String.format(getSpace()+"</%s>",TAG.getInfo().substring(0,pos)));
                else //NO SPACE IN THE </TAG>
                    fw.write(String.format("</%s>",TAG.getInfo()));
        }catch(IOException ex) {
                System.out.println("ErroR: "+ex);
        }
    }

    public String xml_content(ArrayList <String> info) {
        String list ="";
        setTagSpace(7);
        for(int i =0; i< info.size();i++) {
            list +=getSpace()+"<item>"
                 +"\n"+getSpace()+"  <content>"+info.get(i)+"</content>\n"
                 +((i!=info.size()-1)?getSpace()+"</item>\n":getSpace()+"</item>");
        }
        setTagSpace(0);
        return list;
    }
}