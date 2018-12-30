package br.com.CDApi.bean;

/**
 *
 * @author Gyovanne Cavalcanti
 */
public class Patient {
    private long   id;
    private String addr;
    private String phone;
    private String name;
    private String family;
    private String admin;
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
        this.admin = "nullFlavor";
        this.codeSystem = "nullFlavor";
        this.birth = "nullFlavor";
        this.maritalStatus = "nullFlavor";
        this.religious = "nullFlavor";
        this.race = "nullFlavor";
        this.ethnicGroup = "nullFlavor";
        this.birthPlace = "nullFlavor";
        this.addrBirthPlace = "nullFlavor";
        this.idExtension = "nullFlavor";
    }

    /**
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getAddr() {
        return addr;
    }

    /**
     *
     * @param addr
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getFamily() {
        return family;
    }

    /**
     *
     * @param family
     */
    public void setFamily(String family) {
        this.family = family;
    }

    /**
     *
     * @return
     */
    public String getAdmin() {
        return admin;
    }

    /**
     *
     * @param admin
     */
    public void setAdmin(String admin) {
        this.admin = admin;
    }

    /**
     *
     * @return
     */
    public String getCodeSystem() {
        return codeSystem;
    }

    /**
     *
     * @param codeSystem
     */
    public void setCodeSystem(String codeSystem) {
        this.codeSystem = codeSystem;
    }

    /**
     *
     * @return
     */
    public String getBirth() {
        return birth;
    }

    /**
     *
     * @param birth
     */
    public void setBirth(String birth) {
        this.birth = birth;
    }

    /**
     *
     * @return
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     *
     * @param maritalStatus
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     *
     * @return
     */
    public String getReligious() {
        return religious;
    }

    /**
     *
     * @param religious
     */
    public void setReligious(String religious) {
        this.religious = religious;
    }

    /**
     *
     * @return
     */
    public String getRace() {
        return race;
    }

    /**
     *
     * @param race
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     *
     * @return
     */
    public String getEthnicGroup() {
        return ethnicGroup;
    }

    /**
     *
     * @param ethnicGroup
     */
    public void setEthnicGroup(String ethnicGroup) {
        this.ethnicGroup = ethnicGroup;
    }

    /**
     *
     * @return
     */
    public String getBirthPlace() {
        return birthPlace;
    }

    /**
     *
     * @param birthPlace
     */
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    /**
     *
     * @return
     */
    public String getAddrBirthPlace() {
        return addrBirthPlace;
    }

    /**
     *
     * @param addrBirthPlace
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
    
}
