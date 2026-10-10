<h1 align="center">☕ Jogo da Forca — Lista de Aquecimento (POO)</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white" alt="Java"/>
  <img src="https://img.shields.io/badge/POO-6A0DAD?style=flat&logo=hackthebox&logoColor=white" alt="POO"/>
  <img src="https://img.shields.io/badge/XStream-XML-2C7BB6?style=flat" alt="XStream"/>
  <img src="https://img.shields.io/badge/iText-PDF-D32F2F?style=flat&logo=adobeacrobatreader&logoColor=white" alt="iText"/>
  <img src="https://img.shields.io/badge/JavaMail-E-mail-EA4335?style=flat&logo=gmail&logoColor=white" alt="JavaMail"/>
  <img src="https://img.shields.io/badge/Eclipse-2C2255?style=flat&logo=eclipseide&logoColor=white" alt="Eclipse"/>
</p>

<p align="center">
  Projeto desenvolvido para a disciplina <b>Programação Orientada a Objetos</b> (ADS – Prof. Cleyton Caetano de Souza),<br>
  referente à <i>Lista Semanal de Aquecimento para o Projeto</i>.
</p>

---

O sistema permite cadastrar jogadores, importar palavras de um arquivo CSV, gerar relatórios em PDF, enviar e-mails aos jogadores cadastrados e jogar uma partida de Jogo da Forca, com persistência dos dados em XML.

## Equipe

| Integrante | GitHub |
|---|---|
| Hádrian Renê | [@hadriiiian](https://github.com/hadriiiian) |
| Eduardo Hipólito | [@eduardohtech](https://github.com/eduardohtech) |
| João Augusto | [@joaoaugusto14](https://github.com/joaoaugusto14) |

## 🧩 Funcionalidades

- **Cadastro de jogadores**: nome, sexo, CPF e e-mail (CPF e e-mail únicos no sistema).
- **Listagem de jogadores** cadastrados.
- **Busca de jogador** por CPF ou por e-mail.
- **Importação de palavras via CSV** (`palavra, nível de dificuldade, dica`).
- **Listagem de palavras** cadastradas.
- **Geração de relatório em PDF** com a lista de jogadores e palavras.
- **Envio de e-mail** a todos os jogadores cadastrados.
- **Persistência automática** da Central de Informações em `central.xml` (via XStream), recuperada a cada execução.
- Estrutura já preparada para o **Jogo da Forca** (sorteio de palavra, tentativa de letras, controle de gabarito).

## 📂 Estrutura de classes

| Classe | Responsabilidade |
|---|---|
| `Main` | Menu principal e fluxo de interação com o usuário |
| `Jogador` | Representa um usuário do sistema (nome, e-mail, sexo, CPF) |
| `Sexo` | Enum com os valores `MASCULINO` e `FEMININO` |
| `Palavra` | Representa uma palavra do jogo (termo, dica, dificuldade, data de cadastro) |
| `Dificuldade` | Enum com os níveis `FACIL`, `MEDIO`, `DIFICIL` |
| `CentralDeInformacoes` | Armazena as listas de jogadores e de palavras; regras de unicidade |
| `Persistencia` | Salva/recupera a `CentralDeInformacoes` em `central.xml` usando XStream |
| `ExtratorPalavrasCSV` | Lê um arquivo CSV e gera uma lista de objetos `Palavra` |
| `GeradorDeRelatorios` | Gera um relatório em PDF (`relatorio.pdf`) com jogadores e palavras, usando iText |
| `Mensageiro` | Envia e-mails via SMTP (Gmail) usando JavaMail |
| `JogoDaForca` | Lógica do jogo: sorteio de palavra, tentativa de letras, gabarito e controle de acertos |

## Dependências externas

O projeto utiliza três bibliotecas que precisam estar no *classpath*:

| Biblioteca | Uso | Classe |
|---|---|---|
| **XStream** | Serialização de objetos em XML | `Persistencia` |
| **iText** (`com.itextpdf`) | Geração de PDF | `GeradorDeRelatorios` |
| **JavaMail** (`javax.mail`) | Envio de e-mails via SMTP | `Mensageiro` |

Se estiver usando Maven, adicione ao `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>com.thoughtworks.xstream</groupId>
        <artifactId>xstream</artifactId>
        <version>1.4.20</version>
    </dependency>
    <dependency>
        <groupId>com.itextpdf</groupId>
        <artifactId>itextpdf</artifactId>
        <version>5.5.13.3</version>
    </dependency>
    <dependency>
        <groupId>com.sun.mail</groupId>
        <artifactId>javax.mail</artifactId>
        <version>1.6.2</version>
    </dependency>
</dependencies>
```

Caso esteja usando Eclipse/IntelliJ sem Maven, baixe os `.jar` correspondentes e adicione-os manualmente ao *build path* do projeto.

## Como executar

1. Compile todas as classes `.java` do projeto (garanta que as dependências acima estejam no classpath).
2. Execute a classe `Main`.
3. Utilize o menu interativo:

```
[ 1 ] - Novo jogador
[ 2 ] - Listar todos os jogadores
[ 3 ] - Exibir as informações de um jogador
[ 4 ] - Salvar palavras a partir de um arquivo CSV
[ 5 ] - Listar todas as palavras
[ 6 ] - Relatório em PDF
[ 7 ] - Enviar email à todos os jogadores
[ "S" ] - Sair
```

Os dados ficam salvos automaticamente em `central.xml`, no diretório do projeto, e são recarregados a cada nova execução.

## Formato do arquivo CSV de palavras

Cada linha deve seguir o formato:

```
palavra, nível_de_dificuldade, dica
```

Onde `nível_de_dificuldade` é um número inteiro correspondente à posição no enum `Dificuldade`:

| Valor | Dificuldade |
|:-:|---|
| `0` | `FACIL` |
| `1` | `MEDIO` |
| `2` | `DIFICIL` |

Exemplo:

```
bola,0,objeto usado em atividades esportivas
computador,1,equipamento eletrônico usado para processar dados
paralelepipedo,2,sólido geométrico com seis faces retangulares
```

Se alguma linha estiver fora desse formato, `ExtratorPalavrasCSV.extrairPalavras` retorna `null` e o programa solicita novamente o nome do arquivo.

## Observações e pontos de atenção

> [!WARNING]
> **Credenciais de e-mail expostas**: a classe `Mensageiro` contém o e-mail e a senha do remetente diretamente no código-fonte. Antes de compartilhar ou versionar o projeto publicamente (ex.: GitHub), recomenda-se mover essas credenciais para variáveis de ambiente ou um arquivo de configuração fora do controle de versão, e trocar a senha exposta.

- **Jogo da Forca**: as classes `JogoDaForca`, `Palavra` e `Dificuldade` já implementam a lógica base do jogo (sorteio, tentativa de letras, gabarito), mas essa parte ainda não está integrada ao menu do `Main` — é o próximo passo natural do projeto completo.
- **`CentralDeInformacoes`**: os métodos de leitura (`readCPF`, `readEmail`, `readPalavra`) e adição (`addJogador`, `addPalavra`) evitam duplicidade de CPF/e-mail e de palavras repetidas, conforme exigido no enunciado.
