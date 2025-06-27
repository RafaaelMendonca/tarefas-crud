# Todo Application

Aplicação backend para gerenciamento de tarefas (Todo List) utilizando Spring Boot, JPA, MySQL.

---

## Estrutura do Projeto

- **src/main/java/com.project.todo**
  - **controller**  
    - `TarefaController`  
    - `UsuarioController`  
  - **dto**  
    - `TarefaDto`  
    - `UsuarioDto`  
  - **model**
    - **entities**  
      - `Status` (enum)  
      - `Tarefa`  
      - `Usuario`  
    - **repositories**  
      - `TarefaRepository` (interface)  
      - `UsuarioRepository` (interface)  
  - **service**  
    - `TarefaService`  
    - `UsuarioService`  
  - `TodoApplication.java` (classe principal para rodar o Spring Boot)

---

## Configuração do Banco de Dados

O projeto está configurado para usar MySQL. As configurações de conexão com o banco de dados devem ser definidas no arquivo `application.properties`, que está listado no `.gitignore` para evitar expor credenciais sensíveis no repositório.

Exemplo genérico de configuração (não incluir credenciais reais):

spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco  
spring.datasource.username=seu_usuario  
spring.datasource.password=sua_senha  
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver  

spring.jpa.hibernate.ddl-auto=update  
spring.jpa.show-sql=true  
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect  

> **Atenção:**  
> Lembre-se de criar o banco de dados localmente e configurar as credenciais corretas no seu ambiente.

---

## Endpoints disponíveis

### Usuário (`/usuario`)

- `POST /usuario` — criar usuário  
- `GET /usuario/{id}` — buscar usuário por ID  
- `PUT /usuario/{id}` — atualizar usuário  
- `DELETE /usuario/{id}` — deletar usuário

### Tarefa (`/tarefa`)

- `POST /tarefa` — criar tarefa  
- `GET /tarefa/{id}` — buscar tarefa por ID  
- `DELETE /tarefa/{id}` — deletar tarefa  
- `GET /tarefa/usuario/{idUsuario}` — listar tarefas de um usuário

---

## Como rodar o projeto

1. Configure o MySQL e crie o banco de dados para o projeto.  
2. Atualize o arquivo `application.properties` com as credenciais do seu ambiente local.  
3. Rode o projeto TodoApplication.
4. Use o Postman ou outro cliente HTTP para testar os endpoints.

---

## Próximos passos e melhorias

- Implementar autenticação e autorização (ex: JWT)  
- Tratar exceções com `@ControllerAdvice`  
- Hash de senha para segurança  
- Separar DTOs para requisição e resposta

---

## Contato

Rafael — contato.rafael2023@gmail.com

---
