

package ws;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
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
    
    
    //Este servicio puede ser redundante ya que existe un servicio que devuelve el usuario por username y contrasena AuteticacionWS. El otro servicio se puede reciclar.
    @GET
    @Path("obtenerUsuarioPorId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    
   public Usuario obtenerUsuarioPorId(@PathParam("id") Integer id){
       return UsuarioDAO.obtenerUsuarioPorId(id);
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
    
    @Path("eliminarUsuario/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarUsuario(@PathParam("id") Integer id) {
        if (id <= 0) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return UsuarioDAO.eliminarUsuario(id);
    }
    
}
