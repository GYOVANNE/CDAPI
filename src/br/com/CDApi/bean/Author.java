package br.com.CDApi.bean;

/**
 *
 * @author Gyovanne
 */
public class Author extends Patient{
    private String crm;

    /**
     *
     */
    public Author() {
        this.crm = "nullFlavor";
    }
        
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
