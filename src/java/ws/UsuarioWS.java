

package ws;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.UsuarioDAO;
import modelo.pojo.Mensaje;
import modelo.pojo.Usuario;

/**
 *
 * @author lizet
 */


@Path("usuario")
public class UsuarioWS {
    
    @Context
    private UriInfo context;
    
    
    public UsuarioWS(){}
    
    
    @GET
    
    @Path("obtenerUsuarios")
    
    @Produces(MediaType.APPLICATION_JSON)
    
    @Consumes(MediaType.APPLICATION_JSON)
    
    public List<Usuario> obtenerUsuarios(){
        return UsuarioDAO.obtenerUsuarios();
        }
    
    
    
    @POST
    @Path("registrarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarUsuario(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            Usuario usuario = gson.fromJson(json, Usuario.class);
            
            if(usuario != null){
                return UsuarioDAO.registrarUsuario(usuario);
            }else{
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }
    
    @PUT
    @Path("editarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarUsuario(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            Usuario usuario = gson.fromJson(json, Usuario.class);
            
            if(usuario != null){
                return UsuarioDAO.editarUsuario(usuario);
            }else{
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }
    
    
}
