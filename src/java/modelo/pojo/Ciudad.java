
package modelo.pojo;

/**
 *
 * @author lizet
 */
public class Ciudad {
   
    private Integer id;
    private String nombre;
    private Integer id_estado;

    public Ciudad() {
    }

    
    
    public Ciudad(Integer id, String nombre, Integer id_estado) {
        this.id = id;
        this.nombre = nombre;
        this.id_estado = id_estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_estado() {
        return id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }
    
    
    
}
