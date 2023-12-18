/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuradedatos_1;

import BaseDatos.Cliente;
import BaseDatos.Compras;
import BaseDatos.Ventas;
import BaseDatos.Producto;
import estructuradedatos_1.ListaEnlazadaProducto;
import estructuradedatos_1.ListaEnlazadaDeCompras;
import estructuradedatos_1.ListaEnlazadaVentas;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Wilmer Ruiz 
 */
public class EstructuraDeDatos {

    /**
     * @param args the command line arguments
     */
    static Scanner entrada = new Scanner(System.in);
    static int dato;

    public static void main(String[] args) {
        // TODO code application logic here

        ListaEnlazadaCliente l = new ListaEnlazadaCliente();
        ListaEnlazadaProducto p = new ListaEnlazadaProducto();
        ListaEnlazadaDeCompras k = new ListaEnlazadaDeCompras();
        ListaEnlazadaVentas v = new ListaEnlazadaVentas();

        int op = -1;
        while (op != 24) {
            //cls();
            System.out.print("Menú principal de las 4 Listas \n\n Menu Principal de la Lista Cliente\n 1. Adicionar\n 2. Buscar\n 3. Eliminar\n 4. Modificar\n 5. Mostrar\n 6. Salir\n Digite la opcion: \n Menu Principal de la Lista Producto\n 7. Adicionar\n 8. Buscar\n 9. Eliminar\n 10. Modificar\n 11. Mostrar\n 12. Salir\n Digite la opcion:\n Menu Principal de la Lista Compras\n 13. Adicionar\n 14. Buscar\n 15. Eliminar\n 16. Modificar\n 17. Mostrar\n 18. Salir\n Digite la opcion:\n Menu Principal de la Lista Ventas\n 19. Adicionar\n 20. Buscar\n 21. Eliminar\n 22. Modificar\n 23. Mostrar\n 24. Salir\n Digite la opcion:");
            op = entrada.nextInt();
            switch (op) {
                case 1:
                    adicionarClienteLista(l);
                    break;
                case 2:
                    buscarClienteLista(l);
                    break;
                case 3:
                    eliminarClienteLista(l);
                    break;
                case 4:
                    modificarClienteLista(l);
                    break;
                case 5:
                    mostrarClienteLista(l);
                    break;
                case 7:
                    adicionarProductoLista(p);
                    break;
                case 8:
                    buscarProductoLista(p);
                    break;
                case 9:
                    eliminarProductoLista(p);
                    break;
                case 10:
                    modificarProductoLista(p);
                    break;
                case 11:
                    mostrarProductoLista(p);
                    break;
                case 13:
                    adicionarComprasLista(k);
                    break;
                case 14:
                    buscarComprasLista(k);
                    break;
                case 15:
                    eliminarComprasLista(k);
                    break;
                case 16:
                    modificarComprasLista(k);
                    break;
                case 17:
                    mostrarComprasLista(k);
                    break;
                case 19:
                    adicionarVentasLista(v);
                    break;
                case 20:
                    buscarVentasLista(v);
                    break;
                case 21:
                    eliminarVentasLista(v);
                    break;
                case 22:
                    modificarVentasLista(v);
                    break;
                case 23:
                    mostrarVentasLista(v);
                    break;

            }
        }
    }

    //Limpiar pantalla
    public static void cls() {
        try {
            Robot limpiar = new Robot();
            limpiar.keyPress(KeyEvent.VK_CONTROL);
            limpiar.keyPress(KeyEvent.VK_L);
            limpiar.keyRelease(KeyEvent.VK_CONTROL);
            limpiar.keyRelease(KeyEvent.VK_L);

        } catch (Exception e) {
            System.out.println("Error al limpiar la pantalla" + e.getMessage());
        }
    }

    //leyendo los datos del cliente
    public static void leerCliente(Cliente c, boolean estado) {
        if (estado == true) {
            System.out.print("Digite Id del cliente:");
            c.setId(entrada.nextInt());
        }
        System.out.print("Digite nombres del cliente:");
        c.setNombres(entrada.nextLine());
        System.out.print("Digite Apellidos del cliente:");
        c.setApellidos(entrada.nextLine());
        System.out.print("Digite edad del cliente:");
        c.setEdad(entrada.nextInt());
        System.out.print("Digite sexo del cliente (M-masculino, F-femenino:");
        c.setSexo(entrada.next().charAt(0));
        System.out.print("Digite Direccion del cliente:");
        c.setDireccion(entrada.nextLine());
        System.out.print("Digite e-mail del cliente:");
        c.setEmail(entrada.nextLine());
    }

    //Adicionar datos en la Lista
    public static void adicionarClienteLista(ListaEnlazadaCliente l) {
        //Enrada de datos
        while (true) {
            System.out.print("Digite un dato entero 0 en caso de querer termina: ");
            dato = entrada.nextInt();
            if (dato == 0) {
                break;
            } else {
                NodoCliente n = new NodoCliente();
                System.out.println("Ingresar datos del cliente");
                leerCliente(n.getDato(), true);
                l.adicionarFinal(n);
            }
        }
    }

    //Buscar dato en la Lista
    public static void buscarClienteLista(ListaEnlazadaCliente l) {
        int Id;
        NodoCliente nc;
        //Buscar un dato
        System.out.print("Digite el Id del cliente: ");
        Id = entrada.nextInt();
        nc = l.buscar(Id);
        if (nc != null) {
            System.out.println("Datos del cliente encontrado");
            l.mostrarCliente(nc.getDato());
        } else {
            System.out.println("No se encontro el cliente en la lista");
        }
    }

    //Eliminar dato en la Lista
    public static void eliminarClienteLista(ListaEnlazadaCliente l) {
        int Id;
        System.out.print("Digite el Id del cliente a eliminar:");
        Id = entrada.nextInt();
        if (l.eliminar(Id)) {
            System.out.println("El Cliente fue eliminado");
        } else {
            System.out.print("No se elimino el cliente");
        }
    }

    //Modificar dato en la Lista
    public static void modificarClienteLista(ListaEnlazadaCliente l) {
        int Id;
        NodoCliente nc;
        System.out.println("Digite el Id del Cliente:");
        Id = entrada.nextInt();
        nc = l.buscar(Id);
        if (nc != null) {
            leerCliente(nc.getDato(), false);
            System.out.print("Modificacion exitosa");
        } else {
            System.out.println("Dato no encontrado, no se puede modificar");
        }
    }

    //Mostra datos de la Lista
    public static void mostrarClienteLista(ListaEnlazadaCliente l) {
        //Mostrar datos de la Lista
        System.out.println("Los datos de la Lista son:");
        l.mostrar();
    }

    //leyendo los datos del Producto
    public static void leerProducto(Producto c, boolean estado) {
        if (estado == true) {
            System.out.print("Digite Id del Producto:");
            c.setId(entrada.nextInt());
        }
        System.out.println("Digite nombre del producto:");
        c.setNombre(entrada.nextLine());
        System.out.println("Digite la marca del producto:");
        c.setMarca(entrada.nextLine());
        System.out.println("Digite el precio de compra:");
        c.setPreciodc(entrada.nextInt());

        System.out.println("Digite las existencias del producto:");
        c.setExist(entrada.nextInt());

    }

    //Adicionar datos en la Lista Producto
    public static void adicionarProductoLista(ListaEnlazadaProducto p) {
        //Enrada de datos
        while (true) {
            System.out.print("Digite un dato entero 0 en caso de querer termina: ");
            dato = entrada.nextInt();
            if (dato == 0) {
                break;
            } else {
                NodoProducto n = new NodoProducto();
                System.out.println("Ingresar datos del Producto");
                leerProducto(n.getDato(), true);
                p.adiccionarFinal(n);
            }
        }
    }

    //Buscar dato en la Lista Producto
    public static void buscarProductoLista(ListaEnlazadaProducto p) {
        int Id;
        NodoProducto nc;
        //Buscar un dato
        System.out.print("Digite el Id del Producto: ");
        Id = entrada.nextInt();
        nc = p.buscar(Id);
        if (nc != null) {
            System.out.println("Datos del Producto encontrado");
            p.mostrarProducto(nc.getDato());
        } else {
            System.out.println("No se encontro el producto en la lista");
        }
    }

    //Eliminar dato en la Lista Producto
    public static void eliminarProductoLista(ListaEnlazadaProducto p) {
        int Id;
        System.out.print("Digite el Id del Producto a eliminar:");
        Id = entrada.nextInt();
        if (p.eliminar(Id)) {
            System.out.println("El Producto fue eliminado");
        } else {
            System.out.print("No se elimino el producto");
        }
    }

    //Modificar dato en la Lista Producto
    public static void modificarProductoLista(ListaEnlazadaProducto p) {
        int Id;
        NodoProducto nc;
        System.out.println("Digite el Id del Producto:");
        Id = entrada.nextInt();
        nc = p.buscar(Id);
        if (nc != null) {
            leerProducto(nc.getDato(), false);

            System.out.print("Modificacion exitosa");
        } else {
            System.out.println("Dato no encontrado, no se puede modificar");
        }
    }

    //Mostra datos de la Lista Producto
    public static void mostrarProductoLista(ListaEnlazadaProducto p) {
        //Mostrar datos de la Lista
        System.out.println("Los datos de la Lista son:");
        p.mostrar();
    }
    //leyendo los datos de las Compras

    public static void leerCompras(Compras c, boolean estado) {
        if (estado == true) {
            System.out.print("Digite Id de la compra:");
            c.setId(entrada.nextInt());
        }
        System.out.print("Digite la fecha de la compra:");
        c.setFecha(entrada.nextInt());
        System.out.print("Digite el Id del  producto :");
        c.setIdproducto(entrada.nextInt());
        System.out.print("Digite el precio de compra:");
        c.setPrecio(entrada.nextInt());

    }
    //Adicionar datos en la Lista Compras

    public static void adicionarComprasLista(ListaEnlazadaDeCompras k) {
        //Enrada de datos
        while (true) {
            System.out.print("Digite un dato entero 0 en caso de querer termina: ");
            dato = entrada.nextInt();
            if (dato == 0) {
                break;
            } else {
                NodoCompras n = new NodoCompras();
                System.out.println("Ingresar datos dela compra");
                leerCompras(n.getDato(), true);
                k.adicionarFinal(n);
            }
        }
    }

    //Buscar dato en la Lista Compras
    public static void buscarComprasLista(ListaEnlazadaDeCompras k) {
        int Id;
        NodoCompras nc;
        //Buscar un dato
        System.out.print("Digite el Id de la compra: ");
        Id = entrada.nextInt();
        nc = k.buscar(Id);
        if (nc != null) {
            System.out.println("Datos de la compra encontrado");
            k.mostrarCompras(nc.getDato());
        } else {
            System.out.println("No se encontro la ocmpra en la lista");
        }
    }

    //Eliminar dato en la Lista Producto
    public static void eliminarComprasLista(ListaEnlazadaDeCompras k) {
        int Id;
        System.out.print("Digite el Id de la Compra a eliminar:");
        Id = entrada.nextInt();
        if (k.eliminar(Id)) {
            System.out.println("La compra fue eliminada");
        } else {
            System.out.print("No se elimino la compra");
        }
    }

    //Modificar dato en la Lista Producto
    public static void modificarComprasLista(ListaEnlazadaDeCompras k) {
        int Id;
        NodoCompras nc;
        System.out.println("Digite el Id de la Compra:");
        Id = entrada.nextInt();
        nc = k.buscar(Id);
        if (nc != null) {
            leerCompras(nc.getDato(), false);

            System.out.print("Modificacion exitosa");
        } else {
            System.out.println("Dato no encontrado, no se puede modificar");
        }
    }

    //Mostra datos de la Lista Producto
    public static void mostrarComprasLista(ListaEnlazadaDeCompras k) {
        //Mostrar datos de la Lista
        System.out.println("Los datos de la Lista son:");
        k.mostrar();
    }

    //leyendo los datos de la Venta
    public static void leerVentas(Ventas c, boolean estado) {
        if (estado == true) {
            System.out.print("Digite Id de la Venta:");
            c.setId(entrada.nextInt());
        }
        System.out.print("Digite el id  del cliente:");
        c.setIdcliente(entrada.nextInt());
        System.out.print("Digite el id  del Producto:");
        c.setIdproduct(entrada.nextInt());
        System.out.print("Digite la fecha de la venta:");
        c.setFecha(entrada.nextInt());
    }

    //Adicionar datos en la Lista Ventas
    public static void adicionarVentasLista(ListaEnlazadaVentas v) {
        //Enrada de datos
        while (true) {
            System.out.print("Digite un dato entero 0 en caso de querer termina: ");
            dato = entrada.nextInt();
            if (dato == 0) {
                break;
            } else {
                NodoVentas n = new NodoVentas();
                System.out.println("Ingresar datos de la Venta");
                leerVentas(n.getDato(), true);
                v.adicionarFinal(n);
            }
        }
    }

    //Buscar dato en la Lista Ventas
    public static void buscarVentasLista(ListaEnlazadaVentas v) {
        int Id;
        NodoVentas nc;
        //Buscar un dato en la  Lista Ventas
        System.out.print("Digite el Id de la Venta: ");
        Id = entrada.nextInt();
        nc = v.buscar(Id);
        if (nc != null) {
            System.out.println("Datos de la Venta encontrado");
            v.mostrarVentas(nc.getDato());
        } else {
            System.out.println("No se encontro la venta  en la lista");
        }
    }

    //Eliminar dato en la Lista Ventas
    public static void eliminarVentasLista(ListaEnlazadaVentas v) {
        int Id;
        System.out.print("Digite el Id de la Venta a eliminar:");
        Id = entrada.nextInt();
        if (v.eliminar(Id)) {
            System.out.println("La venta fue eliminado");
        } else {
            System.out.print("No se elimino la venta");
        }
    }

    //Modificar dato en la Lista Ventas
    public static void modificarVentasLista(ListaEnlazadaVentas v) {
        int Id;
        NodoVentas nc;
        System.out.println("Digite el Id de la Venta:");
        Id = entrada.nextInt();
        nc = v.buscar(Id);
        if (nc != null) {
            leerVentas(nc.getDato(), false);
            System.out.print("Modificacion exitosa");
        } else {
            System.out.println("Dato no encontrado, no se puede modificar");
        }
    }

    //Mostra datos de la Lista Ventas
    public static void mostrarVentasLista(ListaEnlazadaVentas v) {
        //Mostrar datos de la Lista
        System.out.println("Los datos de la Lista son:");
        v.mostrar();
    }
}
