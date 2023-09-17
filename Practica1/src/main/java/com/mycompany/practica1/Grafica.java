
package com.mycompany.practica1;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Complejidad Computacional 2024-1
 * Profesor: Oscar Hernández Constantino	
 * Ayudante: Malinali Gónzalez Lara
 * 
 * Practica 1 - Grafica
 * 
 * @author Juan Manuel Lucio Rangel
 * @author Victor Rosales
 * @version 1.5
 *
 */
public class Grafica {
    private Vertice[] cnjVertices;

    /**
    * Constructor Grafica.
    * @param k .- Numero de vertices que tendra la grafica
    * @param datos .- Datos de los vertices de la grafica
    */
    public Grafica(int k, String[] datos) {
        
        // Asignamos la longitud del conjunto de vertices
        this.setCnjVertices(k);
        
        // Buscamos y definimos a los vertices
        this.defineVertices(datos);
        
        // Comprobacion de que el metodo funciono, QUITARLO EN LA VERSION FINAL
        System.out.println("La Grafica se creo exitosamente");
        
        // Comprobacion de que la grafica es correcta, QUITARLO EN LA VERSION FINAL
        System.out.println(this.toString());
    }

    /**
    * Metodo setCnjVertices.- Asigna el numero de vertices que tendra la grafica
    * @param k .- Numero de vertices de la grafica
    */
    private void setCnjVertices(int k) {
        
        // Asignamos la longitud del conjunto de vertices
        this.cnjVertices = new Vertice[k];
    }

    /**
    * Metodo defineVertices.- Asigna los datos correspondientes a cada
    * vertice de la grafica.
    * @param lineas
    */
    private void defineVertices(String[] lineas) {
        
        // Creamos un patrón para buscar las aristas en cada línea
        Pattern patron = Pattern.compile("\\((\\d+),(\\d+)\\)");

        for (int i = 0; i < lineas.length; i++) {
            String linea = lineas[i];

            // Extraemos el nombre del vértice (por ejemplo, "Vertice 1")
            String nombre = linea.split(":")[0].trim();

            // Buscamos las aristas en la línea y las almacenamos en un ArrayList
            Matcher matcher = patron.matcher(linea);
            ArrayList<Integer> vecinos = new ArrayList<>();

            while (matcher.find()) {
                int vecino = Integer.parseInt(matcher.group(2));
                vecinos.add(vecino);
            }

            // Creamos el vértice y lo almacenamos en el arreglo de vértices
            cnjVertices[i] = new Vertice(nombre, vecinos);
        }
    }
    
    /**
    * Metodo toString: Imprime la grafica con sus datos correspondientes
    */
    @Override
    public String toString() {
        String g = "Grafica{" + "\n";
        
        for (Vertice vertice : this.cnjVertices) {
            g += vertice.toString() + "\n";
        }
        
        g += "}";
        
        return g;
    }
}
