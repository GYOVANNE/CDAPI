package controller;

import br.com.multcare.ClinicalDocument;
import br.com.multcare.bean.*;
import java.io.File;

/**
 * Classe responsável por ler o conteúdo do arquivo XML.
 * @author Gyovanne
 */
public class JReadAll{

    private final ClinicalDocument clinicalDocument;
    private File file;
    private final JReadContent t;
    private final JReadContentList comp;

    public ClinicalDocument getClinicalDocument() {
        return clinicalDocument;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public JReadAll(ClinicalDocument clinicalDocument, File file) {
        this.clinicalDocument = clinicalDocument;
        this.file = file;
        this.t = new JReadContent();
        this.comp = new JReadContentList();
    }

    public void read() throws Exception{
        
        try{
        Header header = new Header();

        header.setRealmCode(t.TAG(getFile(), "ClinicalDocument", "recordTarget","realmCode", 3));
        header.setRealmCode(t.TAG(getFile(), "ClinicalDocument", "recordTarget","realmCode", 3));
        header.setIdRoot(t.TAG(getFile(), "ClinicalDocument", "recordTarget","id root=", 2));
        header.setExtension2(t.TAG(getFile(), "ClinicalDocument", "recordTarget","id root", 4));
        header.setCode(t.TAG(getFile(), "ClinicalDocument", "recordTarget","code code=", 2));
        header.setEfetiveTime(t.TAG(getFile(), "ClinicalDocument", "recordTarget","effectiveTime ", 3));
        header.setId(t.TAG(getFile(), "ClinicalDocument", "recordTarget","setId extension=", 2));
        header.setVersion(Integer.parseInt(t.TAG(getFile(), "ClinicalDocument", "recordTarget","versionNumber ", 3)));

        getClinicalDocument().setHeader(header);

        Patient patient = new Patient();

        patient.setId(Integer.parseInt(t.TAG(getFile(),"patientRole",null,"id extension",2)));
        patient.setAddr(t.TAG(getFile(),"patientRole",null, "addr",1));
        patient.setPhone(t.TAG(getFile(),"patientRole",null, "telecom value",3));
        patient.setName(t.TAG(getFile(),"patient",null, "given",1));
        patient.setFamily(t.TAG(getFile(),"patient",null, "family",1));
        patient.setAdmin(t.TAG(getFile(),"patient",null, "administrativeGenderCode code",2));
        patient.setBirth(t.TAG(getFile(),"patient",null, "birthTime",3));
        patient.setMaritalStatus(t.TAG(getFile(),"patient",null, "maritalStatusCode",3));
        patient.setReligious(t.TAG(getFile(),"patient",null, "religiousAffiliationCode",3));
        patient.setRace(t.TAG(getFile(),"patient",null, "raceCode",3));
        patient.setEthnicGroup(t.TAG(getFile(),"patient",null, "ethnicGroupCode",3));
        patient.setBirthPlace(t.TAG(getFile(),"birthplace",null,"name",1));
        patient.setAddrBirthPlace(t.TAG(getFile(),"birthplace",null,"addr",1));
        patient.setIdExtension(t.TAG(getFile(),"providerOrganization",null, "id extension",2));

        getClinicalDocument().setPatient(patient);

        Author author = new Author();

        author.setCrm(t.TAG(getFile(), "author",null,"id root", 4));
        author.setAddr(t.TAG(getFile(), "author",null,"addr", 1));
        author.setPhone(t.TAG(getFile(), "author",null,"telecom", 3));
        author.setName(t.TAG(getFile(), "author",null,"given", 1));
        author.setFamily(t.TAG(getFile(), "author",null,"family", 1));

        getClinicalDocument().setAuthor(author);

        Authenticator authenticator = new Authenticator();

        authenticator.setCode(t.TAG(getFile(), "legalAuthenticator", null,"signatureCode", 3));

        getClinicalDocument().setAuthenticator(authenticator);

        Related related = new Related();

        related.setCode(t.TAG(getFile(), "/legalAuthenticator", "relatedDocument","relatedDocument", 0));
        related.setID(t.TAG(getFile(), "relatedDocument", null,"id", 2));
        related.setExtension(t.TAG(getFile(), "relatedDocument", null,"setId", 2));
        related.setVersion(t.TAG(getFile(), "relatedDocument", null,"versionNumber", 3));

        getClinicalDocument().setRelated(related);

        Tratament tratament = new Tratament();

        tratament.setContent(comp.TAG(getFile(), "Tratamento","content"));

        getClinicalDocument().setTratament(tratament);

        Diagnostic diagnostic = new Diagnostic();

        diagnostic.setContent(comp.TAG(getFile(), "Diagnóstico","content"));

        getClinicalDocument().setDiagnostic(diagnostic);

        LaboratoryExams laboratoryExams = new LaboratoryExams();

        laboratoryExams.setContent(comp.TAG(getFile(), "Exames de laboratório","content"));

        getClinicalDocument().setLaboratoryExams(laboratoryExams);

        Exams exams = new Exams();

        exams.setContent(comp.TAG(getFile(), "Exame/Métrica físico","content"));

        getClinicalDocument().setExams(exams);

        FamilyHistoric familyHistoric = new FamilyHistoric();

        familyHistoric.setContent(comp.TAG(getFile(), "Histórico familiar","content"));

        getClinicalDocument().setFamilyHistoric(familyHistoric);

        Allergy allergy = new Allergy();

        allergy.setContent(comp.TAG(getFile(), "Alergias","content"));

        getClinicalDocument().setAllergy(allergy);

        Medicines medicines = new Medicines();

        medicines.setContent(comp.TAG(getFile(), "Medicamentos","content"));

        getClinicalDocument().setMedicines(medicines);

        DoctorHistoric doctorHistoric = new DoctorHistoric();

        doctorHistoric.setContent(comp.TAG(getFile(), "Histórico médico passado","content"));

        getClinicalDocument().setDoctorHistoric(doctorHistoric);

        HealthHistoric healthHistoric = new HealthHistoric();

        healthHistoric.setText((comp.TAG(getFile(),"Histórico da doença atual","text")).get(0));

        getClinicalDocument().setHealthHistoric(healthHistoric);

        }catch(Exception ex){
             System.err.println(ex);
        }
    }
}
