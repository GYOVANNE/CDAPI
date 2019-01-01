package br.com.CDApi.validator;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import org.xml.sax.SAXException;
/**
 * Classe responsável por validar o conteúdo XML.
 * @author Gyovanne Cavalcanti
 */
public class ValidateCDA {

    private File xmlFile;
    private URL xsdFile;
    private String notification;

    /**
     * Retorna uma representação String do objeto. Em geral, o método
     * {@code getNotification} retorna uma String representando o resultado do processamento 
     * de validação do arquivo, se foi bem sucedida ou não.
     * <p>
     * O método {@code getNotification} para a classe {@code ValidateCDA}
     * retorna uma String, que indica o resultado da validação de 
     * um documento CDA, conforme o padrão HL7 CDA.
     * O método deve ser instanciado como mostrado na implementação:
     * <blockquote>
     * <pre>{@code getClass().getNotification();}</pre>
     * </blockquote>
     *
     * @return  uma String para fins de representação.
     */
    public String getNotification() {
        return notification;
    }
    private File getXmlFile() {
        return xmlFile;
    }
    private void setXmlFile(File xmlFile) {
        this.xmlFile = xmlFile;
    }

    private void setXsdFile(URL xsdFile) {
        this.xsdFile = xsdFile;
    }

    private URL getXsdFile() {
       return xsdFile; 
    }
    private URL localFile() throws IOException {
        return ValidateCDA.class.getResource("/Resources/CDA.xsd");
    }
    private boolean validate(File xml) throws IOException{
        setXsdFile(localFile());

        if(getXsdFile()==null){
            setNotification(xml,false,"Arquivo XSD não encontrado!","Não foi possivel encontrar o arquivo XSD de origem."
                                     +"\nVerifique se a pasta Resources está no diretorio src da aplicação.");
            return false;
        }

        try {
            SchemaFactory schemafactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

            URL schemaLocation = getXsdFile();
            Schema schema = schemafactory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();

            Source source = new StreamSource(xml);

            validator.validate(source);
            setNotification(xml,true,null,null);
            return true;

        } catch (SAXException | IOException ex) {
            setNotification(xml,false,ex.getLocalizedMessage(),ex.toString());
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
     * <pre>{@code getClass().validationCDAFile(File xml);}</pre>
     * </blockquote>
     *
     * @param xml Arquivo xml ao qual sera validado.
     * @return  um valor booleano para fins de verificação.
     * @throws java.io.IOException
     */
    public boolean validationCDAFile(File xml) throws IOException{
        return validate(xml);
    }

    private void setNotification(File xml,boolean value,String menssage,String detail) {
        this.notification = "Relatório de validação para "+xml.getName()+
                           "\nValidando: esquema XML CDA"+
                           "\nData de validação: "+getValidationDate()+
                           "\nResultado do teste: "+value;
         
        if(value)this.notification += "\n\nValidado\nNenhum problema encontrado!";
        else this.notification += "\n\nErro de Validação!\n\nMensagem:\n"+menssage+
                                 "\n"+detail;
    }
}