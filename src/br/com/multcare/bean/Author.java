package br.com.multcare.bean;

/**
 *
 * @author android
 */
public class Author extends Patient{
	private String crm;
        
    /**
     *
     * @param crm
     */
    public void setCrm(String crm) {
		this.crm = crm;
	}

    /**
     *
     * @return
     */
    public String getCrm() {
		return crm;
	}
}
