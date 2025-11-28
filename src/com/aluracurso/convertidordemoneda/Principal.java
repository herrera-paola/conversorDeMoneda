package com.aluracurso.convertidordemoneda;

import com.aluracurso.convertidordemoneda.conexion.ConexionApi;
import com.aluracurso.convertidordemoneda.convertidor.GeneradorDeArchivo;
import com.aluracurso.convertidordemoneda.modelos.Menu;
import com.aluracurso.convertidordemoneda.modelos.Moneda;
import com.aluracurso.convertidordemoneda.modelos.RegistroConversion;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        Menu menu = new Menu();
        ConexionApi conexionApi = new ConexionApi();
        GeneradorDeArchivo generadorDeArchivo = new GeneradorDeArchivo();

        while (true) {
            try {
                menu.mostrarMenu();
                int opcion = teclado.nextInt();
                String base = "";
                String target = "";

                switch (opcion) {
                    case 1:
                        base = "USD";
                        target = "ARS";
                        break;
                    case 2:
                        base = "ARS";
                        target = "USD";
                        break;
                    case 3:
                        base = "USD";
                        target = "BRL";
                        break;
                    case 4:
                        base = "BRL";
                        target = "USD";
                        break;
                    case 5:
                        base = "USD";
                        target = "CLP";
                        break;
                    case 6:
                        base = "CLP";
                        target = "USD";
                        break;
                    case 7:
                        System.out.println("Saliendo de la aplicacion.");
                        return;
                    default:
                        System.out.println("Opcion no valida.");
                        continue;
                }

                System.out.println("Ingresa el valor que deseas convertir: ");
                double valor = teclado.nextDouble();
                Moneda moneda = conexionApi.obtenerMoneda();
                double tasa;
                if (base.equals("USD")) {
                    tasa = moneda.conversion_rates().get(target);
                } else {
                    double valorBase = moneda.conversion_rates().get(base);
                    tasa = 1 / valorBase;
                }
                double conversion = valor * tasa;
                System.out.println("El valor de : " + valor + " " + "[" + base + "]" + " = " + conversion + " " + "[" + target + "]");

                RegistroConversion registro = new RegistroConversion(base,target,valor,conversion);
                generadorDeArchivo.guardarJson(registro);

            } catch (InputMismatchException e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
                teclado.nextLine();
            }
        }
    }
}
