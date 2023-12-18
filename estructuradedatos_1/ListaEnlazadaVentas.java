/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuradedatos_1;

import BaseDatos.Cliente;
import BaseDatos.Ventas;
import estructuradedatos_1.NodoVentas;

/**
 *
 * @author Wilmer Ruiz 
 */
public class ListaEnlazadaVentas {

    //Declaraciones  de los atributos
    private NodoVentas inicio, fin;

    //Metodo contructor
    public ListaEnlazadaVentas() {
        inicio = fin = null;
    }
    //Método Get 

    public NodoVentas getInicio() {
        return inicio;
    }

    public NodoVentas getFin() {
        return fin;
    }
    //Método Set

    public void setInicio(NodoVentas inicio) {
        this.inicio = inicio;
    }

    public void setFin(NodoVentas fin) {
        this.fin = fin;
    }

    //Acciones 
    //Método Lista vacia
    public boolean estaVacia() {
        return inicio == null;
    }

    //Método  adicionar
    public boolean adicionarFinal(NodoVentas n) {
        Ventas c;
        NodoVentas nc;
        if (estaVacia()) {
            inicio = fin = null;
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

    public boolean adicionarInicio(NodoVentas n) {
        NodoVentas nc;
        Ventas c;
        if (estaVacia()) {
            inicio = fin = n;
            return true;
        } else {
            c = n.getDato();
            nc = buscar(c.getId());
            if (nc == null) {
                n.setDirSig(inicio);
                inicio = n;
                return true;
            } else {
                return false;
            }
        }
    }

    //Buscar
    public NodoVentas buscar(int id) {
        NodoVentas aux = inicio;
        Ventas c;
        if (estaVacia()) {
            return null;
        } else {
            while (aux != null) {
                c = aux.getDato();
                if (id == c.getId()) {
                    return aux;
                } else {
                    aux = aux.getDirSig();
                }
            }
            return null;
        }
    }

    //Eliminar
    public boolean eliminar(int id) {
        NodoVentas ant = null;
        NodoVentas aux = inicio;
        while (aux != null) {
            if (id == aux.getDato().getId()) {
                //Dato al inicio de la ista
                if (aux == inicio) {
                    inicio = aux.getDirSig();
                    aux.setDirSig(null);
                    return true;
                } else {
                    //Dato despues del inicio
                    ant.setDirSig(aux.getDirSig());
                    aux.setDirSig(null);
                    //Dato al final de la lista
                    if (aux == fin) {
                        fin = ant;
                    }
                    return true;
                }
            } else {
                ant = aux;
                aux = aux.getDirSig();
            }
        }
        return false;
    }

    //Mostrar datos de la Lista
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Lista vacia");
        } else {
            NodoVentas aux = inicio;
            while (aux != null) {
                mostrarVentas(aux.getDato());
                aux = aux.getDirSig();
            }
        }
    }

    public void mostrarVentas(Ventas c) {
        System.out.println(c.getId() + " " + c.getCantidad()+ " " + c.getFecha()+ " " + c.getIdcliente()+ " " + c.getIdproduct()+ " " + c.getPreciodeventa());
    }

    //Modoficar
    public boolean modificar(Ventas c) {
        if (estaVacia()) {
            return false;
        } else {
            NodoVentas nc = buscar(c.getId());
            if (nc == null) {
                return false;
            } else {
                nc.setDato(c);
                return true;
            }
        }
    }
}
