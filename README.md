# TSS-STOCK - Sistema de Controle de Estoque

## Descrição

O TSS-STOCK é um sistema de controle de estoque desenvolvido para facilitar o gerenciamento de produtos, categorias, fornecedores e usuários. Ele oferece funcionalidades como cadastro, listagem, pesquisa, edição e exclusão de produtos, além de controle de entrada e saída de estoque, geração de histórico de movimentações e envio de alertas de estoque baixo por e-mail.

## Funcionalidades

* Gerenciamento de produtos (cadastro, listagem, pesquisa, edição, exclusão)
* Gerenciamento de categorias de produtos
* Gerenciamento de fornecedores
* Controle de entrada e saída de estoque
* Exibição do estoque total
* Geração de histórico de movimentações de estoque
* Exportação de dados de estoque para CSV
* Cálculo do valor total do estoque
* Gerenciamento de usuários (cadastro, listagem, pesquisa, edição, exclusão)
* Login de usuários
* Controle de acesso por usuário
* Envio de alertas de estoque baixo por e-mail para gerentes

## Tecnologias Utilizadas

* Linguagem de programação: Java 17
* Framework: Spring Boot
* Banco de dados: MySQL
* Bibliotecas: Lombok, Spring Data JPA, Flyway, dotenv-java, Spring Boot Mail

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

* `src/main/java/com/tsslesselis/stock`: Código fonte da aplicação.
    * `controller`: Contém os controladores REST da aplicação.
    * `exception`: Contém classes de exceção personalizadas.
    * `model`: Contém as classes de modelo (entidades) que representam as tabelas do banco de dados.
    * `repository`: Contém as interfaces de repositório JPA.
    * `service`: Contém as classes de serviço que implementam a lógica de negócios.
    * `StockApplication.java`: Classe principal da aplicação Spring Boot.
* `src/main/resources`: Arquivos de configuração e recursos.
    * `db/migration`: Scripts de migração do Flyway.
    * `application.properties`: Arquivo de configuração.
* `src/test/java/com/tsslesselis/stock`: Código fonte dos testes da aplicação.
* `target`: Diretório de build da aplicação.
* `.env`: Arquivo de variáveis de ambiente (não incluído no repositório por motivos de segurança.
* `.gitignore`: Arquivo para ignorar arquivos no Git.
* `README.md`: Documentação do projeto.

## Pré-requisitos

* Docker
* Docker Compose
* Java 17

## Configuração

### Dependências

As dependências do projeto estão definidas no arquivo `pom.xml`. Certifique-se de que todas as dependências estejam corretamente configuradas.

### Variáveis de Ambiente

As variáveis de ambiente estão definidas no arquivo `.env`.  Certifique-se de criar um arquivo `.env` seguindo o exemplo abaixo:

```dotenv
# Configurações do MySQL
MYSQL_ROOT_PASSWORD= sua senha do root
MYSQL_DATABASE= sua base de dados
MYSQL_USER= seu usuário do banco de dados
MYSQL_PASSWORD= senha do seu usuário do banco de dados
MYSQL_HOST= seu host do banco de dados
MYSQL_PORT= sua porta do banco de dados

## Configurações de E-mail
MAIL_HOST= seu host de e-mail
MAIL_PORT= sua porta de e-mail
MAIL_USERNAME= seu usuário de e-mail
MAIL_PASSWORD= senha do seu usuário de e-mail
```
## Configurações de E-mail

O sistema utiliza um serviço de e-mail para enviar notificações, como alertas de estoque baixo. Para configurar este serviço, você precisa fornecer as credenciais de um servidor de e-mail no arquivo `.env`. Você pode usar um e-mail genérico, de teste ou um e-mail específico da aplicação.
## Docker

O projeto utiliza Docker e Docker Compose para facilitar a configuração e execução dos ambientes de desenvolvimento e produção.

### Dockerfile

O Dockerfile está configurado para construir a imagem da aplicação Spring Boot.

### Docker Compose

O `docker-compose.yml` está configurado para orquestrar os contêineres da aplicação Spring Boot e do banco de dados MySQL.

### Instruções para Execução

1. Certifique-se de que Docker e Docker Compose estão instalados.
2. Crie o arquivo `.env` com as variáveis de ambiente necessárias.
3. Execute o comando abaixo para iniciar os contêineres Docker:

```sh
docker-compose up -d
```

Isso iniciará os serviços necessários para a aplicação.
