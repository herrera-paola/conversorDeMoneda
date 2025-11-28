package com.aluracurso.convertidordemoneda.conexion;

import com.aluracurso.convertidordemoneda.modelos.Moneda;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi {
    public Moneda obtenerMoneda() throws IOException, InterruptedException {
        String direccion = "https://v6.exchangerate-api.com/v6/c184f866f42e35ff8c1c3de6/latest/USD";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).GET().build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e){
            throw new RuntimeException("No es posible convertir.");
        }
    }
}
