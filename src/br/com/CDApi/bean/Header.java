package br.com.CDApi.bean;

/**
 *
 * @author Gyovanne
 */
public class Header {
	private String realmCode;
	private String typeId;
	private String extension1;
	private String template;
	private String idRoot;
	private String extension2;
	private String code;
        private String displayName;
        private String codeSystem;
        private String codeSystemName;
	private String efetiveTime;
	private String id;
	private int version;

    /**
     *
     */
    public Header() {
        this.realmCode = "nullFlavor";
        this.typeId = "2.16.840.1.113883.1.3";
        this.extension1 = "POCD_HD000040";
        this.template = "2.16.840.1.113883.10.20.1";
        this.idRoot = "nullFlavor";
        this.extension2 = "nullFlavor";
        this.code = "nullFlavor";
        this.displayName = "nullFlavor";
        this.codeSystem = "2.16.840.1.113883.6.103";
        this.codeSystemName = "ICD-9-CM";
        this.efetiveTime = "nullFlavor";
        this.id = "nullFlavor";
        this.version = 0;
    }

    /**
     *
     * @return
     */
    public String getRealmCode() {
        return realmCode;
    }

    /**
     *
     * @param realmCode
     */
    public void setRealmCode(String realmCode) {
        this.realmCode = realmCode;
    }

    /**
     *
     * @return
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     *
     * @param typeId
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    /**
     *
     * @return
     */
    public String getExtension1() {
        return extension1;
    }

    /**
     *
     * @param extension1
     */
    public void setExtension1(String extension1) {
        this.extension1 = extension1;
    }

    /**
     *
     * @return
     */
    public String getTemplate() {
        return template;
    }

    /**
     *
     * @param template
     */
    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     *
     * @return
     */
    public String getIdRoot() {
        return idRoot;
    }

    /**
     *
     * @param idRoot
     */
    public void setIdRoot(String idRoot) {
        this.idRoot = idRoot;
    }

    /**
     *
     * @return
     */
    public String getExtension2() {
        return extension2;
    }

    /**
     *
     * @param extension2
     */
    public void setExtension2(String extension2) {
        this.extension2 = extension2;
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
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
    public String getDisplayName() {
        return displayName;
    }

    /**
     *
     * @param displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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
    public String getCodeSystemName() {
        return codeSystemName;
    }

    /**
     *
     * @param codeSystemName
     */
    public void setCodeSystemName(String codeSystemName) {
        this.codeSystemName = codeSystemName;
    }

    /**
     *
     * @return
     */
    public String getEfetiveTime() {
        return efetiveTime;
    }

    /**
     *
     * @param efetiveIime
     */
    public void setEfetiveTime(String efetiveIime) {
        this.efetiveTime = efetiveIime;
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
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public int getVersion() {
        return version;
    }

    /**
     *
     * @param version
     */
    public void setVersion(int version) {
        this.version = version;
    }
	
}
