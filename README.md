# CDA
# Cliente HL7 CDA Orientação
=========
Introdução
=========

Esta API cliente pretende mostrar um simples exemplo  do Hl7 CDA Orientação.

É uma API simples de usar, que irá gerar, ler e  validar um documento XML baseado em CDA.
===========
Configuração
===========
 
O arquivo .jar está localizado no diretório dist. Se você preferir usar suas próprias cópias desses pacotes, certifique-se de que esse arquivo .jar está
localizado no classpath Java, junto com a pasta lib de dependencias.

Não há  arquivos .jar necessários.
É necessário incluir o arquivo DocumentaçãoHL7CDA.zip junto ao arquivo executável e setar na aplicação para fazer uso da documentação da API.

O cliente é um .jar executável simples. Não há etapas de configuração adicionais que são necessárias.
========
Execução
========
Este cliente é liberado com um arquivo .jar Java não executável. É necessário pelo menos ter o Java 2 SDK (versão
1.5 ou posterior). Para utilizar o cliente, certifique-se de que o arquivo java não-executável está em seu caminho.

=================================
DESCRIÇÃO DE SAÍDA DA CONSTRUÇÃO
=================================

Para distribuir este projeto, feche a pasta dist (incluindo a pasta lib)
e distribua o arquivo ZIP.

Informações adicionais:

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
