# Pedidos Integrado - Arquitectura Hexagonal y Patrones de Diseño

Proyecto desarrollado para la Unidad 12 de Patrones de Diseño de Software.

---

# Objetivo

Implementar un sistema de procesamiento de pedidos aplicando múltiples patrones de diseño y principios de arquitectura limpia para mejorar:

- mantenibilidad
- escalabilidad
- modularidad
- desacoplamiento

además de validar la calidad del código mediante SonarQube.

---

# Tecnologías Utilizadas

- Java 17
- Spring Boot
- Maven
- SonarQube
- H2 Database
- Spring Events
- Spring Web
- JUnit 5

---

# Arquitectura Implementada

El proyecto utiliza una arquitectura inspirada en Arquitectura Hexagonal (Ports & Adapters).

## Estructura del Proyecto

```txt
src/
 ├── dominio/
 │    └── puertos/
 │
 ├── aplicacion/
 │
 ├── infraestructura/
 │    ├── persistencia/
 │    └── notificaciones/
 │
 └── adaptadores/
      ├── processors/
      ├── facade/
      └── rest/
```

---

# Patrones de Diseño Aplicados

## 1. Strategy Pattern

Se implementó para encapsular las diferentes reglas de procesamiento de pedidos según el tipo:

- ESTANDAR
- EXPRESS
- INTERNACIONAL

Cada estrategia implementa:

```java
ProcesadorPedido
```

### Clases Implementadas

- `ProcesadorPedidoEstandar`
- `ProcesadorPedidoExpress`
- `ProcesadorPedidoInternacional`

### Beneficios

- Eliminación de lógica condicional compleja.
- Fácil extensión de nuevos tipos de pedido.
- Cumplimiento del principio Open/Closed.

---

## 2. Factory Pattern

Se implementó mediante:

```java
ProcesadorPedidoFactory
```

La fábrica selecciona dinámicamente la estrategia correcta dependiendo del tipo de pedido.

### Beneficios

- Centralización de creación de estrategias.
- Reducción de acoplamiento.
- Mayor mantenibilidad.

---

## 3. Observer Pattern

Se implementó utilizando Spring Events mediante:

```java
PedidoProcesadoEvent
```

y listeners:

- `NotificacionEmail`
- `NotificacionLog`

### Beneficios

- Desacoplamiento entre procesamiento y notificaciones.
- Posibilidad de agregar nuevos observers sin modificar lógica principal.
- Mejor separación de responsabilidades.

---

## 4. Facade Pattern

Se implementó mediante:

```java
FachadaPedidos
```

La fachada centraliza:

- procesamiento
- persistencia
- publicación de eventos

### Beneficios

- Simplificación del flujo de negocio.
- Punto único de acceso.
- Reducción de complejidad para los controladores REST.

---

# Flujo del Sistema

1. El cliente envía un pedido vía API REST.
2. `PedidoController` delega a `FachadaPedidos`.
3. La fachada obtiene la estrategia adecuada mediante `ProcesadorPedidoFactory`.
4. La estrategia procesa el pedido.
5. El pedido se guarda.
6. Se publica `PedidoProcesadoEvent`.
7. Los observers ejecutan notificaciones y logs.

---

# Endpoint REST

## Crear Pedido

### Request

```http
POST /api/pedidos
```

### Ejemplo JSON

```json
{
  "subtotal": 100,
  "tipo": "EXPRESS"
}
```

### Response Esperada

```json
{
  "id": 1,
  "subtotal": 100.0,
  "costo": 130.0,
  "tipo": "EXPRESS",
  "estado": "PROCESADO"
}
```

---

# Ejecución del Proyecto

## Ejecutar aplicación

```bash
./mvnw spring-boot:run
```

---

## Ejecutar análisis SonarQube

```bash
./mvnw verify sonar:sonar \
"-Dsonar.host.url=http://localhost:9000" \
"-Dsonar.token=TU_TOKEN" \
"-Dsonar.projectKey=pedidos-integrado"
```

---

# Resultados SonarQube

## Métricas Obtenidas

| Métrica | Resultado |
|---|---|
| Quality Gate | Passed |
| Maintainability | A |
| Reliability | A |
| Security | A |
| Duplications | 0.0% |


---

# Beneficios de la Arquitectura

- Código desacoplado.
- Fácil mantenimiento.
- Extensión sencilla de funcionalidades.
- Separación clara de responsabilidades.
- Alta cohesión y bajo acoplamiento.
- Mejor organización del dominio.

---

# Reflexión Técnica

La combinación de Strategy, Factory, Observer y Facade permitió construir un sistema modular y extensible. La arquitectura hexagonal ayudó a separar el dominio de la infraestructura, facilitando futuras integraciones y pruebas. El uso de SonarQube permitió validar la mantenibilidad y calidad general del código.

---

# Resultados Obtenidos

- Implementación exitosa de múltiples patrones de diseño.
- Integración correcta de eventos con Spring.
- API REST funcional.
- Quality Gate Passed en SonarQube.
- Arquitectura modular y mantenible.
- Reducción de complejidad y acoplamiento.

---
