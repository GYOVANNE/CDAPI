package controller;

import br.com.multcare.bean.*;
import java.io.File;

/**
 * Classe responsável por ler o conteúdo do arquivo XML.
 * @author Gyovanne
 */
public class JReadAll {

    private final JReadContent t;

    private final JReadContentList comp;

    public JReadAll(
            File file,Header header,Patient patient,Author author,Authenticator authentic,Related related,
            ResponsibleParty responsible,HealthHistoric historic,DoctorHistoric dhistoric,
            Medicines medicines,Allergy allergy,FamilyHistoric fhistoric,Exams exams,LaboratoryExams laboratory,
            Diagnostic diagnostic,
            Tratament tratament) throws Exception{

    this.comp = new JReadContentList();
    this.t = new JReadContent();
    
    try{

    header.setRealmCode(t.TAG(file, "ClinicalDocument", "recordTarget","realmCode", 3));
    header.setIdRoot(t.TAG(file, "ClinicalDocument", "recordTarget","id root=", 2));
    header.setExtension2(t.TAG(file, "ClinicalDocument", "recordTarget","id root", 4));
    header.setCode(t.TAG(file, "ClinicalDocument", "recordTarget","code code=", 2));
    header.setEfetiveTime(t.TAG(file, "ClinicalDocument", "recordTarget","effectiveTime ", 3));
    header.setId(t.TAG(file, "ClinicalDocument", "recordTarget","setId extension=", 2));
    header.setVersion(Integer.parseInt(t.TAG(file, "ClinicalDocument", "recordTarget","versionNumber ", 3)));

    patient.setId(Integer.parseInt(t.TAG(file,"patientRole",null,"id extension",2)));
    patient.setAddr(t.TAG(file,"patientRole",null, "addr",1));
    patient.setPhone(t.TAG(file,"patientRole",null, "telecom value",3));
    patient.setName(t.TAG(file,"patient",null, "given",1));
    patient.setFamily(t.TAG(file,"patient",null, "family",1));
    patient.setAdmin(t.TAG(file,"patient",null, "administrativeGenderCode code",2));
    patient.setBirth(t.TAG(file,"patient",null, "birthTime",3));
    patient.setMaritalStatus(t.TAG(file,"patient",null, "maritalStatusCode",3));
    patient.setReligious(t.TAG(file,"patient",null, "religiousAffiliationCode",3));
    patient.setRace(t.TAG(file,"patient",null, "raceCode",3));
    patient.setEthnicGroup(t.TAG(file,"patient",null, "ethnicGroupCode",3));
    patient.setBirthPlace(t.TAG(file,"birthplace",null,"name",1));
    patient.setAddrBirthPlace(t.TAG(file,"birthplace",null,"addr",1));
    patient.setIdExtension(t.TAG(file,"providerOrganization",null, "id extension",2));

    author.setCrm(t.TAG(file, "author",null,"id root", 4));
    author.setAddr(t.TAG(file, "author",null,"addr", 1));
    author.setPhone(t.TAG(file, "author",null,"telecom", 3));
    author.setName(t.TAG(file, "author",null,"given", 1));
    author.setFamily(t.TAG(file, "author",null,"family", 1));

    authentic.setCode(t.TAG(file, "legalAuthenticator", null,"signatureCode", 3));
    related.setCode(t.TAG(file, "/legalAuthenticator", "relatedDocument","relatedDocument", 0));
    related.setID(t.TAG(file, "relatedDocument", null,"id", 2));
    related.setExtension(t.TAG(file, "relatedDocument", null,"setId", 2));
    related.setVersion(t.TAG(file, "relatedDocument", null,"versionNumber", 3));

    tratament.setContent(comp.TAG(file, "Tratamento","content"));
    diagnostic.setContent(comp.TAG(file, "Diagnóstico","content"));
    laboratory.setContent(comp.TAG(file, "Exames de laboratório","content"));
    exams.setContent(comp.TAG(file, "Exame/Métrica físico","content"));
    fhistoric.setContent(comp.TAG(file, "Histórico familiar","content"));
    allergy.setContent(comp.TAG(file, "Alergias","content"));
    medicines.setContent(comp.TAG(file, "Medicamentos","content"));
    dhistoric.setContent(comp.TAG(file, "Histórico médico passado","content"));
    historic.setText((comp.TAG(file,"Histórico da doença atual","text")).get(0));
    
    }catch(Exception ex){
         System.err.println(ex);
    }
    }
}
