package controller;

import br.com.multcare.bean.*;
import java.io.File;

/**
 *
 * @author Gyovanne
 */
public class Implements {
    protected String local;
    protected Header header = new Header();
    protected Patient patient = new Patient();
    protected Author author = new Author();
    protected Authenticator authentic = new Authenticator();
    protected Related related = new Related();
    protected ResponsibleParty responsibleParty = new ResponsibleParty();
    protected HealthHistoric healthHistoric = new HealthHistoric();
    protected DoctorHistoric doctorHistoric = new DoctorHistoric();
    protected Medicines medicines = new Medicines();
    protected Allergy allergy = new Allergy();
    protected FamilyHistoric familyHistoric = new FamilyHistoric();
    protected Exams exams = new Exams();
    protected LaboratoryExams laboratoryExams = new LaboratoryExams();
    protected Diagnostic diagnostic = new Diagnostic();
    protected Tratament tratament =  new Tratament();
    
    public Implements(String local,Header header, Patient patient, Author author, Authenticator authentic, Related related, ResponsibleParty responsible, HealthHistoric historic, DoctorHistoric dhistoric, Medicines medicines, Allergy allergy, FamilyHistoric fhistoric, Exams exams, LaboratoryExams laboratory, Diagnostic diagnostic, Tratament tratament) {
        this.local = local;
        this.allergy = allergy;
        this.authentic = authentic;
        this.author = author;
        this.doctorHistoric = dhistoric;
        this.diagnostic = diagnostic;
        this.exams = exams;
        this.familyHistoric = fhistoric;
        this.header = header;
        this.healthHistoric = historic;
        this.laboratoryExams = laboratory;
        this.medicines = medicines;
        this.patient = patient;
        this.related = related;
        this.responsibleParty = responsible;
        this.tratament = tratament;
    }

    public Implements() {
    }
}
