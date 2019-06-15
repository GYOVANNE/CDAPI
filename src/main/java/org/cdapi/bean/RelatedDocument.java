package org.cdapi.bean;

/**
 *
 * @author Gyovanne Cavalcanti
 */
public class RelatedDocument {

    private String code;
    private String id;
    private String extension;
    private double version;

    /**
     *
     */
    public RelatedDocument() {
        this.code = "nullFlavor";
        this.id = "nullFlavor";
        this.extension = "nullFlavor";
        this.version = 0.0;
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

    /**
     *
     * @param id
     */
    public void setID(String id) {
        this.id = id;
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
     * @param extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     *
     * @return
     */
    public String getExtension() {
        return extension;
    }

    /**
     *
     * @param version
     */
    public void setVersion(double version) {
        this.version = version;
    }

    /**
     *
     * @return
     */
    public double getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "code=" + code + "\nid=" + id + "\nextension=" + extension + "\nversion=" + version;
    }

}
