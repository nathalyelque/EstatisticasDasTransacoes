# Estatísticas das Transações API REST

Uma API REST com o intuíto de receber transações e fornecer estatísticas sob essas transações.

## Índice
* [Tecnologias](#tecnologias)
* [Instalação e inicialização](#instalação-e-inicialização)
  + [Pré-requisitos](#pré-requisitos)
  + [Instalação](#instalação)
  + [Inicialização](#inicialização)
* [Funcionalidades](#funcionalidades)

## Tecnologias

O projeto foi criado usando:

* Java 8
* Spring Boot
* Bean Validation
* Springfox (Swagger)

## Instalação e inicialização

### Pré-requisitos

É necessário que em sua máquina esteja instalado as seguintes ferramentas:

* [Maven](https://maven.apache.org/download.cgi)
* [Java 8](https://www.java.com)

### Instalação

Clonar este repositório através do link do `github`:

```bash
git clone https://github.com/nathalyelque/EstatisticasDasTransacoes.git
```

Compilar o projeto e instalar as depedências através do comando `maven` na pasta do projeto:

```bash
mvn install
```

### Inicialização

Para iniciar o projeto basta executar o comando `maven` na pasta do projeto:

```bash
mvn spring-boot:run
```

A aplicação vai ser executada por padrão na porta `8080` e podemos acessar o **Swagger** através do endereço:

```url
http://localhost:8080/swagger-ui/index.html
```

## Funcionalidades

![Post1](https://user-images.githubusercontent.com/61016575/93405080-67317780-f862-11ea-86d2-f121e40924c0.JPG)
![Post2](https://user-images.githubusercontent.com/61016575/93405114-83cdaf80-f862-11ea-8052-e89bfa4dff7f.JPG)
![Delete](https://user-images.githubusercontent.com/61016575/93405161-a233ab00-f862-11ea-82f7-cabc1ac49d25.JPG)
![Get](https://user-images.githubusercontent.com/61016575/93404980-1caffb00-f862-11ea-91f9-4613524fb782.JPG)
