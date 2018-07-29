package br.com.multcare.validator;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.xml.sax.SAXException;

/**
 *
 * @author Gyovanne
 */
public class ValidateCDA {

    private File xmlFile;
    private File xsdFile;
    private String notificacao;
    
    /**
     * Retorna uma representação String do objeto. Em geral, o método
     * {@code getNotificacao} retorna uma String representando o resultado do processamento 
     * de validação do arquivo, se foi bem sucedida ou não.
     * <p>
     * O método {@code getNotificacao} para a classe {@code ValidateCDA}
     * retorna uma String, que indica o resultado da validação de 
     * um documento CDA, conforme o padrão HL7 CDA.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().getNotificacao();</pre>
     * </blockquote>
     *
     * @return  uma String para fins de representação.
     */
    public String getNotificacao() {
        return notificacao;
    }
    private File getXmlFile() {
        return xmlFile;
    }
    
    private void setXmlFile(File xmlFile) {
        this.xmlFile = xmlFile;
    }

    private File getXsdFile() {
        return xsdFile;
    }

    private void setXsdFile(File xsdFile) {
        this.xsdFile = xsdFile;
    }

    private boolean validate(File xml) {
        setXsdFile(new File("CDA.xsd"));
        
        File f = new File(xml.getAbsolutePath());
 
        try {
            SchemaFactory schemafactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

            File schemaLocation = getXsdFile();
            Schema schema = schemafactory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();

            Source source = new StreamSource(xml);

            validator.validate(source);
            setNotificacao(xml,true,null,null);
            return true;

        } catch (SAXException | IOException ex) {
            setNotificacao(xml,false,ex.getLocalizedMessage(),ex.toString());
            return false;
        }
    }

    private static Date getValidationDate(){
        return new Date();
    }
    
    /**
     * Retorna uma representação boolean do objeto. Em geral, o método
     * {@code validationCDAFile} retorna um boolean, sendo true para uma validação
     * bem sucedida e false caso não tenha validado com sucesso.
     * <p>
     * O método {@code validationCDAFile} para a classe {@code ValidateCDA}
     * retorna um valor booleano, que indica o resultado da validação de 
     * um documento CDA. Após o método receber o arquivo {@code File} como parâmetro,
     * ele verifica se todos os campos do esquema XML corresponde ao padrão HL7 CDA,
     * de acordo com um XSD válido dentro da aplicação.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().validationCDAFile(File xml);</pre>
     * </blockquote>
     *
     * @param xml
     * @return  um valor booleano para fins de verificação.
     */
    public boolean validationCDAFile(File xml){
        return validate(xml);
    }
    
    /**
     * Retorna uma representação boolean do objeto. Em geral, o método
     * {@code validationCDAFile} retorna um boolean, sendo true para uma validação
     * bem sucedida e false caso não tenha validado com sucesso.
     * <p>
     * O método {@code validationCDAFile} para a classe {@code ValidateCDA}
     * retorna um valor booleano, que indica o resultado da validação de 
     * um documento CDA. Após o método receber uma {@code String} como parâmetro,
     * ele verifica se todos os campos do esquema XML corresponde ao padrão HL7 CDA,
     * de acordo com um XSD válido dentro da aplicação.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().validationCDAFile(String xmlFileName);</pre>
     * </blockquote>
     *
     * @param xmlFileName
     * @return  um valor booleano para fins de verificação.
     */
    public boolean validationCDAFile(String xmlFileName){
        setXmlFile(new File(local(xmlFileName)));
        return validationCDAFile(getXmlFile()); 
    }
    
    /**
     * Retorna uma representação boolean do objeto. Em geral, o método
     * {@code validationCDAFile} retorna um boolean, sendo true para uma validação
     * bem sucedida e false caso não tenha validado com sucesso.
     * <p>
     * O método {@code validationCDAFile} para a classe {@code ValidateCDA}
     * retorna um valor booleano, que indica o resultado da validação de 
     * um documento CDA. Após o método receber um {@code integer} carrespondente ao id do paciente como parâmetro,
     * ele verifica se todos os campos do esquema XML corresponde ao padrão HL7 CDA,
     * de acordo com um XSD válido dentro da aplicação.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>getClass().validationCDAFile(int idPatient);</pre>
     * </blockquote>
     *
     * @param IdPatient
     * @return  um valor booleano para fins de verificação.
     */
    public boolean validationCDAFile(int IdPatient){
        return validationCDAFile(IdPatient+".xml");
    }

    private void setNotificacao(File xml,boolean value,String menssage,String detail) {
        this.notificacao = "Relatório de validação para "+xml.toString()+
                           "\nValidando: esquema XML CDA"+
                           "\nData de validação: "+getValidationDate()+
                           "\nResultado do teste: "+value;
                           
        if(value)this.notificacao += "\n\nValidado\nNenhum problema encontrado!";
        else this.notificacao += "\n\nErro de Validação!\n\nMensagem:\n"+menssage+
                                 "\n"+detail;
    }
    
    private String local(String filename){
        File direct = new File("");
        File file = new File(""+direct.getAbsolutePath()+"/XML_FILES");
        file.mkdir();
        return file.getAbsolutePath()+"/"+filename;
    }
}