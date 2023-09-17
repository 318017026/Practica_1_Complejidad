
package com.mycompany.practica1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Complejidad Computacional 2024-1
 * Profesor: Oscar Hernández Constantino	
 * Ayudante: Malinali Gónzalez Lara
 * 
 * Practica 1 - Menu principal
 * 
 * @author Juan Manuel Lucio Rangel
 * @author Victor Rosales
 * @version 2.1
 *
 */
public class Practica1{

    Grafica G;
    int minimo;
    
    /**
    * Metodo main.- Muestra el menu principal que nos permite crear la grafica
    * y resolver el problema de ruta inducida.
    * @param args .- Nombre del archivo .txt con los datos de la grafica
    */
    public static void main(String[] args) {
        
        Practica1 M = new Practica1();
        
        if (args.length == 0){
            args = new String[]{"Prueba.txt"};
        }
        
        if (args.length != 1){
            System.out.println("Uso incorrecto. Debes proporcionar el nombre del archivo .txt.");
            return;
        }

        String nombreArchivo = args[0];
        String datos = "";

        try(BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))){
            String linea;
            while ((linea = br.readLine()) != null) {
                datos += linea + "\n";
            }
        }catch (IOException e){
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        String[] lineas = datos.split("\n");
              
        M.crearGrafica(lineas);
    }

    /**
    * Metodo crearGrafica .- Recibe los datos de la grafica para crearla.
    * @param lineas .- Datos de la grafica
    */
    private void crearGrafica(String[] lineas){
        
        String[] aux = lineas[0].split(" ");
        this.minimo = Integer.parseInt(aux[aux.length-1]);
        
        // Comprobacion de que los valores son correctos, QUITARLO EN LA VERSION FINAL
        System.out.println(this.minimo);
        
        aux = lineas[1].split(" ");
        int numVertices = Integer.parseInt(aux[aux.length-1]);
        
        // Comprobacion de que los valores son correctos, QUITARLO EN LA VERSION FINAL
        System.out.println(numVertices);
        
        String[] datos = this.datosVertices(lineas);
        
        // Comprobacion de que los valores son correctos, QUITARLO EN LA VERSION FINAL
        for(int i  = 0; i < datos.length; i++){
            System.out.println(datos[i]);
        }
        
        G = new Grafica(numVertices, datos);
    }

    /**
    * Metodo datosVertices .- Obtiene los datos correspondientes de los vertices.
    * @param lineas .- Datos de la grafica
    */
    private String[] datosVertices(String[] lineas) {
        String[] s = new String[lineas.length - 2];
        int j = 0;
        
        for(int i = 2; i<lineas.length; i++){
            s[j] = lineas[i];
            j++;
        }
        
        return s;
    }
}
