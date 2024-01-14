# Transaction TGID Demo
Este repositório contém uma aplicação REST que lida com usuários que podem ser empresas e clientes, 
dos quais clientes podem realizar saques e depósitos das empresas caso estas possuam
saldo para realizar as operações.

# Getting Started

### Modelagem inicial das entidades:

Imagem criada no [DB diagram](https://dbdiagram.io)

![dbdiagram.png](src/main/resources/dbdiagram.png)

<details><summary>Snippet das entidades</summary>

O snippet abaixo pode ser colado no [DB diagram](https://dbdiagram.io) e editado

```bash
Table Clients {
  id integer [pk]
  name string [not null]
  natural_person_registry string [unique]
  email string [not null]
}

Table Companies {
  id integer [pk]
  name string [not null]
  legal_person_registry string [unique]
  email string [not null]
  fee decimal [null]
  balance decimal [not null]
}

Table Transaction_Type {
  id integer [pk]
  string name [not null]
}

Table Transactions {
  id integer 
  company_id integer [ref: > Companies.id]
  client_id integer [ref: > Clients.id]
  type_id integer [ref: > Transaction_Type.id]
  amount decimal [not null]
}
```
</details>





### Depências do projeto
As depêndencias utilizadas neste repositório são:

* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#web)
* [Spring Data JPA](https://docs.spring.io/spring-data/jpa/reference/)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#using.devtools)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#actuator)

