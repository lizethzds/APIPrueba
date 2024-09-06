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
public class Estatus {
    
    
    private Integer id;
    private String estado_estatus;

    public Estatus() {
    }

    public Estatus(Integer id, String estado_estatus) {
        this.id = id;
        this.estado_estatus = estado_estatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado_estatus() {
        return estado_estatus;
    }

    public void setEstado_estatus(String estado_estatus) {
        this.estado_estatus = estado_estatus;
    }
    
    
    
}
