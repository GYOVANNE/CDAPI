package br.com.CDApi.bean;

/**
 *
 * @author Gyovanne
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
}
