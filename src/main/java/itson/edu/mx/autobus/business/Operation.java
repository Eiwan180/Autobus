/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.edu.mx.autobus.business;

import itson.edu.mx.autobus.entidades.Asiento;
import itson.edu.mx.autobus.entidades.Pasajero;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author yato_
 */
public class Operation {


    private List<Asiento> asientos;
    private List<Pasajero> pasajeros;
    private int terminalActual;
    private final String[] terminales;

    public Operation() {
        this.asientos = new ArrayList<>();
        this.pasajeros = new ArrayList<>();
        this.terminalActual = 0;
        this.terminales = new String[]{
                "Navojoa", "Obregón", "Empalme", "Guaymas", "Hermosillo", "Santa Ana", "Magdalena", "Imuris", "Nogales"
        };

        // Inicializar los 20 asientos
        for (int i = 1; i <= 20; i++) {
            asientos.add(new Asiento(i));
        }
    }

    public void venderBoleto(String nombre, String destino, double precio, int asientoNumero) {
        Asiento asiento = asientos.get(asientoNumero - 1);
        if (asiento.isDisponible()) {
            asiento.ocupar();
            pasajeros.add(new Pasajero(nombre, destino, precio, asientoNumero));
        }
    }

    public void avanzarTerminal() {
        if (terminalActual < terminales.length - 1) {
            terminalActual++;
        }
    }

    public String getTerminalActual() {
        return terminales[terminalActual];
    }

    public int getPasajerosBajadosEnTerminal() {
        // Contar los pasajeros que bajan en esta terminal
        int bajados = 0;
        for (int i = pasajeros.size() - 1; i >= 0; i--) {
            if (pasajeros.get(i).getDestino().equals(terminales[terminalActual])) {
                bajados++;
                pasajeros.remove(i);
            }
        }
        return bajados;
    }

    public List<Asiento> getAsientosDisponibles() {
        List<Asiento> disponibles = new ArrayList<>();
        for (Asiento asiento : asientos) {
            if (asiento.isDisponible()) {
                disponibles.add(asiento);
            }
        }
        return disponibles;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public String mostrarReporte() {
        StringBuilder reporte = new StringBuilder("Reporte Final:\n");
        double totalGanancia = 0;
        for (Pasajero pasajero : pasajeros) {
            reporte.append("Nombre: ").append(pasajero.getNombre())
                    .append(", Origen: ").append("Sur")
                    .append(", Destino: ").append(pasajero.getDestino())
                    .append(", Precio: $").append(pasajero.getPrecio())
                    .append(", Asiento: ").append(pasajero.getAsientoNumero())
                    .append("\n");
            totalGanancia += pasajero.getPrecio();
        }
        reporte.append("Ganancia Total: $").append(totalGanancia);
        return reporte.toString();
    }
}
