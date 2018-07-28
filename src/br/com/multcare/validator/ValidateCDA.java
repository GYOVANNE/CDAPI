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
            setNotificacao(xml,true,null);
            return true;

        } catch (SAXException | IOException ex) {
            setNotificacao(xml,false,ex.getLocalizedMessage());
            return false;
        }
    }

    private static Date getValidationDate(){
        return new Date();
    }
    
    /**
     *
     * @param xml
     * @return
     */
    public boolean validationCDAFile(File xml){
        return validate(xml);
    }
    
    /**
     * Validar arquivo XML com XSD manualmente.
     * @param xmlFileName
     * @return 
     */
    public boolean validationCDAFile(String xmlFileName){
        setXmlFile(new File(local(xmlFileName)));
        return validationCDAFile(getXmlFile()); 
    }

    /**
     * Validar arquivo a partir do id do paciente
     * @param IdPatient
     * @return 
     */
    public boolean validationCDAFile(int IdPatient){
        return validationCDAFile(IdPatient+".xml");
    }

    private void setNotificacao(File xml,boolean value,String menssage) {
        this.notificacao = "Relatório de validação para "+xml.toString()+
                           "\nValidando: esquema XML CDA"+
                           "\nData de validação: "+getValidationDate()+
                           "\nResultado do teste: "+value;
                           
        if(value)this.notificacao += "\n\nValidado\nNenhum problema encontrado!";
        else this.notificacao += "\n\nErro de Validação!\n\nMensagem:\n"+menssage;
    }
    
    private String local(String filename){
        File direct = new File("");
        File file = new File(""+direct.getAbsolutePath()+"/XML_FILES");
        file.mkdir();
        return file.getAbsolutePath()+"/"+filename;
    }
}