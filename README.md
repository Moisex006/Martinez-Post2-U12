# Validación Arquitectónica y Arquitectura Hexagonal - Pedidos Integrado

Proyecto desarrollado para la Unidad 12 de Patrones de Diseño y Validación Arquitectónica.

---

# Objetivo

Implementar una arquitectura modular y desacoplada utilizando Arquitectura Hexagonal junto con múltiples patrones de diseño y validaciones automáticas de arquitectura mediante ArchUnit y GitHub Actions.

El proyecto busca demostrar:

- separación de responsabilidades
- desacoplamiento entre capas
- validación continua de arquitectura
- integración de CI/CD
- detección automática de violaciones arquitectónicas

---

# Tecnologías Utilizadas

- Java 21
- Spring Boot
- Maven
- ArchUnit
- GitHub Actions
- SonarQube
- Spring Events
- JUnit 5

---

# Arquitectura Implementada

El sistema utiliza Arquitectura Hexagonal (Ports & Adapters).

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
      ├── facade/
      ├── procesadores/
      └── rest/
```

---

# Patrones de Diseño Aplicados

## 1. Strategy Pattern

Se implementó para encapsular el procesamiento de pedidos según su tipo.

### Estrategias implementadas

- ProcesadorPedidoEstandar
- ProcesadorPedidoExpress
- ProcesadorPedidoInternacional

### Beneficios

- Eliminación de lógica condicional.
- Extensión sencilla.
- Cumplimiento de Open/Closed Principle.

---

## 2. Factory Pattern

Se implementó mediante:

```java
ProcesadorPedidoFactory
```

La fábrica selecciona dinámicamente la estrategia correspondiente.

### Beneficios

- Desacoplamiento.
- Centralización de creación.
- Escalabilidad.

---

## 3. Observer Pattern

Se implementó utilizando Spring Events.

### Componentes

- PedidoProcesadoEvent
- NotificacionEmail
- NotificacionLog

### Beneficios

- Comunicación desacoplada.
- Fácil extensión de listeners.
- Mayor modularidad.

---

## 4. Facade Pattern

Implementado mediante:

```java
FachadaPedidos
```

Centraliza:

- procesamiento
- persistencia
- publicación de eventos

### Beneficios

- Simplificación del flujo.
- Menor complejidad en controladores.
- Punto único de acceso.

---

# Validación Arquitectónica con ArchUnit

Se implementaron reglas automáticas de validación arquitectónica.

## Reglas Implementadas

### Regla 1

El dominio no puede depender de infraestructura.

### Regla 2

Los controladores REST no deben acceder directamente a infraestructura.

### Regla 3

Los puertos deben ser interfaces.

### Regla 4

Los procesadores deben implementar el puerto ProcesadorPedido.

### Regla 5

Infraestructura no debe depender de REST.

---

# Integración Continua con GitHub Actions

Se configuró un pipeline automático utilizando GitHub Actions.

## Workflow

```txt
.github/workflows/arquitectura.yml
```

## Validaciones automáticas

- compilación
- ejecución de tests
- ejecución de reglas ArchUnit

---

# Violación Arquitectónica Intencional

Se realizó una violación arquitectónica controlada para validar el funcionamiento de ArchUnit y CI/CD.

## Violación Realizada

Se introdujo una dependencia desde la capa dominio hacia REST y Spring Web.

## Resultado

GitHub Actions detectó automáticamente la violación y el pipeline falló correctamente.

Posteriormente se corrigió la arquitectura y el pipeline volvió a estado exitoso.

---

# ADRs Implementados

## ADR-001

Arquitectura Hexagonal para aislar el dominio.

## ADR-002

Uso de Strategy y Factory para procesamiento dinámico.

## ADR-003

Uso de Observer Pattern con Spring Events.

---

# SonarQube

## Métricas Obtenidas

| Métrica | Resultado |
|---|---|
| Quality Gate | Passed |
| Maintainability | A |
| Reliability | A |
| Security | A |
| Duplications | 0.0% |

---

# Ejecución del Proyecto

## Ejecutar aplicación

```bash
./mvnw spring-boot:run
```

---

## Ejecutar SonarQube

```bash
./mvnw verify sonar:sonar \
"-Dsonar.host.url=http://localhost:9000" \
"-Dsonar.token=TU_TOKEN" \
"-Dsonar.projectKey=pedidos-integrado"
```

---

## Ejecutar ArchUnit

```bash
./mvnw test -Dtest=ReglasArquitectura
```


---

# Beneficios de la Arquitectura

- Bajo acoplamiento.
- Alta cohesión.
- Separación clara de responsabilidades.
- Escalabilidad.
- Facilidad de mantenimiento.
- Validación automática de reglas arquitectónicas.
- Integración continua automatizada.

---

# Resultados Obtenidos

- Implementación exitosa de arquitectura hexagonal.
- Integración de múltiples patrones de diseño.
- Validación arquitectónica automatizada.
- Pipeline CI/CD funcional.
- Detección automática de violaciones arquitectónicas.
- Arquitectura desacoplada y mantenible.

---

