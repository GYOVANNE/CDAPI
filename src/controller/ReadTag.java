package controller;

import br.com.multcare.ClinicalDocument;
import br.com.multcare.bean.*;
import java.io.File;

/**
 * Classe responsável por ler o conteúdo do arquivo XML.
 * @author Gyovanne
 */
public class ReadTag{

    private final ClinicalDocument clinicalDocument;
    private final File file;
    private final SimpleTag simpleTag;
    private final ListTag listTag;

    /**
     *
     * @return
     */
    public ClinicalDocument getClinicalDocument() {
        return clinicalDocument;
    }

    /**
     *
     * @return
     */
    public File getFile() {
        return file;
    }

    /**
     *
     * @param clinicalDocument
     * @param file
     */
    public ReadTag(ClinicalDocument clinicalDocument, File file) {
        this.clinicalDocument = clinicalDocument;
        this.file = file;
        this.simpleTag = new SimpleTag();
        this.listTag = new ListTag();
    }

    /**
     *
     * @throws Exception
     */
    public void read() throws Exception{

        try{
        Header header = new Header();

        header.setRealmCode(simpleTag.TAG(getFile(), "ClinicalDocument", "recordTarget","realmCode", 3));
        header.setRealmCode(simpleTag.TAG(getFile(), "ClinicalDocument", "recordTarget","realmCode", 3));
        header.setIdRoot(simpleTag.TAG(getFile(), "ClinicalDocument", "recordTarget","id root=", 2));
        header.setExtension2(simpleTag.TAG(getFile(), "ClinicalDocument", "recordTarget","id root", 4));
        header.setCode(simpleTag.TAG(getFile(), "ClinicalDocument", "recordTarget","code code=", 2));
        header.setEfetiveTime(simpleTag.TAG(getFile(), "ClinicalDocument", "recordTarget","effectiveTime ", 3));
        header.setId(simpleTag.TAG(getFile(), "ClinicalDocument", "recordTarget","setId extension=", 2));
        header.setVersion(Integer.parseInt(simpleTag.TAG(getFile(), "ClinicalDocument", "recordTarget","versionNumber ", 3)));

        getClinicalDocument().setHeader(header);

        Patient patient = new Patient();

        patient.setId(Integer.parseInt(simpleTag.TAG(getFile(),"patientRole",null,"id extension",2)));
        patient.setAddr(simpleTag.TAG(getFile(),"patientRole",null, "addr",1));
        patient.setPhone(simpleTag.TAG(getFile(),"patientRole",null, "telecom value",3));
        patient.setName(simpleTag.TAG(getFile(),"patient",null, "given",1));
        patient.setFamily(simpleTag.TAG(getFile(),"patient",null, "family",1));
        patient.setAdmin(simpleTag.TAG(getFile(),"patient",null, "administrativeGenderCode code",2));
        patient.setBirth(simpleTag.TAG(getFile(),"patient",null, "birthTime",3));
        patient.setMaritalStatus(simpleTag.TAG(getFile(),"patient",null, "maritalStatusCode",3));
        patient.setReligious(simpleTag.TAG(getFile(),"patient",null, "religiousAffiliationCode",3));
        patient.setRace(simpleTag.TAG(getFile(),"patient",null, "raceCode",3));
        patient.setEthnicGroup(simpleTag.TAG(getFile(),"patient",null, "ethnicGroupCode",3));
        patient.setBirthPlace(simpleTag.TAG(getFile(),"birthplace",null,"name",1));
        patient.setAddrBirthPlace(simpleTag.TAG(getFile(),"birthplace",null,"addr",1));
        patient.setIdExtension(simpleTag.TAG(getFile(),"providerOrganization",null, "id extension",2));

        getClinicalDocument().setPatient(patient);

        Author author = new Author();

        author.setCrm(simpleTag.TAG(getFile(), "author",null,"id root", 4));
        author.setAddr(simpleTag.TAG(getFile(), "author",null,"addr", 1));
        author.setPhone(simpleTag.TAG(getFile(), "author",null,"telecom", 3));
        author.setName(simpleTag.TAG(getFile(), "author",null,"given", 1));
        author.setFamily(simpleTag.TAG(getFile(), "author",null,"family", 1));

        getClinicalDocument().setAuthor(author);

        Authenticator authenticator = new Authenticator();

        authenticator.setCode(simpleTag.TAG(getFile(), "legalAuthenticator", null,"signatureCode", 3));

        getClinicalDocument().setAuthenticator(authenticator);

        Related related = new Related();

        related.setCode(simpleTag.TAG(getFile(), "/legalAuthenticator", "relatedDocument","relatedDocument", 0));
        related.setID(simpleTag.TAG(getFile(), "relatedDocument", null,"id", 2));
        related.setExtension(simpleTag.TAG(getFile(), "relatedDocument", null,"setId", 2));
        related.setVersion(simpleTag.TAG(getFile(), "relatedDocument", null,"versionNumber", 3));

        getClinicalDocument().setRelated(related);

        Tratament tratament = new Tratament();

        tratament.setContent(listTag.TAG(getFile(), "Tratamento","content"));

        getClinicalDocument().setTratament(tratament);

        Diagnostic diagnostic = new Diagnostic();

        diagnostic.setContent(listTag.TAG(getFile(), "Diagnóstico","content"));

        getClinicalDocument().setDiagnostic(diagnostic);

        LaboratoryExams laboratoryExams = new LaboratoryExams();

        laboratoryExams.setContent(listTag.TAG(getFile(), "Exames de laboratório","content"));

        getClinicalDocument().setLaboratoryExams(laboratoryExams);

        Exams exams = new Exams();

        exams.setContent(listTag.TAG(getFile(), "Exame/Métrica físico","content"));

        getClinicalDocument().setExams(exams);

        FamilyHistoric familyHistoric = new FamilyHistoric();

        familyHistoric.setContent(listTag.TAG(getFile(), "Histórico familiar","content"));

        getClinicalDocument().setFamilyHistoric(familyHistoric);

        Allergy allergy = new Allergy();

        allergy.setContent(listTag.TAG(getFile(), "Alergias","content"));

        getClinicalDocument().setAllergy(allergy);

        Medicines medicines = new Medicines();

        medicines.setContent(listTag.TAG(getFile(), "Medicamentos","content"));

        getClinicalDocument().setMedicines(medicines);

        DoctorHistoric doctorHistoric = new DoctorHistoric();

        doctorHistoric.setContent(listTag.TAG(getFile(), "Histórico médico passado","content"));

        getClinicalDocument().setDoctorHistoric(doctorHistoric);

        HealthHistoric healthHistoric = new HealthHistoric();

        healthHistoric.setText((listTag.TAG(getFile(),"Histórico da doença atual","text")).get(0));

        getClinicalDocument().setHealthHistoric(healthHistoric);

        }catch(Exception ex){
             System.err.println(ex);
        }
    }
}
