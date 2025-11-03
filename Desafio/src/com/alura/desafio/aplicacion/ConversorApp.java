package com.alura.desafio.aplicacion;


import com.alura.desafio.modelo.Menu;
import com.alura.desafio.modelo.conecxionApi;

import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in); // Se crea una sola vez
        try {
            while(true) {
                Menu.menuConversor();
                String opcion = teclado.nextLine();
                if(opcion.equals("1")) {
                    // Pasar el Scanner compartido para evitar múltiples scanners sobre System.in
                    conecxionApi.conectar(teclado);
                }else if(opcion.equals("2")) {
                    break;
                }else if(opcion.equals("3")) {
                    Menu.mostrarCodigosMoneda();
                }else{
                    System.out.println("Opción inválida. Intente nuevamente.");
                }
            }
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Entrada cerrada. Saliendo...");
        } finally {
            teclado.close(); // Se cierra al salir del ciclo
            Menu.menuSalida();
        }
    }
}
