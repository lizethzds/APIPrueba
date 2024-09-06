
package modelo.pojo;

/**
 *
 * @author lizet
 */
public class DatosRegistroEmpresa {
    
    private Empresa empresa;
    private Domicilio domicilio;
    private Integer filasAfectadas;
    private String error;

    public DatosRegistroEmpresa() {
    }
    
    
    

    public DatosRegistroEmpresa(Empresa empresa, Domicilio domicilio, Integer filasAfectadas, String error) {
        this.empresa = empresa;
        this.domicilio = domicilio;
        this.filasAfectadas = filasAfectadas;
        this.error = error;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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

