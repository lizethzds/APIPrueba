/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojo;

/**
 *
 * @author lizet
 */
public class Domicilio {
    
    private Integer id;
    private String calle;
    private Integer numero;
    private String colonia;
    private Integer codigo_postal;
    private Integer id_ciudad;

    public Domicilio() {
    }

    public Domicilio(Integer id, String calle, Integer numero, String colonia, Integer codigo_postal, Integer id_ciudad) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigo_postal = codigo_postal;
        this.id_ciudad = id_ciudad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public Integer getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(Integer codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public Integer getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(Integer id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
    

    
    
}
