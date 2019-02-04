package br.com.CDApi.bean;

/**
 * Classe responsavel por gerenciar as informaçoes do medico.
 *
 * @author Gyovanne Cavalcanti
 */
public class Author {

    private String addr;
    private String phone;
    private String name;
    private String family;
    private String crm;

    /**
     *
     */
    public Author() {
        this.addr = "nullFlavor";
        this.phone = "nullFlavor";
        this.name = "nullFlavor";
        this.family = "nullFlavor";
        this.crm = "nullFlavor";
    }

    /**
     *
     * @param addr
     * @param phone
     * @param name
     * @param family
     * @param crm
     */
    public Author(String addr, String phone, String name, String family, String crm) {
        this.addr = addr;
        this.phone = phone;
        this.name = name;
        this.family = family;
        this.crm = crm;
    }

    /**
     * Retorna o endereço do medico.
     *
     * @return
     */
    public String getAddr() {
        return addr;
    }

    /**
     * Inserir o endereço do medico.
     *
     * @param addr
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * Retorna o telefone do medico.
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Inserir o telefone do medico.
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Retorna o primeiro nome do medico.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Inserir o primeiro nome do medico.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o sobrenome do medico.
     *
     * @return
     */
    public String getFamily() {
        return family;
    }

    /**
     * Inserir o sobrenome do medico.
     *
     * @param family
     */
    public void setFamily(String family) {
        this.family = family;
    }

    /**
     * Inserir o numero da CRM do medico.
     *
     * @param crm
     */
    public void setCrm(String crm) {
        this.crm = crm;
    }

    /**
     * Retorna o numero da CRM do medico.
     *
     * @return
     */
    public String getCrm() {
        return crm;
    }

    @Override
    public String toString() {
        return "addr=" + addr + "\nphone=" + phone + "\nname=" + name + "\nfamily=" + family + "\ncrm=" + crm;
    }

}
