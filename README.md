# Bank Application
#### Educação Virtual
<div align="center">

![hexagonal_architecture.png](hexagonal_architecture.png)

</div>

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)
<br/>
![GitHub Org's stars](https://img.shields.io/github/stars/EducacaoVirtual/bank-app?style=social)
<br/>
![Static Badge]( https://img.shields.io/badge/Java_17-Spring_Boot-orange)
![Static Badge]( https://img.shields.io/badge/Hexagonal_Architecture-DDD-blue)
![Static Badge]( https://img.shields.io/badge/Release_Date-November_2024-red)
![Static Badge]( https://img.shields.io/badge/License-MIT-green)

### Índice

1. [Descrição do Projeto](#descricao-do-projeto)
2. [Dependências](#dependencias)
3. [Adapters](#adapters)
4. [Contribuidores](#contribuidores)
5. [Youtube](#youtube)
6. [Autores](#autores)
7. [Connect with me](#connect-with-me)


### Descrição do Projeto
Esse projeto está vinculado ao vídeo no canal Educação Virtual no Youtube, onde falo sobre
Hexagonal Architecture com Java e Spring Boot.
Nesse víde desenvolvo um projeto seguindo o padrão da arquitetura e mostrando como pode ser
realizada a implementação tomando como base algumas fontes que tratam dessa arquitetura, como o
artigo do <b>Juan Manuel Garrido de Paz</b> [(Site do Autor do Artigo)](https://jmgarridopaz.github.io/), e 
do criador da arquitetura <b>Alistair Cockburn</b> [(Artigo do Autor)](https://web.archive.org/web/20180822100852/http://alistair.cockburn.us/Hexagonal+architecture).

No projeto falo sobre a divisão proposta pela arquitetura, respeitando suas premissas e produzindo o desacoplamento
da lógica de negócios das tecnologias utilizadas que se concentram nos adapters.
O desenho da arquitetura é bem intuitivo e mostra o que esperar ao usar essa abordagem arquitetural.
<br/>
<br/>
<div align="center">

![Ports & Adapters.png](Ports%20%26%20Adapters.png)

</div>

### Tech Stack e Dependências

- Java 17
- Spring Boot 3.4.0
- Spring Web
- Spring Data JPA
- Lombok
- H2 
- MySQL

### Adapters
Nesse projeto foram desenvolvidos a aplicação (o hexágono) e os seguintes adapters:

- [bank-hexagon](#bank-hexagon)
- [bank-api-adapter](#bank-api-adapter)
- [bank-h2-adapter](#bank-h2-adapter)
- [bank-mysql-adapter](#bank-mysql-adapter)

Além do projeto <b>parent</b> para gerenciar as dependências de todos os projetos.

### Contribuidores
O projeto bank-application é público, portanto, se tiver alguma correção ou melhoria que 
acredite pertinente, fique a vontade para realizar o clone/fork do projeto e enviar PRs
Vamos analisar e melhorar o projeto para que ele seja mais completo e funcional.
Ficamos gratos pela contribuição de cada um!

Inicialmente o projeto foi desenvolvido por:

- [Alexandre Nascimento Costa](https://github.com/alexncosta)

### 🖥 YouTube

### Últimos vídeos no Canal
<!-- YOUTUBE:START -->
- [Spring Boot Completo 2024 | com Docker, PostgreSQL e Swagger]
- [Applicação BackEnd com Java, Spring Boot, AWS SQS e Postgres - Parte 02 - Conclusão]
- [Applicação BackEnd com Java, Spring Boot, AWS SQS e Postgres - 🔴 Live Code 💻]
- [Build a complete Project with Next.JS/Spring Boot/MySQL]

### Autores
[<img loading="lazy" src="https://avatars.githubusercontent.com/u/13712678?v=4" width=115><br><sub>Alexandre Nascimnento Costa</sub>](https://github.com/alexncosta) 

### 🤝 Connect with me:

- Website: https://alexncosta.com
- YouTube: https://www.youtube.com/@educacaovirtualenglishofc
- LinkedIn: https://www.linkedin.com/in/alexandre-nascimento-ev/?locale=en_US
