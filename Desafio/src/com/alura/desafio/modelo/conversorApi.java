package com.alura.desafio.modelo;

import java.util.Map;

public record conversorApi(Map<String, Double> conversion_rates) {
    // Permite acceder a cualquier moneda por su código
}

