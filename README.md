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

## 🐳 Docker
Build local:
```bash
docker build -t findesk-app .
docker run -p 8080:8080 findesk-app