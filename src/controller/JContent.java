package controller;

import br.com.multcare.bean.*;
import controller.XMLTree.TAG;
import java.io.FileWriter;

/**
 * Classe que contém a interface do documento CDA, representado em XML.
 * @author Gyovanne
 */
public class JContent extends Implements {

    private final XMLTree w;

    public JContent(String local, Header header, Patient patient, Author author, Authenticator authentic, Related related, ResponsibleParty responsible, HealthHistoric historic, DoctorHistoric dhistoric, Medicines medicines, Allergy allergy, FamilyHistoric fhistoric, Exams exams, LaboratoryExams laboratory, Diagnostic diagnostic, Tratament tratament) {
        super(local, header, patient, author, authentic, related, responsible, historic, dhistoric, medicines, allergy, fhistoric, exams, laboratory, diagnostic, tratament);
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
        TAG C1 = w.xml_CREATE("realmCode code='"+header.getRealmCode()+"'","");
        TAG C2 = w.xml_CREATE("typeId root='2.16.840.1.113883.1.3' extension='POCD_HD000040'","");/*+h.getTypeid()+*/	/*+h.getExtension1()+*/
        TAG C3 = w.xml_CREATE("templateId root='2.16.840.1.113883.10.20.1'","");/*+h.getTemplate()+*/
        TAG C4 = w.xml_CREATE("id root='"+header.getIdRoot()+"' extension='"+header.getExtension2()+"'","");
        TAG C5 = w.xml_CREATE("code code='"+header.getCode()+"' displayName='Diagnostico utilizando Multcare' codeSystem='2.16.840.1.113883.6.103' codeSystemName='ICD-9-CM'","");
        TAG C6 = w.xml_CREATE("effectiveTime value=\""+header.getEfetiveTime()+"\"","");
        TAG C7 = w.xml_CREATE("confidentialityCode code=\"N\" displayName='Normal' codeSystem='2.16.840.1.113883.5.25' codeSystemName='Confidentiality'","");
        TAG C8 = w.xml_CREATE("setId extension=\""+header.getId()+"\" root=\""+header.getExtension2()+"\"","");
        TAG C9 = w.xml_CREATE("versionNumber value=\""+header.getVersion()+"\"","");
        TAG C10 =w.xml_CREATE("copyTime value='"+header.getEfetiveTime()+"'","");
        //==========================================================================================
        //STRUCTURE PATIENT
        TAG P19 =w.xml_CREATE("recordTarget","");
        TAG P20 =w.xml_CREATE("patientRole","");
        TAG P0 = w.xml_CREATE("id extension=\""+patient.getId()+"\" root=\""+header.getExtension2()+"\"","");
        TAG P1 = w.xml_CREATE("addr",""+patient.getAddr()+"");
        TAG P2 = w.xml_CREATE("telecom value=\""+patient.getPhone()+"\"","");
        TAG P3 = w.xml_CREATE("patient","");
        TAG P4 = w.xml_CREATE("name","");
        TAG P17 =w.xml_CREATE("given",""+patient.getName()+"");
        TAG P18 =w.xml_CREATE("family",""+patient.getFamily()+"");
        TAG P5 = w.xml_CREATE("administrativeGenderCode code=\""+patient.getAdmin()+"\" codeSystem=\""+patient.getCodeSystem()+"\"",""); 
        TAG P6 = w.xml_CREATE("birthTime value=\""+patient.getBirth()+"\"","");
        TAG P7 = w.xml_CREATE("maritalStatusCode code='"+patient.getMaritalStatus()+"'","");
        TAG P8 = w.xml_CREATE("religiousAffiliationCode code='"+patient.getReligious()+"'","");
        TAG P9 = w.xml_CREATE("raceCode code='"+patient.getRace()+"'","");
        TAG P10 =w.xml_CREATE("ethnicGroupCode code='"+patient.getEthnicGroup()+"'","");
        TAG P11 =w.xml_CREATE("birthplace","");
        TAG P12 =w.xml_CREATE("place","");
        TAG P13 =w.xml_CREATE("name",""+patient.getBirthPlace()+"");
        TAG P14 =w.xml_CREATE("addr", ""+patient.getAddrBirthPlace()+"");
        TAG P15 =w.xml_CREATE("providerOrganization","");
        TAG P16 =w.xml_CREATE("id extension=\""+patient.getIdExtension()+"\" root=\""+header.getExtension2()+"\"","");
        //STRUCTURE AUTHOR
        //==========================================================================================
        TAG A0 = w.xml_CREATE("author","");
        TAG A1 = w.xml_CREATE("time value = \""+header.getEfetiveTime()+"\"", "");
        TAG A2 = w.xml_CREATE("assignedAuthor","");
        TAG A3 = w.xml_CREATE("id root='"+header.getExtension2()+"' extension='"+author.getCrm()+"'", "");
        TAG A4 = w.xml_CREATE("addr", ""+author.getAddr()+"");
        TAG A5 = w.xml_CREATE("telecom value = '"+author.getPhone()+"'","");
        TAG A6 = w.xml_CREATE("assignedPerson", "");
        TAG A7 = w.xml_CREATE("name","");
        TAG A8 = w.xml_CREATE("given",""+author.getName()+"");
        TAG A9 = w.xml_CREATE("family",""+author.getFamily()+"");
        //==========================================================================================
        TAG CS0 = w.xml_CREATE("custodian", "");
        TAG CS1 = w.xml_CREATE("assignedCustodian","");
        TAG CS2 = w.xml_CREATE("representedCustodianOrganization","");
        TAG CS3 = w.xml_CREATE("id extension=\""+patient.getId()+"\" root=\""+header.getExtension2()+"\"", "");
        TAG CS4 = w.xml_CREATE("name", "MultCare");
        //==========================================================================================
        TAG L0 = w.xml_CREATE("legalAuthenticator", "");
        TAG L1 = w.xml_CREATE("time value=\""+header.getEfetiveTime()+"\"", "");
        TAG L2 = w.xml_CREATE("signatureCode code=\""+authentic.getCode()+"\"","");
        TAG L3 = w.xml_CREATE("assignedEntity", "");
        TAG L4 = w.xml_CREATE("id extension=\""+patient.getIdExtension()+"\" root=\""+header.getExtension2()+"\"","");
        TAG L5 = w.xml_CREATE("assignedPerson","");
        TAG L6 = w.xml_CREATE("name","");
        TAG L7 = w.xml_CREATE("given", ""+author.getName()+"");
        TAG L8 = w.xml_CREATE("family",""+author.getFamily()+"");
        //==========================================================================================
        TAG R0 = w.xml_CREATE("relatedDocument typeCode=\""+related.getCode()+"\"", "");
        TAG R1 = w.xml_CREATE("parentDocument","");
        TAG R2 = w.xml_CREATE("id extension=\""+related.getId()+"\" root=\""+header.getExtension2()+"\"", "");
        TAG R3 = w.xml_CREATE("setId extension=\""+related.getExtension()+"\" root=\""+header.getExtension2()+"\"", "");
        TAG R4 = w.xml_CREATE("versionNumber value=\""+related.getVersion()+"\"", "");
        //=====================================================================================
        TAG OFF0 =w.xml_CREATE("componentOf","");
        TAG OFF1 =w.xml_CREATE("encompassingEncounter", "");
        TAG OFF2 =w.xml_CREATE("id root=\""+responsibleParty.getIdRoot()+"\" extension=\""+responsibleParty.getExtension()+"\"", "");
        TAG OFF3 =w.xml_CREATE("effectiveTime value=\""+responsibleParty.getDate()+"\"","");
        TAG OFF4 =w.xml_CREATE("responsibleParty","");
        TAG OFF5 =w.xml_CREATE("assignedEntity", "");
        TAG OFF6 =w.xml_CREATE("id nullFlavor=\""+responsibleParty.getId()+"\"", "");
        TAG OFF7 =w.xml_CREATE("addr","");
        TAG OFF8 =w.xml_CREATE("state", ""+responsibleParty.getState()+"");
        TAG OFF9 =w.xml_CREATE("city",""+responsibleParty.getCity()+"");
        TAG OFF10 =w.xml_CREATE("postalCode", ""+responsibleParty.getPostal()+"");
        TAG OFF11 =w.xml_CREATE("streetAddressLine", ""+responsibleParty.getStreet()+"");
        TAG OFF12 =w.xml_CREATE("telecom value=\"tel:"+responsibleParty.getPhone()+"\" use=\""+responsibleParty.getUse()+"\"", "");
        TAG OFF13 =w.xml_CREATE("assignedPerson", "");
        TAG OFF14 =w.xml_CREATE("name","");
        TAG OFF15 =w.xml_CREATE("family", ""+responsibleParty.getFamily()+"");
        TAG OFF16 =w.xml_CREATE("given", ""+responsibleParty.getName1()+"");
        TAG OFF17 =w.xml_CREATE("given", ""+responsibleParty.getName2()+"");
        TAG OFF18 =w.xml_CREATE("suffix", ""+responsibleParty.getSuffixe()+"");
        TAG OFF19 =w.xml_CREATE("location","");
        TAG OFF20 =w.xml_CREATE("healthCareFacility", "");
        TAG OFF21 =w.xml_CREATE("id root=\""+responsibleParty.getIdRoot()+"\" extension=\""+responsibleParty.getExtension()+"\"", "");
        TAG OFF22 =w.xml_CREATE("location","");
        TAG OFF23 =w.xml_CREATE("name", ""+responsibleParty.getLocation()+"");
        TAG OFF24 =w.xml_CREATE("addr", "");
        TAG OFF25 =w.xml_CREATE("state", ""+responsibleParty.getState()+"");
        TAG OFF26 =w.xml_CREATE("city",""+responsibleParty.getCity()+"");
        TAG OFF27 =w.xml_CREATE("postalCode", ""+responsibleParty.getPostal()+"");
        TAG OFF28 =w.xml_CREATE("streetAddressLine",""+responsibleParty.getStreet()+"");
        //==========================================================================================
        //STRUCTURE DOCTOR HISTORIC
        TAG CO0 =	w.xml_CREATE("component", "");
        TAG CO1 =	w.xml_CREATE("structuredBody", "");
        TAG CO2 =	w.xml_CREATE("languageCode code=\'pt-BR\'","");

        if(healthHistoric.getCode() != null) {
            TAG CO3 = 	w.xml_CREATE("component", "");
            TAG CO4 = 	w.xml_CREATE("section classCode=\""+healthHistoric.getSection()+"\" moodCode=\""+healthHistoric.getMoodCode()+"\"","");
            TAG CO5 = 	w.xml_CREATE("templateId root=\""+healthHistoric.getTemplateId()+"\"", ""); 
            TAG CO6 = 	w.xml_CREATE("code code=\""+healthHistoric.getCode()+"\" codeSystem=\""+healthHistoric.getCodeSystem()+"\" codeSystemName=\""+healthHistoric.getCodeName()+"\" displayName=\"Problema atual\"","");
            TAG CO7 =	w.xml_CREATE("title", "Histórico da doença atual"); 
            TAG CO8 =	w.xml_CREATE("text", ""+healthHistoric.getText()+"");
            //==============================
            w.xml_INSERT(CO4, CO8);
            w.xml_INSERT(CO4, CO7);
            w.xml_INSERT(CO4, CO6);
            w.xml_INSERT(CO4, CO5);
            w.xml_INSERT(CO3, CO4);
            w.xml_INSERT(CO1, CO3);
        }
        //==========================================================================================
        if(doctorHistoric.getContent() != null) {
            TAG COMP10 = w.xml_CREATE("component","");
            TAG COMP11 = w.xml_CREATE("section","");
            TAG COMP12 = w.xml_CREATE("title","Histórico médico passado");
            TAG COMP13 = w.xml_CREATE("text","");
            TAG COMP14 = w.xml_CREATE("list","");
            TAG COMP15 = w.xml_CREATE("",w.xml_content(doctorHistoric.getContent()));
            //==============================
            w.xml_INSERT(COMP14, COMP15);
            w.xml_INSERT(COMP13, COMP14);
            w.xml_INSERT(COMP11, COMP13);
            w.xml_INSERT(COMP11, COMP12);
            w.xml_INSERT(COMP10, COMP11);
            w.xml_INSERT(CO1,    COMP10);
        }
        //==========================================================================================
        if(medicines.getContent() != null) {
            TAG COMP20 = w.xml_CREATE("component","");
            TAG COMP21 = w.xml_CREATE("section","");
            TAG COMP22 = w.xml_CREATE("title","Medicamentos");
            TAG COMP23 = w.xml_CREATE("text","");
            TAG COMP24 = w.xml_CREATE("list","");
            TAG COMP25 = w.xml_CREATE("",w.xml_content(medicines.getContent()));
            //==============================
            w.xml_INSERT(COMP24, COMP25);
            w.xml_INSERT(COMP23, COMP24);
            w.xml_INSERT(COMP21, COMP23);
            w.xml_INSERT(COMP21, COMP22);
            w.xml_INSERT(COMP20, COMP21);
            w.xml_INSERT(CO1,    COMP20);
        }
        //==========================================================================================
        if(allergy.getContent() != null) {
            TAG COMP30 = w.xml_CREATE("component","");
            TAG COMP31 = w.xml_CREATE("section classCode=\""+healthHistoric.getSection()+"\" moodCode=\""+healthHistoric.getMoodCode()+"\"","");
            TAG COMP32 = w.xml_CREATE("title","Alergias");
            TAG COMP33 = w.xml_CREATE("text","");
            TAG COMP34 = w.xml_CREATE("list","");
            TAG COMP35 = w.xml_CREATE("",w.xml_content(allergy.getContent()));
            //==============================
            w.xml_INSERT(COMP34, COMP35);
            w.xml_INSERT(COMP33, COMP34);
            w.xml_INSERT(COMP31, COMP33);
            w.xml_INSERT(COMP31, COMP32);
            w.xml_INSERT(COMP30, COMP31);
            w.xml_INSERT(CO1, COMP30);
        }
        //==========================================================================================
        if(familyHistoric.getContent() != null) {
            TAG COMP40 = w.xml_CREATE("component","");
            TAG COMP41 = w.xml_CREATE("section","");
            TAG COMP42 = w.xml_CREATE("title","Histórico familiar");
            TAG COMP43 = w.xml_CREATE("text","");
            TAG COMP44 = w.xml_CREATE("list","");
            TAG COMP45 = w.xml_CREATE("",w.xml_content(familyHistoric.getContent()));
            //==============================
            w.xml_INSERT(COMP44, COMP45);
            w.xml_INSERT(COMP43, COMP44);
            w.xml_INSERT(COMP41, COMP43);
            w.xml_INSERT(COMP41, COMP42);
            w.xml_INSERT(COMP40, COMP41);
            w.xml_INSERT(CO1,    COMP40);
        }
        //==========================================================================================
        if(exams.getContent() != null) {
            TAG COMP50 = w.xml_CREATE("component","");
            TAG COMP51 = w.xml_CREATE("section","");
            TAG COMP52 = w.xml_CREATE("title","Exame/Métrica físico");
            TAG COMP53 = w.xml_CREATE("text","");
            TAG COMP54 = w.xml_CREATE("list","");
            TAG COMP55 = w.xml_CREATE("",w.xml_content(exams.getContent()));
            //==============================
            w.xml_INSERT(COMP54, COMP55);
            w.xml_INSERT(COMP53, COMP54);
            w.xml_INSERT(COMP51, COMP53);
            w.xml_INSERT(COMP51, COMP52);
            w.xml_INSERT(COMP50, COMP51);
            w.xml_INSERT(CO1,    COMP50);
        }
        //==========================================================================================
        if(laboratoryExams.getContent() != null) {
            TAG COMP60 = w.xml_CREATE("component","");
            TAG COMP61 = w.xml_CREATE("section classCode=\""+healthHistoric.getSection()+"\" moodCode=\""+healthHistoric.getMoodCode()+"\"","");
            TAG COMP62 = w.xml_CREATE("templateId root=\"2.16.840.1.113883."+laboratoryExams.getId()+"\"","");  
            TAG COMP63 = w.xml_CREATE("code code=\""+laboratoryExams.getCode()+"\" codeSystem=\""+healthHistoric.getCodeSystem()+"\" codeSystemName=\""+healthHistoric.getCodeName()+"\" displayName=\"Exames de laboratório\"",""); 
            TAG COMP64 =  w.xml_CREATE("title","Exames de laboratório");
            TAG COMP65 =  w.xml_CREATE("text","");
            TAG COMP66 =  w.xml_CREATE("list","");
            TAG COMP67 =  w.xml_CREATE("",w.xml_content(laboratoryExams.getContent()));
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
        if(diagnostic.getContent() != null) {
            TAG COMP70 = w.xml_CREATE("component","");
            TAG COMP71 = w.xml_CREATE("section","");
            TAG COMP72 = w.xml_CREATE("title","Diagnóstico");
            TAG COMP73 = w.xml_CREATE("text","");
            TAG COMP74 = w.xml_CREATE("list","");
            TAG COMP75 = w.xml_CREATE("",w.xml_content(diagnostic.getContent()));
            //==============================
            w.xml_INSERT(COMP74, COMP75);
            w.xml_INSERT(COMP73, COMP74);
            w.xml_INSERT(COMP71, COMP73);
            w.xml_INSERT(COMP71, COMP72);
            w.xml_INSERT(COMP70, COMP71);
            w.xml_INSERT(CO1,    COMP70);
        }
        //==========================================================================================
        if(tratament.getContent() != null) {
            TAG COMP80 = w.xml_CREATE("component","");
            TAG COMP81 = w.xml_CREATE("section","");
            TAG COMP82 = w.xml_CREATE("title","Tratamento");
            TAG COMP83 = w.xml_CREATE("text","");
            TAG COMP84 = w.xml_CREATE("list","");
            TAG COMP85 = w.xml_CREATE("",w.xml_content(tratament.getContent()));
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
        w.xml_INSERT(L6, L8);
        w.xml_INSERT(L6, L7);
        w.xml_INSERT(L5, L6);
        w.xml_INSERT(L3, L5);
        w.xml_INSERT(L3, L4);
        w.xml_INSERT(L0,L3);
        w.xml_INSERT(L0, L2);
        w.xml_INSERT(L0, L1);
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
        w.xml_CLEAN(local);
        
        try (FileWriter fw = new FileWriter(local,true);){
            fw.write("<?xml version='1.0' encoding='UTF-8'?>");
            //GENERATES XML FILE
            w.xml_PRINT(CD,fw);
            fw.close();
            return true;
        }catch(Exception ex){
            System.err.println(ex);
            return false;
        }
    }
}