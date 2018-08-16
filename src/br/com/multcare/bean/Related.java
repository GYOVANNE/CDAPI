package br.com.multcare.bean;

/**
 *
 * @author android
 */
public class Related {
	private String code;
	private String id;
	private String extension;
	private String version;
	
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
		this.extension= extension;
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
    public void setVersion(String version) {
		this.version= version;
	}

    /**
     *
     * @return
     */
    public String getVersion() {
		return version;
	}
}
