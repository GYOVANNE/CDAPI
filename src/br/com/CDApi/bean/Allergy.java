package br.com.CDApi.bean;

import java.util.ArrayList;

/**
 * Classe responsavel por gerenciar as informaçoes referentes as alergia do paciente.
 * @author Gyovanne Cavalcanti
 */
public class Allergy {

    /**
     *
     */
    protected ArrayList <String> content;
    /**
     * Inserir uma lista de conteudos de uma lista de alergias do paciente.
     * @param content Conteudo do ArrayList.
     */
    public void setContent(ArrayList <String> content) {
            this.content = content;
    }

    /**
     * Retorna uma lista de conteudos de uma lista de alergias do paciente.
     * @return ArrayList
     */
    public ArrayList <String> getContent() {
            return content;
    }
}