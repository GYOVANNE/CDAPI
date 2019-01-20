package br.com.CDApi.bean;

/**
 * Classe responsavel por gerenciar as informaçoes referentes ao paciente.
 *
 * @author Gyovanne Cavalcanti
 */
public class Patient {

    private long id;
    private String addr;
    private String phone;
    private String name;
    private String family;
    private String gender;
    private String codeSystem;
    private String birth;
    private String maritalStatus;
    private String religious;
    private String race;
    private String ethnicGroup;
    private String birthPlace;
    private String addrBirthPlace;
    private String idExtension;

    /**
     *
     */
    public Patient() {
        this.id = 0;
        this.addr = "nullFlavor";
        this.phone = "nullFlavor";
        this.name = "nullFlavor";
        this.family = "nullFlavor";
        this.gender = "nullFlavor";
        this.codeSystem = "2.16.840.1.113883.5.1";
        this.birth = "0";
        this.maritalStatus = "nullFlavor";
        this.religious = "nullFlavor";
        this.race = "nullFlavor";
        this.ethnicGroup = "nullFlavor";
        this.birthPlace = "nullFlavor";
        this.addrBirthPlace = "nullFlavor";
        this.idExtension = "M555";
    }

    /**
     * Retorna o identificador do paciente.
     *
     * @return Id do paciente.
     */
    public long getId() {
        return id;
    }

    /**
     * Inserir o identificador do paciente.
     *
     * @param id Id do paciente.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o endereço do paciente.
     *
     * @return Endereço do paciente
     */
    public String getAddr() {
        return addr;
    }

    /**
     * Inserir o endereço do paciente.
     *
     * @param addr Endereço do paciente.
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * Retorna o telefone de contato do paciente.
     *
     * @return Telefone do paciente.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Inserir o telefone de contato do paciente.
     *
     * @param phone Telefone do paciente.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Retorna o primeiro nome do paciente.
     *
     * @return Primeiro nome do paciente.
     */
    public String getName() {
        return name;
    }

    /**
     * Inserir o primeiro nome do paciente.
     *
     * @param name Nome do paciente.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o sobrenome do paciente.
     *
     * @return Sobrenome do paciente.
     */
    public String getFamily() {
        return family;
    }

    /**
     * Inserir o sobrenome do paciente.
     *
     * @param family Sobrenome do paciente.
     */
    public void setFamily(String family) {
        this.family = family;
    }

    /**
     * Retorna caracter correspondente ao genero do paciente.
     *
     * @return Genero do paciente.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Inserir caracter correspondente ao genero do paciente. Ex: M ou F.
     *
     * @param gender Genero do paciente.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return Inscrição OID correspondente ao gênero do paciente.
     */
    public String getCodeSystem() {
        return codeSystem;
    }

    /**
     * Inserir a inscrição OID correspondente ao gênero do paciente:
     * <p>
     * Exemplo de inserção: 2.16.840.1.113883.5.1
     * <p>
     * @see http://oid-info.com/
     * @param codeSystem
     */
    public void setCodeSystem(String codeSystem) {
        this.codeSystem = codeSystem;
    }

    /**
     * Retorna a data de aniversario do paciente.
     *
     * @return Data de aniversario.
     */
    public String getBirth() {
        return birth;
    }

    /**
     * Inserir uma data de aniversario do paciente. Exemplo de entrada:
     * setBirth("19901212");
     *
     * @param birth Data de aniversario.
     */
    public void setBirth(String birth) {
        this.birth = birth;
    }

    /**
     * Retorna o estado civil do paciente.
     *
     * @return Estado civil.
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Inserir estado civil do paciente.
     *
     * @param maritalStatus Estado civil.
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * Retorna a religiao do paciente.
     *
     * @return Regiliao do paciente.
     */
    public String getReligious() {
        return religious;
    }

    /**
     * Inserir a religiao do paciente.
     *
     * @param religious Religiao do paciente.
     */
    public void setReligious(String religious) {
        this.religious = religious;
    }

    /**
     * Retorna a afiliaçao racial do paciente. (Informações sobre raça e etnia
     * podem ser usado para ajudar a avaliar o risco de um paciente em relação a
     * condições particulares. Em alguns locais (por exemplo, os EUA), essas
     * informações também podem ser usadas operacionalmente para detectar
     * disparidades étnicas na forma como os pacientes são tratados. Em outros,
     * transmissão desta informação em um registro médico é proibido.)
     *
     * @return Afiliaçao racial do paciente.
     */
    public String getRace() {
        return race;
    }

    /**
     * Inserir a afiliaçao racial do paciente. (Informações sobre raça e etnia
     * podem ser usado para ajudar a avaliar o risco de um paciente em relação a
     * condições particulares. Em alguns locais (por exemplo, os EUA), essas
     * informações também podem ser usadas operacionalmente para detectar
     * disparidades étnicas na forma como os pacientes são tratados. Em outros,
     * transmissão desta informação em um registro médico é proibido.)
     *
     * @param race Afiliaçao racial do paciente.
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * Retorna o grupo etnico do paciente. (Informações sobre raça e etnia podem
     * ser usado para ajudar a avaliar o risco de um paciente em relação a
     * condições particulares. Em alguns locais (por exemplo, os EUA), essas
     * informações também podem ser usadas operacionalmente para detectar
     * disparidades étnicas na forma como os pacientes são tratados. Em outros,
     * transmissão desta informação em um registro médico é proibido.)
     *
     * @return Grupo etnico do paciente.
     */
    public String getEthnicGroup() {
        return ethnicGroup;
    }

    /**
     * Inserir o grupo etnico do paciente. (Informações sobre raça e etnia podem
     * ser usado para ajudar a avaliar o risco de um paciente em relação a
     * condições particulares. Em alguns locais (por exemplo, os EUA), essas
     * informações também podem ser usadas operacionalmente para detectar
     * disparidades étnicas na forma como os pacientes são tratados. Em outros,
     * transmissão desta informação em um registro médico é proibido.)
     *
     * @param ethnicGroup Grupo etnico do paciente.
     */
    public void setEthnicGroup(String ethnicGroup) {
        this.ethnicGroup = ethnicGroup;
    }

    /**
     * Retorna o local de nascimento do paciente. (O local de nascimento do
     * paciente é registrado como uma associação de papéis entre a classe de
     * naturalidade. A classe de associação do local de nascimento liga a classe
     * do paciente a classe de lugar.)
     *
     * @return Local de nascimento do paciente.
     */
    public String getBirthPlace() {
        return birthPlace;
    }

    /**
     * /* Inserir o local de nascimento do paciente. (O local de nascimento do
     * paciente é registrado como uma associação de papéis entre a classe de
     * naturalidade. A classe de associação do local de nascimento liga a classe
     * do paciente a classe de lugar.)
     *
     * @param birthPlace Local de nascimento do paciente.
     */
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    /**
     * Retorna o endereço do local de nascimento do paciente.
     *
     * @return Endereço do local de nascimento.
     */
    public String getAddrBirthPlace() {
        return addrBirthPlace;
    }

    /**
     * Inserir o endereço do local de nascimento do paciente.
     *
     * @param addrBirthPlace Endereço local de nascimento.
     */
    public void setAddrBirthPlace(String addrBirthPlace) {
        this.addrBirthPlace = addrBirthPlace;
    }

    /**
     *
     * @return
     */
    public String getIdExtension() {
        return idExtension;
    }

    /**
     *
     * @param idExtension
     */
    public void setIdExtension(String idExtension) {
        this.idExtension = idExtension;
    }

    @Override
    public String toString() {
        return "id=" + id + "\naddr=" + addr + "\nphone=" + phone + "\nname=" + name + "\nfamily=" + family + "\ngender=" + gender + "\ncodeSystem=" + codeSystem + "\nbirth=" + birth + "\nmaritalStatus=" + maritalStatus + "\nreligious=" + religious + "\nrace=" + race + "\nethnicGroup=" + ethnicGroup + "\nbirthPlace=" + birthPlace + "\naddrBirthPlace=" + addrBirthPlace + "\nidExtension=" + idExtension;
    }

}
