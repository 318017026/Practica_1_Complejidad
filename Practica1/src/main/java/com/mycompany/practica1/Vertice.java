
package com.mycompany.practica1;
import java.util.ArrayList;

/**
 * Complejidad Computacional 2024-1
 * Profesor: Oscar Hernández Constantino	
 * Ayudante: Malinali Gónzalez Lara
 * 
 * Practica 1 - Vertice
 * 
 * @author Juan Manuel Lucio Rangel
 * @author Victor Rosales
 * @version 1.2
 *
 */
public class Vertice{
    
    private ArrayList vecinos = new ArrayList<>();
    private String nombre = " ";

    /**
    * Constructor Vertice.
    * @param nombre .- Nombre que se le asignara al vertice
    * @param vecinos .- Vecinos del vertice
    */
    public Vertice(String nombre, ArrayList vecinos){
      this.setNombre(nombre);
      this.setVecinos(vecinos);
      
      // Comprobacion de que el metodo funciono, QUITARLO EN LA VERSION FINAL
      System.out.println("El vertice "+this.getNombre()+" se creo exitosamente");
    }

    /**
    * Metodo setVecinos.- Asigna los vecinos del vertice
    * @param vecinos
    */
    private void setVecinos(ArrayList vecinos) {
        this.vecinos = vecinos;
    }

    /**
    * Metodo setNombre.- Asigna el nombre del vertice
    * @param nombre
    */
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
    * Metodo getVecinos.- Regresa la lista de vecinos del vertice
    * @return Vecinos
    */
    public ArrayList getVecinos() {
        return vecinos;
    }

    /**
    * Metodo getNombre.- Regresa el nombre del vertice
    * @return Nombre
    */
    public String getNombre() {
        return nombre;
    }

    /**
    * Metodo toString: Imprime el vertice con sus datos correspondientes
    */
    @Override
    public String toString() {
        String v = nombre + ": [";
        
        for (Object vecino : this.vecinos){
           v += vecino + ", ";            
        } 
        
        v+=")";      
        v = v.replace(", )","]");
        
        return v;
    }
    
}
