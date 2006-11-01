/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import static com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary.formatNumber;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.text.DecimalFormat;

/**
 *
 * @author Popa
 */
public class Producto {
  private String codigo;
  private String marca;
 private String tipo;
 private double precioCosto;
 private double precioFinal;
 private int Stock;
 private int porcentajeGanancia;

 
 
    public Producto(String codigo, String marca, String tipo, double precioCosto, double precioFinal, int Stock, int porcentajeGanancia) {
        this.codigo = codigo;
        this.marca = marca;
        this.tipo = tipo;
        this.precioCosto = precioCosto;
        this.precioFinal = precioFinal;
        this.Stock = Stock;
        this.porcentajeGanancia = porcentajeGanancia;
    }
 

    public Producto(String codigo, String marca, String tipo, double precioCosto, int Stock) {
        this.codigo = codigo;
        this.marca = marca;
        this.tipo = tipo;
        this.precioCosto = precioCosto;
        this.Stock = Stock;
    }

   public Producto() {
       }

   

    public int getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    public void setPorcentajeGanancia(int porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

   

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }
   public static Double formatearDecimales(Double numero, Integer numeroDecimales) {
return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
}

   
}
