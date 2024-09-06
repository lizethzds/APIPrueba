
package modelo.pojo;

/**
 *
 * @author lizet
 */
public class Usuario {
    
    private Integer id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String curp;
    private String correo_electronico;
    private String username;
    private String contrasena;
    private Integer rol_id;
    private Integer empresa_id;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String apellido_paterno, String apellido_materno, String curp, String correo_electronico, String username, String contrasena, Integer rol_id, Integer empresa_id) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.curp = curp;
        this.correo_electronico = correo_electronico;
        this.username = username;
        this.contrasena = contrasena;
        this.rol_id = rol_id;
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

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getRol_id() {
        return rol_id;
    }

    public void setRol_id(Integer rol_id) {
        this.rol_id = rol_id;
    }

    public Integer getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(Integer empresa_id) {
        this.empresa_id = empresa_id;
    }
    
    
    
}
