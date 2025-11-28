package com.aluracurso.convertidordemoneda.convertidor;

import com.aluracurso.convertidordemoneda.modelos.Moneda;
import com.aluracurso.convertidordemoneda.modelos.RegistroConversion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneradorDeArchivo {
    private final String nombreArchivo = "Historial.json";

    public void guardarJson(RegistroConversion registro) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<RegistroConversion> historial = new ArrayList<>();
        File archivo = new File(nombreArchivo);

        if (archivo.exists()){
            FileReader lector = new FileReader(archivo);
            RegistroConversion[] registrosPrevios = gson.fromJson(lector, RegistroConversion[].class);
            if (registrosPrevios != null) {
                historial.addAll(Arrays.asList(registrosPrevios));
            }
            lector.close();
        }

        historial.add(registro);

        FileWriter escritura = new FileWriter(  nombreArchivo);
        escritura.write(gson.toJson(historial));
        escritura.close();
    }
}
