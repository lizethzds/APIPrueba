
package modelo.pojo;

/**
 *
 * @author lizet
 */
public class Mensaje {
    
    private boolean error;
    private String mensaje;

    public Mensaje() {
    }

    public Mensaje(boolean error, String mensaje) {
        this.error = error;
        this.mensaje = mensaje;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String isMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
    
    
    
}
