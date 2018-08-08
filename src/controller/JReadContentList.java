package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class JReadContentList {

public ArrayList <String> TAG (File file,String Title,String content) throws Exception{
    ArrayList <String> list = new ArrayList <>();
    String line;
        StringTokenizer st;
        try(FileReader fr = new FileReader(file);BufferedReader br = new BufferedReader(new FileReader(file));){
            while((line = br.readLine()) != null){
                if(line.contains(Title))
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
            System.out.println(ex);
        }
    return null;
}
}
