# Projeto Final Programação Avançada

> Este Repositorio comtempla o projeto da máteria de programação avançada,criado no intuito obtenção de nota para av2.
Projeto esse que consiste na criação de uma API Rest,simulando um sistema academico com o cadastro de professores e alunos e etc.


## Sobre a API

O projeto está sendo desenvolvido utilizando as seguintes tecnologias:

<p>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original-wordmark.svg" height="160px" />
  <img src="https://github.com/EdsoonJr/EdsoonJr/blob/main/postman.svg" height="150px"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original-wordmark.svg" height="160px" />
</p>


## Funcionamento da API⚙️

### Requisitos 

> Para o devido funcionamento da Api é necessário a instalação de suas dependências,siga os passos abaixo

```bash
# 1. Clonar  repositório
$ git clone https://github.com/GiMarrocos/Projeto-Final-Av2.git

# 2. Acessar a pasta do projeto
$ cd Projeto-Final-Av2.git

# 3. Instale as dependências

# 4. Start na API
$  Executar a classe TomorrowApplication.java

```

## Bibliotecas Utilizadas
+ Spring-DevTolls
+ Spring-DataJpa
+ Lombok


## Rotas

### 🧑🏽‍🎓 Student

> Post : Cadastrar Estudante `http://localhost:8080/students/create`

```bash
{
    "name": "Alfredo Ribeiro",
    "phone": "819883-05819",
    "address": "rua dos alfeneiros",
    "cpf": "145.244.490-00",
    "class_id": 1
}

```

> Get : Listar todos os Estudantes `http://localhost:8080/students/list`

> Get : Listar  um Estudante `http://localhost:8080/students/find/id/{id}`

> Put : Atualizar  um Estudante `http://localhost:8080/students/update/id/{id}`

> Delete : Deletar  um Estudante `http://localhost:8080/students/delete/id/{id}`


### 👨‍🏫 Teacher

>Post: Cadastrar Professor `http://localhost:8080/teacher/create`

```bash
{
    "name": "Alfredo Ribeiro",
    "phone": "819883-05819",
    "hourlyRate": 150.56
}

```

> Get : Listar todos os Professores `http://localhost:8080/teacher/list`

> Get : Listar  um Professor `http://localhost:8080/teacher/find/id/{id}`

> Put : Atualizar  um Professor `http://localhost:8080/teacher/update/id/{id}`

> Delete : Deletar  um Professor `http://localhost:8080/students/{id}`

### 📚 Course

>Post: Cadastrar Curso `http://localhost:8080/courses/create`

```bash
{
    "course_name": "Programação Avançada",
    "classWorkload": 300.10,
    "totalWorkload": 3000,
    "shift": "Noite",
    "value": 80,
    "monday": 0,
    "tuesday": 0,
    "wednesday": 0,
    "thursday": 1,
    "friday": 1,
    "saturday": 0
}

```

> Get : Listar todos os Cursos `http://localhost:8080/courses/list`

> Get : Listar  um Curso `http://localhost:8080/courses/find/id/{id}`

> Put : Atualizar  um Curso `http://localhost:8080/courses/update/id/{id}`

> Delete : Deletar  um Curso `http://localhost:8080/courses/delete/id/{id}`

### Lead

> Post: Cadastrar Curso `http://localhost:8080/lead/create`

```bash
{
   "name": "Alfredo Ribeiro",
   "phone": "819883-05819",
   "dateRegister": 
   "status_2" :
   "newDateContact":
   "observation" :
}
```

> Get : Listar todos os Cursos `http://localhost:8080/lead/list`

> Get : Listar  um Curso `http://localhost:8080/lead/find/id/{id}`

> Put : Atualizar  um Curso `http://localhost:8080/lead/update/id/{id}`

> Delete : Deletar  um Curso `http://localhost:8080/lead/{id}`


## Contributors 🍷🗿


* [Mateus Henrique Candido dos Santos - 01426871](https://github.com/MateusHCandido)
* [Edson de Araújo Junior - 01489468](https://github.com/EdsoonJr)
* [Geovanna Larissa Marrocos de Lima - 01472003](https://github.com/GiMarrocos)
* [Dayvson Henrique Silva de Assis - 01471232](https://github.com/dayvson-henriquee)
* [Lucas Crespo Rodrigues - 01419654]()
* [Gustavo Henrique de Souza Silva - 01100114](https://github.com/ghdss26)




