package com.alura.desafio.modelo;

public class Menu {
    public static void menuConversor(){
        System.out.println("***************************************");
        System.out.println("Bienvenido al conversor de monedas");
        System.out.println("Elige una opcion:");
        System.out.println("1. Convertir moneda");
        System.out.println("2. Salir");
        System.out.println("3. Ver Codigos de Monedas");
        System.out.println("***************************************");
    }

    public static void menuSalida(){
        System.out.println("Gracias por usar el conversor de monedas. ¡Hasta luego!");
    }

    public static void mostrarCodigosMoneda(){
        System.out.println("Códigos de moneda más usados:");
        System.out.println("USD - Dólar estadounidense");
        System.out.println("EUR - Euro");
        System.out.println("ARS - Peso argentino");
        System.out.println("BRL - Real brasileño");
        System.out.println("BOB - Boliviano");
        System.out.println("CLP - Peso chileno");
        System.out.println("COP - Peso colombiano");
        System.out.println("MXN - Peso mexicano");
        System.out.println("GBP - Libra esterlina");
        System.out.println("JPY - Yen japonés");
        System.out.println("CNY - Yuan chino");
        System.out.println("AUD - Dólar australiano");
        System.out.println("CAD - Dólar canadiense");
        System.out.println("INR - Rupia india");
        System.out.println("RUB - Rublo ruso");
        System.out.println("... y muchos más. Puedes consultar la lista completa en https://www.iban.com/currency-codes");
        System.out.println();
    }
}
