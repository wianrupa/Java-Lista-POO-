/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuradedatos_1;

import BaseDatos.Producto;

public class ListaEnlazadaProducto {

    //Declaración de los atributos
    private NodoProducto inicio, fin;

    //Método constructor
    public ListaEnlazadaProducto() {
        inicio = fin = null;
    }
    //Método Get

    public NodoProducto getInicio() {
        return inicio;
    }

    public NodoProducto getFin() {
        return fin;
    }
    //Método Set

    public void setInicio(NodoProducto inicio) {
        this.inicio = inicio;
    }

    public void setFin(NodoProducto fin) {
        this.fin = fin;
    }

    //Acciones
    //Lista vacia
    public boolean  estaVacia() {
        return inicio==null;

    }

    //Adiccionar
    public boolean adiccionarFinal(NodoProducto n) {
        Producto c;
        NodoProducto nc;
        if (estaVacia()) {
            inicio = fin = n;
            return true;
        } else {
            c = n.getDato();
            nc = buscar(c.getId());
            if (nc == null) {
                fin.setDirSig(n);
                fin = n;
                return true;
            } else {
                return false;
            }
        }

    }
     public boolean adicionarInicio(NodoProducto n){
        NodoProducto nc;
        Producto c;
        if(estaVacia()){
            inicio = fin = n;
            return true;
        }
        else{
            c = n.getDato();
            nc  = buscar(c.getId());
            if(nc == null){
              n.setDirSig(inicio);
              inicio = n;
              return true;
            }
            else{
                return false;
            }
        }
    }
    //Buscar
    public NodoProducto buscar(int id){
        NodoProducto aux = inicio;
        Producto c;
        if(estaVacia()){
            return null;
        }
        else{
            while(aux != null){
                c = aux.getDato();
                if(id == c.getId()){
                    return aux;
                }
                else{
                    aux = aux.getDirSig();
                }
            }
            return null;
        }
    }
    //Eliminar
    public boolean eliminar(int id){
        NodoProducto ant = null;
        NodoProducto aux = inicio;
        while(aux != null){
           if(id == aux.getDato().getId()){
               //Dato al inicio de la ista
               if(aux == inicio){
                  inicio = aux.getDirSig();
                  aux.setDirSig(null);
                  return true;
               }
               else{
                   //Dato despues del inicio
                   ant.setDirSig(aux.getDirSig());
                   aux.setDirSig(null);
                   //Dato al final de la lista
                   if(aux == fin){
                      fin = ant; 
                   }
                   return true;
               }
           }
           else{
               ant = aux;
               aux = aux.getDirSig();
           }
        }
        return false;
    }
    //Mostrar datos de la Lista
    public void mostrar(){
        if(estaVacia()){
            System.out.println("Lista vacia");
        }
        else{
            NodoProducto aux = inicio;
            while(aux != null){
                mostrarProducto(aux.getDato());
                aux = aux.getDirSig();
            }
        }
    }
    public void mostrarProducto(Producto c){
        System.out.println(c.getId()+" "+c.getNombre()+" "+c.getId()+" "+c.getMarca()+" "+c.getPreciodc()+" "+c.getPreciodv());
    }
    //Modoficar
    public boolean modificar(Producto c){
        if(estaVacia()){
            return false;
        }
        else{
            NodoProducto nc = buscar(c.getId());
            if( nc == null){
                return false;
            }
            else{
                nc.setDato(c);
                return true;
            }
        }
    }

}
