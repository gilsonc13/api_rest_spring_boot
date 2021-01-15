# API REST com Spring Boot

API REST para o cadastro de cliente e cidades

## 🚀 Endpoints 

CIDADE:

```
GET /cidades - Listar todas as cidades
```
```
POST /cidades - Cadastrar uma nova cidade
```
```
GET /cidades/{nome} - Buscar cidade pelo nome
```
```
GET /estado/{sigla_estado} - Buscar cidades de um estado
```

CLIENTE:

```
GET /clientes - Listar todos os clientes
```
```
POST /clientes - Cadastrar um novo cliente
```
```
DELETE /cliente/{id} - Deletar cliente pelo ID
```
```
PUT /cliente/{id} - Alterar cliente
```
```
GET /cliente/{id} - Retorna cliente pelo ID
```


## 🛠️ Construído com

* [Java](https://spring.io/projects/spring-boot) - Tecnologia
* [Spring Boot](https://spring.io/projects/spring-boot) - framework
* [Maven](https://maven.apache.org/) - Gerente de Dependência
* [Swagger](https://swagger.io/) - Usada para gerar a documentação da API
