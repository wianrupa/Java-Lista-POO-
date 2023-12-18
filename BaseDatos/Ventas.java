/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDatos;

import BaseDatos.Producto;
import BaseDatos.Cliente;
import BaseDatos.Compras;

/**
 *
 * @author wilmer
 */
public class Ventas {

    //Declaración de los atributos
    private int id, fecha, cantidad, idproduct , idcliente ;
    double preciodeventa ;
    
    Producto c; Cliente d; Compras s;
   

    //Método constructor.
    public Ventas() {
        c= null;
        s= null;
        
        int id = fecha = cantidad = 0;
      double preciodeventa = (double)(s.precio * 1.20);
       int idproduct = c.getId();
       int idcliente = d.getId();
       
        
    }
    //Metodo Get

    public Compras getS() {
        return s;
    }

    public double getPreciodeventa() {
        return preciodeventa;
    }

    public int getId() {
        return id;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public Cliente getD() {
        return d;
    }

    public int getFecha() {
        return fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public Producto getC() {
        return c;
    }
    //Método Set

    public void setS(Compras s) {
        this.s = s;
    }

    public void setPreciodeventa(double preciodeventa) {
        this.preciodeventa = preciodeventa;
    }
    

    

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public void setC(Producto c) {
        this.c = c;
    }

    public void setD(Cliente d) {
        this.d = d;
    }
    
    

public  boolean  productoVentas(){
   
    return true;

       }
    
}
