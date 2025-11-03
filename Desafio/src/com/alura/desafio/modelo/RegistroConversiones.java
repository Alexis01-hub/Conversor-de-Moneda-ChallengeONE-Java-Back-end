package com.alura.desafio.modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroConversiones {
    private static final String LOG_FILE = "conversiones.log";

    public static void writeLog(String mensaje) {
        try {
            Path logPath = Path.of(LOG_FILE);
            if (!Files.exists(logPath)) {
                Files.createFile(logPath);
            }
            String timestamp = ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            try (FileWriter fw = new FileWriter(LOG_FILE, true); PrintWriter pw = new PrintWriter(fw)) {
                pw.println(timestamp + " - " + mensaje);
            }
        } catch (IOException ex) {
            System.err.println("No se pudo escribir en el log: " + ex.getMessage());
        }
    }
}

