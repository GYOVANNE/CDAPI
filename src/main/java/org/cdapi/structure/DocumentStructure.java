package org.cdapi.structure;

import org.cdapi.document.ClinicalDocument;
import org.cdapi.structure.Tag;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe que contém o conteúdo do documento CDA, representado em XML.
 *
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
     */
    public boolean generateContent() {
        // STRUCTURE HEADER
        // ==========================================================================================
        Tag rootTag = xmlc.toCreate(
                "ClinicalDocument xmlns=\"urn:hl7-org:v3\" xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' classCode='DOCCLIN'",
                "");

        Tag h[] = new Tag[10];
        h[0] = xmlc.toCreate("realmCode code='" + getClinicalDocument().getHeader().getRealmCode() + "'", "");
        h[1] = xmlc.toCreate("typeId root='2.16.840.1.113883.1.3' extension='POCD_HD000040'", "");
        h[2] = xmlc.toCreate("templateId root='2.16.840.1.113883.10.20.1'", "");
        h[3] = xmlc.toCreate("id root='" + getClinicalDocument().getHeader().getIdRoot() + "' extension='"
                + getClinicalDocument().getHeader().getExtension() + "'", "");
        h[4] = xmlc.toCreate("code code='" + getClinicalDocument().getHeader().getCode() + "' displayName='"
                + getClinicalDocument().getHeader().getDisplayName() + "' codeSystem='"
                + getClinicalDocument().getHeader().getCodeSystem() + "' codeSystemName='"
                + getClinicalDocument().getHeader().getCodeSystemName() + "'", "");
        h[5] = xmlc.toCreate("effectiveTime value=\"" + getClinicalDocument().getHeader().getEfetiveTime() + "\"", "");
        h[6] = xmlc.toCreate(
                "confidentialityCode code=\"N\" displayName='Normal' codeSystem='2.16.840.1.113883.5.25' codeSystemName='Confidentiality'",
                "");
        h[7] = xmlc.toCreate("setId extension=\"" + getClinicalDocument().getHeader().getId() + "\" root=\""
                + getClinicalDocument().getHeader().getExtension() + "\"", "");
        h[8] = xmlc.toCreate("versionNumber value=\"" + getClinicalDocument().getHeader().getVersion() + "\"", "");
        h[9] = xmlc.toCreate("copyTime value='" + getClinicalDocument().getHeader().getEfetiveTime() + "'", "");
        // ==========================================================================================
        // STRUCTURE PATIENT
        Tag P19 = xmlc.toCreate("recordTarget", "");
        Tag P20 = xmlc.toCreate("patientRole", "");
        Tag P0 = xmlc.toCreate("id extension=\"" + getClinicalDocument().getPatient().getId() + "\" root=\""
                + getClinicalDocument().getHeader().getExtension() + "\"", "");
        Tag P1 = xmlc.toCreate("addr", "" + getClinicalDocument().getPatient().getAddr() + "");
        Tag P2 = xmlc.toCreate("telecom value=\"" + getClinicalDocument().getPatient().getPhone() + "\"", "");
        Tag P3 = xmlc.toCreate("patient", "");
        Tag P4 = xmlc.toCreate("name", "");
        Tag P17 = xmlc.toCreate("given", "" + getClinicalDocument().getPatient().getName() + "");
        Tag P18 = xmlc.toCreate("family", "" + getClinicalDocument().getPatient().getFamily() + "");
        Tag P5 = xmlc.toCreate("administrativeGenderCode code=\"" + getClinicalDocument().getPatient().getGender()
                + "\" codeSystem=\"" + getClinicalDocument().getPatient().getCodeSystem() + "\"", "");
        Tag P6 = xmlc.toCreate("birthTime value=\"" + getClinicalDocument().getPatient().getBirth() + "\"", "");
        Tag P7 = xmlc.toCreate("maritalStatusCode code='" + getClinicalDocument().getPatient().getMaritalStatus() + "'",
                "");
        Tag P8 = xmlc.toCreate(
                "religiousAffiliationCode code='" + getClinicalDocument().getPatient().getReligious() + "'", "");
        Tag P9 = xmlc.toCreate("raceCode code='" + getClinicalDocument().getPatient().getRace() + "'", "");
        Tag P10 = xmlc.toCreate("ethnicGroupCode code='" + getClinicalDocument().getPatient().getEthnicGroup() + "'",
                "");
        Tag P11 = xmlc.toCreate("birthplace", "");
        Tag P12 = xmlc.toCreate("place", "");
        Tag P13 = xmlc.toCreate("name", "" + getClinicalDocument().getPatient().getBirthPlace() + "");
        Tag P14 = xmlc.toCreate("addr", "" + getClinicalDocument().getPatient().getAddrBirthPlace() + "");
        Tag P15 = xmlc.toCreate("providerOrganization", "");
        Tag P16 = xmlc.toCreate("id extension=\"" + getClinicalDocument().getPatient().getIdExtension() + "\" root=\""
                + getClinicalDocument().getHeader().getExtension() + "\"", "");
        // STRUCTURE AUTHOR
        // ==========================================================================================
        Tag A0 = xmlc.toCreate("author", "");
        Tag A1 = xmlc.toCreate("time value = \"" + getClinicalDocument().getHeader().getEfetiveTime() + "\"", "");
        Tag A2 = xmlc.toCreate("assignedAuthor", "");
        Tag A3 = xmlc.toCreate("id root='" + getClinicalDocument().getHeader().getExtension() + "' extension='"
                + getClinicalDocument().getAuthor().getCrm() + "'", "");
        Tag A4 = xmlc.toCreate("addr", "" + getClinicalDocument().getAuthor().getAddr() + "");
        Tag A5 = xmlc.toCreate("telecom value='" + getClinicalDocument().getAuthor().getPhone() + "'", "");
        Tag A6 = xmlc.toCreate("assignedPerson", "");
        Tag A7 = xmlc.toCreate("name", "");
        Tag A8 = xmlc.toCreate("given", "" + getClinicalDocument().getAuthor().getName() + "");
        Tag A9 = xmlc.toCreate("family", "" + getClinicalDocument().getAuthor().getFamily() + "");
        // ==========================================================================================
        Tag CS0 = xmlc.toCreate("custodian", "");
        Tag CS1 = xmlc.toCreate("assignedCustodian", "");
        Tag CS2 = xmlc.toCreate("representedCustodianOrganization", "");
        Tag CS3 = xmlc.toCreate("id extension=\"" + getClinicalDocument().getPatient().getId() + "\" root=\""
                + getClinicalDocument().getHeader().getExtension() + "\"", "");
        Tag CS4 = xmlc.toCreate("name", "" + getClinicalDocument().getHeader().getDisplayName() + "");
        // ==========================================================================================

        Tag L0 = xmlc.toCreate("legalAuthenticator", "");

        Tag L1 = xmlc.toCreate("time value=\"" + getClinicalDocument().getHeader().getEfetiveTime() + "\"", "");
        Tag L2 = xmlc.toCreate("signatureCode code=\"" + getClinicalDocument().getAuthenticator().getCode() + "\"", "");
        Tag L3 = xmlc.toCreate("assignedEntity", "");
        Tag L4 = xmlc.toCreate("id extension=\"" + getClinicalDocument().getPatient().getIdExtension() + "\" root=\""
                + getClinicalDocument().getHeader().getExtension() + "\"", "");
        Tag L5 = xmlc.toCreate("assignedPerson", "");
        Tag L6 = xmlc.toCreate("name", "");
        Tag L7 = xmlc.toCreate("given", "" + getClinicalDocument().getAuthor().getName() + "");
        Tag L8 = xmlc.toCreate("family", "" + getClinicalDocument().getAuthor().getFamily() + "");
        // ==============================
        xmlc.toInsert(L6, L8);
        xmlc.toInsert(L6, L7);
        xmlc.toInsert(L5, L6);
        xmlc.toInsert(L3, L5);
        xmlc.toInsert(L3, L4);
        xmlc.toInsert(L0, L3);
        xmlc.toInsert(L0, L2);
        xmlc.toInsert(L0, L1);
        // ==========================================================================================
        Tag R0 = xmlc.toCreate("relatedDocument typeCode=\"" + getClinicalDocument().getRelated().getCode() + "\"", "");
        Tag R1 = xmlc.toCreate("parentDocument", "");
        Tag R2 = xmlc.toCreate("id extension=\"" + getClinicalDocument().getRelated().getId() + "\" root=\""
                + getClinicalDocument().getHeader().getExtension() + "\"", "");
        Tag R3 = xmlc.toCreate("setId extension=\"" + getClinicalDocument().getRelated().getExtension() + "\" root=\""
                + getClinicalDocument().getHeader().getExtension() + "\"", "");
        Tag R4 = xmlc.toCreate("versionNumber value=\"" + getClinicalDocument().getRelated().getVersion() + "\"", "");
        // =====================================================================================

        Tag OFF0 = xmlc.toCreate("componentOf", "");

        Tag OFF1 = xmlc.toCreate("encompassingEncounter", "");
        Tag OFF2 = xmlc.toCreate("id root=\"" + getClinicalDocument().getResponsibleParty().getIdRoot()
                + "\" extension=\"" + getClinicalDocument().getResponsibleParty().getDate() + "_"
                + getClinicalDocument().getResponsibleParty().getExtension() + "\"", "");
        Tag OFF3 = xmlc
                .toCreate("effectiveTime value=\"" + getClinicalDocument().getResponsibleParty().getDate() + "\"", "");
        Tag OFF4 = xmlc.toCreate("responsibleParty", "");
        Tag OFF5 = xmlc.toCreate("assignedEntity", "");
        Tag OFF6 = xmlc.toCreate("id nullFlavor=\"" + getClinicalDocument().getResponsibleParty().getId() + "\"", "");
        Tag OFF7 = xmlc.toCreate("addr", "");
        Tag OFF8 = xmlc.toCreate("state", "" + getClinicalDocument().getResponsibleParty().getState() + "");
        Tag OFF9 = xmlc.toCreate("city", "" + getClinicalDocument().getResponsibleParty().getCity() + "");
        Tag OFF10 = xmlc.toCreate("postalCode", "" + getClinicalDocument().getResponsibleParty().getPostal() + "");
        Tag OFF11 = xmlc.toCreate("streetAddressLine",
                "" + getClinicalDocument().getResponsibleParty().getStreet() + "");
        Tag OFF12 = xmlc.toCreate("telecom value=\"tel:" + getClinicalDocument().getResponsibleParty().getPhone()
                + "\" use=\"" + getClinicalDocument().getResponsibleParty().getUse() + "\"", "");
        Tag OFF13 = xmlc.toCreate("assignedPerson", "");
        Tag OFF14 = xmlc.toCreate("name", "");
        Tag OFF15 = xmlc.toCreate("family", "" + getClinicalDocument().getResponsibleParty().getFamily() + "");
        Tag OFF16 = xmlc.toCreate("given", "" + getClinicalDocument().getResponsibleParty().getName() + "");
        // Tag OFF17 =xmlc.toCreate("given",
        // ""+getClinicalDocument().getResponsibleParty().getName()+"");
        Tag OFF18 = xmlc.toCreate("suffix", "" + getClinicalDocument().getResponsibleParty().getSuffixe() + "");
        Tag OFF19 = xmlc.toCreate("location", "");
        Tag OFF20 = xmlc.toCreate("healthCareFacility", "");
        Tag OFF21 = xmlc.toCreate("id root=\"" + getClinicalDocument().getResponsibleParty().getIdRoot()
                + "\" extension=\"" + getClinicalDocument().getResponsibleParty().getDate() + "_"
                + getClinicalDocument().getResponsibleParty().getExtension() + "\"", "");
        Tag OFF22 = xmlc.toCreate("location", "");
        Tag OFF23 = xmlc.toCreate("name", "" + getClinicalDocument().getResponsibleParty().getLocation() + "");
        Tag OFF24 = xmlc.toCreate("addr", "");
        Tag OFF25 = xmlc.toCreate("state", "" + getClinicalDocument().getResponsibleParty().getState() + "");
        Tag OFF26 = xmlc.toCreate("city", "" + getClinicalDocument().getResponsibleParty().getCity() + "");
        Tag OFF27 = xmlc.toCreate("postalCode", "" + getClinicalDocument().getResponsibleParty().getPostal() + "");
        Tag OFF28 = xmlc.toCreate("streetAddressLine",
                "" + getClinicalDocument().getResponsibleParty().getStreet() + "");

        xmlc.toInsert(OFF24, OFF28);
        xmlc.toInsert(OFF24, OFF27);
        xmlc.toInsert(OFF24, OFF26);
        xmlc.toInsert(OFF24, OFF25);
        xmlc.toInsert(OFF22, OFF24);
        xmlc.toInsert(OFF22, OFF23);
        xmlc.toInsert(OFF20, OFF22);
        xmlc.toInsert(OFF20, OFF21);
        xmlc.toInsert(OFF19, OFF20);
        xmlc.toInsert(OFF14, OFF18);
        // xmlc.toInsert(OFF14,OFF17);
        xmlc.toInsert(OFF14, OFF16);
        xmlc.toInsert(OFF14, OFF15);
        xmlc.toInsert(OFF13, OFF14);
        xmlc.toInsert(OFF7, OFF11);
        xmlc.toInsert(OFF7, OFF10);
        xmlc.toInsert(OFF7, OFF9);
        xmlc.toInsert(OFF7, OFF8);
        xmlc.toInsert(OFF5, OFF13);
        xmlc.toInsert(OFF5, OFF12);
        xmlc.toInsert(OFF5, OFF7);
        xmlc.toInsert(OFF5, OFF6);
        xmlc.toInsert(OFF4, OFF5);
        xmlc.toInsert(OFF1, OFF19);
        xmlc.toInsert(OFF1, OFF4);
        xmlc.toInsert(OFF1, OFF3);
        xmlc.toInsert(OFF1, OFF2);
        xmlc.toInsert(OFF0, OFF1);
        // ==========================================================================================
        // STRUCTURE DOCTOR HISTORIC
        Tag CO0 = xmlc.toCreate("component", "");
        Tag component = xmlc.toCreate("structuredBody", "");
        Tag CO2 = xmlc.toCreate("languageCode code=\'pt-BR\'", "");
        // ==============================
        xmlc.toInsert(CO0, component);
        // ==============================
        xmlc.toInsert(P15, P16);
        xmlc.toInsert(P20, P15);
        xmlc.toInsert(P12, P14);
        xmlc.toInsert(P12, P13);
        xmlc.toInsert(P11, P12);
        xmlc.toInsert(P3, P11);
        xmlc.toInsert(P3, P10);
        xmlc.toInsert(P3, P9);
        xmlc.toInsert(P3, P8);
        xmlc.toInsert(P3, P7);
        xmlc.toInsert(P3, P6);
        xmlc.toInsert(P3, P5);
        xmlc.toInsert(P4, P18);
        xmlc.toInsert(P4, P17);
        xmlc.toInsert(P3, P4);
        xmlc.toInsert(P20, P3);
        xmlc.toInsert(P20, P2);
        xmlc.toInsert(P20, P1);
        xmlc.toInsert(P20, P0);
        xmlc.toInsert(P19, P20);
        // ==============================
        xmlc.toInsert(A7, A9);
        xmlc.toInsert(A7, A8);
        xmlc.toInsert(A6, A7);
        xmlc.toInsert(A2, A6);
        xmlc.toInsert(A2, A5);
        xmlc.toInsert(A2, A4);
        xmlc.toInsert(A2, A3);
        xmlc.toInsert(A0, A2);
        xmlc.toInsert(A0, A1);
        // ==============================
        xmlc.toInsert(CS2, CS4);
        xmlc.toInsert(CS2, CS3);
        xmlc.toInsert(CS1, CS2);
        xmlc.toInsert(CS0, CS1);
        // ==============================
        xmlc.toInsert(R1, R4);
        xmlc.toInsert(R1, R3);
        xmlc.toInsert(R1, R2);
        xmlc.toInsert(R0, R1);
        // ==============================
        xmlc.toInsert(rootTag, CO0);
        xmlc.toInsert(rootTag, OFF0);
        xmlc.toInsert(rootTag, R0);
        xmlc.toInsert(rootTag, L0);
        xmlc.toInsert(rootTag, CS0);
        xmlc.toInsert(rootTag, A0);
        xmlc.toInsert(rootTag, P19);
        // ==============================
        for (int i = 9; i >= 0; i--) {
            xmlc.toInsert(rootTag, h[i]);
        }

        int x = getClinicalDocument().getComponents().size();

        if (x != 0) {
            Tag componentes[] = new Tag[x];

            for (int i = 0; i < x; i++) {
                componentes[i] = xmlc.toCreate("component",
                        toCreateItems(getClinicalDocument().getComponents().get(i).getTitle(),
                                getClinicalDocument().getComponents().get(i).getContent()));
            }
            for (int i = x - 1; i >= 0; i--) {
                xmlc.toInsert(component, componentes[i]);
            }
        }
        xmlc.toInsert(component, CO2);
        // DELETES FILE CDA TO OVERWRITE A NEW
        xmlc.toClean(getFile());
        try (FileWriter fw = new FileWriter(getFile(), true);) {
            fw.write("<?xml version='1.0' encoding='UTF-8'?>");
            // GENERATES XML FILE
            xmlc.toPrint(rootTag, fw);
            fw.close();
            System.out.println("Success when writing file\n");
            return true;
        } catch (IOException ex) {
            System.err.println(ex.getLocalizedMessage());
            return false;
        }
    }

    private int TagSpace;
    private String space;

    private void setSpace(String line) {
        this.space = line;
    }

    private String getSpace() {
        return space;
    }

    private int getTagSpace() {
        return TagSpace;
    }

    private void setTagSpace(int TagSpace) {
        this.TagSpace = TagSpace;
        String newline = "";
        for (int i = 0; i < getTagSpace(); i++) {
            newline += "   ";
        }
        setSpace(newline);
    }

    private String toCreateItems(String title, ArrayList<Object> content) {
        setTagSpace(4);
        String component;
        component = "\n" + getSpace() + "<section>\n" + getSpace() + "<title>" + title + "</title>\n" + getSpace()
                + "   <text>\n" + getSpace() + "      <list>\n";
        component += getItens(content) + "\n";
        setTagSpace(4);
        return component += getSpace() + "      </list>\n" + getSpace() + "   </text>\n" + getSpace() + "</section>";
    }

    private String getItens(ArrayList<Object> content) {
        String list = "";
        setTagSpace(7);
        if (content != null) {
            for (int i = 0; i < content.size(); i++) {
                list += getSpace() + "<item>" + "\n" + getSpace() + "  <content>" + content.get(i) + "</content>\n"
                        + ((i != content.size() - 1) ? getSpace() + "</item>\n" : getSpace() + "</item>");
            }
        } else {
            list = getSpace() + "<item>" + "\n" + getSpace() + "  <content>nullFlavor</content>\n" + getSpace()
                    + "</item>";
        }
        setTagSpace(0);
        return list;
    }
}
