package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Gyovanne
 */
public class ListTag {

    /**
     * 
     * @param file
     * @param title
     * @param content
     * @return Retorna um ArrayList com conteúdo da TAG.
     * @throws java.io.IOException
     */
    public ArrayList <String> TAG (File file,String title,String content) throws IOException{
        ArrayList <String> list = new ArrayList <>();
        String line;
            StringTokenizer st;
            try(FileReader fr = new FileReader(file);BufferedReader br = new BufferedReader(new FileReader(file));){
                while((line = br.readLine()) != null){
                    if(line.contains(title))
                    {
                    while((line = br.readLine()) != null){
                        String dados;
                        st = new StringTokenizer(line,"\n");
                        while(st.hasMoreTokens()){
                            dados = st.nextToken();
                            if(dados.contains("<"+content+">")){
                                list.add(dados.substring(dados.indexOf(">")+1,
                                dados.indexOf("</", dados.indexOf(">"))));
                            }else break;
                        }
                        if(line.contains("</component>")) break;
                    }
                    fr.close();
                    br.close();
                    return list;
                    }
                }
                fr.close();
                br.close();
                return null;
            }catch(IOException ex){
                System.out.println(ex.getLocalizedMessage());
            }
        return null;
    }
}
