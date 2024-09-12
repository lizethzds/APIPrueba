
package modelo.pojo;

/**
 *
 * @author lizet
 */
public class Sucursal {
    
    private Integer id;
    private String nombre;
    private String nombre_encargado;
    private String telefono;
    private String latitud;
    private String longitud;
    private Integer direccion_id;
    private Integer empresa_id;

    public Sucursal() {
    }

    public Sucursal(Integer id, String nombre, String nombre_encargado, String telefono, String latitud, String longitud, Integer direccion_id, Integer empresa_id) {
        this.id = id;
        this.nombre = nombre;
        this.nombre_encargado = nombre_encargado;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccion_id = direccion_id;
        this.empresa_id = empresa_id;
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

    public String getNombre_encargado() {
        return nombre_encargado;
    }

    public void setNombre_encargado(String nombre_encargado) {
        this.nombre_encargado = nombre_encargado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public Integer getDireccion_id() {
        return direccion_id;
    }

    public void setDireccion_id(Integer direccion_id) {
        this.direccion_id = direccion_id;
    }

    public Integer getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(Integer empresa_id) {
        this.empresa_id = empresa_id;
    }
    
    
    
    
}
