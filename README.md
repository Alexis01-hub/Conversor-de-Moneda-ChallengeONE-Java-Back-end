
# Conversor de Moneda — Desafío (Back-end Java)

Proyecto para el Challenge ONE de Alura: un conversor de moneda implementado en Java (aplicación de consola).

## Descripción

Aplicación de consola para convertir montos entre monedas usando la API pública ExchangeRate (v6). La versión actual del proyecto incluye varias mejoras respecto a la versión inicial:

- Menú de consola con opciones para convertir, ver códigos de moneda y salir.
- Manejo robusto de entrada del usuario (validación del monto y normalización de códigos de moneda a mayúsculas).
- Registro (logging) de conversiones y errores en el archivo `conversiones.log` (clase `RegistroConversiones`).
- Consumo de la API con `HttpClient` (JDK 11+) y parseo JSON con Gson.

La clase ejecutable principal es `ConversorApp` en `Desafio/src/com/alura/desafio/aplicacion`.

## Estructura del proyecto

```
README.md
Desafio/
	src/
		com/alura/desafio/
			aplicacion/
				ConversorApp.java        # Clase principal (entrypoint)
			modelo/
				conecxionApi.java        # Lógica de conexión a la API externa y flujo de conversión
				conversorApi.java        # Modelo para parsear la respuesta JSON (conversion_rates)
				Menu.java                # Interfaz de consola / menú de usuario
				RegistroConversiones.java# Escritura de logs de conversiones y errores
	lib/                         # Dependencias externas (JARs) — por ejemplo Gson.jar
```

## Requisitos

- JDK 11 o superior (necesario por `java.net.http.HttpClient`).
- Conexión a Internet para acceder a la API de tipos de cambio.
- Gson en `Desafio/lib/` (o gestionado por Maven/Gradle).

Nota: la API key está actualmente definida directamente en `conecxionApi.java` en la variable `apiKey`.

## Nuevas funcionalidades añadidas

- Logging en `conversiones.log`: cada conversión y errores importantes se registran con timestamp (ISO_OFFSET_DATE_TIME). Implementado en `RegistroConversiones.java`.
- Opción del menú para listar códigos de moneda comunes (`Menu.mostrarCodigosMoneda()`).
- Reutilización de un único `Scanner` en `ConversorApp` para evitar problemas con múltiples instancias sobre `System.in`.
- Validación del monto ingresado (manejo de NumberFormatException) y mensajes de error más informativos.
 los `.java` recursivamente en PowerShell puedes usar `Get-ChildItem -Recurse -Filter *.java | % FullName` y pasarlo a `javac`.

## Uso (flujo y opciones)

Al ejecutar `ConversorApp` verás el menú con estas opciones:

1. Convertir moneda — solicita moneda origen (ej: USD), moneda destino (ej: ARS) y monto. Valida el monto y realiza la petición a la API.
2. Salir — termina la aplicación.
3. Ver Códigos de Monedas — muestra códigos comunes (USD, EUR, ARS, etc.) y referencia.

Ejemplo de salida de conversión:

```
100.00 USD = 8_500.00 ARS (tasa: 85.000000)
```

Cada conversión exitosa o error se registra en `conversiones.log` con timestamp.

## Archivos clave (detallado)

- `ConversorApp.java` — Punto de entrada. Controla el bucle del menú y reutiliza un `Scanner` compartido.
- `Menu.java` — Presenta las opciones del menú, lista códigos de monedas y muestra el mensaje de salida.
- `conecxionApi.java` — Solicita datos al usuario, construye la URL de la API, realiza la petición HTTP con `HttpClient`, parsea JSON con Gson, calcula la conversión y escribe logs mediante `RegistroConversiones`.
- `conversorApi.java` — `record` que modela `conversion_rates` (Map<String, Double>) y permite extraer la tasa por código de moneda.
- `RegistroConversiones.java` — Gestiona la escritura en `conversiones.log` (crea el archivo si no existe y añade entradas con timestamp).

## Dependencias

Coloca `gson-*.jar` dentro de `Desafio\lib/` y usa `-cp "Desafio\lib/*"` al compilar/ejecutar. Alternativamente, convierte el proyecto a Maven/Gradle e incluye `com.google.code.gson:gson` como dependencia.

## Configurar la API key

Actualmente la API key se encuentra hardcodeada en `conecxionApi.java`:

```java
String apiKey = "42ddfeb78f1bfe02e34ca3c9"; // Cambia por tu propia key
```

## Logs

El archivo `conversiones.log` se crea en el directorio de trabajo (donde ejecutes la app). Contiene entradas con timestamp ISO y mensajes de conversión o error.

Ejemplo de línea de log:

```
2025-11-03T12:34:56+01:00 - CONVERSION: 100.00 USD -> 8500.00 ARS | tasa: 85.000000
```



