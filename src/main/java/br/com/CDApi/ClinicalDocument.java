package br.com.CDApi;

import br.com.CDApi.bean.*;
import br.com.CDApi.validator.ValidationCDA;
import controller.CDApiLogger;
import controller.DocumentStructure;
import controller.XMLRead;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Classe responsavel pela escrita, leitura e validaçao do Documento CDA.
 *
 * @author Gyovanne Cavalcanti
 * @version 1.0
 * @see https://sites.google.com/view/cdapi
 */
public class ClinicalDocument {

    private static String local(String fileName) {
        File direct = new File("");
        File file = new File("" + direct.getAbsolutePath() + "/XML");
        file.mkdir();
        return file.getAbsolutePath() + "/" + fileName;
    }

    private static String date(String form) {
        SimpleDateFormat format = new SimpleDateFormat(form);
        Calendar today = Calendar.getInstance();
        return (format.format(today.getTime()));
    }

    private boolean status;
    private File xmlFile;
    private Header header;
    private Patient patient;
    private Author author;
    private Authenticator authenticator;
    private Related related;
    private ResponsibleParty responsibleParty;
    private ArrayList<Component> components;
    private CDApiLogger logger;

    /**
     * Contrutor com argumento necessário para leitura do Arquivo XML. <br>
     * Necessário informar o Arquivo XML ao qual será usado para leitura. <br>
     * Exemplo de implementação:<br>
     * <blockquote>
     *
     * <pre>
     * {@code
     * ClinicalDocument cda = new ClinicalDocuement(File file);}
     * </pre>
     *
     * </blockquote>
     *
     * @param xml Arquivo xml que sera lido.
     */
    public ClinicalDocument(File xml) {
        logger = new CDApiLogger();
        this.status = true;
        if (xml.exists()) {
            ValidationCDA vcda = new ValidationCDA();
            try {
                if (vcda.toValidate(xml)) {
                    new XMLRead(this, xml).toRead();
                } else {
                    logger.setup();
                    logger.warning(this.getClass().getName(), "Constructor", "Arquivo não pode ser lido, pois ocorreu um erro de validação!\n");
                    System.err.println(vcda.getNotification());
                }
            } catch (IOException ex) {
                logger.setup();
                logger.severe(this.getClass().getName(), "Constructor", ex.getLocalizedMessage());
            }
        } else {
            logger.setup();
            logger.warning(this.getClass().getName(), "Constructor", "Arquivo XML não encontrado!");
        }
    }

    /**
     * Construtor sem argumento. <br>
     * Não é necessário informar nenhum parâmetro, pois a instância do objeto a
     * partir deste construtor é usada para acessar os métodos de escrita do
     * Arquivo XML. <br>
     * Exemplo de implementação:<br>
     * <blockquote>
     *
     * <pre>
     * {
     * 	&#64;code
     * 	ClinicalDocument cda = new ClinicalDocuement();
     * }
     * </pre>
     *
     * </blockquote>
     */
    public ClinicalDocument() {
        logger = new CDApiLogger();
        this.status = false;
    }

    public CDApiLogger getLogger() {
        return logger;
    }

    private File getXmlFile() {
        return xmlFile;
    }

    private void setXmlFile(File xmlFile) {
        this.xmlFile = xmlFile;
    }

    /**
     * Retorna uma representação Header do objeto. Em geral, o método
     * {@code getHeader} retorna um Header que representa este objeto.
     * <p>
     * O método {@code getHeader} para a classe {@code ClinicalDocument} retorna
     * um Header consistindo nos dados do cabeçario do qual o objeto é uma
     * instância. Em outras palavras, este método deve retornar a informação
     * contida no método instanciado por este objeto, como mostrado na
     * implementação: <blockquote>
     *
     * <pre>
     * {@code
     * clinicalDocument.getHeader().getId();}
     * </pre>
     *
     * </blockquote>
     *
     * @return uma representação Header do objeto.
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Recebe uma representação Header do objeto. O método {@code setHeader}
     * para a classe {@code ClinicalDocument} deve receber as informações
     * necessárias de um {@code Header} para que seja preenchido nos campos que
     * corresponde aos dados de cabeçario no documento CDA. Para isto, as
     * informações devem ser válidas. O método deve ser instanciado como
     * mostrado na implementação: <blockquote>
     *
     * <pre>
     * {@code clinicalDocument.setHeader(Header header);}
     * </pre>
     *
     * </blockquote>
     *
     * @param header
     */
    public void setHeader(Header header) {
        if (header.getEfetiveTime() == null) {
            header.setEfetiveTime(date("yyyyMMddHHmmss"));
        }
        this.header = header;
    }

    /**
     * Retorna uma representação Patient do objeto. Em geral, o método
     * {@code getPatient} retorna um Patient que representa este objeto.
     * <p>
     * O método {@code getPatient} para a classe {@code ClinicalDocument}
     * retorna um Patient consistindo nos dados do paciente do qual o objeto é
     * uma instância. Em outras palavras, este método deve retornar a informação
     * contida no método instanciado por este objeto, como mostrado na
     * implementação: <blockquote>
     *
     * <pre>
     * {@code
     * clinicalDocument.getPatient().getId();}
     * </pre>
     *
     * </blockquote>
     *
     * @return uma representação Patient do objeto.
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Recebe uma representação Patient do objeto. O método {@code setPatient}
     * para a classe {@code ClinicalDocument} deve receber as informações
     * necessárias de um {@code Patient} para que seja preenchido nos campos que
     * corresponde aos dados do paciente no documento CDA. Para isto, as
     * informações devem ser válidas. O método deve ser instanciado como
     * mostrado na implementação:
     * <blockquote>
     *
     * <pre>
     * {@code clinicalDocument.setPatient(Patient patient);}
     * </pre>
     *
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
     * O método {@code getAuthor} para a classe {@code ClinicalDocument} retorna
     * um Author consistindo nos dados do médico do qual o objeto é uma
     * instância. Em outras palavras, este método deve retornar a informação
     * contida no método instanciado por este objeto, como mostrado na
     * implementação: <blockquote>
     *
     * <pre>
     * {@code
     * clinicalDocument.getAuthor().getCrm();}
     * </pre>
     *
     * </blockquote>
     *
     * @return uma representação Author do objeto.
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Recebe uma representação Author do objeto. O método {@code setAuthor}
     * para a classe {@code ClinicalDocument} deve receber as informações
     * necessárias de um {@code Author} para que seja preenchido nos campos que
     * corresponde aos dados do médico no documento CDA. Para isto, as
     * informações devem ser válidas. O método deve ser instanciado como
     * mostrado na implementação: <blockquote>
     *
     * <pre>
     * {@code clinicalDocument.setAuthor(Author author);}
     * </pre>
     *
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
     * objeto é uma instância. Em outras palavras, este método deve retornar a
     * informação contida no método instanciado por este objeto, como mostrado
     * na implementação: <blockquote>
     *
     * <pre>
     * {@code
     * clinicalDocument.getAuthenticator().getCode();}
     * </pre>
     *
     * </blockquote>
     *
     * @return uma representação Authentic do objeto.
     */
    public Authenticator getAuthenticator() {
        return authenticator;
    }

    /**
     * Recebe uma representação Authentic do objeto. O método
     * {@code setAuthenticator} para a classe {@code ClinicalDocument} deve
     * receber as informações necessárias de um {@code Authentic} para que seja
     * preenchido nos campos que corresponde aos dados de autenticação no
     * documento CDA. Para isto, as informações devem ser válidas. O método deve
     * ser instanciado como mostrado na implementação: <blockquote>
     *
     * <pre>
     * {@code clinicalDocument.setAuthenticator(Authenticator authenticator);}
     * </pre>
     *
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
     * retorna um Related consistindo nos dados relacionados do qual o objeto é
     * uma instância. Em outras palavras, este método deve retornar a informação
     * contida no método instanciado por este objeto, como mostrado na
     * implementação: <blockquote>
     *
     * <pre>
     * {@code
     * clinicalDocument.getRelated().getId();}
     * </pre>
     *
     * </blockquote>
     *
     * @return uma representação Related do objeto.
     */
    public Related getRelated() {
        return related;
    }

    /**
     * Recebe uma representação Related do objeto. O método {@code setRelated}
     * para a classe {@code ClinicalDocument} deve receber as informações
     * necessárias de um {@code Related} para que seja preenchido nos campos que
     * corresponde aos dados de relacionados no documento CDA. Para isto, as
     * informações devem ser válidas. O método deve ser instanciado como
     * mostrado na implementação:
     * <blockquote>
     *
     * <pre>
     * {@code clinicalDocument.setRelated(Related related);}
     * </pre>
     *
     * </blockquote>
     *
     * @param related
     */
    public void setRelated(Related related) {
        this.related = related;
    }

    /**
     * Retorna uma representação Responsible do objeto. Em geral, o método
     * {@code getResponsibleParty} retorna um Responsible que representa este
     * objeto.
     * <p>
     * O método {@code getResponsibleParty} para a classe
     * {@code ClinicalDocument} retorna um Responsible consistindo nos dados do
     * responsável do paciente do qual o objeto é uma instância. Em outras
     * palavras, este método deve retornar a informação contida no método
     * instanciado por este objeto, como mostrado na implementação: <blockquote>
     *
     * <pre>
     * {@code
     * clinicalDocument.getResponsibleParty().getId();}
     * </pre>
     *
     * </blockquote>
     *
     * @return uma representação Responsible do objeto.
     */
    public ResponsibleParty getResponsibleParty() {
        return responsibleParty;
    }

    /**
     * Recebe uma representação ResponsibleParty do objeto. O método
     * {@code setResponsibleParty} para a classe {@code ClinicalDocument} deve
     * receber as informações necessárias de um {@code ResponsibleParty} para
     * que seja preenchido nos campos que corresponde aos dados do responsável
     * no documento CDA. Para isto, as informações devem ser válidas. O método
     * deve ser instanciado como mostrado na implementação: <blockquote>
     *
     * <pre>
     * {@code clinicalDocument.setResponsibleParty(ResponsibleParty responsibleParty);}
     * </pre>
     *
     * </blockquote>
     *
     * @param responsibleParty
     */
    public void setResponsibleParty(ResponsibleParty responsibleParty) {
        this.responsibleParty = responsibleParty;
    }

    /**
     * Retorna uma representação ArrayList do objeto.
     * <p>
     * O método {@code getComponents} para a classe {@code ClinicalDocument}
     * retorna um ArrayList consistindo nos dados dos componentes que fazem
     * parte do Documento. Em outras palavras, este método deve retornar um
     * ArrayList contendo nas informaçoes do paciente, tais como: Historico
     * medico, medicamentos, doenças, etc. Para exibir os dados dos componentes,
     * o método deve ser instanciado como mostrado no exemplo de implementação:
     * <blockquote>
     *
     * <pre>
     * {@code
     * for(int i = 0; clinicalDocument.getComponents().size(); i++){
     *  //Titulo do componente
     *  System.out.println(clinicalDocument.getComponents().get(0).getTitle());
     * //Conteudo do componente (tambem um ArrayList)
     *  System.out.println(clinicalDocument.getComponents().get(0).getContent());
     * }
     * clinicalDocument.getComponents().}
     * </pre>
     *
     * </blockquote>
     *
     * @return uma representação ArrayList com as informaçoes dos componentes
     */
    public ArrayList<Component> getComponents() {
        return components;
    }

    /**
     * Recebe uma representação ArrayList do objeto.
     * <p>
     * O método {@code getComponents} para a classe {@code ClinicalDocument}
     * recebe um ArrayList consistindo nos dados dos componentes que fazem parte
     * do Documento. Em outras palavras, este método deve receber um ArrayList
     * contendo nas informaçoes do paciente, tais como: Historico medico,
     * medicamentos, doenças, etc. Para exibir os dados dos componentes, o
     * método deve ser instanciado como mostrado no exemplo de implementação:
     * EXEMPLO PARA INSERIR HISTORICO DA DOENÇA DO PACIENTE <blockquote>
     *
     * <pre>
     * {@code
     * ArrayList  <Component> componentes = new ArrayList();
     *
     * ArrayList historico = new ArrayList();
     * historico.add("Ditar o histórico da doença do paciente");
     * componentes.add(new Component("Historico da doença", historico));
     *  .
     *  .
     *  .
     * clinicalDocument.setComponents(componentes);}
     * </pre>
     *
     * </blockquote>
     *
     * @param components ArrayList dos componentes
     */
    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    /**
     * Retorna uma representação boolean do objeto. Em geral, o método
     * {@code toGenerateCDAFile} retorna um boolean, sendo true para a criação e
     * validação bem sucedida do Arquivo XML e false caso não tenha gerado ou
     * validado com sucesso.
     * <p>
     * O método {@code toGenerateCDAFile} para a classe {@code ClinicalDocument}
     * recebe um diretório como parâmetro onde será salvo o Arquivo XML gerado
     * no local indicado. Retorna um valor booleano que indica o resultado da
     * criação e validação de documento CDA. Esse documento sera Validado com o
     * validador da própria aplicação, para que seus campos corresponda ao
     * padrão HL7 CDA. O método deve ser instanciado como mostrado na
     * implementação: <blockquote>
     *
     * <pre>
     * {@code clinicalDocument.toGenerateCDAFile(String path);}
     * </pre>
     *
     * </blockquote>
     *
     * @param path local para onde sera escrito o arquivo XML
     * @return um valor booleano para fins de verificação.
     */
    public boolean toGenerateCDAFile(String path) {
        boolean value;
        if (this.status == true) {
            logger.warning(this.getClass().getName(), "Constructor", "Para gerar o arquivo o contrutor da classe ClinicalDocument não pode conter parâmetros!");
            return false;
        }
        toInitializeObjects();
        String idFile;
        if (patient.getId() == 0) {
            idFile = "Sem título" + " " + date("dd-MM-yyyy_HH:mm:ss") + ".xml";
        } else {
            idFile = "" + patient.getName() + " " + patient.getFamily() + "_" + patient.getId() + " "
                    + date("dd-MM-yyyy_HH:mm:ss") + ".xml";
        }

        if (path != null) {
            setXmlFile(new File(path + "/" + idFile));
        } else {
            setXmlFile(new File(local(idFile)));
        }

        if (new DocumentStructure(getXmlFile(), this).generateContent()) {
            ValidationCDA vcda = new ValidationCDA();
            try {
                if (vcda.toValidate(getXmlFile())) {
                    value = true;
                } else {
                    value = false;
                    logger.severe(this.getClass().getName(), "toGenerateCDAFile", vcda.getNotification());
                }
            } catch (IOException ex) {
                logger.setup();
                logger.severe(this.getClass().getName(), "toGenerateCDAFile", ex.getLocalizedMessage());
                value = false;
            }
        } else {
            value = false;
        }
        return value;
    }

    /**
     * Retorna uma representação boolean do objeto. Em geral, o método
     * {@code toGenerateCDAFile} retorna um boolean, sendo true para a criação e
     * validação bem sucedida do Arquivo XML e false caso não tenha gerado ou
     * validado com sucesso.
     * <p>
     * O método {@code toGenerateCDAFile} para a classe {@code ClinicalDocument}
     * retorna um valor booleano, que indica o resultado da criação e validação
     * de um documento CDA. Após o método ser chamado ele gera um documento CDA
     * dentro da pasta XML, no diretório da aplicação, ao mesmo tempo que valida
     * com o validador da própria aplicação, para que seus campos corresponda ao
     * padrão HL7 CDA. O método deve ser instanciado como mostrado na
     * implementação:
     * <blockquote>
     *
     * <pre>
     * {@code clinicalDocument.toGenerateCDAFile();}
     * </pre>
     *
     * </blockquote>
     *
     * @return um valor booleano para fins de verificação.
     */
    public boolean toGenerateCDAFile() {
        return toGenerateCDAFile(null);
    }

    private void toInitializeObjects() {
        if (this.header == null) {
            this.header = new Header();
        }
        if (this.patient == null) {
            this.patient = new Patient();
        }
        if (this.author == null) {
            this.author = new Author();
        }
        if (this.authenticator == null) {
            this.authenticator = new Authenticator();
        }
        if (this.related == null) {
            this.related = new Related();
        }
        if (this.responsibleParty == null) {
            this.responsibleParty = new ResponsibleParty();
        }
        if (this.components == null) {
            this.components = new ArrayList<>();
        }
    }
}
