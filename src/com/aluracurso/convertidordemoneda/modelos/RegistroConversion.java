package com.aluracurso.convertidordemoneda.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroConversion {
    private String base;
    private String target;
    private double valorIngresado;
    private double valorConvertido;
    private String fechaHora;

    public RegistroConversion(String base, String target, double valorIngresado, double valorConvertido) {
        this.base = base;
        this.target = target;
        this.valorIngresado = valorIngresado;
        this.valorConvertido = valorConvertido;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.fechaHora = LocalDateTime.now().format(formato);
    }
}
