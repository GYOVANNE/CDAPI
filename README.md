# CDA
# Cliente HL7 CDA Orientação

# Introdução


Esta API cliente pretende mostrar um simples exemplo  do Hl7 CDA Orientação.

É uma API simples de usar, que irá gerar, ler e  validar um documento XML baseado em CDA.

# Configuração

O arquivo .jar está localizado no diretório CDACliente. Se você preferir usar suas próprias cópias desses pacotes, certifique-se de que esse arquivo .jar está localizado no classpath Java.

Para validação, é terminantemente necessário que a pasta lib esteja dentro do pacote da aplicação (juntamente com a src).

Não há  arquivos .jar (dependências externas) necessários.

Este cliente é liberado com um arquivo .jar Java não executável. É necessário pelo menos ter o Java 2 SDK (versão
1.5 ou posterior). Para utilizar o cliente, certifique-se de que o arquivo java não-executável está em seu caminho.

# DESCRIÇÃO DE SAÍDA DA CONSTRUÇÃO



É necessário incluir o arquivo DocumentaçãoHL7CDA.zip junto ao arquivo não executável e setar na aplicação para fazer uso da documentação da API.

O cliente é um .jar não executável simples que deve ser importado no diretório da aplicação cliente. Não há etapas de configuração adicionais que são necessárias.

O arquivo é validado no momento da escrita do arquivo XML.
O arquivo é validado no momento da leitura do arquivo XML.

O arquivo pode ser validado independente da escrita e leitura do XML.  

Informações adicionais:

* O arquivo CDA.xsd deve estar dentro da pasta lib, para que o arquivo XML gerado pela aplicação
seja validado corretamente. Implementações futuras irão tornar essa dependência obsoleta, visto
que a validação se dará por meio de web service (servidor multcare).
* Se dois arquivos JAR no caminho de classe do projeto tiverem o mesmo nome, somente o primeiro
O arquivo JAR é copiado para a pasta lib.
* Somente arquivos JAR são copiados para a pasta lib.
Se o classpath contiver outros tipos de arquivos ou pastas, esses arquivos (pastas)
não são copiados.
* Se uma biblioteca no caminho de classe do projeto também tiver um elemento Class-Path
especificado no manifesto, o conteúdo do elemento Class-Path deve estar ativado
o caminho de execução dos projetos.
* Para definir uma classe principal em um projeto Java padrão, clique com o botão direito do mouse no nó do projeto
na janela Projetos e escolha Propriedades. Em seguida, clique em Executar e digite o
nome da classe no campo Classe Principal. Como alternativa, você pode digitar manualmente
nome da classe no elemento manifest Main-Class.


!aviso Legal! 

AVISO DE RECONHECIMENTO DE SOFTWARE E REDISTRIBUIÇÃO:

Software disponibilizado apenas para uso com fins de pesquisas.