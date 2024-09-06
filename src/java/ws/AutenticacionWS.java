
package ws;

import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.AutenticacionDAO;
import modelo.pojo.RespuestaLoginUsuario;
import modelo.pojo.Usuario;

/**
 *
 * @author lizet
 */

 @Path("login")
public class AutenticacionWS {
     
     
     @POST
     @Path("loginUsuario")
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
     
     public RespuestaLoginUsuario verificarUsuario(String json){
         Gson gson = new Gson();
         Usuario usuario = gson.fromJson(json, Usuario.class);
         if(usuario != null){
             return AutenticacionDAO.verificarSesionUsuario(usuario);
                     
         }
         throw new WebApplicationException(Response.Status.BAD_REQUEST);
         
     }
    
  
   
   
    
}
