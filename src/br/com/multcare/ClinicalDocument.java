package br.com.multcare;

import br.com.multcare.bean.*;
import br.com.multcare.validator.ValidateCDA;
import controller.DocumentStructure;
import controller.ReadTag;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Classe responsavel pela escrita, leitura e validaçao do arquivo.
 * @author Gyovanne
 */
public class ClinicalDocument {
    private boolean status;
    private File xmlFile;
    private Header header;
    private Patient patient;
    private Author author;
    private Authenticator authenticator;
    private Related related;
    private ResponsibleParty responsibleParty;
    private HealthHistoric healthHistoric;
    private DoctorHistoric doctorHistoric;
    private Medicines medicines;
    private Allergy allergy;
    private FamilyHistoric familyHistoric;
    private Exams exams;
    private LaboratoryExams laboratoryExams;
    private Diagnostic diagnostic;
    private Tratament tratament;

     /**
     * Contrutor com argumento necessário para leitura do arquivo.
     * <br>Necessário informar o arquivo ao qual será usado para leitura.
     * <br>Exemplo de implementação:<br>
     * <blockquote>
     * <pre>
     * ClinicalDocument cda = new ClinicalDocuement(File file);
     * </pre>
     * </blockquote>
     * @param xml
     */
    public ClinicalDocument(File xml) {
        this.status = true;
        if(xml.exists()) {
            new ReadTag(this,xml).read();
        } else {
            System.err.println("File not found");
        }
    }

    /**
     * Contrutor com argumento necessário para leitura do arquivo.
     * <br>Necessário informar o nome do arquivo ao qual será usado para leitura.
     * <br>Exemplo de implementação:<br>
     * <blockquote>
     * <pre>
     * ClinicalDocument cda = new ClinicalDocuement("12345");
     * </pre>
     * </blockquote>
     * @param fileName
     */
    public ClinicalDocument(String fileName){
        this(new File(local(fileName)));
    }

    /**
     * Contrutor com argumento necessário para leitura do arquivo.
     * <br>Necessário informar o Id do paciente, que será usado como identificador do arquivo
     * <br>Exemplo de implementação:<br>
     * <blockquote>
     * <pre>
     * ClinicalDocument cda = new ClinicalDocuement(12345);
     * </pre>
     * </blockquote>
     * @param Patientid
     */
    public ClinicalDocument(int Patientid) {
        this(""+Patientid);
    }
    
    /**
     * Contrutor sem  argumento.
     * <br>Não é necessário informar nenhum parâmetro, pois a instância do objeto
     * a partir deste construtor é usado para acessar os métodos de escrita do arquivo.
     * <br>Exemplo de implementação:<br>
     * <blockquote>
     * <pre>
     * ClinicalDocument cda = new ClinicalDocuement();
     * </pre>
     * </blockquote>
     */
    public ClinicalDocument() {
        this.status = false;
    }
    
    private File getXmlFile() {
        return xmlFile;
    }

    private void setXmlFile(File xmlFile) {
        this.xmlFile = xmlFile;
    }

    private static String local(String filename){
        File direct = new File("");
        File file = new File(""+direct.getAbsolutePath()+"/XML_FILES");
        file.mkdir();
        return file.getAbsolutePath()+"/"+filename+".xml";
    }

    private static String DATE() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar today = Calendar.getInstance();
        return(format.format(today.getTime()));
    }

    /**
     * Retorna uma representação Header do objeto. Em geral, o método
     * {@code getHeader} retorna um Header que representa este objeto.
     * <p>
     * O método {@code getHeader} para a classe {@code ClinicalDocument}
     * retorna um Header consistindo nos dados do cabeçario do qual o
     * objeto é uma instância. Em outras palavras, este método deve retornar 
     * a informação contida no método instanciado por este objeto, como mostrado
     * na implementação:
     * <blockquote>
     * <pre>
     * getClass().getHeader().getId();
     * </pre></blockquote>
     *
     * @return  uma representação Header do objeto.
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Recebe uma representação Header do objeto.
     * O método {@code setHeader} para a classe {@code ClinicalDocument}
     * deve receber as informações necessárias de um {@code Header} para que seja 
     * preenchido nos campos que corresponde aos dados de cabeçario no documento CDA.
     * Para isto, as informações devem ser válidas.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().setHeader(Header header);</pre>
     * </blockquote>
     *
     * @param header
     */
    public void setHeader(Header header) {
        if(header.getEfetiveTime()==null)header.setEfetiveTime(DATE());
        this.header = header;
    }
    
    /**
     * Retorna uma representação Patient do objeto. Em geral, o método
     * {@code getPatient} retorna um Patient que representa este objeto.
     * <p>
     * O método {@code getPatient} para a classe {@code ClinicalDocument}
     * retorna um Patient consistindo nos dados do paciente do qual o
     * objeto é uma instância. Em outras palavras, este método deve retornar 
     * a informação contida no método instanciado por este objeto, como mostrado
     * na implementação:
     * <blockquote>
     * <pre>
     * getClass().getPatient().getId();
     * </pre></blockquote>
     *
     * @return  uma representação Patient do objeto.
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Recebe uma representação Patient do objeto.
     * O método {@code setPatient} para a classe {@code ClinicalDocument}
     * deve receber as informações necessárias de um {@code Patient} para que seja 
     * preenchido nos campos que corresponde aos dados do paciente no documento CDA.
     * Para isto, as informações devem ser válidas.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().setPatient(Patient patient);</pre>
     * </blockquote>
     *
     * @param patient
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Retorna uma representação Author do objeto. Em geral, o método
     * {@code getAuthor} retorna um Author que representa este objeto.
     * <p>
     * O método {@code getAuthor} para a classe {@code ClinicalDocument}
     * retorna um Author consistindo nos dados do médico do qual o
     * objeto é uma instância. Em outras palavras, este método deve retornar 
     * a informação contida no método instanciado por este objeto, como mostrado
     * na implementação:
     * <blockquote>
     * <pre>
     * getClass().getAuthor().getCrm();
     * </pre></blockquote>
     *
     * @return  uma representação Author do objeto.
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Recebe uma representação Author do objeto.
     * O método {@code setAuthor} para a classe {@code ClinicalDocument}
     * deve receber as informações necessárias de um {@code Author} para que seja 
     * preenchido nos campos que corresponde aos dados do médico no documento CDA.
     * Para isto, as informações devem ser válidas.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().setAuthor(Author author);</pre>
     * </blockquote>
     *
     * @param author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }
    
    /**
     * Retorna uma representação Authentic do objeto. Em geral, o método
     * {@code getAuthenticator} retorna um Authentic que representa este objeto.
     * <p>
     * O método {@code getAuthenticator} para a classe {@code ClinicalDocument}
     * retorna um Authentic consistindo nos dados de autenticação do qual o
     * objeto é uma instância. Em outras palavras, este método deve retornar 
     * a informação contida no método instanciado por este objeto, como mostrado
     * na implementação:
     * <blockquote>
     * <pre>
     * getClass().getAuthenticator().getCode();
     * </pre></blockquote>
     *
     * @return  uma representação Authentic do objeto.
     */
    public Authenticator getAuthenticator() {
        return authenticator;
    }

    /**
     * Recebe uma representação Authentic do objeto.
     * O método {@code setAuthenticator} para a classe {@code ClinicalDocument}
     * deve receber as informações necessárias de um {@code Authentic} para que seja 
     * preenchido nos campos que corresponde aos dados de autenticação no documento CDA.
     * Para isto, as informações devem ser válidas.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().setAuthenticator(Authenticator authenticator);</pre>
     * </blockquote>
     *
     * @param authenticator
     */
    public void setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
    }
    
    /**
     * Retorna uma representação Related do objeto. Em geral, o método
     * {@code getRelated} retorna um Related que representa este objeto.
     * <p>
     * O método {@code getRelated} para a classe {@code ClinicalDocument}
     * retorna um Related consistindo nos dados relacionados do qual o
     * objeto é uma instância. Em outras palavras, este método deve retornar 
     * a informação contida no método instanciado por este objeto, como mostrado
     * na implementação:
     * <blockquote>
     * <pre>
     * getClass().getRelated().getId();
     * </pre></blockquote>
     *
     * @return  uma representação Related  do objeto.
     */
    public Related getRelated() {
        return related;
    }

    /**
     * Recebe uma representação Related do objeto.
     * O método {@code setRelated} para a classe {@code ClinicalDocument}
     * deve receber as informações necessárias de um {@code Related} para que seja 
     * preenchido nos campos que corresponde aos dados de relacionados no documento CDA.
     * Para isto, as informações devem ser válidas.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().setRelated(Related related);</pre>
     * </blockquote>
     *
     * @param related
     */
    public void setRelated(Related related) {
        this.related = related;
    }
    
    /**
     * Retorna uma representação Responsible do objeto. Em geral, o método
     * {@code getResponsibleParty} retorna um Responsible que representa este objeto.
     * <p>
     * O método {@code getResponsibleParty} para a classe {@code ClinicalDocument}
     * retorna um Responsible consistindo nos dados do responsável do paciente do qual o
     * objeto é uma instância. Em outras palavras, este método deve retornar 
     * a informação contida no método instanciado por este objeto, como mostrado
     * na implementação:
     * <blockquote>
     * <pre>
     * getClass().getResponsibleParty().getId();
     * </pre></blockquote>
     *
     * @return  uma representação Responsible do objeto.
     */
    public ResponsibleParty getResponsibleParty() {
        return responsibleParty;
    }

    /**
     * Recebe uma representação ResponsibleParty do objeto.
     * O método {@code setResponsibleParty} para a classe {@code ClinicalDocument}
     * deve receber as informações necessárias de um {@code ResponsibleParty} para que seja 
     * preenchido nos campos que corresponde aos dados do responsável no documento CDA.
     * Para isto, as informações devem ser válidas.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().setResponsibleParty(ResponsibleParty responsibleParty);</pre>
     * </blockquote>
     *
     * @param responsibleParty
     */
    public void setResponsibleParty(ResponsibleParty responsibleParty) {
        this.responsibleParty = responsibleParty;
    }

    /**
     * Retorna uma representação HealthHistoric do objeto. Em geral, o método
     * {@code getHealthHistoric} retorna um HealthHistoric que representa este objeto.
     * <p>
     * O método {@code getHealthHistoric} para a classe {@code ClinicalDocument}
     * retorna um HealthHistoric consistindo nos dados do histórico de saúde do qual o
     * objeto é uma instância. Em outras palavras, este método deve retornar 
     * a informação contida no método instanciado por este objeto, como mostrado
     * na implementação:
     * <blockquote>
     * <pre>
     * getClass().getHealthHistoric().getSection();
     * </pre></blockquote>
     *
     * @return  uma representação HealthHistoric do objeto.
     */
    public HealthHistoric getHealthHistoric() {
        return healthHistoric;
    }

    /**
     * Recebe uma representação HealthHistoric do objeto.
     * O método {@code setHealthHistoric} para a classe {@code ClinicalDocument}
     * deve receber as informações necessárias de um {@code HealthHistoric} para que seja 
     * preenchido nos campos que corresponde aos dados do histórico de saúde no documento CDA.
     * Para isto, as informações devem ser válidas.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().setHealthHistoric(HealthHistoric healthHistoric);</pre>
     * </blockquote>
     *
     * @param healthHistoric
     */
    public void setHealthHistoric(HealthHistoric healthHistoric) {
        this.healthHistoric = healthHistoric;
    }

    /**
     * Retorna uma representação DoctorHistoric do objeto. Em geral, o método
     * {@code getDoctorHistoric} retorna um DoctorHistoric que representa este objeto.
     * <p>
     * O método {@code getDoctorHistoric} para a classe {@code ClinicalDocument}
     * retorna um HealthHistoric consistindo nos dados do histórico do médico do qual o
     * objeto é uma instância. Em outras palavras, este método deve retornar 
     * a informação contida no método instanciado por este objeto, como mostrado
     * na implementação:
     * <blockquote>
     * <pre>
     * getClass().getDoctorHistoric().getContent();
     * </pre></blockquote>
     *<p> Onde getContent() retorna um ArrayList.
     * @return  uma representação DoctorHistoric do objeto.
     */
    public DoctorHistoric getDoctorHistoric() {
        return doctorHistoric;
    }

    /**
     * Recebe uma representação DoctorHistoric do objeto.
     * O método {@code setDoctorHistoric} para a classe {@code ClinicalDocument}
     * deve receber as informações necessárias de um {@code DoctorHistoric} para que seja 
     * preenchido nos campos que corresponde aos dados do histórico do médico no documento CDA.
     * Para isto, as informações devem ser válidas.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().setDoctorHistoric(DoctorHistoric doctorHistoric);</pre>
     * </blockquote>
     *
     * @param doctorHistoric
     */
    public void setDoctorHistoric(DoctorHistoric doctorHistoric) {
        this.doctorHistoric = doctorHistoric;
    }

    /**
     * Retorna uma representação Medicines do objeto. Em geral, o método
     * {@code getMedicines} retorna um Medicines que representa este objeto.
     * <p>
     * O método {@code getMedicines} para a classe {@code ClinicalDocument}
     * retorna um Medicines consistindo nos dados de medicamentos do qual o
     * objeto é uma instância. Em outras palavras, este método deve retornar 
     * a informação contida no método instanciado por este objeto, como mostrado
     * na implementação:
     * <blockquote>
     * <pre>
     * getClass().getMedicines().getContent();
     * </pre></blockquote>
     *<p> Onde getContent() retorna um ArrayList.
     * @return  uma representação HealthHistoric do objeto.
     */
    public Medicines getMedicines() {
        return medicines;
    }

    /**
     * Recebe uma representação Medicines do objeto.
     * O método {@code setMedicines} para a classe {@code ClinicalDocument}
     * deve receber as informações necessárias de um {@code Medicines} para que seja 
     * preenchido nos campos que corresponde aos dados de medicamentos no documento CDA.
     * Para isto, as informações devem ser válidas.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().setMedicines(Medicines medicines);</pre>
     * </blockquote>
     *
     * @param medicines
     */
    public void setMedicines(Medicines medicines) {
        this.medicines = medicines;
    }

    /**
     * Retorna uma representação Allergy do objeto. Em geral, o método
     * {@code getAllergy} retorna um Allergy que representa este objeto.
     * <p>
     * O método {@code getAllergy} para a classe {@code ClinicalDocument}
     * retorna um Allergy consistindo nos dados de alergias do qual o
     * objeto é uma instância. Em outras palavras, este método deve retornar 
     * a informação contida no método instanciado por este objeto, como mostrado
     * na implementação:
     * <blockquote>
     * <pre>
     * getClass().getAllergy().getContent();
     * </pre></blockquote>
     *<p> Onde getContent() retorna um ArrayList.
     * @return  uma representação Allergy do objeto.
     */
    public Allergy getAllergy() {
        return allergy;
    }

    /**
     * Recebe uma representação Allergy do objeto.
     * O método {@code setAllergy} para a classe {@code ClinicalDocument}
     * deve receber as informações necessárias de um {@code Allergy} para que seja 
     * preenchido nos campos que corresponde aos dados de alergias no documento CDA.
     * Para isto, as informações devem ser válidas.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().setAllergy(Allergy allergy);</pre>
     * </blockquote>
     *
     * @param allergy
     */
    public void setAllergy(Allergy allergy) {
        this.allergy = allergy;
    }

    /**
     * Retorna uma representação FamilyHistoric do objeto. Em geral, o método
     * {@code getFamilyHistoric} retorna um FamilyHistoric que representa este objeto.
     * <p>
     * O método {@code getFamilyHistoric} para a classe {@code ClinicalDocument}
     * retorna um FamilyHistoric consistindo nos dados de histórico familiar do qual o
     * objeto é uma instância. Em outras palavras, este método deve retornar 
     * a informação contida no método instanciado por este objeto, como mostrado
     * na implementação:
     * <blockquote>
     * <pre>
        getClass().getFamilyHistoric().getContent();
        </pre></blockquote>
     *<p> Onde getContent() retorna um ArrayList.
     * @return  uma representação FamilyHistoric do objeto.
     */
    public FamilyHistoric getFamilyHistoric() {
        return familyHistoric;
    }

    /**
     * Recebe uma representação FamilyHistoric do objeto.
     * O método {@code setFamilyHistoric} para a classe {@code ClinicalDocument}
     * deve receber as informações necessárias de um {@code FamilyHistoric} para que seja 
     * preenchido nos campos que corresponde aos dados do histórico familizar no documento CDA.
     * Para isto, as informações devem ser válidas.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().setFamilyHistoric(FamilyHistoric familyHistoric);</pre>
     * </blockquote>
     *
     * @param familyHistoric
     */
    public void setFamilyHistoric(FamilyHistoric familyHistoric) {
        this.familyHistoric = familyHistoric;
    }

    /**
     * Retorna uma representação Exams do objeto. Em geral, o método
     * {@code getExams} retorna um Exams que representa este objeto.
     * <p>
     * O método {@code getExams} para a classe {@code ClinicalDocument}
     * retorna um Exams consistindo nos dados de exames/Métrica físico do qual o
     * objeto é uma instância. Em outras palavras, este método deve retornar 
     * a informação contida no método instanciado por este objeto, como mostrado
     * na implementação:
     * <blockquote>
     * <pre>
     * getClass().getExams().getContent();
     * </pre></blockquote>
     *<p> Onde getContent() retorna um ArrayList.
     * @return  uma representação Exams do objeto.
     */
    public Exams getExams() {
        return exams;
    }

    /**
     * Recebe uma representação Exams do objeto.
     * O método {@code setExams} para a classe {@code ClinicalDocument}
     * deve receber as informações necessárias de um {@code Exams} para que seja 
     * preenchido nos campos que corresponde aos dados de exames no documento CDA.
     * Para isto, as informações devem ser válidas.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().setExams(Exams exams);</pre>
     * </blockquote>
     *
     * @param exams
     */
    public void setExams(Exams exams) {
        this.exams = exams;
    }

    /**
     * Retorna uma representação LaboratoryExams do objeto. Em geral, o método
     * {@code getLaboratoryExams} retorna um LaboratoryExams que representa este objeto.
     * <p>
     * O método {@code getLaboratoryExams} para a classe {@code ClinicalDocument}
     * retorna um LaboratoryExams consistindo nos dados de exames laboratoriais do qual o
     * objeto é uma instância. Em outras palavras, este método deve retornar 
     * a informação contida no método instanciado por este objeto, como mostrado
     * na implementação:
     * <blockquote>
     * <pre>
     * getClass().getLaboratoryExams().getId();
     * getClass().getLaboratoryExams().getCode();
     * getClass().getLaboratoryExams().getContent();
     * </pre></blockquote>
     *<br> Onde getId() retorna uma String,
     *<br> getCode() retorna uma String e
     *<br> getContent() retorna um ArrayList.
     * @return  uma representação LaboratoryExams do objeto.
     */
    public LaboratoryExams getLaboratoryExams() {
        return laboratoryExams;
    }

    /**
     * Recebe uma representação LaboratoryExams do objeto.
     * O método {@code setLaboratoryExams} para a classe {@code ClinicalDocument}
     * deve receber as informações necessárias de um {@code LaboratoryExams} para que seja 
     * preenchido nos campos que corresponde aos dados de exames laboratoriais no documento CDA.
     * Para isto, as informações devem ser válidas.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().setLaboratoryExams(LaboratoryExams laboratoryExams);</pre>
     * </blockquote>
     *
     * @param laboratory
     */
    public void setLaboratoryExams(LaboratoryExams laboratory) {
        this.laboratoryExams = laboratory;
    }

    /**
     * Retorna uma representação Diagnostic do objeto. Em geral, o método
     * {@code getDiagnostic} retorna um Diagnostic que representa este objeto.
     * <p>
     * O método {@code getDiagnostic} para a classe {@code ClinicalDocument}
     * retorna um Diagnostic consistindo nos dados de diagnóstico do qual o
     * objeto é uma instância. Em outras palavras, este método deve retornar 
     * a informação contida no método instanciado por este objeto, como mostrado
     * na implementação:
     * <blockquote>
     * <pre>
     * getClass().getDiagnostic().getContent();
     * </pre></blockquote>
     *<p> Onde getContent() retorna um ArrayList.
     * @return  uma representação Diagnostic do objeto.
     */
    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    /**
     * Recebe uma representação Diagnostic do objeto.
     * O método {@code setDiagnostic} para a classe {@code ClinicalDocument}
     * deve receber as informações necessárias de um {@code Diagnostic} para que seja 
     * preenchido nos campos que corresponde aos dados de diagnóstico no documento CDA.
     * Para isto, as informações devem ser válidas.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().setDiagnostic(Diagnostic diagnostic);</pre>
     * </blockquote>
     *
     * @param diagnostic
     */
    public void setDiagnostic(Diagnostic diagnostic) {
        this.diagnostic = diagnostic;
    }

    /**
     * Retorna uma representação Tratament do objeto. Em geral, o método
     * {@code getTratament} retorna um Tratament que representa este objeto.
     * <p>
     * O método {@code getTratament} para a classe {@code ClinicalDocument}
     * retorna um Tratament consistindo nos dados de tratamento do qual o
     * objeto é uma instância. Em outras palavras, este método deve retornar 
     * a informação contida no método instanciado por este objeto, como mostrado
     * na implementação:
     * <blockquote>
     * <pre>
     * getClass().getTratament().getContent();
     * </pre></blockquote>
     *<p> Onde getContent() retorna um ArrayList.
     * @return  uma representação Tratament do objeto.
     */
    public Tratament getTratament() {
        return tratament;
    }

    /**
     * Recebe uma representação Tratament do objeto.
     * O método {@code setTratament} para a classe {@code ClinicalDocument}
     * deve receber as informações necessárias de um {@code Tratament} para que seja 
     * preenchido nos campos que corresponde aos dados de tratamento no documento CDA.
     * Para isto, as informações devem ser válidas.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().setTratament(Tratament tratament);</pre>
     * </blockquote>
     *
     * @param tratament
     */
    public void setTratament(Tratament tratament) {
        this.tratament = tratament;
    }

    /**
     * Retorna uma representação boolean do objeto. Em geral, o método
     * {@code generateCDAFile} retorna um boolean, sendo true para a criação e validação
     * bem sucedida do arquivo XML e false caso não tenha gerado ou validado com sucesso.
     * <p>
     * O método {@code generateCDAFile} para a classe {@code ClinicalDocument}
     * recebe um diretório como parâmetro onde será salvo o arquivo gerado no local indicado e retorna um valor booleano, 
     * que indica o resultado da criação e validação de 
     * um documento CDA. Após o método ser chamado ele gera um documento CDA no diretório da aplicação,
     * ao mesmo tempo que valida com o validador da própria aplicação, para que seus campos corresponda ao padrão HL7 CDA.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().generateCDAFile(String local);</pre>
     * </blockquote>
     *
     * @param local
     * @return  um valor booleano para fins de verificação.
     */
    public boolean generateCDAFile(String local){
        if(this.status==false){
            InitializeObjects();
            String idFile;
            if(patient==null)
                idFile= "ArquivoSemNome.xml";
            else 
                idFile = "" + patient.getId();

            if(local != null) {
                setXmlFile(new File(local+idFile));
            }else setXmlFile(new File(local(idFile)));

            try {

            DocumentStructure structure = new DocumentStructure(getXmlFile(),this);
            ValidateCDA validator = new ValidateCDA();

                if(structure.generateContent()){

                    if(validator.validationCDAFile(idFile+".xml"))
                        System.out.println(""+validator.getNotification());
                    else
                        System.err.println(""+validator.getNotification());
                    return true;
                }
            } catch (IOException ex) {
                System.err.println(ex.getLocalizedMessage());
            }
        }else System.err.println("Para gerar o arquivo o contrutor da classe ClinicalDocument nao pode haver parametros!");
        return false;
    }
    /**
     * Retorna uma representação boolean do objeto. Em geral, o método
     * {@code generateCDAFile} retorna um boolean, sendo true para a criação e validação
     * bem sucedida do arquivo XML e false caso não tenha gerado ou validado com sucesso.
     * <p>
     * O método {@code generateCDAFile} para a classe {@code ClinicalDocument}
     * retorna um valor booleano, que indica o resultado da criação e validação de 
     * um documento CDA. Após o método ser chamado ele gera um documento CDA no diretório da aplicação,
     * ao mesmo tempo que valida com o validador da própria aplicação, para que seus campos corresponda ao padrão HL7 CDA.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().generateCDAFile();</pre>
     * </blockquote>
     *
     * @return  um valor booleano para fins de verificação.
     */
    public boolean generateCDAFile(){
        return generateCDAFile(null);
    }

    private void InitializeObjects(){
        if(this.header == null)         this.header = new Header();
        if(this.patient == null)        this.patient = new Patient();
        if(this.author == null)         this.author = new Author();
        if(this.authenticator == null)  this.authenticator = new Authenticator();
        if(this.related == null)        this.related = new Related();
        if(this.responsibleParty == null)this.responsibleParty = new ResponsibleParty();
        if(this.healthHistoric == null) this.healthHistoric = new HealthHistoric();
        if(this.doctorHistoric == null) this.doctorHistoric = new DoctorHistoric();
        if(this.medicines == null)      this.medicines = new Medicines();
        if(this.allergy == null)        this.allergy = new Allergy();
        if(this.familyHistoric == null) this.familyHistoric = new FamilyHistoric();
        if(this.exams == null)          this.exams = new Exams();
        if(this.laboratoryExams == null)this.laboratoryExams = new LaboratoryExams();
        if(this.diagnostic == null)     this.diagnostic = new Diagnostic();
        if(this.tratament == null)      this.tratament = new Tratament();
    }
}