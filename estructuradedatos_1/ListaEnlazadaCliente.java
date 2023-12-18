/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuradedatos_1;

import BaseDatos.Cliente;

/**
 *
 * @author Wilmer Ruiz 
 */
public class ListaEnlazadaCliente {
    //Declarar los atributos
    private NodoCliente inicio,fin;
    //Constructor
    ListaEnlazadaCliente(){
        inicio = fin = null;
    }
    //Get
    public NodoCliente getInicio() {
        return inicio;
    }
    public NodoCliente getFin() {
        return fin;
    }
    //Set
    public void setInicio(NodoCliente inicio) {
        this.inicio = inicio;
    }
    public void setFin(NodoCliente fin) {
        this.fin = fin;
    }
    //Lista vacia
    public boolean estaVacia(){
        return inicio == null;
    }
    //Adicionar
    public boolean adicionarFinal(NodoCliente n){
        Cliente c;
        NodoCliente nc;
        if(estaVacia()){
            inicio = fin = n;
            return true;
        }
        else{
            c = n.getDato();
            nc = buscar(c.getId());
            if(nc == null){
                fin.setDirSig(n);
                fin = n;
                return true;
            }
            else{
               return false; 
            }
        }
    }
    public boolean adicionarInicio(NodoCliente n){
        NodoCliente nc;
        Cliente c;
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
    public NodoCliente buscar(int id){
        NodoCliente aux = inicio;
        Cliente c;
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
        NodoCliente ant = null;
        NodoCliente aux = inicio;
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
            NodoCliente aux = inicio;
            while(aux != null){
                mostrarCliente(aux.getDato());
                aux = aux.getDirSig();
            }
        }
    }
    public void mostrarCliente(Cliente c){
        System.out.println(c.getId()+" "+c.getNombres()+" "+c.getApellidos()+" "+c.getDireccion()+" "+c.getEmail()+" "+c.getEdad());
    }
    //Modoficar
    public boolean modificar(Cliente c){
        if(estaVacia()){
            return false;
        }
        else{
            NodoCliente nc = buscar(c.getId());
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
