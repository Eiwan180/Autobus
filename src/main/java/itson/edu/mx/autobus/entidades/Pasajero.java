/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.edu.mx.autobus.entidades;

/**
 *
 * @author yato_
 */
public class Pasajero {

    private String nombre;
    private String destino;
    private double precio;
    private int asientoNumero;

    public Pasajero(String nombre, String destino, double precio, int asientoNumero) {
        this.nombre = nombre;
        this.destino = destino;
        this.precio = precio;
        this.asientoNumero = asientoNumero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDestino() {
        return destino;
    }

    public double getPrecio() {
        return precio;
    }

    public int getAsientoNumero() {
        return asientoNumero;
    }
}
