# Conversor de Moneda — Desafío (Back-end Java)

Proyecto para el Challenge ONE de Alura: un conversor de moneda implementado en Java (con una pequeña aplicación de consola).

## Descripción

Esta aplicación provee una utilidad de consola para convertir valores entre monedas. La lógica principal y la comunicación con una API externa están en la carpeta `src/com/alura/desafio/modelo`. La clase ejecutable principal es `ConversorApp` en `src/com/alura/desafio/aplicacion`.


## Estructura del proyecto

```
README.md
Desafio/
	src/
		com/alura/desafio/
			aplicacion/
				ConversorApp.java        # Clase principal (entrypoint)
			modelo/
				conecxionApi.java        # Lógica de conexión a la API externa
				conversorApi.java        # Lógica de conversión / parseo de respuestas
				Menu.java                # Interfaz de consola / menú de usuario
	lib/                         # Dependencias externas (JARs) — opcional
```

## Requisitos

- Conexión a Internet, la aplicación consume una API externa.
- JARs de dependencias en la carpeta `lib/` (el codigo utiliza Gson).

## Archivos clave

- `ConversorApp.java` — Punto de entrada. Inicializa la aplicación y muestra el menú.
- `Menu.java` — Interacción con el usuario por consola (mostrar opciones, leer entrada, validar).
- `conecxionApi.java` — Gestiona peticiones HTTP a la API externa (endpoints, manejo de respuestas y errores).
- `conversorApi.java` — Contiene la lógica para convertir valores usando la respuesta de la API.

Revisa estas clases para cambiar el endpoint de la API, el formato de entrada/salida o la lógica de validación.

## Dependencias

El proyecto usa Gson para parsear JSON.

## Errores y excepciones comunes

- Problema de `ClassNotFoundException` al ejecutar: revisa que el classpath incluya `out` y `lib/*` si necesitas JARs.
- Fallos al conectar a la API: revisa la conexión a Internet y el endpoint; maneja timeouts y respuestas no válidas.



