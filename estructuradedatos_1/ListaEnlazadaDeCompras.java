/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuradedatos_1;

import BaseDatos.Compras;
import BaseDatos.Ventas;
import estructuradedatos_1.NodoCompras;

/**
 *
 * @author Wilmer Ruiz 
 */
public class ListaEnlazadaDeCompras {

    //Declaraciones de los atributos
    private NodoCompras inicio, fin;

    //Método constructor
    public ListaEnlazadaDeCompras() {
        inicio = fin = null;
        //Método Get

    }

    public NodoCompras getInicio() {
        return inicio;
    }

    public NodoCompras getFin() {
        return fin;
    }
    //Método Set

    public void setInicio(NodoCompras inicio) {
        this.inicio = inicio;
    }

    public void setFin(NodoCompras fin) {
        this.fin = fin;
    }

    //Aciones de la lista
    //Lista vacia
    public boolean estaVacia() {
        return inicio == null;
    }

    //Método adicionar
    public boolean adicionarFinal(NodoCompras n) {
        Compras c;
        NodoCompras nc;
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

    public boolean adicionarInicio(NodoCompras n) {
        NodoCompras nc;
        Compras c;
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
    public NodoCompras buscar(int id) {
        NodoCompras aux = inicio;
        Compras c;
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
            adicionarFinal(aux);
            
        }
        return null;
    }

    //Eliminar
    public boolean eliminar(int id) {
        NodoCompras ant = null;
        NodoCompras aux = inicio;
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
            NodoCompras aux = inicio;
            while (aux != null) {
                mostrarCompras(aux.getDato());
                aux = aux.getDirSig();
            }
        }
    }

    public void mostrarCompras(Compras c) {
        System.out.println(c.getId() + " " + c.getPrecio() + " " + c.getFecha() + " " + c.getIdproducto());
    }

    //Modoficar
    public boolean modificar(Compras c) {
        if (estaVacia()) {
            return false;
        } else {
            NodoCompras nc = buscar(c.getId());
            if (nc == null) {
                return false;
            } else {
                nc.setDato(c);
                return true;
            }
        }
    }
}
