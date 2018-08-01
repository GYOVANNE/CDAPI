package controller;

import br.com.multcare.bean.*;
import java.io.File;

/**
 *
 * @author Gyovanne
 */
public class jObjects {
    protected File xml;
    protected Header header;
    protected Patient patient;
    protected Author author;
    protected Authenticator authenticator;
    protected Related related;
    protected ResponsibleParty responsibleParty;
    protected HealthHistoric healthHistoric;
    protected DoctorHistoric doctorHistoric;
    protected Medicines medicines;
    protected Allergy allergy;
    protected FamilyHistoric familyHistoric;
    protected Exams exams;
    protected LaboratoryExams laboratoryExams;
    protected Diagnostic diagnostic;
    protected Tratament tratament;
    
    public jObjects(File xml,Header header, Patient patient, Author author, Authenticator authenticator, Related related, ResponsibleParty responsible, HealthHistoric historic, DoctorHistoric doctorHistoric, Medicines medicines, Allergy allergy, FamilyHistoric fhistoric, Exams exams, LaboratoryExams laboratory, Diagnostic diagnostic, Tratament tratament) {
        this.xml = xml;
        this.allergy = allergy;
        this.authenticator = authenticator;
        this.author = author;
        this.doctorHistoric = doctorHistoric;
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

    public jObjects() {
        this.allergy = new Allergy();
        this.authenticator = new Authenticator();
        this.author = new Author();
        this.doctorHistoric = new DoctorHistoric();
        this.diagnostic = new Diagnostic();
        this.exams = new Exams();
        this.familyHistoric = new FamilyHistoric();
        this.header = new Header();
        this.healthHistoric = new HealthHistoric();
        this.laboratoryExams = new LaboratoryExams();
        this.medicines = new Medicines();
        this.patient = new Patient();
        this.related = new Related();
        this.responsibleParty = new ResponsibleParty();
        this.tratament = new Tratament();
    }   
}
