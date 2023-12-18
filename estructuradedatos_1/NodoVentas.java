/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuradedatos_1;
import BaseDatos.Ventas;

/**
 *
 * @author Wilmer Ruiz 
 */
public class NodoVentas {
    //Declaración de  atributos
    private Ventas dato;
    private NodoVentas dirSig;
    
    //Método contructor 
    NodoVentas (){
    dato = new Ventas();
    dirSig= null ;
    }
    //Get

    public Ventas getDato() {
        return dato;
    }

    public NodoVentas getDirSig() {
        return dirSig;
    }
    //set

    public void setDato(Ventas dato) {
        this.dato = dato;
    }

    public void setDirSig(NodoVentas dirSig) {
        this.dirSig = dirSig;
    }
    
}
