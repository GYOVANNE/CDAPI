package br.com.CDApi.bean;

import java.util.ArrayList;

/**
 *Classe responsavel por gerenciar as informaçoes referentes aos exames laboratoriais do paciente.
 * @author Gyovanne Cavalcanti
 */
public class LaboratoryExams extends Allergy {
    private String id;
    private String code;
    /**
     *
     * Retorna o conteudo de uma lista de exames laboratoriais do paciente.
     * @return ArrayList
    */
    @Override
    public ArrayList<String> getContent() {
        return content;
    }
    /**
     *
     * Inserir o conteudo de uma lista de exames laboratorias do paciente.
     * @param content Conteudo do ArrayList.
    */
    @Override
    public void setContent(ArrayList<String> content) {
        this.content = content;
    }

    /**
     *
     */
    public LaboratoryExams() {
        this.id = null;
        this.code = null;
        this.content = null;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id= id;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code= code;
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }
}