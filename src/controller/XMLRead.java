package controller;

import br.com.CDApi.bean.*;
import br.com.CDApi.ClinicalDocument;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Classe responsável por ler o conteúdo do arquivo XML.
 *
 * @author Gyovanne Cavalcanti
 */
public class XMLRead {

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

	public void toRead() {

		try {
			Header header = new Header();

			header.setRealmCode(getTag("ClinicalDocument", "recordTarget", "realmCode", 3));
			header.setIdRoot(getTag("ClinicalDocument", "recordTarget", "id root=", 2));
			header.setExtension(getTag("ClinicalDocument", "recordTarget", "id root", 4));
			header.setCode(getTag("ClinicalDocument", "recordTarget", "code code=", 2));
			header.setDisplayName(getTag("ClinicalDocument", "recordTarget", "displayName", 5));
			header.setCodeSystem(getTag("ClinicalDocument", "recordTarget", "codeSystem", 6));
			header.setCodeSystemName(getTag("ClinicalDocument", "recordTarget", "codeSystemName", 7));
			header.setEfetiveTime(getTag("ClinicalDocument", "recordTarget", "effectiveTime ", 3));
			header.setId(getTag("ClinicalDocument", "recordTarget", "setId extension=", 2));
			header.setVersion(Integer.parseInt(getTag("ClinicalDocument", "recordTarget", "versionNumber ", 3)));

			getClinicalDocument().setHeader(header);

			Patient patient = new Patient();

			patient.setId(Integer.parseInt(getTag("patientRole", null, "id extension", 2)));
			patient.setAddr(getTag("patientRole", null, "addr", 1));
			patient.setPhone(getTag("patientRole", null, "telecom value", 3));
			patient.setName(getTag("patient", null, "given", 1));
			patient.setFamily(getTag("patient", null, "family", 1));
			patient.setGender(getTag("patient", null, "administrativeGenderCode code", 2));
			patient.setBirth(getTag("patient", null, "birthTime", 3));
			patient.setMaritalStatus(getTag("patient", null, "maritalStatusCode", 3));
			patient.setReligious(getTag("patient", null, "religiousAffiliationCode", 3));
			patient.setRace(getTag("patient", null, "raceCode", 3));
			patient.setEthnicGroup(getTag("patient", null, "ethnicGroupCode", 3));
			patient.setBirthPlace(getTag("birthplace", null, "name", 1));
			patient.setAddrBirthPlace(getTag("birthplace", null, "addr", 1));
			patient.setIdExtension(getTag("providerOrganization", null, "id extension", 2));

			getClinicalDocument().setPatient(patient);

			Author author = new Author();

			author.setCrm(getTag("author", null, "id root", 4));
			author.setAddr(getTag("author", null, "addr", 1));
			author.setPhone(getTag("author", null, "telecom", 3));
			author.setName(getTag("author", null, "given", 1));
			author.setFamily(getTag("author", null, "family", 1));

			getClinicalDocument().setAuthor(author);

			ResponsibleParty responsibleParty = new ResponsibleParty();

			responsibleParty.setIdRoot(getTag("encompassingEncounter", "responsibleParty", "id root", 2));
			responsibleParty.setExtension(getTag("encompassingEncounter", "responsibleParty", "extension", 4));
			responsibleParty.setDate(getTag("encompassingEncounter", "responsibleParty", "value", 3));
			responsibleParty.setId(getTag("assignedEntity", null, "id nullFlavor", 3));
			responsibleParty.setState(getTag("responsibleParty", null, "state", 1));
			responsibleParty.setCity(getTag("responsibleParty", null, "city", 1));
			responsibleParty.setPostal(getTag("responsibleParty", null, "postalCode", 1));
			responsibleParty.setStreet(getTag("responsibleParty", null, "streetAddressLine", 1));
			responsibleParty.setPhone(getTag("responsibleParty", null, "telecom value", 2));
			responsibleParty.setUse(getTag("responsibleParty", null, "use", 8));
			responsibleParty.setFamily(getTag("responsibleParty", null, "family", 1));
			responsibleParty.setName(getTag("responsibleParty", null, "given", 1));
			responsibleParty.setSuffixe(getTag("responsibleParty", null, "suffix", 1));
			responsibleParty.setLocation(getTag("location", null, "name", 1));

			getClinicalDocument().setResponsibleParty(responsibleParty);

			Authenticator authenticator = new Authenticator();

			authenticator.setCode(getTag("legalAuthenticator", null, "signatureCode", 3));

			getClinicalDocument().setAuthenticator(authenticator);

			Related related = new Related();

			related.setCode(getTag("/legalAuthenticator", "relatedDocument", "relatedDocument", 0));
			related.setID(getTag("relatedDocument", null, "id", 2));
			related.setExtension(getTag("relatedDocument", null, "setId", 2));
			related.setVersion(getTag("relatedDocument", null, "versionNumber", 3));

			getClinicalDocument().setRelated(related);

			try {
				getClinicalDocument().setComponents(getList());
			} catch (IOException ex) {
				System.err.println(ex.getLocalizedMessage());
			}

		} catch (NumberFormatException ex) {
			System.err.println(ex.getLocalizedMessage());
		}
	}

	private String getTag(String tagBegin, String tagFinish, String info, int op) {
		String linha;
		StringTokenizer st;
		try (FileReader fr = new FileReader(getFile());
				BufferedReader br = new BufferedReader(
						new InputStreamReader(new FileInputStream(getFile()), "UTF-8"));) {

			while ((linha = br.readLine()) != null) {
				if (linha.contains("<" + tagBegin + "")) {
					while ((linha = br.readLine()) != null) {
						String dados;
						st = new StringTokenizer(linha, "\n");
						while (st.hasMoreTokens()) {
							dados = st.nextToken();
							if (dados.contains(info)) {
								switch (op) {
								case 0:
									fr.close();
									br.close();
									return (dados.substring(dados.indexOf("=") + 2,
											dados.indexOf(">", dados.indexOf("=")) - 1));
								case 1:
									fr.close();
									br.close();
									return (dados.substring(dados.indexOf(">") + 1,
											dados.indexOf("</", dados.indexOf(">"))));
								case 2:
									fr.close();
									br.close();
									return (dados.substring(dados.indexOf("=") + 2,
											dados.indexOf(" ", dados.indexOf("=")) - 1));
								case 3:
									fr.close();
									br.close();
									return (dados.substring(dados.indexOf("=") + 2,
											dados.indexOf("/>", dados.indexOf("=")) - 1));
								case 4:
									fr.close();
									br.close();
									return (dados.substring(dados.indexOf("n=") + 3,
											dados.indexOf("/>", dados.indexOf("n=")) - 1));
								case 5:
									fr.close();
									br.close();
									return (dados.substring(dados.indexOf("me=") + 4,
											dados.indexOf(" code", dados.indexOf("me=")) - 1));
								case 6:
									fr.close();
									br.close();
									return (dados.substring(dados.indexOf("em=") + 4,
											dados.indexOf(" ", dados.indexOf("em=")) - 1));
								case 7:
									fr.close();
									br.close();
									return (dados.substring(dados.indexOf("SystemName=") + 12,
											dados.indexOf("/>", dados.indexOf("SystemName=")) - 1));
								case 8:
									fr.close();
									br.close();
									return (dados.substring(dados.indexOf("se=") + 4,
											dados.indexOf("/>", dados.indexOf("se=")) - 1));
								}
							} else {
								break;
							}
						}
						if (tagFinish != null && linha.contains("<" + tagFinish + ">")) {
							break;
						}
					}
				}
				if (linha.contains("</" + tagFinish + ">")) {
					break;
				}
			}
			fr.close();
			br.close();
		} catch (IOException ex) {
			System.err.println(ex.getLocalizedMessage());
		}
		return null;
	}

	private ArrayList<Component> getList() throws IOException {
		ArrayList<Component> component = new ArrayList<>();
		String line;
		StringTokenizer st;
		try (FileReader fr = new FileReader(getFile());
				BufferedReader br = new BufferedReader(
						new InputStreamReader(new FileInputStream(getFile()), "UTF-8"));) {
			while ((line = br.readLine()) != null) {
				if (line.contains("<structuredBody>")) {
					while ((line = br.readLine()) != null) {
						if (line.contains("</structuredBody>")) {
							break;
						} else if (line.contains("<component>")) {
							ArrayList<Object> content = new ArrayList<>();
							String title = null;
							while ((line = br.readLine()) != null) {
								if (line.contains("</component>")) {
									break;
								}
								String dados;
								st = new StringTokenizer(line, "\n");
								while (st.hasMoreTokens()) {
									dados = st.nextToken();
									if (dados.contains("<title>")) {
										title = dados.substring(dados.indexOf(">") + 1,
												dados.indexOf("</", dados.indexOf(">")));
									}
									if (dados.contains("<content>")) {
										content.add(dados.substring(dados.indexOf(">") + 1,
												dados.indexOf("</", dados.indexOf(">"))));
									} else {
										break;
									}
								}
							}
							component.add(new Component(title, content));
						}
					}
					fr.close();
					br.close();
					return component;
				}
			}
		} catch (IOException ex) {
			System.err.println(ex.getLocalizedMessage());
		}
		return null;
	}
}
