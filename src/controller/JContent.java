package controller;

import br.com.multcare.ClinicalDocument;
import controller.XMLTree.TAG;
import java.io.File;
import java.io.FileWriter;

/**
 * Classe que contém o conteúdo do documento CDA, representado em XML.
 * @author Gyovanne
 */
public class JContent {

    private final XMLTree w;
    private final File file; 
    private final ClinicalDocument clinicalDocument;

    public File getFile() {
        return file;
    }

    public ClinicalDocument getClinicalDocument() {
        return clinicalDocument;
    }
    
    public JContent(File file, ClinicalDocument clinicalDocument) {
        this.file = file;
        this.clinicalDocument = clinicalDocument;
        this.w = new XMLTree();
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public boolean generateContent() throws Exception {
        //STRUCTURE HEADER
        //==========================================================================================
        TAG CD = w.xml_CREATE("ClinicalDocument xmlns=\"urn:hl7-org:v3\" xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' classCode='DOCCLIN'","");
        TAG C1 = w.xml_CREATE("realmCode code='"+getClinicalDocument().getHeader().getRealmCode()+"'","");
        TAG C2 = w.xml_CREATE("typeId root='2.16.840.1.113883.1.3' extension='POCD_HD000040'","");/*+h.getTypeid()+*/	/*+h.getExtension1()+*/
        TAG C3 = w.xml_CREATE("templateId root='2.16.840.1.113883.10.20.1'","");/*+h.getTemplate()+*/
        TAG C4 = w.xml_CREATE("id root='"+getClinicalDocument().getHeader().getIdRoot()+"' extension='"+getClinicalDocument().getHeader().getExtension2()+"'","");
        TAG C5 = w.xml_CREATE("code code='"+getClinicalDocument().getHeader().getCode()+"' displayName='Diagnostico utilizando Multcare' codeSystem='2.16.840.1.113883.6.103' codeSystemName='ICD-9-CM'","");
        TAG C6 = w.xml_CREATE("effectiveTime value=\""+getClinicalDocument().getHeader().getEfetiveTime()+"\"","");
        TAG C7 = w.xml_CREATE("confidentialityCode code=\"N\" displayName='Normal' codeSystem='2.16.840.1.113883.5.25' codeSystemName='Confidentiality'","");
        TAG C8 = w.xml_CREATE("setId extension=\""+getClinicalDocument().getHeader().getId()+"\" root=\""+getClinicalDocument().getHeader().getExtension2()+"\"","");
        TAG C9 = w.xml_CREATE("versionNumber value=\""+getClinicalDocument().getHeader().getVersion()+"\"","");
        TAG C10 =w.xml_CREATE("copyTime value='"+getClinicalDocument().getHeader().getEfetiveTime()+"'","");
        //==========================================================================================
        //STRUCTURE PATIENT
        TAG P19 =w.xml_CREATE("recordTarget","");
        TAG P20 =w.xml_CREATE("patientRole","");
        TAG P0 = w.xml_CREATE("id extension=\""+getClinicalDocument().getPatient().getId()+"\" root=\""+getClinicalDocument().getHeader().getExtension2()+"\"","");
        TAG P1 = w.xml_CREATE("addr",""+getClinicalDocument().getPatient().getAddr()+"");
        TAG P2 = w.xml_CREATE("telecom value=\""+getClinicalDocument().getPatient().getPhone()+"\"","");
        TAG P3 = w.xml_CREATE("patient","");
        TAG P4 = w.xml_CREATE("name","");
        TAG P17 =w.xml_CREATE("given",""+getClinicalDocument().getPatient().getName()+"");
        TAG P18 =w.xml_CREATE("family",""+getClinicalDocument().getPatient().getFamily()+"");
        TAG P5 = w.xml_CREATE("administrativeGenderCode code=\""+getClinicalDocument().getPatient().getAdmin()+"\" codeSystem=\""+getClinicalDocument().getPatient().getCodeSystem()+"\"",""); 
        TAG P6 = w.xml_CREATE("birthTime value=\""+getClinicalDocument().getPatient().getBirth()+"\"","");
        TAG P7 = w.xml_CREATE("maritalStatusCode code='"+getClinicalDocument().getPatient().getMaritalStatus()+"'","");
        TAG P8 = w.xml_CREATE("religiousAffiliationCode code='"+getClinicalDocument().getPatient().getReligious()+"'","");
        TAG P9 = w.xml_CREATE("raceCode code='"+getClinicalDocument().getPatient().getRace()+"'","");
        TAG P10 =w.xml_CREATE("ethnicGroupCode code='"+getClinicalDocument().getPatient().getEthnicGroup()+"'","");
        TAG P11 =w.xml_CREATE("birthplace","");
        TAG P12 =w.xml_CREATE("place","");
        TAG P13 =w.xml_CREATE("name",""+getClinicalDocument().getPatient().getBirthPlace()+"");
        TAG P14 =w.xml_CREATE("addr", ""+getClinicalDocument().getPatient().getAddrBirthPlace()+"");
        TAG P15 =w.xml_CREATE("providerOrganization","");
        TAG P16 =w.xml_CREATE("id extension=\""+getClinicalDocument().getPatient().getIdExtension()+"\" root=\""+getClinicalDocument().getHeader().getExtension2()+"\"","");
        //STRUCTURE AUTHOR
        //==========================================================================================
        TAG A0 = w.xml_CREATE("author","");
        TAG A1 = w.xml_CREATE("time value = \""+getClinicalDocument().getHeader().getEfetiveTime()+"\"", "");
        TAG A2 = w.xml_CREATE("assignedAuthor","");
        TAG A3 = w.xml_CREATE("id root='"+getClinicalDocument().getHeader().getExtension2()+"' extension='"+getClinicalDocument().getAuthor().getCrm()+"'", "");
        TAG A4 = w.xml_CREATE("addr", ""+getClinicalDocument().getAuthor().getAddr()+"");
        TAG A5 = w.xml_CREATE("telecom value = '"+getClinicalDocument().getAuthor().getPhone()+"'","");
        TAG A6 = w.xml_CREATE("assignedPerson", "");
        TAG A7 = w.xml_CREATE("name","");
        TAG A8 = w.xml_CREATE("given",""+getClinicalDocument().getAuthor().getName()+"");
        TAG A9 = w.xml_CREATE("family",""+getClinicalDocument().getAuthor().getFamily()+"");
        //==========================================================================================
        TAG CS0 = w.xml_CREATE("custodian", "");
        TAG CS1 = w.xml_CREATE("assignedCustodian","");
        TAG CS2 = w.xml_CREATE("representedCustodianOrganization","");
        TAG CS3 = w.xml_CREATE("id extension=\""+getClinicalDocument().getPatient().getId()+"\" root=\""+getClinicalDocument().getHeader().getExtension2()+"\"", "");
        TAG CS4 = w.xml_CREATE("name", "MultCare");
        //==========================================================================================
        
        TAG L0 = w.xml_CREATE("legalAuthenticator", "");
        
        if(getClinicalDocument().getAuthenticator().getCode()!=null){
            TAG L1 = w.xml_CREATE("time value=\""+getClinicalDocument().getHeader().getEfetiveTime()+"\"", "");
            TAG L2 = w.xml_CREATE("signatureCode code=\""+getClinicalDocument().getAuthenticator().getCode()+"\"","");
            TAG L3 = w.xml_CREATE("assignedEntity", "");
            TAG L4 = w.xml_CREATE("id extension=\""+getClinicalDocument().getPatient().getIdExtension()+"\" root=\""+getClinicalDocument().getHeader().getExtension2()+"\"","");
            TAG L5 = w.xml_CREATE("assignedPerson","");
            TAG L6 = w.xml_CREATE("name","");
            TAG L7 = w.xml_CREATE("given", ""+getClinicalDocument().getAuthor().getName()+"");
            TAG L8 = w.xml_CREATE("family",""+getClinicalDocument().getAuthor().getFamily()+"");
                    //==============================
            w.xml_INSERT(L6, L8);
            w.xml_INSERT(L6, L7);
            w.xml_INSERT(L5, L6);
            w.xml_INSERT(L3, L5);
            w.xml_INSERT(L3, L4);
            w.xml_INSERT(L0,L3);
            w.xml_INSERT(L0, L2);
            w.xml_INSERT(L0, L1);
        }
        //==========================================================================================
        TAG R0 = w.xml_CREATE("relatedDocument typeCode=\""+getClinicalDocument().getRelated().getCode()+"\"", "");
        TAG R1 = w.xml_CREATE("parentDocument","");
        TAG R2 = w.xml_CREATE("id extension=\""+getClinicalDocument().getRelated().getId()+"\" root=\""+getClinicalDocument().getHeader().getExtension2()+"\"", "");
        TAG R3 = w.xml_CREATE("setId extension=\""+getClinicalDocument().getRelated().getExtension()+"\" root=\""+getClinicalDocument().getHeader().getExtension2()+"\"", "");
        TAG R4 = w.xml_CREATE("versionNumber value=\""+getClinicalDocument().getRelated().getVersion()+"\"", "");
        //=====================================================================================
        
        TAG OFF0 =w.xml_CREATE("componentOf","");
        
        if(getClinicalDocument().getResponsibleParty().getIdRoot()!=null){
            TAG OFF1 =w.xml_CREATE("encompassingEncounter", "");
            TAG OFF2 =w.xml_CREATE("id root=\""+getClinicalDocument().getResponsibleParty().getIdRoot()+"\" extension=\""+getClinicalDocument().getResponsibleParty().getExtension()+"\"", "");
            TAG OFF3 =w.xml_CREATE("effectiveTime value=\""+getClinicalDocument().getResponsibleParty().getDate()+"\"","");
            TAG OFF4 =w.xml_CREATE("responsibleParty","");
            TAG OFF5 =w.xml_CREATE("assignedEntity", "");
            TAG OFF6 =w.xml_CREATE("id nullFlavor=\""+getClinicalDocument().getResponsibleParty().getId()+"\"", "");
            TAG OFF7 =w.xml_CREATE("addr","");
            TAG OFF8 =w.xml_CREATE("state", ""+getClinicalDocument().getResponsibleParty().getState()+"");
            TAG OFF9 =w.xml_CREATE("city",""+getClinicalDocument().getResponsibleParty().getCity()+"");
            TAG OFF10 =w.xml_CREATE("postalCode", ""+getClinicalDocument().getResponsibleParty().getPostal()+"");
            TAG OFF11 =w.xml_CREATE("streetAddressLine", ""+getClinicalDocument().getResponsibleParty().getStreet()+"");
            TAG OFF12 =w.xml_CREATE("telecom value=\"tel:"+getClinicalDocument().getResponsibleParty().getPhone()+"\" use=\""+getClinicalDocument().getResponsibleParty().getUse()+"\"", "");
            TAG OFF13 =w.xml_CREATE("assignedPerson", "");
            TAG OFF14 =w.xml_CREATE("name","");
            TAG OFF15 =w.xml_CREATE("family", ""+getClinicalDocument().getResponsibleParty().getFamily()+"");
            TAG OFF16 =w.xml_CREATE("given", ""+getClinicalDocument().getResponsibleParty().getName1()+"");
            TAG OFF17 =w.xml_CREATE("given", ""+getClinicalDocument().getResponsibleParty().getName2()+"");
            TAG OFF18 =w.xml_CREATE("suffix", ""+getClinicalDocument().getResponsibleParty().getSuffixe()+"");
            TAG OFF19 =w.xml_CREATE("location","");
            TAG OFF20 =w.xml_CREATE("healthCareFacility", "");
            TAG OFF21 =w.xml_CREATE("id root=\""+getClinicalDocument().getResponsibleParty().getIdRoot()+"\" extension=\""+getClinicalDocument().getResponsibleParty().getExtension()+"\"", "");
            TAG OFF22 =w.xml_CREATE("location","");
            TAG OFF23 =w.xml_CREATE("name", ""+getClinicalDocument().getResponsibleParty().getLocation()+"");
            TAG OFF24 =w.xml_CREATE("addr", "");
            TAG OFF25 =w.xml_CREATE("state", ""+getClinicalDocument().getResponsibleParty().getState()+"");
            TAG OFF26 =w.xml_CREATE("city",""+getClinicalDocument().getResponsibleParty().getCity()+"");
            TAG OFF27 =w.xml_CREATE("postalCode", ""+getClinicalDocument().getResponsibleParty().getPostal()+"");
            TAG OFF28 =w.xml_CREATE("streetAddressLine",""+getClinicalDocument().getResponsibleParty().getStreet()+"");

            w.xml_INSERT(OFF24,OFF28);
            w.xml_INSERT(OFF24,OFF27);
            w.xml_INSERT(OFF24,OFF26);
            w.xml_INSERT(OFF24,OFF25);
            w.xml_INSERT(OFF22,OFF24);
            w.xml_INSERT(OFF22,OFF23);
            w.xml_INSERT(OFF20,OFF22);
            w.xml_INSERT(OFF20,OFF21);
            w.xml_INSERT(OFF19,OFF20);
            w.xml_INSERT(OFF14,OFF18);
            w.xml_INSERT(OFF14,OFF17);
            w.xml_INSERT(OFF14,OFF16);
            w.xml_INSERT(OFF14,OFF15);
            w.xml_INSERT(OFF13,OFF14);
            w.xml_INSERT(OFF7, OFF11);
            w.xml_INSERT(OFF7, OFF10);
            w.xml_INSERT(OFF7, OFF9);
            w.xml_INSERT(OFF7, OFF8);
            w.xml_INSERT(OFF5, OFF13);
            w.xml_INSERT(OFF5, OFF12);
            w.xml_INSERT(OFF5, OFF7);
            w.xml_INSERT(OFF5, OFF6);
            w.xml_INSERT(OFF4, OFF5);
            w.xml_INSERT(OFF1, OFF19);
            w.xml_INSERT(OFF1, OFF4);
            w.xml_INSERT(OFF1, OFF3);
            w.xml_INSERT(OFF1, OFF2);
            w.xml_INSERT(OFF0, OFF1);
        }
        //==========================================================================================
        //STRUCTURE DOCTOR HISTORIC
        TAG CO0 =	w.xml_CREATE("component", "");
        TAG CO1 =	w.xml_CREATE("structuredBody", "");
        TAG CO2 =	w.xml_CREATE("languageCode code=\'pt-BR\'","");

        if(getClinicalDocument().getHealthHistoric().getCode() != null) {
            TAG CO3 = 	w.xml_CREATE("component", "");
            TAG CO4 = 	w.xml_CREATE("section classCode=\""+getClinicalDocument().getHealthHistoric().getSection()+"\" moodCode=\""+getClinicalDocument().getHealthHistoric().getMoodCode()+"\"","");
            TAG CO5 = 	w.xml_CREATE("templateId root=\""+getClinicalDocument().getHealthHistoric().getTemplateId()+"\"", ""); 
            TAG CO6 = 	w.xml_CREATE("code code=\""+getClinicalDocument().getHealthHistoric().getCode()+"\" codeSystem=\""+getClinicalDocument().getHealthHistoric().getCodeSystem()+"\" codeSystemName=\""+getClinicalDocument().getHealthHistoric().getCodeName()+"\" displayName=\"Problema atual\"","");
            TAG CO7 =	w.xml_CREATE("title", "Histórico da doença atual"); 
            TAG CO8 =	w.xml_CREATE("text", ""+getClinicalDocument().getHealthHistoric().getText()+"");
            //==============================
            w.xml_INSERT(CO4, CO8);
            w.xml_INSERT(CO4, CO7);
            w.xml_INSERT(CO4, CO6);
            w.xml_INSERT(CO4, CO5);
            w.xml_INSERT(CO3, CO4);
            w.xml_INSERT(CO1, CO3);
        }
        //==========================================================================================
        if(getClinicalDocument().getDoctorHistoric().getContent() != null) {
            TAG COMP10 = w.xml_CREATE("component","");
            TAG COMP11 = w.xml_CREATE("section","");
            TAG COMP12 = w.xml_CREATE("title","Histórico médico passado");
            TAG COMP13 = w.xml_CREATE("text","");
            TAG COMP14 = w.xml_CREATE("list","");
            TAG COMP15 = w.xml_CREATE("",w.xml_content(getClinicalDocument().getDoctorHistoric().getContent()));
            //==============================
            w.xml_INSERT(COMP14, COMP15);
            w.xml_INSERT(COMP13, COMP14);
            w.xml_INSERT(COMP11, COMP13);
            w.xml_INSERT(COMP11, COMP12);
            w.xml_INSERT(COMP10, COMP11);
            w.xml_INSERT(CO1,    COMP10);
        }
        //==========================================================================================
        if(getClinicalDocument().getMedicines().getContent() != null) {
            TAG COMP20 = w.xml_CREATE("component","");
            TAG COMP21 = w.xml_CREATE("section","");
            TAG COMP22 = w.xml_CREATE("title","Medicamentos");
            TAG COMP23 = w.xml_CREATE("text","");
            TAG COMP24 = w.xml_CREATE("list","");
            TAG COMP25 = w.xml_CREATE("",w.xml_content(getClinicalDocument().getMedicines().getContent()));
            //==============================
            w.xml_INSERT(COMP24, COMP25);
            w.xml_INSERT(COMP23, COMP24);
            w.xml_INSERT(COMP21, COMP23);
            w.xml_INSERT(COMP21, COMP22);
            w.xml_INSERT(COMP20, COMP21);
            w.xml_INSERT(CO1,    COMP20);
        }
        //==========================================================================================
        if(getClinicalDocument().getAllergy().getContent() != null) {
            TAG COMP30 = w.xml_CREATE("component","");
            TAG COMP31 = w.xml_CREATE("section classCode=\""+getClinicalDocument().getHealthHistoric().getSection()+"\" moodCode=\""+getClinicalDocument().getHealthHistoric().getMoodCode()+"\"","");
            TAG COMP32 = w.xml_CREATE("title","Alergias");
            TAG COMP33 = w.xml_CREATE("text","");
            TAG COMP34 = w.xml_CREATE("list","");
            TAG COMP35 = w.xml_CREATE("",w.xml_content(getClinicalDocument().getAllergy().getContent()));
            //==============================
            w.xml_INSERT(COMP34, COMP35);
            w.xml_INSERT(COMP33, COMP34);
            w.xml_INSERT(COMP31, COMP33);
            w.xml_INSERT(COMP31, COMP32);
            w.xml_INSERT(COMP30, COMP31);
            w.xml_INSERT(CO1, COMP30);
        }
        //==========================================================================================
        if(getClinicalDocument().getFamilyHistoric().getContent() != null) {
            TAG COMP40 = w.xml_CREATE("component","");
            TAG COMP41 = w.xml_CREATE("section","");
            TAG COMP42 = w.xml_CREATE("title","Histórico familiar");
            TAG COMP43 = w.xml_CREATE("text","");
            TAG COMP44 = w.xml_CREATE("list","");
            TAG COMP45 = w.xml_CREATE("",w.xml_content(getClinicalDocument().getFamilyHistoric().getContent()));
            //==============================
            w.xml_INSERT(COMP44, COMP45);
            w.xml_INSERT(COMP43, COMP44);
            w.xml_INSERT(COMP41, COMP43);
            w.xml_INSERT(COMP41, COMP42);
            w.xml_INSERT(COMP40, COMP41);
            w.xml_INSERT(CO1,    COMP40);
        }
        //==========================================================================================
        if(getClinicalDocument().getExams().getContent() != null) {
            TAG COMP50 = w.xml_CREATE("component","");
            TAG COMP51 = w.xml_CREATE("section","");
            TAG COMP52 = w.xml_CREATE("title","Exame/Métrica físico");
            TAG COMP53 = w.xml_CREATE("text","");
            TAG COMP54 = w.xml_CREATE("list","");
            TAG COMP55 = w.xml_CREATE("",w.xml_content(getClinicalDocument().getExams().getContent()));
            //==============================
            w.xml_INSERT(COMP54, COMP55);
            w.xml_INSERT(COMP53, COMP54);
            w.xml_INSERT(COMP51, COMP53);
            w.xml_INSERT(COMP51, COMP52);
            w.xml_INSERT(COMP50, COMP51);
            w.xml_INSERT(CO1,    COMP50);
        }
        //==========================================================================================
        if(getClinicalDocument().getLaboratoryExams().getContent() != null) {
            TAG COMP60 = w.xml_CREATE("component","");
            TAG COMP61 = w.xml_CREATE("section classCode=\""+getClinicalDocument().getHealthHistoric().getSection()+"\" moodCode=\""+getClinicalDocument().getHealthHistoric().getMoodCode()+"\"","");
            TAG COMP62 = w.xml_CREATE("templateId root=\"2.16.840.1.113883."+getClinicalDocument().getLaboratoryExams().getId()+"\"","");  
            TAG COMP63 = w.xml_CREATE("code code=\""+getClinicalDocument().getLaboratoryExams().getCode()+"\" codeSystem=\""+getClinicalDocument().getHealthHistoric().getCodeSystem()+"\" codeSystemName=\""+getClinicalDocument().getHealthHistoric().getCodeName()+"\" displayName=\"Exames de laboratório\"",""); 
            TAG COMP64 =  w.xml_CREATE("title","Exames de laboratório");
            TAG COMP65 =  w.xml_CREATE("text","");
            TAG COMP66 =  w.xml_CREATE("list","");
            TAG COMP67 =  w.xml_CREATE("",w.xml_content(getClinicalDocument().getLaboratoryExams().getContent()));
            //==============================
            w.xml_INSERT(COMP66, COMP67);
            w.xml_INSERT(COMP65, COMP66);
            w.xml_INSERT(COMP61, COMP65);
            w.xml_INSERT(COMP61, COMP64);
            w.xml_INSERT(COMP61, COMP63);
            w.xml_INSERT(COMP61, COMP62);
            w.xml_INSERT(COMP60, COMP61);
            w.xml_INSERT(CO1,	COMP60);
        }
        //==========================================================================================
        if(getClinicalDocument().getDiagnostic().getContent() != null) {
            TAG COMP70 = w.xml_CREATE("component","");
            TAG COMP71 = w.xml_CREATE("section","");
            TAG COMP72 = w.xml_CREATE("title","Diagnóstico");
            TAG COMP73 = w.xml_CREATE("text","");
            TAG COMP74 = w.xml_CREATE("list","");
            TAG COMP75 = w.xml_CREATE("",w.xml_content(getClinicalDocument().getDiagnostic().getContent()));
            //==============================
            w.xml_INSERT(COMP74, COMP75);
            w.xml_INSERT(COMP73, COMP74);
            w.xml_INSERT(COMP71, COMP73);
            w.xml_INSERT(COMP71, COMP72);
            w.xml_INSERT(COMP70, COMP71);
            w.xml_INSERT(CO1,    COMP70);
        }
        //==========================================================================================
        if(getClinicalDocument().getTratament().getContent() != null) {
            TAG COMP80 = w.xml_CREATE("component","");
            TAG COMP81 = w.xml_CREATE("section","");
            TAG COMP82 = w.xml_CREATE("title","Tratamento");
            TAG COMP83 = w.xml_CREATE("text","");
            TAG COMP84 = w.xml_CREATE("list","");
            TAG COMP85 = w.xml_CREATE("",w.xml_content(getClinicalDocument().getTratament().getContent()));
            //==============================
            w.xml_INSERT(COMP84, COMP85);
            w.xml_INSERT(COMP83, COMP84);
            w.xml_INSERT(COMP81, COMP83);
            w.xml_INSERT(COMP81, COMP82);
            w.xml_INSERT(COMP80, COMP81);
            w.xml_INSERT(CO1,    COMP80);
        }
        //==============================
        w.xml_INSERT(CO0, CO1);

        w.xml_INSERT(CO1, CO2);

        
        //==============================
        w.xml_INSERT(P15,P16);
        w.xml_INSERT(P20,P15);
        w.xml_INSERT(P12,P14);
        w.xml_INSERT(P12,P13);
        w.xml_INSERT(P11,P12);
        w.xml_INSERT(P3,P11);
        w.xml_INSERT(P3,P10);
        w.xml_INSERT(P3,P9);
        w.xml_INSERT(P3,P8);
        w.xml_INSERT(P3,P7);
        w.xml_INSERT(P3,P6);
        w.xml_INSERT(P3,P5);
        w.xml_INSERT(P4,P18);
        w.xml_INSERT(P4,P17);
        w.xml_INSERT(P3, P4);
        w.xml_INSERT(P20,P3);
        w.xml_INSERT(P20,P2);
        w.xml_INSERT(P20,P1);
        w.xml_INSERT(P20,P0);
        w.xml_INSERT(P19,P20);
        //==============================
        w.xml_INSERT(A7, A9);
        w.xml_INSERT(A7, A8);
        w.xml_INSERT(A6, A7);
        w.xml_INSERT(A2, A6);
        w.xml_INSERT(A2, A5);
        w.xml_INSERT(A2, A4);
        w.xml_INSERT(A2, A3);
        w.xml_INSERT(A0, A2);
        w.xml_INSERT(A0, A1);
        //==============================
        w.xml_INSERT(CS2, CS4);
        w.xml_INSERT(CS2, CS3);
        w.xml_INSERT(CS1, CS2);
        w.xml_INSERT(CS0, CS1);
        //==============================
        w.xml_INSERT(R1, R4);
        w.xml_INSERT(R1, R3);
        w.xml_INSERT(R1, R2);
        w.xml_INSERT(R0, R1);
        //==============================
        w.xml_INSERT(CD,CO0);
        w.xml_INSERT(CD,OFF0);
        w.xml_INSERT(CD,R0);
        w.xml_INSERT(CD,L0);
        w.xml_INSERT(CD,CS0);
        w.xml_INSERT(CD,A0);
        w.xml_INSERT(CD,P19);
        //==============================
        w.xml_INSERT(CD,C10);
        w.xml_INSERT(CD,C9);
        w.xml_INSERT(CD,C8);
        w.xml_INSERT(CD,C7);
        w.xml_INSERT(CD,C6);
        w.xml_INSERT(CD,C5);
        w.xml_INSERT(CD,C4);
        w.xml_INSERT(CD,C3);
        w.xml_INSERT(CD,C2);
        w.xml_INSERT(CD,C1);

        //DELETES FILE CDA TO OVERWRITE A NEW
        w.xml_CLEAN(getFile());

        try (FileWriter fw = new FileWriter(getFile(),true);){
            fw.write("<?xml version='1.0' encoding='UTF-8'?>");
            //GENERATES XML FILE
            w.xml_PRINT(CD,fw);
            fw.close();
            System.out.println("Success when writing file\n");
            return true;
        }catch(Exception ex){
            System.err.println("Error writing file:\n"+ex);
            return false;
        }
    }
}