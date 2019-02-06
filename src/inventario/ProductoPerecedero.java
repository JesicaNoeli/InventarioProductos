/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Popa
 */
public class ProductoPerecedero extends Producto{
 LocalDate fechaVencimiento; 

    public ProductoPerecedero() {
    }

 
    public ProductoPerecedero(LocalDate fechaVencimiento, String codigo, String marca, String tipo, double precioCosto, double precioFinal, int Stock, int porcentajeGanancia) {
        super(codigo, marca, tipo, precioCosto, precioFinal, Stock, porcentajeGanancia);
        this.fechaVencimiento = fechaVencimiento;
    }

    public ProductoPerecedero(LocalDate fechaVencimiento, String codigo, String marca, String tipo, double precioCosto, int Stock) {
        super(codigo, marca, tipo, precioCosto, Stock);
        this.fechaVencimiento = fechaVencimiento;
    }


    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
       
}
