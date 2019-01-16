package br.com.CDApi.bean;

/**
 *
 * @author Gyovanne Cavalcanti
 */
public class ResponsibleParty {
	
	private String idRoot;
	private String extension ;
	private String date;
	private String id;
	private String state;
	private String city;
	private String postal;
	private String street;
	private String phone;
	private String use;
	private String family;
	private String name;
	private String suffixe;
	private String location;

    /**
     *
     */
    public ResponsibleParty() {
        this.idRoot = "nullFlavor";
        this.extension = "nullFlavor";
        this.date = "0";
        this.id = "nullFlavor";
        this.state = "nullFlavor";
        this.city = "nullFlavor";
        this.postal = "0";
        this.street = "nullFlavor";
        this.phone = "nullFlavor";
        this.use = "nullFlavor";
        this.family = "nullFlavor";
        this.name = "nullFlavor";
        this.suffixe = "nullFlavor";
        this.location = "nullFlavor";
    }

    /**
     *
     * @param id
     */
    public void setIdRoot(String id) {
		this.idRoot = id;
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
     * @param date
     */
    public void setDate(String date) {
		this.date= date;
	}

    /**
     *
     * @return
     */
    public String getDate() {
		return date;
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
    public String getId() {
		return id;
	}

    /**
     *
     * @param state
     */
    public void setState(String state) {
		this.state = state;
	}

    /**
     *
     * @return
     */
    public String getState() {
		return state;
	}

    /**
     *
     * @param city
     */
    public void setCity(String city) {
		this.city= city;
	}

    /**
     *
     * @return
     */
    public String getCity() {
		return city;
	}

    /**
     *
     * @param postal
     */
    public void setPostal(String postal) {
		this.postal= postal;
	}

    /**
     *
     * @return
     */
    public String getPostal() {
		return postal;
	}

    /**
     *
     * @param street
     */
    public void setStreet(String street) {
		this.street = street;
	}

    /**
     *
     * @return
     */
    public String getStreet() {
		return street;
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
    public String getPhone() {
		return phone;
	}

    /**
     *
     * @param use
     */
    public void setUse(String use) {
		this.use = use;
	}

    /**
     *
     * @return
     */
    public String getUse() {
		return use;
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
    public String getFamily() {
		return family;
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
    public String getName() {
		return name;
	}

    /**
     *
     * @param suffixe
     */
    public void setSuffixe(String suffixe) {
		this.suffixe= suffixe;
	}

    /**
     *
     * @return
     */
    public String getSuffixe() {
		return suffixe;
	}

    /**
     *
     * @param location
     */
    public void setLocation(String location) {
		this.location = location;
	}

    /**
     *
     * @return
     */
    public String getLocation() {
		return location;
	}
}
