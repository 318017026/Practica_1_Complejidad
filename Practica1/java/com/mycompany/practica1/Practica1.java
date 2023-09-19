package com.mycompany.practica1;

import java.io.*;
import java.util.*;

/**
 * Complejidad Computacional 2024-1
 * Profesor: Oscar Hernández Constantino	
 * Ayudante: Malinali Gónzalez Lara
 * 
 * Practica 1
 * 
 * @author Rosales Jaimes Victor 
 * @author Lucio Rangel Juan Manuel
 * @version 1.0
 *
 */
public class Practica1 {

    /**
    * Metodo main.- Menu principal que nos permite recibir la grafica
    * y crear la matriz de adyacencias.
    * @param args .- Nombre del archivo de entrada con la grafica y nombre del 
    * archivo de salida con el resultado de la codificacion como matriz.
    */
    public static void main(String[] args) {
        
        if (args.length != 2) {
            System.out.println("Uso: java Practica1 archivoEntrada archivoSalida");
            return;
        }

        String archivoEntrada = args[0];
        String archivoSalida = args[1];
        
        try {
            List<String> grafo = leerArchivo(archivoEntrada);
            int numVertices = grafo.size()-1;
            int[][] matrizAdyacencia = crearMatrizAdyacencia(grafo, numVertices);

            escribirArchivoSalida(matrizAdyacencia, numVertices, archivoSalida);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * Metodo leerArchivo.- Lee un archivo de texto y devuelve el contenido como 
    * una lista de cadenas.
    *
    * @param archivoEntrada .- Ruta  donde se encuentra el archivo.
    * @return .- Lista de cadenas que representan las líneas del archivo.
    * @throws .- IOException si ocurre un error al leer el archivo.
    */
    private static List<String> leerArchivo(String archivoEntrada) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
        List<String> grafo = new ArrayList<>();
        String linea;

        while ((linea = br.readLine()) != null) {
            grafo.add(linea);
        }
        br.close();

        return grafo;
    }

    /**
    * Metodo crearMatrizAdyacencia.- Crea la matriz de adyacencia basandose en la
    * grafica.
    *
    * @param grafica .- Grafica representada como una lista de cadenas.
    * @param numVertices .- Número de vértices de la grafica.
    * @return .- La matriz de adyacencia que representa las conexiones entre vértices.
    */
    private static int[][] crearMatrizAdyacencia(List<String> grafica, int numVertices) {
        int[][] matrizAdyacencia = new int[numVertices][numVertices];
        int k = -1;

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                matrizAdyacencia[i][j] = 0; // Inicializar todas las celdas en 0
            }
        }

        int numAristas = 0;

        for (String linea : grafica) {
            if (linea.startsWith("k: ")) {
                String[] partes = linea.split(": ");

                k = Integer.parseInt(partes[1]);
            }else{
                String vertice = linea.trim().replace("[", "").replace("]", "").replace("(", "");
                vertice = vertice.substring(0, vertice.length() - 1);
                String[] partes = vertice.split(": ");
                String[] adyacencias = partes[1].split("\\),");

                for (String adyacencia : adyacencias) {
                    String[] vertices = adyacencia.split(",");
                    int v1 = Integer.parseInt(vertices[0]);
                    int v2 = Integer.parseInt(vertices[1]);
                    matrizAdyacencia[v1 - 1][v2 - 1] = 1;
                    matrizAdyacencia[v2 - 1][v1 - 1] = 1;
                    numAristas++;
                }
            }
        }

        System.out.println("Número de aristas: " + numAristas / 2);
        System.out.println("Número de vértices: " + numVertices);
        System.out.println("k: " + k);
        return matrizAdyacencia;
    }

    /**
    * Metodo escribirArchivoSalida.- Escribe la matriz de adyacencia en un archivo de salida.
    *
    * @param matrizAdyacencia .- Matriz de adyacencia a escribir.
    * @param numVertices .- Número de vértices de la matriz de adyacencia.
    * @param archivoSalida .-Ruta del archivo donde se escribirá la matriz.
    * @throws .- IOException si ocurre un error al escribir en el archivo.
    */
    private static void escribirArchivoSalida(int[][] matrizAdyacencia, int numVertices, String archivoSalida) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida));
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                bw.write(matrizAdyacencia[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
