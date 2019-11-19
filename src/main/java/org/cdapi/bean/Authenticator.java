package org.cdapi.bean;

/**
 * Classe responsavel por gerenciar as informaçoes referentes a autenticidade do
 * paciente.
 *
 * @author Gyovanne Cavalcanti
 */
public class Authenticator {

    private String code;

    /**
     *
     */
    public Authenticator() {
        this.code = "nullFlavor";
    }

    /**
     *
     * @param code
     */
    public Authenticator(String code) {
        this.code = code;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "code=" + code;
    }

}
