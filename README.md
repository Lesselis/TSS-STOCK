# TSS-STOCK
# Stock Application

Este é o repositório do projeto da aplicação de gestão de estoque.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- `src/main/java/com/tsslesselis/stock`: Código fonte da aplicação.
- `src/main/resources`: Arquivos de configuração, incluindo `application.properties`.
- `Dockerfile`: Configuração do Docker para construir a imagem da aplicação.
- `docker-compose.yml`: Configuração do Docker Compose para orquestrar os contêineres da aplicação e do banco de dados MySQL.
- `.env`: Arquivo de variáveis de ambiente (não incluído no repositório por motivos de segurança).

## Pré-requisitos

- Docker
- Docker Compose
- Java 17

## Configuração

### Dependências

As dependências do projeto estão definidas no arquivo `pom.xml`. Certifique-se de que todas as dependências estejam corretamente configuradas.

### Variáveis de Ambiente

As variáveis de ambiente estão definidas no arquivo `.env`. Certifique-se de criar um arquivo `.env` seguindo o exemplo abaixo:

```dotenv
# Configurações do MySQL
MYSQL_ROOT_PASSWORD= sua senha do root
MYSQL_DATABASE= sua base de dados
MYSQL_USER= seu usuário do banco de dados
MYSQL_PASSWORD= senha do seu usuário do banco de dados
MYSQL_HOST= seu host do banco de dados
MYSQL_PORT= sua porta do banco de dados
```

### Docker

O projeto utiliza Docker e Docker Compose para facilitar a configuração e execução dos ambientes de desenvolvimento e produção.

#### Dockerfile

O `Dockerfile` está configurado para construir a imagem da aplicação Spring Boot.

#### Docker Compose

O `docker-compose.yml` está configurado para orquestrar os contêineres da aplicação Spring Boot e do banco de dados MySQL.

### Instruções para Execução

1. Certifique-se de que Docker e Docker Compose estão instalados.
2. Crie o arquivo `.env` com as variáveis de ambiente necessárias.
3. Execute o comando abaixo para iniciar os contêineres Docker:

```sh
docker-compose up -d
```

4. A aplicação estará disponível em `http://localhost:8080`.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
