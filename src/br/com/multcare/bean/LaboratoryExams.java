package br.com.multcare.bean;

/**
 *
 * @author Gyovanne
 */
public class LaboratoryExams extends Allergy {
    private String id;
    private String code;

    public LaboratoryExams() {
        this.id = null;
        this.code = null;
        this.content = null;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id= id;
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
     * @param code
     */
    public void setCode(String code) {
        this.code= code;
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }
}