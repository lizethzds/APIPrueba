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
public class DatosRegistroCliente {
    
    private Cliente cliente;
    private Domicilio domicilio;
    private Integer filasAfectadas;
    private String error;

    public DatosRegistroCliente() {
    }
    
    

    public DatosRegistroCliente(Cliente cliente, Domicilio domicilio, Integer filasAfectadas, String error) {
        this.cliente = cliente;
        this.domicilio = domicilio;
        this.filasAfectadas = filasAfectadas;
        this.error = error;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Integer getFilasAfectadas() {
        return filasAfectadas;
    }

    public void setFilasAfectadas(Integer filasAfectadas) {
        this.filasAfectadas = filasAfectadas;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    
    
}
