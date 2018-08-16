package controller;

import br.com.multcare.ClinicalDocument;
import controller.XMLConstruction.TAG;
import java.io.File;
import java.io.FileWriter;

/**
 * Classe que contém o conteúdo do documento CDA, representado em XML.
 * @author Gyovanne
 */
public class DocumentStructure {

    private final XMLConstruction xmlc;
    private final File file; 
    private final ClinicalDocument clinicalDocument;

    /**
     *
     * @return
     */
    public File getFile() {
        return file;
    }

    /**
     *
     * @return
     */
    public ClinicalDocument getClinicalDocument() {
        return clinicalDocument;
    }

    /**
     *
     * @param file
     * @param clinicalDocument
     */
    public DocumentStructure(File file, ClinicalDocument clinicalDocument) {
        this.file = file;
        this.clinicalDocument = clinicalDocument;
        this.xmlc = new XMLConstruction();
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public boolean generateContent() throws Exception {
        //STRUCTURE HEADER
        //==========================================================================================
        TAG rootTag = xmlc.xml_CREATE("ClinicalDocument xmlns=\"urn:hl7-org:v3\" xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' classCode='DOCCLIN'","");

        TAG h[] = new TAG[10];
        h[0] = xmlc.xml_CREATE("realmCode code='"+getClinicalDocument().getHeader().getRealmCode()+"'","");
        h[1] = xmlc.xml_CREATE("typeId root='2.16.840.1.113883.1.3' extension='POCD_HD000040'","");/*+h.getTypeid()+*/	/*+h.getExtension1()+*/
        h[2] = xmlc.xml_CREATE("templateId root='2.16.840.1.113883.10.20.1'","");/*+h.getTemplate()+*/
        h[3] = xmlc.xml_CREATE("id root='"+getClinicalDocument().getHeader().getIdRoot()+"' extension='"+getClinicalDocument().getHeader().getExtension2()+"'","");
        h[4] = xmlc.xml_CREATE("code code='"+getClinicalDocument().getHeader().getCode()+"' displayName='Diagnostico utilizando Multcare' codeSystem='2.16.840.1.113883.6.103' codeSystemName='ICD-9-CM'","");
        h[5] = xmlc.xml_CREATE("effectiveTime value=\""+getClinicalDocument().getHeader().getEfetiveTime()+"\"","");
        h[6] = xmlc.xml_CREATE("confidentialityCode code=\"N\" displayName='Normal' codeSystem='2.16.840.1.113883.5.25' codeSystemName='Confidentiality'","");
        h[7] = xmlc.xml_CREATE("setId extension=\""+getClinicalDocument().getHeader().getId()+"\" root=\""+getClinicalDocument().getHeader().getExtension2()+"\"","");
        h[8] = xmlc.xml_CREATE("versionNumber value=\""+getClinicalDocument().getHeader().getVersion()+"\"","");
        h[9] =xmlc.xml_CREATE("copyTime value='"+getClinicalDocument().getHeader().getEfetiveTime()+"'","");
        //==========================================================================================
        //STRUCTURE PATIENT
        TAG P19 =xmlc.xml_CREATE("recordTarget","");
        TAG P20 =xmlc.xml_CREATE("patientRole","");
        TAG P0 = xmlc.xml_CREATE("id extension=\""+getClinicalDocument().getPatient().getId()+"\" root=\""+getClinicalDocument().getHeader().getExtension2()+"\"","");
        TAG P1 = xmlc.xml_CREATE("addr",""+getClinicalDocument().getPatient().getAddr()+"");
        TAG P2 = xmlc.xml_CREATE("telecom value=\""+getClinicalDocument().getPatient().getPhone()+"\"","");
        TAG P3 = xmlc.xml_CREATE("patient","");
        TAG P4 = xmlc.xml_CREATE("name","");
        TAG P17 =xmlc.xml_CREATE("given",""+getClinicalDocument().getPatient().getName()+"");
        TAG P18 =xmlc.xml_CREATE("family",""+getClinicalDocument().getPatient().getFamily()+"");
        TAG P5 = xmlc.xml_CREATE("administrativeGenderCode code=\""+getClinicalDocument().getPatient().getAdmin()+"\" codeSystem=\""+getClinicalDocument().getPatient().getCodeSystem()+"\"",""); 
        TAG P6 = xmlc.xml_CREATE("birthTime value=\""+getClinicalDocument().getPatient().getBirth()+"\"","");
        TAG P7 = xmlc.xml_CREATE("maritalStatusCode code='"+getClinicalDocument().getPatient().getMaritalStatus()+"'","");
        TAG P8 = xmlc.xml_CREATE("religiousAffiliationCode code='"+getClinicalDocument().getPatient().getReligious()+"'","");
        TAG P9 = xmlc.xml_CREATE("raceCode code='"+getClinicalDocument().getPatient().getRace()+"'","");
        TAG P10 =xmlc.xml_CREATE("ethnicGroupCode code='"+getClinicalDocument().getPatient().getEthnicGroup()+"'","");
        TAG P11 =xmlc.xml_CREATE("birthplace","");
        TAG P12 =xmlc.xml_CREATE("place","");
        TAG P13 =xmlc.xml_CREATE("name",""+getClinicalDocument().getPatient().getBirthPlace()+"");
        TAG P14 =xmlc.xml_CREATE("addr", ""+getClinicalDocument().getPatient().getAddrBirthPlace()+"");
        TAG P15 =xmlc.xml_CREATE("providerOrganization","");
        TAG P16 =xmlc.xml_CREATE("id extension=\""+getClinicalDocument().getPatient().getIdExtension()+"\" root=\""+getClinicalDocument().getHeader().getExtension2()+"\"","");
        //STRUCTURE AUTHOR
        //==========================================================================================
        TAG A0 = xmlc.xml_CREATE("author","");
        TAG A1 = xmlc.xml_CREATE("time value = \""+getClinicalDocument().getHeader().getEfetiveTime()+"\"", "");
        TAG A2 = xmlc.xml_CREATE("assignedAuthor","");
        TAG A3 = xmlc.xml_CREATE("id root='"+getClinicalDocument().getHeader().getExtension2()+"' extension='"+getClinicalDocument().getAuthor().getCrm()+"'", "");
        TAG A4 = xmlc.xml_CREATE("addr", ""+getClinicalDocument().getAuthor().getAddr()+"");
        TAG A5 = xmlc.xml_CREATE("telecom value = '"+getClinicalDocument().getAuthor().getPhone()+"'","");
        TAG A6 = xmlc.xml_CREATE("assignedPerson", "");
        TAG A7 = xmlc.xml_CREATE("name","");
        TAG A8 = xmlc.xml_CREATE("given",""+getClinicalDocument().getAuthor().getName()+"");
        TAG A9 = xmlc.xml_CREATE("family",""+getClinicalDocument().getAuthor().getFamily()+"");
        //==========================================================================================
        TAG CS0 = xmlc.xml_CREATE("custodian", "");
        TAG CS1 = xmlc.xml_CREATE("assignedCustodian","");
        TAG CS2 = xmlc.xml_CREATE("representedCustodianOrganization","");
        TAG CS3 = xmlc.xml_CREATE("id extension=\""+getClinicalDocument().getPatient().getId()+"\" root=\""+getClinicalDocument().getHeader().getExtension2()+"\"", "");
        TAG CS4 = xmlc.xml_CREATE("name", "MultCare");
        //==========================================================================================

        TAG L0 = xmlc.xml_CREATE("legalAuthenticator", "");

        if(getClinicalDocument().getAuthenticator().getCode()!=null){
            TAG L1 = xmlc.xml_CREATE("time value=\""+getClinicalDocument().getHeader().getEfetiveTime()+"\"", "");
            TAG L2 = xmlc.xml_CREATE("signatureCode code=\""+getClinicalDocument().getAuthenticator().getCode()+"\"","");
            TAG L3 = xmlc.xml_CREATE("assignedEntity", "");
            TAG L4 = xmlc.xml_CREATE("id extension=\""+getClinicalDocument().getPatient().getIdExtension()+"\" root=\""+getClinicalDocument().getHeader().getExtension2()+"\"","");
            TAG L5 = xmlc.xml_CREATE("assignedPerson","");
            TAG L6 = xmlc.xml_CREATE("name","");
            TAG L7 = xmlc.xml_CREATE("given", ""+getClinicalDocument().getAuthor().getName()+"");
            TAG L8 = xmlc.xml_CREATE("family",""+getClinicalDocument().getAuthor().getFamily()+"");
                    //==============================
            xmlc.xml_INSERT(L6, L8);
            xmlc.xml_INSERT(L6, L7);
            xmlc.xml_INSERT(L5, L6);
            xmlc.xml_INSERT(L3, L5);
            xmlc.xml_INSERT(L3, L4);
            xmlc.xml_INSERT(L0,L3);
            xmlc.xml_INSERT(L0, L2);
            xmlc.xml_INSERT(L0, L1);
        }
        //==========================================================================================
        TAG R0 = xmlc.xml_CREATE("relatedDocument typeCode=\""+getClinicalDocument().getRelated().getCode()+"\"", "");
        TAG R1 = xmlc.xml_CREATE("parentDocument","");
        TAG R2 = xmlc.xml_CREATE("id extension=\""+getClinicalDocument().getRelated().getId()+"\" root=\""+getClinicalDocument().getHeader().getExtension2()+"\"", "");
        TAG R3 = xmlc.xml_CREATE("setId extension=\""+getClinicalDocument().getRelated().getExtension()+"\" root=\""+getClinicalDocument().getHeader().getExtension2()+"\"", "");
        TAG R4 = xmlc.xml_CREATE("versionNumber value=\""+getClinicalDocument().getRelated().getVersion()+"\"", "");
        //=====================================================================================

        TAG OFF0 =xmlc.xml_CREATE("componentOf","");

        if(getClinicalDocument().getResponsibleParty().getIdRoot()!=null){
            TAG OFF1 =xmlc.xml_CREATE("encompassingEncounter", "");
            TAG OFF2 =xmlc.xml_CREATE("id root=\""+getClinicalDocument().getResponsibleParty().getIdRoot()+"\" extension=\""+getClinicalDocument().getResponsibleParty().getExtension()+"\"", "");
            TAG OFF3 =xmlc.xml_CREATE("effectiveTime value=\""+getClinicalDocument().getResponsibleParty().getDate()+"\"","");
            TAG OFF4 =xmlc.xml_CREATE("responsibleParty","");
            TAG OFF5 =xmlc.xml_CREATE("assignedEntity", "");
            TAG OFF6 =xmlc.xml_CREATE("id nullFlavor=\""+getClinicalDocument().getResponsibleParty().getId()+"\"", "");
            TAG OFF7 =xmlc.xml_CREATE("addr","");
            TAG OFF8 =xmlc.xml_CREATE("state", ""+getClinicalDocument().getResponsibleParty().getState()+"");
            TAG OFF9 =xmlc.xml_CREATE("city",""+getClinicalDocument().getResponsibleParty().getCity()+"");
            TAG OFF10 =xmlc.xml_CREATE("postalCode", ""+getClinicalDocument().getResponsibleParty().getPostal()+"");
            TAG OFF11 =xmlc.xml_CREATE("streetAddressLine", ""+getClinicalDocument().getResponsibleParty().getStreet()+"");
            TAG OFF12 =xmlc.xml_CREATE("telecom value=\"tel:"+getClinicalDocument().getResponsibleParty().getPhone()+"\" use=\""+getClinicalDocument().getResponsibleParty().getUse()+"\"", "");
            TAG OFF13 =xmlc.xml_CREATE("assignedPerson", "");
            TAG OFF14 =xmlc.xml_CREATE("name","");
            TAG OFF15 =xmlc.xml_CREATE("family", ""+getClinicalDocument().getResponsibleParty().getFamily()+"");
            TAG OFF16 =xmlc.xml_CREATE("given", ""+getClinicalDocument().getResponsibleParty().getName1()+"");
            TAG OFF17 =xmlc.xml_CREATE("given", ""+getClinicalDocument().getResponsibleParty().getName2()+"");
            TAG OFF18 =xmlc.xml_CREATE("suffix", ""+getClinicalDocument().getResponsibleParty().getSuffixe()+"");
            TAG OFF19 =xmlc.xml_CREATE("location","");
            TAG OFF20 =xmlc.xml_CREATE("healthCareFacility", "");
            TAG OFF21 =xmlc.xml_CREATE("id root=\""+getClinicalDocument().getResponsibleParty().getIdRoot()+"\" extension=\""+getClinicalDocument().getResponsibleParty().getExtension()+"\"", "");
            TAG OFF22 =xmlc.xml_CREATE("location","");
            TAG OFF23 =xmlc.xml_CREATE("name", ""+getClinicalDocument().getResponsibleParty().getLocation()+"");
            TAG OFF24 =xmlc.xml_CREATE("addr", "");
            TAG OFF25 =xmlc.xml_CREATE("state", ""+getClinicalDocument().getResponsibleParty().getState()+"");
            TAG OFF26 =xmlc.xml_CREATE("city",""+getClinicalDocument().getResponsibleParty().getCity()+"");
            TAG OFF27 =xmlc.xml_CREATE("postalCode", ""+getClinicalDocument().getResponsibleParty().getPostal()+"");
            TAG OFF28 =xmlc.xml_CREATE("streetAddressLine",""+getClinicalDocument().getResponsibleParty().getStreet()+"");

            xmlc.xml_INSERT(OFF24,OFF28);
            xmlc.xml_INSERT(OFF24,OFF27);
            xmlc.xml_INSERT(OFF24,OFF26);
            xmlc.xml_INSERT(OFF24,OFF25);
            xmlc.xml_INSERT(OFF22,OFF24);
            xmlc.xml_INSERT(OFF22,OFF23);
            xmlc.xml_INSERT(OFF20,OFF22);
            xmlc.xml_INSERT(OFF20,OFF21);
            xmlc.xml_INSERT(OFF19,OFF20);
            xmlc.xml_INSERT(OFF14,OFF18);
            xmlc.xml_INSERT(OFF14,OFF17);
            xmlc.xml_INSERT(OFF14,OFF16);
            xmlc.xml_INSERT(OFF14,OFF15);
            xmlc.xml_INSERT(OFF13,OFF14);
            xmlc.xml_INSERT(OFF7, OFF11);
            xmlc.xml_INSERT(OFF7, OFF10);
            xmlc.xml_INSERT(OFF7, OFF9);
            xmlc.xml_INSERT(OFF7, OFF8);
            xmlc.xml_INSERT(OFF5, OFF13);
            xmlc.xml_INSERT(OFF5, OFF12);
            xmlc.xml_INSERT(OFF5, OFF7);
            xmlc.xml_INSERT(OFF5, OFF6);
            xmlc.xml_INSERT(OFF4, OFF5);
            xmlc.xml_INSERT(OFF1, OFF19);
            xmlc.xml_INSERT(OFF1, OFF4);
            xmlc.xml_INSERT(OFF1, OFF3);
            xmlc.xml_INSERT(OFF1, OFF2);
            xmlc.xml_INSERT(OFF0, OFF1);
        }
        //==========================================================================================
        //STRUCTURE DOCTOR HISTORIC
        TAG CO0 =	xmlc.xml_CREATE("component", "");
        TAG CO1 =	xmlc.xml_CREATE("structuredBody", "");
        TAG CO2 =	xmlc.xml_CREATE("languageCode code=\'pt-BR\'","");

        if(getClinicalDocument().getHealthHistoric().getCode() != null) {
            TAG CO3 = 	xmlc.xml_CREATE("component", "");
            TAG CO4 = 	xmlc.xml_CREATE("section classCode=\""+getClinicalDocument().getHealthHistoric().getSection()+"\" moodCode=\""+getClinicalDocument().getHealthHistoric().getMoodCode()+"\"","");
            TAG CO5 = 	xmlc.xml_CREATE("templateId root=\""+getClinicalDocument().getHealthHistoric().getTemplateId()+"\"", ""); 
            TAG CO6 = 	xmlc.xml_CREATE("code code=\""+getClinicalDocument().getHealthHistoric().getCode()+"\" codeSystem=\""+getClinicalDocument().getHealthHistoric().getCodeSystem()+"\" codeSystemName=\""+getClinicalDocument().getHealthHistoric().getCodeName()+"\" displayName=\"Problema atual\"","");
            TAG CO7 =	xmlc.xml_CREATE("title", "Histórico da doença atual"); 
            TAG CO8 =	xmlc.xml_CREATE("text", ""+getClinicalDocument().getHealthHistoric().getText()+"");
            //==============================
            xmlc.xml_INSERT(CO4, CO8);
            xmlc.xml_INSERT(CO4, CO7);
            xmlc.xml_INSERT(CO4, CO6);
            xmlc.xml_INSERT(CO4, CO5);
            xmlc.xml_INSERT(CO3, CO4);
            xmlc.xml_INSERT(CO1, CO3);
        }
        //==========================================================================================
        if(getClinicalDocument().getDoctorHistoric().getContent() != null) {
            TAG COMP10 = xmlc.xml_CREATE("component","");
            TAG COMP11 = xmlc.xml_CREATE("section","");
            TAG COMP12 = xmlc.xml_CREATE("title","Histórico médico passado");
            TAG COMP13 = xmlc.xml_CREATE("text","");
            TAG COMP14 = xmlc.xml_CREATE("list","");
            TAG COMP15 = xmlc.xml_CREATE("",xmlc.xml_content(getClinicalDocument().getDoctorHistoric().getContent()));
            //==============================
            xmlc.xml_INSERT(COMP14, COMP15);
            xmlc.xml_INSERT(COMP13, COMP14);
            xmlc.xml_INSERT(COMP11, COMP13);
            xmlc.xml_INSERT(COMP11, COMP12);
            xmlc.xml_INSERT(COMP10, COMP11);
            xmlc.xml_INSERT(CO1,    COMP10);
        }
        //==========================================================================================
        if(getClinicalDocument().getMedicines().getContent() != null) {
            TAG COMP20 = xmlc.xml_CREATE("component","");
            TAG COMP21 = xmlc.xml_CREATE("section","");
            TAG COMP22 = xmlc.xml_CREATE("title","Medicamentos");
            TAG COMP23 = xmlc.xml_CREATE("text","");
            TAG COMP24 = xmlc.xml_CREATE("list","");
            TAG COMP25 = xmlc.xml_CREATE("",xmlc.xml_content(getClinicalDocument().getMedicines().getContent()));
            //==============================
            xmlc.xml_INSERT(COMP24, COMP25);
            xmlc.xml_INSERT(COMP23, COMP24);
            xmlc.xml_INSERT(COMP21, COMP23);
            xmlc.xml_INSERT(COMP21, COMP22);
            xmlc.xml_INSERT(COMP20, COMP21);
            xmlc.xml_INSERT(CO1,    COMP20);
        }
        //==========================================================================================
        if(getClinicalDocument().getAllergy().getContent() != null) {
            TAG COMP30 = xmlc.xml_CREATE("component","");
            TAG COMP31 = xmlc.xml_CREATE("section classCode=\""+getClinicalDocument().getHealthHistoric().getSection()+"\" moodCode=\""+getClinicalDocument().getHealthHistoric().getMoodCode()+"\"","");
            TAG COMP32 = xmlc.xml_CREATE("title","Alergias");
            TAG COMP33 = xmlc.xml_CREATE("text","");
            TAG COMP34 = xmlc.xml_CREATE("list","");
            TAG COMP35 = xmlc.xml_CREATE("",xmlc.xml_content(getClinicalDocument().getAllergy().getContent()));
            //==============================
            xmlc.xml_INSERT(COMP34, COMP35);
            xmlc.xml_INSERT(COMP33, COMP34);
            xmlc.xml_INSERT(COMP31, COMP33);
            xmlc.xml_INSERT(COMP31, COMP32);
            xmlc.xml_INSERT(COMP30, COMP31);
            xmlc.xml_INSERT(CO1, COMP30);
        }
        //==========================================================================================
        if(getClinicalDocument().getFamilyHistoric().getContent() != null) {
            TAG COMP40 = xmlc.xml_CREATE("component","");
            TAG COMP41 = xmlc.xml_CREATE("section","");
            TAG COMP42 = xmlc.xml_CREATE("title","Histórico familiar");
            TAG COMP43 = xmlc.xml_CREATE("text","");
            TAG COMP44 = xmlc.xml_CREATE("list","");
            TAG COMP45 = xmlc.xml_CREATE("",xmlc.xml_content(getClinicalDocument().getFamilyHistoric().getContent()));
            //==============================
            xmlc.xml_INSERT(COMP44, COMP45);
            xmlc.xml_INSERT(COMP43, COMP44);
            xmlc.xml_INSERT(COMP41, COMP43);
            xmlc.xml_INSERT(COMP41, COMP42);
            xmlc.xml_INSERT(COMP40, COMP41);
            xmlc.xml_INSERT(CO1,    COMP40);
        }
        //==========================================================================================
        if(getClinicalDocument().getExams().getContent() != null) {
            TAG COMP50 = xmlc.xml_CREATE("component","");
            TAG COMP51 = xmlc.xml_CREATE("section","");
            TAG COMP52 = xmlc.xml_CREATE("title","Exame/Métrica físico");
            TAG COMP53 = xmlc.xml_CREATE("text","");
            TAG COMP54 = xmlc.xml_CREATE("list","");
            TAG COMP55 = xmlc.xml_CREATE("",xmlc.xml_content(getClinicalDocument().getExams().getContent()));
            //==============================
            xmlc.xml_INSERT(COMP54, COMP55);
            xmlc.xml_INSERT(COMP53, COMP54);
            xmlc.xml_INSERT(COMP51, COMP53);
            xmlc.xml_INSERT(COMP51, COMP52);
            xmlc.xml_INSERT(COMP50, COMP51);
            xmlc.xml_INSERT(CO1,    COMP50);
        }
        //==========================================================================================
        if(getClinicalDocument().getLaboratoryExams().getContent() != null) {
            TAG COMP60 = xmlc.xml_CREATE("component","");
            TAG COMP61 = xmlc.xml_CREATE("section classCode=\""+getClinicalDocument().getHealthHistoric().getSection()+"\" moodCode=\""+getClinicalDocument().getHealthHistoric().getMoodCode()+"\"","");
            TAG COMP62 = xmlc.xml_CREATE("templateId root=\"2.16.840.1.113883."+getClinicalDocument().getLaboratoryExams().getId()+"\"","");  
            TAG COMP63 = xmlc.xml_CREATE("code code=\""+getClinicalDocument().getLaboratoryExams().getCode()+"\" codeSystem=\""+getClinicalDocument().getHealthHistoric().getCodeSystem()+"\" codeSystemName=\""+getClinicalDocument().getHealthHistoric().getCodeName()+"\" displayName=\"Exames de laboratório\"",""); 
            TAG COMP64 =  xmlc.xml_CREATE("title","Exames de laboratório");
            TAG COMP65 =  xmlc.xml_CREATE("text","");
            TAG COMP66 =  xmlc.xml_CREATE("list","");
            TAG COMP67 =  xmlc.xml_CREATE("",xmlc.xml_content(getClinicalDocument().getLaboratoryExams().getContent()));
            //==============================
            xmlc.xml_INSERT(COMP66, COMP67);
            xmlc.xml_INSERT(COMP65, COMP66);
            xmlc.xml_INSERT(COMP61, COMP65);
            xmlc.xml_INSERT(COMP61, COMP64);
            xmlc.xml_INSERT(COMP61, COMP63);
            xmlc.xml_INSERT(COMP61, COMP62);
            xmlc.xml_INSERT(COMP60, COMP61);
            xmlc.xml_INSERT(CO1,    COMP60);
        }
        //==========================================================================================
        if(getClinicalDocument().getDiagnostic().getContent() != null) {
            TAG COMP70 = xmlc.xml_CREATE("component","");
            TAG COMP71 = xmlc.xml_CREATE("section","");
            TAG COMP72 = xmlc.xml_CREATE("title","Diagnóstico");
            TAG COMP73 = xmlc.xml_CREATE("text","");
            TAG COMP74 = xmlc.xml_CREATE("list","");
            TAG COMP75 = xmlc.xml_CREATE("",xmlc.xml_content(getClinicalDocument().getDiagnostic().getContent()));
            //==============================
            xmlc.xml_INSERT(COMP74, COMP75);
            xmlc.xml_INSERT(COMP73, COMP74);
            xmlc.xml_INSERT(COMP71, COMP73);
            xmlc.xml_INSERT(COMP71, COMP72);
            xmlc.xml_INSERT(COMP70, COMP71);
            xmlc.xml_INSERT(CO1,    COMP70);
        }
        //==========================================================================================
        if(getClinicalDocument().getTratament().getContent() != null) {
            TAG COMP80 = xmlc.xml_CREATE("component","");
            TAG COMP81 = xmlc.xml_CREATE("section","");
            TAG COMP82 = xmlc.xml_CREATE("title","Tratamento");
            TAG COMP83 = xmlc.xml_CREATE("text","");
            TAG COMP84 = xmlc.xml_CREATE("list","");
            TAG COMP85 = xmlc.xml_CREATE("",xmlc.xml_content(getClinicalDocument().getTratament().getContent()));
            //==============================
            xmlc.xml_INSERT(COMP84, COMP85);
            xmlc.xml_INSERT(COMP83, COMP84);
            xmlc.xml_INSERT(COMP81, COMP83);
            xmlc.xml_INSERT(COMP81, COMP82);
            xmlc.xml_INSERT(COMP80, COMP81);
            xmlc.xml_INSERT(CO1,    COMP80);
        }
        //==============================
        xmlc.xml_INSERT(CO0, CO1);
        xmlc.xml_INSERT(CO1, CO2);
        //==============================
        xmlc.xml_INSERT(P15,P16);
        xmlc.xml_INSERT(P20,P15);
        xmlc.xml_INSERT(P12,P14);
        xmlc.xml_INSERT(P12,P13);
        xmlc.xml_INSERT(P11,P12);
        xmlc.xml_INSERT(P3,P11);
        xmlc.xml_INSERT(P3,P10);
        xmlc.xml_INSERT(P3,P9);
        xmlc.xml_INSERT(P3,P8);
        xmlc.xml_INSERT(P3,P7);
        xmlc.xml_INSERT(P3,P6);
        xmlc.xml_INSERT(P3,P5);
        xmlc.xml_INSERT(P4,P18);
        xmlc.xml_INSERT(P4,P17);
        xmlc.xml_INSERT(P3, P4);
        xmlc.xml_INSERT(P20,P3);
        xmlc.xml_INSERT(P20,P2);
        xmlc.xml_INSERT(P20,P1);
        xmlc.xml_INSERT(P20,P0);
        xmlc.xml_INSERT(P19,P20);
        //==============================
        xmlc.xml_INSERT(A7, A9);
        xmlc.xml_INSERT(A7, A8);
        xmlc.xml_INSERT(A6, A7);
        xmlc.xml_INSERT(A2, A6);
        xmlc.xml_INSERT(A2, A5);
        xmlc.xml_INSERT(A2, A4);
        xmlc.xml_INSERT(A2, A3);
        xmlc.xml_INSERT(A0, A2);
        xmlc.xml_INSERT(A0, A1);
        //==============================
        xmlc.xml_INSERT(CS2, CS4);
        xmlc.xml_INSERT(CS2, CS3);
        xmlc.xml_INSERT(CS1, CS2);
        xmlc.xml_INSERT(CS0, CS1);
        //==============================
        xmlc.xml_INSERT(R1, R4);
        xmlc.xml_INSERT(R1, R3);
        xmlc.xml_INSERT(R1, R2);
        xmlc.xml_INSERT(R0, R1);
        //==============================
        xmlc.xml_INSERT(rootTag,CO0);
        xmlc.xml_INSERT(rootTag,OFF0);
        xmlc.xml_INSERT(rootTag,R0);
        xmlc.xml_INSERT(rootTag,L0);
        xmlc.xml_INSERT(rootTag,CS0);
        xmlc.xml_INSERT(rootTag,A0);
        xmlc.xml_INSERT(rootTag,P19);
        //==============================
        for(int i = 9; i >= 0; i--){
            xmlc.xml_INSERT(rootTag,h[i]);
        }
        //DELETES FILE CDA TO OVERWRITE A NEW
        xmlc.xml_CLEAN(getFile());

        try (FileWriter fw = new FileWriter(getFile(),true);){
            fw.write("<?xml version='1.0' encoding='UTF-8'?>");
            //GENERATES XML FILE
            xmlc.xml_PRINT(rootTag,fw);
            fw.close();
            System.out.println("Success when writing file\n");
            return true;
        }catch(Exception ex){
            System.err.println("Error writing file:\n"+ex);
            return false;
        }
    }
}