package br.com.multcare;

import br.com.multcare.bean.*;
import br.com.multcare.validator.ValidateCDA;
import controller.Implements;
import controller.JContent;
import controller.JReadAll;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Gyovanne
 */
public class ClinicalDocument extends Implements{
    
    private String fileName;

    private File getFileName() {
        return new File(local(fileName));
    }

    private void setFileName(String filename) {
        this.fileName = filename;
    }
    
    private String local(String filename){
        File direct = new File("");
        File file = new File(""+direct.getAbsolutePath()+"/XML_FILES");
        file.mkdir();
        return file.getAbsolutePath()+"/"+filename+".xml";
    }
    /**
     * Contrutor com argumento necessário para leitura do arquivo.
     * <br>Necessário informar o Id do paciente, que será usado como identificador do arquivo
     * <br>Exemplo de implementação:<br>
     * CDA cda = new CDA(12345);<br>
     * @param Patientid
     * @throws Exception
     */
    public ClinicalDocument(int Patientid) throws Exception{
        this(""+Patientid);
    }
    
    /**
     * Contrutor com argumento necessário para leitura do arquivo.
     * <br>Necessário informar o nome do arquivo.
     * <br>Exemplo de implementação:<br>
     * CDA cda = new CDA(12345);<br>
     * @param Patientid
     * @throws Exception
     */
    public ClinicalDocument(String Patientid) throws Exception{
        setFileName(Patientid);
        JReadAll classRead = new JReadAll(getFileName(),
        header,patient,author,authentic,related,responsibleParty,
        healthHistoric,doctorHistoric,medicines,allergy,familyHistoric,exams,
        laboratoryExams,diagnostic,tratament);
    }

    public ClinicalDocument() {
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
     *
     * @param patient
     */
    public void setPatient(Patient patient) {
        if(patient.getMaritalStatus()==null)    patient.setMaritalStatus("nullFlavor");
        if(patient.getReligious()==null)        patient.setReligious("nullFlavor");
        if(patient.getRace()==null)             patient.setRace("nullFlavor");
        if(patient.getEthnicGroup()==null)      patient.setEthnicGroup("nullFlavor");
        
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
     *
     * @param author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }
    
    /**
     * Retorna uma representação Authentic do objeto. Em geral, o método
     * {@code getAuthentic} retorna um Authentic que representa este objeto.
     * <p>
     * O método {@code getAuthentic} para a classe {@code ClinicalDocument}
     * retorna um Authentic consistindo nos dados de autenticação do qual o
     * objeto é uma instância. Em outras palavras, este método deve retornar 
     * a informação contida no método instanciado por este objeto, como mostrado
     * na implementação:
     * <blockquote>
     * <pre>
     * getClass().getAuthentic().getCode();
     * </pre></blockquote>
     *
     * @return  uma representação Authentic do objeto.
     */
    public Authenticator getAuthentic() {
        return authentic;
    }

    /**
     * @param authentic
     */
    public void setAuthentic(Authenticator authentic) {
        this.authentic = authentic;
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
     *
     * @param dhistoric
     */
    public void setDoctorHistoric(DoctorHistoric dhistoric) {
        this.doctorHistoric = dhistoric;
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
     * 
     * @param tratament
     */
    public void setTratament(Tratament tratament) {
        this.tratament = tratament;
    }
   
    /**
     * É necessário chamar este método ao final da implementação para que seja criado o arquivo XML no diretório.
     * <br><br>
     * Este método realiza a operação de escrita das informações do arquivo ClinicalDocument para o XML.
     * @return 
     */
    public boolean GenerateCDAFile(){
        JContent jContent = new JContent(local(""+patient.getId()),header, patient, author, authentic, related, responsibleParty, healthHistoric, doctorHistoric, medicines, allergy, familyHistoric, exams, laboratoryExams, diagnostic, tratament);
        ValidateCDA validator = new ValidateCDA();
        
        try {
            if(jContent.generateContent()){
                System.out.println("Success when writing file\n");
            
                if(validator.validationCDAFile(local(""+patient.getId()))){
                    System.out.println(""+validator.getNotificacao());
                }else
                    System.err.println(""+validator.getNotificacao());
                return true;
            }else
                System.err.println("Error writing file\n");
            
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return false;
    }
}
