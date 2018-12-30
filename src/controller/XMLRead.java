package controller;

import br.com.CDApi.bean.*;
import br.com.CDApi.ClinicalDocument;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Classe responsável por ler o conteúdo do arquivo XML.
 * @author Gyovanne Cavalcanti
 */
public class XMLRead{

    private final ClinicalDocument clinicalDocument;
    private final File file;

    private ClinicalDocument getClinicalDocument() {
        return clinicalDocument;
    }

    private File getFile() {
        return file;
    }

    public XMLRead(ClinicalDocument clinicalDocument, File file) {
        this.clinicalDocument = clinicalDocument;
        this.file = file;
    }

    public void read(){

        try{
        Header header = new Header();

        header.setRealmCode(simpleTag("ClinicalDocument", "recordTarget","realmCode", 3));
        header.setIdRoot(simpleTag("ClinicalDocument", "recordTarget","id root=", 2));
        header.setExtension(simpleTag("ClinicalDocument", "recordTarget","id root", 4));
        header.setCode(simpleTag("ClinicalDocument", "recordTarget","code code=", 2));
        header.setDisplayName(simpleTag("ClinicalDocument", "recordTarget", "displayName", 5));
        header.setCodeSystem(simpleTag("ClinicalDocument", "recordTarget", "codeSystem", 6));
        header.setCodeSystemName(simpleTag("ClinicalDocument", "recordTarget", "codeSystemName", 7));
        header.setEfetiveTime(simpleTag("ClinicalDocument", "recordTarget","effectiveTime ", 3));
        header.setId(simpleTag("ClinicalDocument", "recordTarget","setId extension=", 2));
        header.setVersion(Integer.parseInt(simpleTag("ClinicalDocument", "recordTarget","versionNumber ", 3)));

        getClinicalDocument().setHeader(header);

        Patient patient = new Patient();

        patient.setId(Integer.parseInt(simpleTag("patientRole",null,"id extension",2)));
        patient.setAddr(simpleTag("patientRole",null, "addr",1));
        patient.setPhone(simpleTag("patientRole",null, "telecom value",3));
        patient.setName(simpleTag("patient",null, "given",1));
        patient.setFamily(simpleTag("patient",null, "family",1));
        patient.setAdmin(simpleTag("patient",null, "administrativeGenderCode code",2));
        patient.setBirth(simpleTag("patient",null, "birthTime",3));
        patient.setMaritalStatus(simpleTag("patient",null, "maritalStatusCode",3));
        patient.setReligious(simpleTag("patient",null, "religiousAffiliationCode",3));
        patient.setRace(simpleTag("patient",null, "raceCode",3));
        patient.setEthnicGroup(simpleTag("patient",null, "ethnicGroupCode",3));
        patient.setBirthPlace(simpleTag("birthplace",null,"name",1));
        patient.setAddrBirthPlace(simpleTag("birthplace",null,"addr",1));
        patient.setIdExtension(simpleTag("providerOrganization",null, "id extension",2));

        getClinicalDocument().setPatient(patient);

        Author author = new Author();

        author.setCrm(simpleTag("author",null,"id root", 4));
        author.setAddr(simpleTag("author",null,"addr", 1));
        author.setPhone(simpleTag("author",null,"telecom", 3));
        author.setName(simpleTag("author",null,"given", 1));
        author.setFamily(simpleTag("author",null,"family", 1));

        getClinicalDocument().setAuthor(author);

        ResponsibleParty responsibleParty = new ResponsibleParty();
        
        responsibleParty.setIdRoot(simpleTag("encompassingEncounter", "responsibleParty", "id root", 2));
        responsibleParty.setExtension(simpleTag("encompassingEncounter","responsibleParty", "extension", 4));
        responsibleParty.setDate(simpleTag("encompassingEncounter","responsibleParty","value", 3));
        responsibleParty.setId(simpleTag("assignedEntity",null,"id nullFlavor", 3));
        responsibleParty.setState(simpleTag("responsibleParty", null,"state",1));
        responsibleParty.setCity(simpleTag("responsibleParty", null, "city", 1));
        responsibleParty.setPostal(simpleTag("responsibleParty", null, "postalCode", 1));
        responsibleParty.setStreet(simpleTag("responsibleParty", null,"streetAddressLine", 1));
        responsibleParty.setPhone(simpleTag("responsibleParty", null, "telecom value", 2));
        responsibleParty.setUse(simpleTag("responsibleParty", null, "use", 8));
        responsibleParty.setFamily(simpleTag("responsibleParty", null, "family", 1));
        responsibleParty.setName(simpleTag("responsibleParty", null, "given", 1));
        responsibleParty.setSuffixe(simpleTag("responsibleParty", null, "suffix", 1));
        responsibleParty.setLocation(simpleTag("location", null, "name", 1));

        getClinicalDocument().setResponsibleParty(responsibleParty);

        Authenticator authenticator = new Authenticator();

        authenticator.setCode(simpleTag("legalAuthenticator", null,"signatureCode", 3));

        getClinicalDocument().setAuthenticator(authenticator);

        Related related = new Related();

        related.setCode(simpleTag("/legalAuthenticator", "relatedDocument","relatedDocument", 0));
        related.setID(simpleTag("relatedDocument", null,"id", 2));
        related.setExtension(simpleTag("relatedDocument", null,"setId", 2));
        related.setVersion(simpleTag("relatedDocument", null,"versionNumber", 3));

        getClinicalDocument().setRelated(related);

        Tratament tratament = new Tratament();

        tratament.setContent(listTag("Tratamento","content"));

        getClinicalDocument().setTratament(tratament);

        Diagnostic diagnostic = new Diagnostic();

        diagnostic.setContent(listTag("Diagnóstico","content"));

        getClinicalDocument().setDiagnostic(diagnostic);

        LaboratoryExams laboratoryExams = new LaboratoryExams();

        laboratoryExams.setContent(listTag("Exames de laboratório","content"));

        getClinicalDocument().setLaboratoryExams(laboratoryExams);

        Exams exams = new Exams();

        exams.setContent(listTag("Exame/Métrica físico","content"));

        getClinicalDocument().setExams(exams);

        FamilyHistoric familyHistoric = new FamilyHistoric();

        familyHistoric.setContent(listTag("Histórico familiar","content"));

        getClinicalDocument().setFamilyHistoric(familyHistoric);

        Allergy allergy = new Allergy();

        allergy.setContent(listTag("Alergias","content"));

        getClinicalDocument().setAllergy(allergy);

        Medicines medicines = new Medicines();

        medicines.setContent(listTag("Medicamentos","content"));

        getClinicalDocument().setMedicines(medicines);

        DoctorHistoric doctorHistoric = new DoctorHistoric();

        doctorHistoric.setContent(listTag("Histórico médico passado","content"));

        getClinicalDocument().setDoctorHistoric(doctorHistoric);

        HealthHistoric healthHistoric = new HealthHistoric();

        healthHistoric.setText((listTag("Histórico da doença atual","text")).get(0));

        getClinicalDocument().setHealthHistoric(healthHistoric);

        }catch(IOException | NumberFormatException ex){
            System.err.println(ex.getLocalizedMessage());
        }
    }

    private String simpleTag (String tagBegin,String tagFinish,String info,int op){
        String linha;
        StringTokenizer st;
        try(FileReader fr = new FileReader(getFile());BufferedReader br = new BufferedReader(new FileReader(getFile()));){

        while((linha = br.readLine()) != null){
            if(linha.contains("<"+tagBegin+""))
            {
                while((linha = br.readLine()) != null){
                String dados;
                st = new StringTokenizer(linha,"\n");
                while(st.hasMoreTokens()){
                    dados = st.nextToken();
                    if(dados.contains(info)){
                        switch(op) {
                        case 0:
                            fr.close();
                            br.close();
                            return (dados.substring(dados.indexOf("=")+2,dados.indexOf(">", dados.indexOf("="))-1));
                        case 1:
                            fr.close();
                            br.close();
                            return (dados.substring(dados.indexOf(">")+1,dados.indexOf("</", dados.indexOf(">"))));
                        case 2:
                            fr.close();
                            br.close();
                            return (dados.substring(dados.indexOf("=")+2,dados.indexOf(" ", dados.indexOf("="))-1));
                        case 3:
                            fr.close();
                            br.close();
                            return (dados.substring(dados.indexOf("=")+2,dados.indexOf("/>", dados.indexOf("="))-1));
                        case 4:
                            fr.close();
                            br.close();
                            return (dados.substring(dados.indexOf("n=")+3,dados.indexOf("/>", dados.indexOf("n="))-1));
                        case 5:
                            fr.close();
                            br.close();
                            return (dados.substring(dados.indexOf("me=")+4,dados.indexOf(" code", dados.indexOf("me="))-1));
                        case 6:
                            fr.close();
                            br.close();
                            return (dados.substring(dados.indexOf("em=")+4,dados.indexOf(" ", dados.indexOf("em="))-1));
                        case 7:
                            fr.close();
                            br.close();
                            return (dados.substring(dados.indexOf("SystemName=")+12,dados.indexOf("/>", dados.indexOf("SystemName="))-1));
                        case 8:
                            fr.close();
                            br.close();
                            return (dados.substring(dados.indexOf("se=")+4,dados.indexOf("/>", dados.indexOf("se="))-1));
                        }
                    }else break;
                }
                    if(tagFinish != null && linha.contains("<"+tagFinish+">")) break;
                }
            }if(linha.contains("</"+tagFinish+">")) break;
        }
        fr.close();
        br.close();
        }catch(IOException ex){
            System.err.println(ex.getLocalizedMessage());
        }
        return null;
    }

    private ArrayList <String> listTag (String title,String content) throws IOException{
        ArrayList <String> list = new ArrayList <>();
        String line;
            StringTokenizer st;
            try(FileReader fr = new FileReader(getFile());BufferedReader br = new BufferedReader(new FileReader(getFile()));){
                while((line = br.readLine()) != null){
                    if(line.contains(title))
                    {
                    while((line = br.readLine()) != null){
                        String dados;
                        st = new StringTokenizer(line,"\n");
                        while(st.hasMoreTokens()){
                            dados = st.nextToken();
                            if(dados.contains("<"+content+">")){
                                list.add(dados.substring(dados.indexOf(">")+1,
                                dados.indexOf("</", dados.indexOf(">"))));
                            }else break;
                        }
                        if(line.contains("</component>")) break;
                    }
                    fr.close();
                    br.close();
                    return list;
                    }
                }
                fr.close();
                br.close();
                return null;
            }catch(IOException ex){
                System.err.println(ex.getLocalizedMessage());
            }
        return null;
    }
}
