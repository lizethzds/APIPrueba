
package modelo.pojo;

/**
 *
 * @author lizet
 */
public class DatosRegistroSucursal {
    
    
    private Sucursal sucursal;
    private Domicilio domicilio;
    
    private Integer filasAfectadas;
    private String error;

    public DatosRegistroSucursal() {
    }

    public DatosRegistroSucursal(Sucursal sucursal, Domicilio domicilio, Integer filasAfectadas, String error) {
        this.sucursal = sucursal;
        this.domicilio = domicilio;
        this.filasAfectadas = filasAfectadas;
        this.error = error;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
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
