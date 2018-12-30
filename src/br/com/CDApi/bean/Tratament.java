package br.com.CDApi.bean;

import java.util.ArrayList;

/**
 *Classe responsavel por gerenciar as informaçoes referentes ao tratamento do paciente.
 * @author Gyovanne Cavalcanti
 */
public class Tratament extends Allergy {
    /**
     *
     * Retorna o conteudo de uma lista de tratamento do paciente.
     * @return ArrayList
    */
    @Override
    public ArrayList<String> getContent() {
        return content;
    }
    /**
     *
     * Inserir o conteudo de uma lista de tratamento do paciente.
     * @param content Conteudo do ArrayList.
    */
    @Override
    public void setContent(ArrayList<String> content) {
        this.content = content;
    }
    
}