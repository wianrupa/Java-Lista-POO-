
package BaseDatos;
import BaseDatos.Producto;


public class Compras {
    //Declaración de los atributos
    int id,fecha,existencia, idproducto, precio;
    Producto c;
    //Método contructor
    public Compras (){
    id = fecha = existencia ;
    c=null;
    idproducto= c.getId();
    }
    //Método Get

    public int getPrecio() {
        return precio;
    }
    

    public int getId() {
        return id;
    }

    public int getFecha() {
        return fecha;
    }

    public int getExistencia() {
        return existencia;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public Producto getC() {
        return c;
    }
    //Método Set

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public void setC(Producto c) {
        this.c = c;
    }
    //Acciones de método
    
    
}
