<div align="center">

# Desafio Engenharia de Software - Itaú

![](https://img.shields.io/badge/Autor-Felippe%20Souza-brightgreen)
![](https://img.shields.io/badge/Language-Java-brightgreen)
![](https://img.shields.io/badge/Framework-Spring%20Boot-brightgreen)
<br><br>
![GitHub Release Date](https://img.shields.io/badge/Release%20Date-Março%202025-yellowgreen)
![](https://img.shields.io/badge/Status-Desenvolvido-brightgreen)

</div>

<div align="center">

# Bank Transfer - Itaú
O objetivo do desafio é desenhar e desenvolver uma solução que permita que os clientes do Itaú consigam realizar Transferência entre contas.
<br>Essa solução precisa ser resiliente, ter alta disponibilidade e de fácil evolução/manutenção.

## 💻 Sobre o projeto

Serviço responsável por realizar transferências bancárias validando informações na "API Cadastro" e "API Contas" e por
fim, notificar o Bacen por meio da "API Bacen"

</div>

## 💫 Arquitetura da solução
- A arquitetura da solução foi baseada em serviços AWS com containers provisionados no ECS com launch Fargate.

<img src="\notify-credit-bureaus\desafio_itau.png" alt="Tela Principal">
<br>

## 🚀 Como executar o projeto

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Java](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html), [Maven](https://maven.apache.org/download.cgi) e [Docker](https://www.docker.com/products/docker-desktop/)

#### 🎲 Rodando o Microserviço
```bash
# Clone este repositório
$ git clone https://github.com/felippesouza10/notify-credit-bureaus.git

# Acesse a pasta do projeto no terminal/cmd
$ cd notify-credit-bureaus

#Certifique de que o Docker está em execução

Execute a aplicação na sua IDE por meio da classe NotifyCreditBureausApplication.

# A aplicação será inicializada na porta: 8080 
```

##### Ao executar a aplicação no profile "dev" será criado também:
- Um container no Docker com o Postgres na porta 27017.



## 📄 Documentação da API (Swagger)

A documentação da aplicação está disponível em:

```bash
localhost:8080/swagger-ui/index.html
```

## 🛠 Tecnologias

- Java 21
- Maven
- Lombok
- Spring Boot 3.2.4
- Spring OpenFeign
- Spring Boot Docker Compose (apenas no profile dev)
- Spring Validation
- Spring Doc (Swagger) 2.5.0
- Tomcat (Integrado ao Spring Boot)
- MongoDB
- Resilience4j

## 💡 Highlights do Desafio

<span style="color:orange"><strong>1</strong></span><span style="color:#f0c665"> - Utilização de Docker Compose integrado
ao Start da aplicação para disponibilizar instâncias de Postgres.
(Em ambiente de desenvolvimento).</span>

<span style="color:orange"><strong>2</strong></span><span style="color:#f0c665"> - O Desenho da solução foi pensado
utilizando serviços da AWS.</span>

<span style="color:orange"><strong>3</strong></span><span style="color:#f0c665"> - DebtsController implementado para
melhor legibilidade e organização, diminuindo drasticamente a complexidade do código.</span>

<span style="color:orange"><strong>4</strong></span><span style="color:#f0c665"> - Utilizado os princípios de SOLID.</span>

<span style="color:orange"><strong>5</strong></span><span style="color:#f0c665"> - Utilização de Conventional Commits
como padrão para os commits.</span>

# ⚙️ O Desafio:

## 1 - Desafio engenharia de software:

> Em um cenário que você é um engenheiro de sistemas que será encarregado por liderar uma iniciativa de
modernização de todo um legado dos sistemas de recuperação de crédito (cobrança e renegociação) (legado de 10-
20 anos).
As principais funções que temos hoje no sistema são: ações que cobram o cliente e funcionalidades para renegociar
as dívidas e facilitar os pagamentos e que praticamente rodam, em sua totalidade, no ambiente mainframe (COBOL,
Assembler, DB2, VSAM). O seu desafio será buscar recortes (desacoplar funcionalidades) e desenhar uma proposta
de solução técnica (apresente peças técnicas e o papel de cada uma delas) de forma que resolva a necessidade de
negócio.
A plataforma atual é um sistema monolítico, com alto acoplamento e processamento batch que provê as informações
dos canais on-line do banco.
A ideia da plataforma que buscamos é ser o mais on-line possível, tendo em vista que a evolução e lançamento de
produtos é constante nesse mercado e o comportamento do consumidor é sazonal.

## 2 - Desafio arquitetura de solução:
> Você deverá desenhar e desenvolver, em poucos dias, uma solução que atenda aos requisitos dados.
Faz parte da problemática, entender o desafio proposto e elaborar um desenho de solução que o resolva.

## Pontos importantes:
>1. Caso não tenha conhecimento das funcionalidades crie algumas premissas para realizar o seu exercício e explicite
   em seu desenho.
>2. Modernização do legado significa aplicar tecnologias novas e emergentes que simplifiquem e acelerem as soluções
   técnicas, valorizando o desacoplamento das funcionalidades com a criação de peças simples, performáticas e que
   tenham reuso.
>3. Fazer uma apresentação livre, minimamente contendo:
   Relatório Técnico explicando de forma sumarizada, considerando:
   I. Diagrama de arquitetura
   II. Publique os códigos gerados (em Java), em seu perfil do https://github.com/
   ▪ Cite no relatório: O seu perfil github e a(s) URL(s) onde se encontram os códigos gerados
   III. Referências utilizadas, se aplicável.
   IV. Demais itens que você julgar relevante (framework ou técnicas de teste, metodologias, padrões etc.)

Requisitos:
> Modernizar legado dos sistemas de Cobrança e Renegociação.
> Aplicar tecnologias novas e emergentes;
> Simplificar as soluções técnicas;
> Acelerar as soluções técnicas;
> Desacoplamento das funcionalidades;
> Peças simples;
> Peças performáticas;
> Peças que tenham reuso;
> Codifique uma funcionalidade;

Funcionalidades:
> Ações de cobrança ao cliente (carta, SMS, e-mail, outros possíveis);
> Negativação junto aos birôs de crédito (Serasa, SPC, BVS, outros possíveis);
> Funcionalidades de renegociação (agrupamento da dívida e simulação de pagamento, oferta de produtos,
efetivação acordo, entre outros);
> Funcionalidades de pagamento (emissão e pagamento de boletos, débito em conta, entre outros).