
package modelo.pojo;

import java.util.Base64;

/**
 *
 * @author lizet
 */
public class Empresa {
    
    private Integer id;
    private String nombre;
    private String nombre_comercial;
    private String nombre_representante;
    private String email;
    private String telefono;
    private String pagina_web;
    private String rfc;
    private Integer estatus_id;
    private Integer domicilio_id;
    private byte[] logo;
    private Base64 logoBase64;

    public Empresa(Integer id, String nombre, String nombre_comercial, String nombre_representante, 
        String email, String telefono, String pagina_web, String rfc, Integer estatus_id, 
        Integer domicilio_id, byte[] logo, Base64 logoBase64) {
        this.id = id;
        this.nombre = nombre;
        this.nombre_comercial = nombre_comercial;
        this.nombre_representante = nombre_representante;
        this.email = email;
        this.telefono = telefono;
        this.pagina_web = pagina_web;
        this.rfc = rfc;
        this.estatus_id = estatus_id;
        this.domicilio_id = domicilio_id;
        this.logo = logo;
        this.logoBase64 = logoBase64;
    }

    public Empresa() {
    }

    public Integer getDomicilio_id() {
        return domicilio_id;
    }

    public void setDomicilio_id(Integer domicilio_id) {
        this.domicilio_id = domicilio_id;
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

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public String getNombre_representante() {
        return nombre_representante;
    }

    public void setNombre_representante(String nombre_representante) {
        this.nombre_representante = nombre_representante;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPagina_web() {
        return pagina_web;
    }

    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

  
    public Integer getEstatus_id() {
        return estatus_id;
    }

    public void setEstatus_id(Integer estatus_id) {
        this.estatus_id = estatus_id;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public Base64 getLogoBase64() {
        return logoBase64;
    }

    public void setLogoBase64(Base64 logoBase64) {
        this.logoBase64 = logoBase64;
    }
    
    
}
