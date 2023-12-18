
package estructuradedatos_1;

import BaseDatos.Producto;


public class NodoProducto {
    //Declaración de los atributos 
    private Producto dato;
    private NodoProducto dirSig;
    
    //Método constructor
    NodoProducto(){
    dato = new Producto();
    dirSig= null;    
    }
    //Método Get

    public Producto getDato() {
        return dato;
    }

    public NodoProducto getDirSig() {
        return dirSig;
    }
    //Método Set

    public void setDato(Producto dato) {
        this.dato = dato;
    }

    public void setDirSig(NodoProducto dirSig) {
        this.dirSig = dirSig;
    }
    
    
}
