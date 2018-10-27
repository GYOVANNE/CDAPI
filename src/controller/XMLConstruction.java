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

    /**
     *
     */
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
    
    /**
     *
     */
    public class TAG{
    private String info;
    private String content;
    private TAG first;
    private TAG next;

        /**
         *
         * @return
         */
        public String getInfo() {
            return info;
        }

        /**
         *
         * @param info
         */
        public void setInfo(String info) {
            this.info = info;
        }

        /**
         *
         * @return
         */
        public String getContent() {
            return content;
        }

        /**
         *
         * @param content
         */
        public void setContent(String content) {
            this.content = content;
        }

        /**
         *
         * @return
         */
        public TAG getFirst() {
            return first;
        }

        /**
         *
         * @param first
         */
        public void setFirst(TAG first) {
            this.first = first;
        }

        /**
         *
         * @return
         */
        public TAG getNext() {
            return next;
        }

        /**
         *
         * @param next
         */
        public void setNext(TAG next) {
            this.next = next;
        }
    }

    /**
     * Cria uma nova TAG na árvore
     * ao passar como parâmetros o nome da TAG seguido de seu conteúdo
     * @param tagName
     * @param tagContent
     * @return
     */
    public TAG xmlCreate(String tagName,String tagContent) {
            TAG n = new TAG();
            n.setInfo(tagName);
            n.setContent(tagContent);
            n.setFirst(null);
            n.setNext(null);
            return n;
    }

    /**
     * Deleta o arquivo ao qual foi passado como nome no parâmetro do método.
     * @param xml
     */
    public void xmlClean(File xml) {
            try {
                boolean del = xml.delete();
            }catch(Exception ex) {
                System.err.println(ex.getLocalizedMessage());
            }
    }

    /**
     * Organização dos nós para contrução da árvore.
     * Essa inserção se dá por inserir a sub-TAG na TAG pai.
     * @param tag
     * @param subTag
     */
    public void xmlInsert(TAG tag,TAG subTag) {
            subTag.setNext(tag.getFirst());
            tag.setFirst(subTag);
    }
    
    /**
     * Impressão da árvore XML.
     * Na chamada desse método, é necessário passar como parâmetro
     * a TAG principal, a qual está contida todo o conteúdo da árvore.
     * @param tag
     * @param fw
     */    
    public void xmlPrint(TAG tag,FileWriter fw) {
        try {
        setTagSpace(getTagSpace());
        if(tag.getFirst() == null && tag.getContent().equals("")) {
            //WRITE JUST ONE LINE <CONTENT/>
            fw.write(String.format("\n"+getSpace()+"<%s/>",tag.getInfo()));
        }else if(tag.getFirst() == null && tag.getInfo().equals("")) {
            fw.write(String.format("\n%s",tag.getInfo()));
        }else {
            fw.write(String.format("\n"+getSpace()+"<%s>",tag.getInfo()));
        }
        //WRITE CONTENT
        fw.write(String.format("%s",tag.getContent()));
        setTagSpace(getTagSpace()+1);//advance row
        
        }catch(IOException ex) {
            System.err.println(ex.getLocalizedMessage());
        }

        for(TAG p = tag.getFirst();p != null; p = p.getNext())
            xmlPrint(p,fw);

        int pos = tag.getInfo().indexOf(' ');//CHECKS SPACE IN <TAG>

        try {
            setTagSpace(getTagSpace()-1);//back row
            if(tag.getFirst() != null) {
                if(pos!=-1) // SPACE IN THE </TAG_>
                    fw.write(String.format("\n"+getSpace()+"</%s>",tag.getInfo().substring(0,pos)));
                else //NO SPACE IN THE </TAG>
                    fw.write(String.format("\n"+getSpace()+"</%s>",tag.getInfo()));
            }else if(tag.getFirst() == null && tag.getInfo().equals("")){
                fw.write(String.format("%s",tag.getInfo()));
            }else if(tag.getFirst() == null && !tag.getContent().equals(""))
                if(pos!=-1) // SPACE IN THE </TAG_>
                    fw.write(String.format(getSpace()+"</%s>",tag.getInfo().substring(0,pos)));
                else //NO SPACE IN THE </TAG>
                    fw.write(String.format("</%s>",tag.getInfo()));
        }catch(IOException ex) {
                System.err.println(ex.getLocalizedMessage());
        }
    }

    /**
     *
     * @param info
     * @return
     */
    public String xmlContent(ArrayList <String> info) {
        String list ="";
        setTagSpace(7);
        if(info!=null){
            for(int i =0; i< info.size();i++) {
                list +=getSpace()+"<item>"
                     +"\n"+getSpace()+"  <content>"+info.get(i)+"</content>\n"
                     +((i!=info.size()-1)?getSpace()+"</item>\n":getSpace()+"</item>");
            }
        }else list = getSpace()+"<item>"+
                "\n"+getSpace()+"  <content>nullFlavor</content>\n"
                    +getSpace()+"</item>";
        setTagSpace(0);
        return list;
    }
}