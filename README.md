# Unidad 3 - API REST con Arquitectura Hexagonal y DDD


## Caso trabajado

- CRUD base: **Usuarios**.
- CRUD del ejercicio/caso asignado: **Restaurante / Pedido / Número de pedido**.


## Ejecutar

```bash
mvn spring-boot:run
```

Abrir:

- Swagger UI: `http://localhost:8080/swagger-ui.html`
- Usuarios: `http://localhost:8080/api/users`
- Pedidos: `http://localhost:8080/api/pedidos`
- Consola H2: `http://localhost:8080/h2-console`

Datos H2:

- JDBC URL: `jdbc:h2:mem:unidad3db`
- User: `sa`
- Password: vacío

## Endpoints

### Usuarios

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/api/users` | Crear usuario |
| GET | `/api/users` | Listar usuarios |
| GET | `/api/users/{id}` | Consultar usuario por ID |
| PUT | `/api/users/{id}` | Actualizar usuario |
| DELETE | `/api/users/{id}` | Eliminar usuario |

### Pedidos

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/api/pedidos` | Crear pedido |
| GET | `/api/pedidos` | Listar pedidos |
| GET | `/api/pedidos/{id}` | Consultar pedido por ID |
| PUT | `/api/pedidos/{id}` | Actualizar pedido |
| DELETE | `/api/pedidos/{id}` | Eliminar pedido |

## Arquitectura

```text
src/main/java/com/udec/unidad3hexagonal
├── application/service
├── domain
│   ├── exception
│   ├── model
│   └── port
│       ├── in
│       └── out
└── infrastructure
    ├── adapter/persistence
    ├── config
    └── entrypoint/rest
```

## Pruebas rápidas

El archivo `requests.http` contiene peticiones listas para probar en Visual Studio Code con la extensión REST Client.


