package controller;

import br.com.CDApi.ClinicalDocument;
import controller.XMLConstruction.TAG;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe que contém o conteúdo do documento CDA, representado em XML.
 * @author Gyovanne Cavalcanti
 */
public class DocumentStructure {

    private final XMLConstruction xmlc;
    private final File file; 
    private final ClinicalDocument clinicalDocument;

    private File getFile() {
        return file;
    }

    private ClinicalDocument getClinicalDocument() {
        return clinicalDocument;
    }

    public DocumentStructure(File file, ClinicalDocument clinicalDocument) {
        this.file = file;
        this.clinicalDocument = clinicalDocument;
        this.xmlc = new XMLConstruction();
    }

    public boolean generateContent() {
        //STRUCTURE HEADER
        //==========================================================================================
        TAG rootTag = xmlc.xmlCreate("ClinicalDocument xmlns=\"urn:hl7-org:v3\" xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' classCode='DOCCLIN'","");

        TAG h[] = new TAG[10];
        h[0] = xmlc.xmlCreate("realmCode code='"+getClinicalDocument().getHeader().getRealmCode()+"'","");
        h[1] = xmlc.xmlCreate("typeId root='2.16.840.1.113883.1.3' extension='POCD_HD000040'","");
        h[2] = xmlc.xmlCreate("templateId root='2.16.840.1.113883.10.20.1'","");
        h[3] = xmlc.xmlCreate("id root='"+getClinicalDocument().getHeader().getIdRoot()+"' extension='"+getClinicalDocument().getHeader().getExtension()+"'","");
        h[4] = xmlc.xmlCreate("code code='"+getClinicalDocument().getHeader().getCode()+"' displayName='"+getClinicalDocument().getHeader().getDisplayName()+"' codeSystem='"+getClinicalDocument().getHeader().getCodeSystem()+"' codeSystemName='"+getClinicalDocument().getHeader().getCodeSystemName()+"'","");
        h[5] = xmlc.xmlCreate("effectiveTime value=\""+getClinicalDocument().getHeader().getEfetiveTime()+"\"","");
        h[6] = xmlc.xmlCreate("confidentialityCode code=\"N\" displayName='Normal' codeSystem='2.16.840.1.113883.5.25' codeSystemName='Confidentiality'","");
        h[7] = xmlc.xmlCreate("setId extension=\""+getClinicalDocument().getHeader().getId()+"\" root=\""+getClinicalDocument().getHeader().getExtension()+"\"","");
        h[8] = xmlc.xmlCreate("versionNumber value=\""+getClinicalDocument().getHeader().getVersion()+"\"","");
        h[9] =xmlc.xmlCreate("copyTime value='"+getClinicalDocument().getHeader().getEfetiveTime()+"'","");
        //==========================================================================================
        //STRUCTURE PATIENT
        TAG P19 =xmlc.xmlCreate("recordTarget","");
        TAG P20 =xmlc.xmlCreate("patientRole","");
        TAG P0 = xmlc.xmlCreate("id extension=\""+getClinicalDocument().getPatient().getId()+"\" root=\""+getClinicalDocument().getHeader().getExtension()+"\"","");
        TAG P1 = xmlc.xmlCreate("addr",""+getClinicalDocument().getPatient().getAddr()+"");
        TAG P2 = xmlc.xmlCreate("telecom value=\""+getClinicalDocument().getPatient().getPhone()+"\"","");
        TAG P3 = xmlc.xmlCreate("patient","");
        TAG P4 = xmlc.xmlCreate("name","");
        TAG P17 =xmlc.xmlCreate("given",""+getClinicalDocument().getPatient().getName()+"");
        TAG P18 =xmlc.xmlCreate("family",""+getClinicalDocument().getPatient().getFamily()+"");
        TAG P5 = xmlc.xmlCreate("administrativeGenderCode code=\""+getClinicalDocument().getPatient().getAdmin()+"\" codeSystem=\""+getClinicalDocument().getPatient().getCodeSystem()+"\"",""); 
        TAG P6 = xmlc.xmlCreate("birthTime value=\""+getClinicalDocument().getPatient().getBirth()+"\"","");
        TAG P7 = xmlc.xmlCreate("maritalStatusCode code='"+getClinicalDocument().getPatient().getMaritalStatus()+"'","");
        TAG P8 = xmlc.xmlCreate("religiousAffiliationCode code='"+getClinicalDocument().getPatient().getReligious()+"'","");
        TAG P9 = xmlc.xmlCreate("raceCode code='"+getClinicalDocument().getPatient().getRace()+"'","");
        TAG P10 =xmlc.xmlCreate("ethnicGroupCode code='"+getClinicalDocument().getPatient().getEthnicGroup()+"'","");
        TAG P11 =xmlc.xmlCreate("birthplace","");
        TAG P12 =xmlc.xmlCreate("place","");
        TAG P13 =xmlc.xmlCreate("name",""+getClinicalDocument().getPatient().getBirthPlace()+"");
        TAG P14 =xmlc.xmlCreate("addr", ""+getClinicalDocument().getPatient().getAddrBirthPlace()+"");
        TAG P15 =xmlc.xmlCreate("providerOrganization","");
        TAG P16 =xmlc.xmlCreate("id extension=\""+getClinicalDocument().getPatient().getIdExtension()+"\" root=\""+getClinicalDocument().getHeader().getExtension()+"\"","");
        //STRUCTURE AUTHOR
        //==========================================================================================
        TAG A0 = xmlc.xmlCreate("author","");
        TAG A1 = xmlc.xmlCreate("time value = \""+getClinicalDocument().getHeader().getEfetiveTime()+"\"", "");
        TAG A2 = xmlc.xmlCreate("assignedAuthor","");
        TAG A3 = xmlc.xmlCreate("id root='"+getClinicalDocument().getHeader().getExtension()+"' extension='"+getClinicalDocument().getAuthor().getCrm()+"'", "");
        TAG A4 = xmlc.xmlCreate("addr", ""+getClinicalDocument().getAuthor().getAddr()+"");
        TAG A5 = xmlc.xmlCreate("telecom value = '"+getClinicalDocument().getAuthor().getPhone()+"'","");
        TAG A6 = xmlc.xmlCreate("assignedPerson", "");
        TAG A7 = xmlc.xmlCreate("name","");
        TAG A8 = xmlc.xmlCreate("given",""+getClinicalDocument().getAuthor().getName()+"");
        TAG A9 = xmlc.xmlCreate("family",""+getClinicalDocument().getAuthor().getFamily()+"");
        //==========================================================================================
        TAG CS0 = xmlc.xmlCreate("custodian", "");
        TAG CS1 = xmlc.xmlCreate("assignedCustodian","");
        TAG CS2 = xmlc.xmlCreate("representedCustodianOrganization","");
        TAG CS3 = xmlc.xmlCreate("id extension=\""+getClinicalDocument().getPatient().getId()+"\" root=\""+getClinicalDocument().getHeader().getExtension()+"\"", "");
        TAG CS4 = xmlc.xmlCreate("name", ""+getClinicalDocument().getHeader().getDisplayName()+"");
        //==========================================================================================

        TAG L0 = xmlc.xmlCreate("legalAuthenticator", "");

        TAG L1 = xmlc.xmlCreate("time value=\""+getClinicalDocument().getHeader().getEfetiveTime()+"\"", "");
        TAG L2 = xmlc.xmlCreate("signatureCode code=\""+getClinicalDocument().getAuthenticator().getCode()+"\"","");
        TAG L3 = xmlc.xmlCreate("assignedEntity", "");
        TAG L4 = xmlc.xmlCreate("id extension=\""+getClinicalDocument().getPatient().getIdExtension()+"\" root=\""+getClinicalDocument().getHeader().getExtension()+"\"","");
        TAG L5 = xmlc.xmlCreate("assignedPerson","");
        TAG L6 = xmlc.xmlCreate("name","");
        TAG L7 = xmlc.xmlCreate("given", ""+getClinicalDocument().getAuthor().getName()+"");
        TAG L8 = xmlc.xmlCreate("family",""+getClinicalDocument().getAuthor().getFamily()+"");
                //==============================
        xmlc.xmlInsert(L6, L8);
        xmlc.xmlInsert(L6, L7);
        xmlc.xmlInsert(L5, L6);
        xmlc.xmlInsert(L3, L5);
        xmlc.xmlInsert(L3, L4);
        xmlc.xmlInsert(L0,L3);
        xmlc.xmlInsert(L0, L2);
        xmlc.xmlInsert(L0, L1);
        //==========================================================================================
        TAG R0 = xmlc.xmlCreate("relatedDocument typeCode=\""+getClinicalDocument().getRelated().getCode()+"\"", "");
        TAG R1 = xmlc.xmlCreate("parentDocument","");
        TAG R2 = xmlc.xmlCreate("id extension=\""+getClinicalDocument().getRelated().getId()+"\" root=\""+getClinicalDocument().getHeader().getExtension()+"\"", "");
        TAG R3 = xmlc.xmlCreate("setId extension=\""+getClinicalDocument().getRelated().getExtension()+"\" root=\""+getClinicalDocument().getHeader().getExtension()+"\"", "");
        TAG R4 = xmlc.xmlCreate("versionNumber value=\""+getClinicalDocument().getRelated().getVersion()+"\"", "");
        //=====================================================================================

        TAG OFF0 =xmlc.xmlCreate("componentOf","");

        TAG OFF1 =xmlc.xmlCreate("encompassingEncounter", "");
        TAG OFF2 =xmlc.xmlCreate("id root=\""+getClinicalDocument().getResponsibleParty().getIdRoot()+"\" extension=\""+getClinicalDocument().getResponsibleParty().getExtension()+"\"", "");
        TAG OFF3 =xmlc.xmlCreate("effectiveTime value=\""+getClinicalDocument().getResponsibleParty().getDate()+"\"","");
        TAG OFF4 =xmlc.xmlCreate("responsibleParty","");
        TAG OFF5 =xmlc.xmlCreate("assignedEntity", "");
        TAG OFF6 =xmlc.xmlCreate("id nullFlavor=\""+getClinicalDocument().getResponsibleParty().getId()+"\"", "");
        TAG OFF7 =xmlc.xmlCreate("addr","");
        TAG OFF8 =xmlc.xmlCreate("state", ""+getClinicalDocument().getResponsibleParty().getState()+"");
        TAG OFF9 =xmlc.xmlCreate("city",""+getClinicalDocument().getResponsibleParty().getCity()+"");
        TAG OFF10 =xmlc.xmlCreate("postalCode", ""+getClinicalDocument().getResponsibleParty().getPostal()+"");
        TAG OFF11 =xmlc.xmlCreate("streetAddressLine", ""+getClinicalDocument().getResponsibleParty().getStreet()+"");
        TAG OFF12 =xmlc.xmlCreate("telecom value=\"tel:"+getClinicalDocument().getResponsibleParty().getPhone()+"\" use=\""+getClinicalDocument().getResponsibleParty().getUse()+"\"", "");
        TAG OFF13 =xmlc.xmlCreate("assignedPerson", "");
        TAG OFF14 =xmlc.xmlCreate("name","");
        TAG OFF15 =xmlc.xmlCreate("family", ""+getClinicalDocument().getResponsibleParty().getFamily()+"");
        TAG OFF16 =xmlc.xmlCreate("given", ""+getClinicalDocument().getResponsibleParty().getName()+"");
        TAG OFF17 =xmlc.xmlCreate("given", ""+getClinicalDocument().getResponsibleParty().getName2()+"");
        TAG OFF18 =xmlc.xmlCreate("suffix", ""+getClinicalDocument().getResponsibleParty().getSuffixe()+"");
        TAG OFF19 =xmlc.xmlCreate("location","");
        TAG OFF20 =xmlc.xmlCreate("healthCareFacility", "");
        TAG OFF21 =xmlc.xmlCreate("id root=\""+getClinicalDocument().getResponsibleParty().getIdRoot()+"\" extension=\""+getClinicalDocument().getResponsibleParty().getExtension()+"\"", "");
        TAG OFF22 =xmlc.xmlCreate("location","");
        TAG OFF23 =xmlc.xmlCreate("name", ""+getClinicalDocument().getResponsibleParty().getLocation()+"");
        TAG OFF24 =xmlc.xmlCreate("addr", "");
        TAG OFF25 =xmlc.xmlCreate("state", ""+getClinicalDocument().getResponsibleParty().getState()+"");
        TAG OFF26 =xmlc.xmlCreate("city",""+getClinicalDocument().getResponsibleParty().getCity()+"");
        TAG OFF27 =xmlc.xmlCreate("postalCode", ""+getClinicalDocument().getResponsibleParty().getPostal()+"");
        TAG OFF28 =xmlc.xmlCreate("streetAddressLine",""+getClinicalDocument().getResponsibleParty().getStreet()+"");

        xmlc.xmlInsert(OFF24,OFF28);
        xmlc.xmlInsert(OFF24,OFF27);
        xmlc.xmlInsert(OFF24,OFF26);
        xmlc.xmlInsert(OFF24,OFF25);
        xmlc.xmlInsert(OFF22,OFF24);
        xmlc.xmlInsert(OFF22,OFF23);
        xmlc.xmlInsert(OFF20,OFF22);
        xmlc.xmlInsert(OFF20,OFF21);
        xmlc.xmlInsert(OFF19,OFF20);
        xmlc.xmlInsert(OFF14,OFF18);
        xmlc.xmlInsert(OFF14,OFF17);
        xmlc.xmlInsert(OFF14,OFF16);
        xmlc.xmlInsert(OFF14,OFF15);
        xmlc.xmlInsert(OFF13,OFF14);
        xmlc.xmlInsert(OFF7, OFF11);
        xmlc.xmlInsert(OFF7, OFF10);
        xmlc.xmlInsert(OFF7, OFF9);
        xmlc.xmlInsert(OFF7, OFF8);
        xmlc.xmlInsert(OFF5, OFF13);
        xmlc.xmlInsert(OFF5, OFF12);
        xmlc.xmlInsert(OFF5, OFF7);
        xmlc.xmlInsert(OFF5, OFF6);
        xmlc.xmlInsert(OFF4, OFF5);
        xmlc.xmlInsert(OFF1, OFF19);
        xmlc.xmlInsert(OFF1, OFF4);
        xmlc.xmlInsert(OFF1, OFF3);
        xmlc.xmlInsert(OFF1, OFF2);
        xmlc.xmlInsert(OFF0, OFF1);
        //==========================================================================================
        //STRUCTURE DOCTOR HISTORIC
        TAG CO0 =	xmlc.xmlCreate("component", "");
        TAG CO1 =	xmlc.xmlCreate("structuredBody", "");
        TAG CO2 =	xmlc.xmlCreate("languageCode code=\'pt-BR\'","");
        TAG CO3 = 	xmlc.xmlCreate("component", "");
        TAG CO4 = 	xmlc.xmlCreate("section classCode=\""+getClinicalDocument().getHealthHistoric().getSection()+"\" moodCode=\""+getClinicalDocument().getHealthHistoric().getMoodCode()+"\"","");
        TAG CO5 = 	xmlc.xmlCreate("templateId root=\""+getClinicalDocument().getHealthHistoric().getTemplateId()+"\"", ""); 
        TAG CO6 = 	xmlc.xmlCreate("code code=\""+getClinicalDocument().getHealthHistoric().getCode()+"\" codeSystem=\""+getClinicalDocument().getHealthHistoric().getCodeSystem()+"\" codeSystemName=\""+getClinicalDocument().getHealthHistoric().getCodeName()+"\" displayName=\"Problema atual\"","");
        TAG CO7 =	xmlc.xmlCreate("title", "Histórico da doença atual"); 
        TAG CO8 =	xmlc.xmlCreate("text", ""+getClinicalDocument().getHealthHistoric().getText()+"");
        //==============================
        xmlc.xmlInsert(CO4, CO8);
        xmlc.xmlInsert(CO4, CO7);
        xmlc.xmlInsert(CO4, CO6);
        xmlc.xmlInsert(CO4, CO5);
        xmlc.xmlInsert(CO3, CO4);
        xmlc.xmlInsert(CO1, CO3);
        //==============================
        TAG COMP10 = xmlc.xmlCreate("component","");
        TAG COMP11 = xmlc.xmlCreate("section","");
        TAG COMP12 = xmlc.xmlCreate("title","Histórico médico passado");
        TAG COMP13 = xmlc.xmlCreate("text","");
        TAG COMP14 = xmlc.xmlCreate("list","");
        TAG COMP15 = xmlc.xmlCreate("",xmlc.xmlContent(getClinicalDocument().getDoctorHistoric().getContent()));
        //==============================
        xmlc.xmlInsert(COMP14, COMP15);
        xmlc.xmlInsert(COMP13, COMP14);
        xmlc.xmlInsert(COMP11, COMP13);
        xmlc.xmlInsert(COMP11, COMP12);
        xmlc.xmlInsert(COMP10, COMP11);
        xmlc.xmlInsert(CO1,    COMP10);
        //==============================
        TAG COMP20 = xmlc.xmlCreate("component","");
        TAG COMP21 = xmlc.xmlCreate("section","");
        TAG COMP22 = xmlc.xmlCreate("title","Medicamentos");
        TAG COMP23 = xmlc.xmlCreate("text","");
        TAG COMP24 = xmlc.xmlCreate("list","");
        TAG COMP25 = xmlc.xmlCreate("",xmlc.xmlContent(getClinicalDocument().getMedicines().getContent()));
        //==============================
        xmlc.xmlInsert(COMP24, COMP25);
        xmlc.xmlInsert(COMP23, COMP24);
        xmlc.xmlInsert(COMP21, COMP23);
        xmlc.xmlInsert(COMP21, COMP22);
        xmlc.xmlInsert(COMP20, COMP21);
        xmlc.xmlInsert(CO1,    COMP20);
        //==============================
        TAG COMP30 = xmlc.xmlCreate("component","");
        TAG COMP31 = xmlc.xmlCreate("section classCode=\""+getClinicalDocument().getHealthHistoric().getSection()+"\" moodCode=\""+getClinicalDocument().getHealthHistoric().getMoodCode()+"\"","");
        TAG COMP32 = xmlc.xmlCreate("title","Alergias");
        TAG COMP33 = xmlc.xmlCreate("text","");
        TAG COMP34 = xmlc.xmlCreate("list","");
        TAG COMP35 = xmlc.xmlCreate("",xmlc.xmlContent(getClinicalDocument().getAllergy().getContent()));
        //==============================
        xmlc.xmlInsert(COMP34, COMP35);
        xmlc.xmlInsert(COMP33, COMP34);
        xmlc.xmlInsert(COMP31, COMP33);
        xmlc.xmlInsert(COMP31, COMP32);
        xmlc.xmlInsert(COMP30, COMP31);
        xmlc.xmlInsert(CO1, COMP30);
        //==============================
        TAG COMP40 = xmlc.xmlCreate("component","");
        TAG COMP41 = xmlc.xmlCreate("section","");
        TAG COMP42 = xmlc.xmlCreate("title","Histórico familiar");
        TAG COMP43 = xmlc.xmlCreate("text","");
        TAG COMP44 = xmlc.xmlCreate("list","");
        TAG COMP45 = xmlc.xmlCreate("",xmlc.xmlContent(getClinicalDocument().getFamilyHistoric().getContent()));
        //==============================
        xmlc.xmlInsert(COMP44, COMP45);
        xmlc.xmlInsert(COMP43, COMP44);
        xmlc.xmlInsert(COMP41, COMP43);
        xmlc.xmlInsert(COMP41, COMP42);
        xmlc.xmlInsert(COMP40, COMP41);
        xmlc.xmlInsert(CO1,    COMP40);
        //==============================
        TAG COMP50 = xmlc.xmlCreate("component","");
        TAG COMP51 = xmlc.xmlCreate("section","");
        TAG COMP52 = xmlc.xmlCreate("title","Exame/Métrica físico");
        TAG COMP53 = xmlc.xmlCreate("text","");
        TAG COMP54 = xmlc.xmlCreate("list","");
        TAG COMP55 = xmlc.xmlCreate("",xmlc.xmlContent(getClinicalDocument().getExams().getContent()));
        //==============================
        xmlc.xmlInsert(COMP54, COMP55);
        xmlc.xmlInsert(COMP53, COMP54);
        xmlc.xmlInsert(COMP51, COMP53);
        xmlc.xmlInsert(COMP51, COMP52);
        xmlc.xmlInsert(COMP50, COMP51);
        xmlc.xmlInsert(CO1,    COMP50);
        //==============================
        TAG COMP60 = xmlc.xmlCreate("component","");
        TAG COMP61 = xmlc.xmlCreate("section classCode=\""+getClinicalDocument().getHealthHistoric().getSection()+"\" moodCode=\""+getClinicalDocument().getHealthHistoric().getMoodCode()+"\"","");
        TAG COMP62 = xmlc.xmlCreate("templateId root=\"2.16.840.1.113883."+getClinicalDocument().getLaboratoryExams().getId()+"\"","");  
        TAG COMP63 = xmlc.xmlCreate("code code=\""+getClinicalDocument().getLaboratoryExams().getCode()+"\" codeSystem=\""+getClinicalDocument().getHealthHistoric().getCodeSystem()+"\" codeSystemName=\""+getClinicalDocument().getHealthHistoric().getCodeName()+"\" displayName=\"Exames de laboratório\"",""); 
        TAG COMP64 =  xmlc.xmlCreate("title","Exames de laboratório");
        TAG COMP65 =  xmlc.xmlCreate("text","");
        TAG COMP66 =  xmlc.xmlCreate("list","");
        TAG COMP67 =  xmlc.xmlCreate("",xmlc.xmlContent(getClinicalDocument().getLaboratoryExams().getContent()));
        //==============================
        xmlc.xmlInsert(COMP66, COMP67);
        xmlc.xmlInsert(COMP65, COMP66);
        xmlc.xmlInsert(COMP61, COMP65);
        xmlc.xmlInsert(COMP61, COMP64);
        xmlc.xmlInsert(COMP61, COMP63);
        xmlc.xmlInsert(COMP61, COMP62);
        xmlc.xmlInsert(COMP60, COMP61);
        xmlc.xmlInsert(CO1,    COMP60);
        //==============================
        TAG COMP70 = xmlc.xmlCreate("component","");
        TAG COMP71 = xmlc.xmlCreate("section","");
        TAG COMP72 = xmlc.xmlCreate("title","Diagnóstico");
        TAG COMP73 = xmlc.xmlCreate("text","");
        TAG COMP74 = xmlc.xmlCreate("list","");
        TAG COMP75 = xmlc.xmlCreate("",xmlc.xmlContent(getClinicalDocument().getDiagnostic().getContent()));
        //==============================
        xmlc.xmlInsert(COMP74, COMP75);
        xmlc.xmlInsert(COMP73, COMP74);
        xmlc.xmlInsert(COMP71, COMP73);
        xmlc.xmlInsert(COMP71, COMP72);
        xmlc.xmlInsert(COMP70, COMP71);
        xmlc.xmlInsert(CO1,    COMP70);
        //==============================
        TAG COMP80 = xmlc.xmlCreate("component","");
        TAG COMP81 = xmlc.xmlCreate("section","");
        TAG COMP82 = xmlc.xmlCreate("title","Tratamento");
        TAG COMP83 = xmlc.xmlCreate("text","");
        TAG COMP84 = xmlc.xmlCreate("list","");
        TAG COMP85 = xmlc.xmlCreate("",xmlc.xmlContent(getClinicalDocument().getTratament().getContent()));
        //==============================
        xmlc.xmlInsert(COMP84, COMP85);
        xmlc.xmlInsert(COMP83, COMP84);
        xmlc.xmlInsert(COMP81, COMP83);
        xmlc.xmlInsert(COMP81, COMP82);
        xmlc.xmlInsert(COMP80, COMP81);
        xmlc.xmlInsert(CO1,    COMP80);
        //==============================
        xmlc.xmlInsert(CO0, CO1);
        xmlc.xmlInsert(CO1, CO2);
        //==============================
        xmlc.xmlInsert(P15,P16);
        xmlc.xmlInsert(P20,P15);
        xmlc.xmlInsert(P12,P14);
        xmlc.xmlInsert(P12,P13);
        xmlc.xmlInsert(P11,P12);
        xmlc.xmlInsert(P3,P11);
        xmlc.xmlInsert(P3,P10);
        xmlc.xmlInsert(P3,P9);
        xmlc.xmlInsert(P3,P8);
        xmlc.xmlInsert(P3,P7);
        xmlc.xmlInsert(P3,P6);
        xmlc.xmlInsert(P3,P5);
        xmlc.xmlInsert(P4,P18);
        xmlc.xmlInsert(P4,P17);
        xmlc.xmlInsert(P3, P4);
        xmlc.xmlInsert(P20,P3);
        xmlc.xmlInsert(P20,P2);
        xmlc.xmlInsert(P20,P1);
        xmlc.xmlInsert(P20,P0);
        xmlc.xmlInsert(P19,P20);
        //==============================
        xmlc.xmlInsert(A7, A9);
        xmlc.xmlInsert(A7, A8);
        xmlc.xmlInsert(A6, A7);
        xmlc.xmlInsert(A2, A6);
        xmlc.xmlInsert(A2, A5);
        xmlc.xmlInsert(A2, A4);
        xmlc.xmlInsert(A2, A3);
        xmlc.xmlInsert(A0, A2);
        xmlc.xmlInsert(A0, A1);
        //==============================
        xmlc.xmlInsert(CS2, CS4);
        xmlc.xmlInsert(CS2, CS3);
        xmlc.xmlInsert(CS1, CS2);
        xmlc.xmlInsert(CS0, CS1);
        //==============================
        xmlc.xmlInsert(R1, R4);
        xmlc.xmlInsert(R1, R3);
        xmlc.xmlInsert(R1, R2);
        xmlc.xmlInsert(R0, R1);
        //==============================
        xmlc.xmlInsert(rootTag,CO0);
        xmlc.xmlInsert(rootTag,OFF0);
        xmlc.xmlInsert(rootTag,R0);
        xmlc.xmlInsert(rootTag,L0);
        xmlc.xmlInsert(rootTag,CS0);
        xmlc.xmlInsert(rootTag,A0);
        xmlc.xmlInsert(rootTag,P19);
        //==============================
        for(int i = 9; i >= 0; i--){
            xmlc.xmlInsert(rootTag,h[i]);
        }
        //DELETES FILE CDA TO OVERWRITE A NEW
        xmlc.xmlClean(getFile());

        try (FileWriter fw = new FileWriter(getFile(),true);){
            fw.write("<?xml version='1.0' encoding='UTF-8'?>");
            //GENERATES XML FILE
            xmlc.xmlPrint(rootTag,fw);
            fw.close();
            System.out.println("Success when writing file\n");
            return true;
        }catch(IOException ex){
            System.err.println("Error writing file:\n"+ex.getLocalizedMessage());
            return false;
        }
    }
}