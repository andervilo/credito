# Sistema de Consulta de Crédito

Este é um sistema de consulta de crédito composto por um backend em Spring Boot e um frontend em Angular, utilizando uma arquitetura de microsserviços com Kafka para processamento de eventos.

## Tecnologias Utilizadas

### Backend (credito-ms)
- Java 17
- Spring Boot 3
- Spring Data JPA
- Spring Kafka
- PostgreSQL
- Flyway para migração de banco de dados
- Maven

### Frontend (credito-web)
- Angular 19
- Angular Material
- TypeScript
- RxJS


### Infraestrutura
- Docker & Docker Compose
- Kafka
- Zookeeper
- PostgreSQL
- Kafka UI (interface web para gerenciamento do Kafka)

## Como Executar

### Pré-requisitos
- Docker
- Docker Compose

### Passos para Execução

1. Clone o repositório:
```bash
git clone https://github.com/andervilo/credito.git
cd credito
```

2. Execute o ambiente com Docker Compose:
```bash
docker-compose up -d
```

Este comando irá:
- Construir as imagens do backend e frontend
- Iniciar todos os serviços necessários
- Configurar a rede entre os containers
- Criar os volumes necessários

### Serviços Disponíveis

Após a execução, os seguintes serviços estarão disponíveis:

- **Actuator**: http://localhost:8080/actuator
- **Health**: http://localhost:8080/actuator/health
- **Swagger**: http://localhost:8080/swagger-ui/index.html
- **Frontend (Angular)**: http://localhost:4200
- **Backend (Spring Boot)**: http://localhost:8080
- **Kafka UI[tópico credito-query]**: http://localhost:8090/ui/clusters/local/all-topics/credito-query/messages?keySerde=String&valueSerde=String&limit=100
- **PostgreSQL**: localhost:5432
  - Username: postgres
  - Password: postgres
  - Database: creditosdb
- **Kafka**: localhost:9092

### Verificando os Logs

Para verificar os logs de um serviço específico:
```bash
docker-compose logs -f [service-name]
```

Onde [service-name] pode ser:
- credito-web
- credito-ms
- kafka
- postgres
- kafka-ui

### Parando os Serviços

Para parar todos os serviços:
```bash
docker-compose down
```

Para parar e remover todos os volumes (isso irá apagar os dados do banco):
```bash
docker-compose down -v
```

## Estrutura do Projeto

```
credito/
├── credito-ms/           # Backend Spring Boot
├── credito-web/          # Frontend Angular
├── docker-compose.yml    # Configuração Docker Compose
└── README.md            # Este arquivo
```

## Funcionalidades

- Consulta de crédito por número
- Consulta de crédito por número de NFSe
- Interface web responsiva
- Processamento assíncrono com Kafka
- Persistência de dados com PostgreSQL

## Desenvolvimento

Para desenvolvimento local sem Docker:

### Backend
```bash
cd credito-ms
./mvnw spring-boot:run
```

### Frontend
```bash
cd credito-web
npm install
ng serve
```