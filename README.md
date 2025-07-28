# FinDesk

> Painel Financeiro Inteligente para Pequenas Empresas

---

## 🚀 Visão do projeto
FinDesk é uma aplicação web para ajudar micro e pequenas empresas a gerenciar:
- Fluxo de caixa (receitas, despesas)
- Contas bancárias e transferências
- Categorias financeiras
- Dashboards e relatórios (CSV/PDF)

Desenvolvido em **Java 17 + Spring Boot 3.5**, usando:
- Spring Data JPA
- Spring Security
- Oracle Database
- Flyway (migração)
- Docker para containerização
- Azure DevOps para CI/CD (futuro)

---

## 📦 Estrutura inicial
src/main/java/com/findesk

├── config

├── controller

├── dto

├── exception

├── model

├── repository

└── service

---

## ⚙️ **Serviços implementados (regras de negócio)**

- **TransactionService**
    - Criar lançamentos financeiros
    - Validar valores e tipos
    - Calcular previsão de saldo futuro

- **TransferService**
    - Criar transferências entre contas
    - Validar que origem ≠ destino
    - Validar valores positivos

- **CategoryService**
    - Criar e listar categorias financeiras de uma empresa

- **BankAccountService**
    - Criar e listar contas bancárias de uma empresa

- **AppUserService**
    - Criar usuários vinculados a empresa
    - Buscar usuários por empresa

- **CompanyService**
    - Criar nova empresa
    - Buscar empresa por CNPJ

---

## 📦 **DTOs criados**
- CompanyDTO
- AppUserDTO
- BankAccountDTO
- CategoryDTO
- TransactionDTO
- TransferDTO

---
## 📌 Endpoints REST

### 🔐 Usuários
| Método | Endpoint              | Descrição                          |
|-------|-----------------------|------------------------------------|
| POST  | /api/users            | Criar novo usuário                 |
| GET   | /api/users            | Listar usuários                    |
| GET   | /api/users/{id}       | Buscar usuário por ID              |
| PUT   | /api/users/{id}       | Atualizar usuário                  |
| DELETE| /api/users/{id}       | Deletar usuário                    |

### 🏦 Contas bancárias
| Método | Endpoint              | Descrição                          |
|-------|----------------------|------------------------------------|
| POST  | /api/bankaccounts    | Criar conta bancária              |
| GET   | /api/bankaccounts    | Listar contas                     |

### 💸 Transações
| Método | Endpoint                | Descrição                         |
|-------|------------------------|----------------------------------|
| POST  | /api/transactions      | Criar transação                  |
| GET   | /api/transactions      | Listar transações                |

### 🔄 Transferências
| Método | Endpoint              | Descrição                        |
|-------|----------------------|---------------------------------|
| POST  | /api/transfers       | Criar transferência             |
| GET   | /api/transfers       | Listar transferências           |
---

## 🐳 Docker
Build local:
```bash
docker build -t findesk-app .
docker run -p 8080:8080 findesk-app