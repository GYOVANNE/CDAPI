package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Classe responsável pela leitura do conteúdo de uma TAG no arquivo.
 * 
 * @author Gyovanne
 */
public class SimpleTag {

    /**
     * Declaração necessária para capturar o conteúdo de uma TAG, que retornará uma string contendo sua informação.
     * É necessário passar o nome do arquivo (filename),
     * o nome da TAG inicial (TagBegin) e a TAG final (TagFinish),
     * a informação da TAG (info) e a opção do tipo da TAG:<br>
     * [0] ( = "content")<br>
     * [1] ()text(/)<br>
     * [2] (text =" " )<br>
     * [3] (text =" "/)<br>
     * [4] (...extension=" "/)<br>
     * @param file
     * @param TagBegin
     * @param TagFinish
     * @param info
     * @param op
     * @return
     */
    public String TAG (File file,String TagBegin,String TagFinish,String info,int op){
    String linha;
    StringTokenizer st;
    try(FileReader fr = new FileReader(file);BufferedReader br = new BufferedReader(new FileReader(file));){

    while((linha = br.readLine()) != null){
        if(linha.contains("<"+TagBegin+""))
        {
            while((linha = br.readLine()) != null){
            String dados;
            st = new StringTokenizer(linha,"\n");
            while(st.hasMoreTokens()){
                dados = st.nextToken();
                if(dados.contains(info)){
                    switch(op) {
                    case 0:
                        fr.close();
                        br.close();
                        return (dados.substring(dados.indexOf("=")+2,dados.indexOf(">", dados.indexOf("="))-1));
                    case 1:
                        fr.close();
                        br.close();
                        return (dados.substring(dados.indexOf(">")+1,dados.indexOf("</", dados.indexOf(">"))));
                    case 2:
                        fr.close();
                        br.close();
                        return (dados.substring(dados.indexOf("=")+2,dados.indexOf(" ", dados.indexOf("="))-1));
                    case 3:
                        fr.close();
                        br.close();
                        return (dados.substring(dados.indexOf("=")+2,dados.indexOf("/>", dados.indexOf("="))-1));
                    case 4:
                        fr.close();
                        br.close();
                        return (dados.substring(dados.indexOf("n=")+3,dados.indexOf("/>", dados.indexOf("n="))-1));
                    }
                }else break;
            }
                if(TagFinish != null && linha.contains("<"+TagFinish+">")) break;
            }
        }if(linha.contains("</"+TagFinish+">")) break;
    }
    fr.close();
    br.close();
    }catch(IOException ex){
        System.err.println(ex.getLocalizedMessage());
    }
    return null;
    }
}