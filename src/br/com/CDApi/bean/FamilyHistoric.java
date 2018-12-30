package br.com.CDApi.bean;

import java.util.ArrayList;

/**
 *Classe responsavel por gerenciar as informaçoes referentes ao historico familiar do paciente.
 * @author Gyovanne Cavalcanti
 */
public class FamilyHistoric extends Allergy {
    /**
     *
     * Retorna o conteudo de uma lista de historico familiar do paciente.
     * @return ArrayList
    */
    @Override
    public ArrayList<String> getContent() {
        return content;
    }
    /**
     *
     * Inserir o conteudo de uma lista de historico familiar do paciente.
     * @param content Conteudo do ArrayList.
    */
    @Override
    public void setContent(ArrayList<String> content) {
        this.content = content;
    }
}
