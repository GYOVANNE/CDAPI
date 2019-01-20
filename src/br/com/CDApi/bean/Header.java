package br.com.CDApi.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Classe responsavel por gerenciar as informaçoes referentes ao cabeçalho do
 * documento.
 *
 * @author Gyovanne Cavalcanti
 */
public class Header {

    private String realmCode;
    private String idRoot;
    private String extension;
    private String code;
    private String displayName;
    private String codeSystem;
    private String codeSystemName;
    private String efetiveTime;
    private String id;
    private int version;

    /**
     *
     */
    public Header() {
        this.realmCode = "nullFlavor";
        this.idRoot = "nullFlavor";
        this.extension = "2.16.840.1.113883.3.933";
        this.code = "0";
        this.displayName = "nullFlavor";
        this.codeSystem = "2.16.840.1.113883.6.103";
        this.codeSystemName = "ICD-9-CM";
        this.efetiveTime = date("yyyyMMddHHmmss");
        this.id = "nullFlavor";
        this.version = 1;
    }

    private static String date(String form) {
        SimpleDateFormat format = new SimpleDateFormat(form);
        Calendar today = Calendar.getInstance();
        return (format.format(today.getTime()));
    }

    /**
     * Retorna informaçao da regiao para qual o conteudo é escrito.
     *
     * @return O código de território.
     */
    public String getRealmCode() {
        return realmCode;
    }

    /**
     * O elemento {@code realmCode} é opcional. Quando aparece, declara a
     * regiao(ou regioes, como pode repetir) para o qual o conteúdo é escrito. O
     * código de território geralmente é usado para indicar quais políticas
     * regionais são aplicáveis ao conteúdo.
     *
     * @param realmCode
     */
    public void setRealmCode(String realmCode) {
        this.realmCode = realmCode;
    }

    /**
     *
     * @return Identidade do documento clinico.
     */
    public String getIdRoot() {
        return idRoot;
    }

    /**
     * . O atributo Id fornece uma identidade única para o documento clínico.
     * Dois documentos com o mesmo Id gravado no interior devem ser idênticos
     * respeito ao conteúdo. Os bytes usados para representar o XML podem ser
     * diferentes (por exemplo, um em EBCDIC e outro em UCS-16), mas o conteúdo
     * deve ser o mesmo.
     *
     * @param idRoot
     */
    public void setIdRoot(String idRoot) {
        this.idRoot = idRoot;
    }

    /**
     *
     * @return
     */
    public String getExtension() {
        return extension;
    }

    /**
     *
     * @param extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * O atributo {@code code} identifica um conceito específico dentro desse
     * conjunto, assim como o atributo {@code extension} identifica uma
     * instância específica de um identificador dentro do tipo de dados II.
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return Sistema que esta utilizando o documento CDA.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * O atributo XML {@code displayName} fornece um nome legível para o código.
     * este atributo carrega semântica computável e é simplesmente fornecido
     * como uma ajuda para interpretação humana. Em um documento CDA, o
     * displayName deve aparecer normalmente no mesmo idioma que o documento
     * está escrito. No cabeçalho {@code displayName} refere-se ao nome do
     * sistema que esta sendo utilziado.
     *
     * @param displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     *
     * @return
     */
    public String getCodeSystem() {
        return codeSystem;
    }

    /**
     * O atributo {@code codeSystem} identifica um conjunto (ou espaço de nomes)
     * de conceitos, assim como o atributo {@code root} do tipo de dados II
     * identifica um conjunto (ou namespace) de identificadores.Quando
     * nullFlavor assume o valor de OTH, o atributo codeSystem é necessário para
     * estar presente para indicar em que sistema de codificação o valor não
     * pôde ser codificado. Os códigos ICD-9-CM pode ser usado como o valor do
     * atributo. Um exemplo de entrada para este codeSystem é :
     * <p>
     * 2.16.840.1.113883.6.103
     * <p>
     * Código de inscrição OID para códgigos de diagnósticos ICD-9-CM
     *
     * @see http://oid-info.com/
     * @param codeSystem
     */
    public void setCodeSystem(String codeSystem) {
        this.codeSystem = codeSystem;
    }

    /**
     *
     * @return Nome legível para o código de sistema.
     */
    public String getCodeSystemName() {
        return codeSystemName;
    }

    /**
     * O atributo XML {@code codeSystemName} fornece um nome legível para o
     * sistema de código. Este atributo não carrega semântica computável e é
     * simplesmente fornecido como uma ajuda para a interpretação humana.
     *
     * @param codeSystemName
     */
    public void setCodeSystemName(String codeSystemName) {
        this.codeSystemName = codeSystemName;
    }

    /**
     *
     * @return Data de criação do documento clinico.
     */
    public String getEfetiveTime() {
        return efetiveTime;
    }

    /**
     * O atributo de classe {@code effectiveTime} indica a data de criação do
     * documento clínico. Mais precisamente, o CDA Release 2 define o tempo
     * efetivo de um documento clínico para ser o hora em que foi criada, o que
     * não é totalmente correto. O tempo efetivo de uma clínica documento é o
     * tempo entre o seu lançamento para atendimento e o momento em que é
     * retirado usar ou não mais válido para atendimento. Em quase todos os
     * casos, este último valor nunca é conhecido avanço, e certamente nunca
     * conhecido com 100% de certeza porque um documento pode ser revisado e
     * relançado (com um novo identificador) substituindo uma versão anterior a
     * qualquer momento. o O tempo de criação de um documento clínico deve
     * corresponder ao tempo de participação mais os autores do documento
     * clínico.<p>
     * Insira o valor {@code null} para que o documento seja formatado com a
     * data e hora atual do sistema, ou você pode passar um valor data
     * {@code String} no parâmetro.
     *
     * @param efetiveIime
     */
    public void setEfetiveTime(String efetiveIime) {
        this.efetiveTime = efetiveIime;
    }

    /**
     *
     * @return Identificação do documento.
     */
    public String getId() {
        return id;
    }

    /**
     * O atributo de classe setId é usado para identificar o documento.
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return Versão do documento
     */
    public int getVersion() {
        return version;
    }

    /**
     * O atributo de classe version é usados para identificar a versão do
     * documento.
     *
     * @param version
     */
    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "realmCode=" + realmCode + "\n idRoot=" + idRoot + "\n extension=" + extension + "\n code=" + code + "\n displayName=" + displayName + "\n codeSystem=" + codeSystem + "\n codeSystemName=" + codeSystemName + "\n efetiveTime=" + efetiveTime + "\n id=" + id + "\n version=" + version;
    }

}
