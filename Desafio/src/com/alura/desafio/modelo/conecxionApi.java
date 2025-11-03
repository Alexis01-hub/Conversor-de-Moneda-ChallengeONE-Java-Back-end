package com.alura.desafio.modelo;

import com.google.gson.Gson;
import com.alura.desafio.modelo.conversorApi;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;
import java.util.Scanner;

public class conecxionApi {
    public static void conectar() {
        System.out.println("Conectando a la API...");
        String apiKey = "42ddfeb78f1bfe02e34ca3c9"; //key de la api

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese la moneda que desea convertir (ej: USD):");
        String primeraMoneda = teclado.nextLine().trim().toUpperCase(Locale.ROOT); // moneda de origen
        System.out.println("¿A qué moneda desea convertirla? (ej: ARS):");
        String segundaMoneda = teclado.nextLine().trim().toUpperCase(Locale.ROOT); // moneda de destino
        System.out.println("Ingrese el monto a convertir:");
        String montoStr = teclado.nextLine().trim(); // monto a convertir
        double monto; // variable para almacenar el monto convertido
        try {
            monto = Double.parseDouble(montoStr); // convertir el monto a double
        } catch (NumberFormatException e) {
            System.err.println("Monto inválido: " + montoStr);
            return;
        }

        // Construir la URL de la API con la moneda de origen
        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + primeraMoneda;
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .GET()
                .build();
        /*
            * Enviar la solicitud y manejar la respuesta
            *
            * Si la respuesta es exitosa (código 200), parsear el JSON
            * y obtener la tasa de conversión para la moneda destino.
            * Luego, calcular el monto convertido y mostrar el resultado.
            * Si hay un error en la solicitud o en la respuesta, mostrar un mensaje de error.
            *
         */
        try {
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString()); // enviar la solicitud
            if (respuesta.statusCode() != 200) {
                System.err.println("Error en la petición HTTP. Código: " + respuesta.statusCode());
                System.err.println("Cuerpo: " + respuesta.body());
                return;
            }
            String body = respuesta.body(); // obtener el cuerpo de la respuesta
            Gson gson = new Gson();
            conversorApi apiResponse = gson.fromJson(body, conversorApi.class); // parsear el JSON a conversorApi
            Double rate = apiResponse.conversion_rates().get(segundaMoneda); // obtener la tasa de conversión
            if (rate == null) { // si la moneda destino no existe
                System.err.println("Moneda destino no encontrada en las tasas: " + segundaMoneda);
                System.err.println("Monedas disponibles: " + apiResponse.conversion_rates().keySet());
                return;
            }
            double convertido = monto * rate; // calcular el monto convertido
            System.out.printf(Locale.ROOT, "%.2f %s = %.2f %s (tasa: %.6f)\n", monto, primeraMoneda, convertido, segundaMoneda, rate);
        } catch (IOException | InterruptedException e) { // manejar errores de IO o interrupciones
            System.err.println("Error al realizar la petición: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
