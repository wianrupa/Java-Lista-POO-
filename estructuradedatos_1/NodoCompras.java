/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuradedatos_1;
import BaseDatos.Compras;

/**
 *
 * @author Wilmer Ruiz 
 */
public class NodoCompras {
    //Declaración de atributos
    private Compras dato;
    private NodoCompras dirSig;
    
    //Método constructor 
    NodoCompras(){
    dato = new Compras();
    dirSig= null;
    }
    //Get

    public Compras getDato() {
        return dato;
    }

    public NodoCompras getDirSig() {
        return dirSig;
    }
    //Set

    public void setDato(Compras dato) {
        this.dato = dato;
    }

    public void setDirSig(NodoCompras dirSig) {
        this.dirSig = dirSig;
    }
    
}
