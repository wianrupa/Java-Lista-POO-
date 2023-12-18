/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDatos;

/**
 *
 * @author wilmer
 */
public class Producto {

    private int id, exist;
    private String nombre, marca;
    private double preciodv, preciodc;

    //Método constructor
    public Producto() {
        id = exist = 0;
        nombre = ""; 
        marca = "";
        preciodc = 0;
         preciodv = preciodc *1.20;

        //Método get
    }

    public int getId() {
        return id;
    }

    public int getExist() {
        return exist;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public double getPreciodv() {
        return preciodv;
    }

    public double getPreciodc() {
        return preciodc;
    }

    //Método Set
    public void setId(int id) {
        this.id = id;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPreciodv(double preciodv) {
        this.preciodv = preciodv;
    }

    public void setPreciodc(double preciodc) {
        this.preciodc = preciodc;
    }

    //Acciones de la clase Producto
    //Método para enviar el nombre
   

}
