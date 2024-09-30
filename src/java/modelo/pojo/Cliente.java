
package modelo.pojo;

/**
 *
 * @author lizet
 */
public class Cliente {
    private Integer id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String correo_electronico;
    private String contrasena;
    private String fecha_nacimiento;
    private String telefono;
    private Integer direccion_id;

    public Cliente() {
    }

    public Cliente(Integer id, String nombre, String apellido_paterno, String apellido_materno, String correo_electronico, String contrasena, String fecha_nacimiento, String telefono, Integer direccion_id) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.correo_electronico = correo_electronico;
        this.contrasena = contrasena;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.direccion_id = direccion_id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getDireccion_id() {
        return direccion_id;
    }

    public void setDireccion_id(Integer direccion_id) {
        this.direccion_id = direccion_id;
    }
    
    
    
    
    
}
