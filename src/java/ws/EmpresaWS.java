
package ws;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import modelo.EmpresaDAO;
import modelo.pojo.DatosRegistroEmpresa;
import modelo.pojo.Domicilio;
import modelo.pojo.Empresa;
import modelo.pojo.Mensaje;

/**
 *
 * @author lizet
 */

@Path("empresa")
public class EmpresaWS {
    
    @Context
    private UriInfo context;
    
    
    public EmpresaWS(){
    }
    
    //Obtener empresas en general
    
    @GET
    
    @Path("obtenerEmpresas")
    
    @Produces(MediaType.APPLICATION_JSON)
    
    public List<Empresa> obtenerEmpresas(String json){
    
        return EmpresaDAO.obtenerEmpresas();
        
    }
   
    

    //Obtener Empresas por Id junto a su dirección.
    
    @GET
    @Path("obtenerEmpresaPorId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DatosRegistroEmpresa obtenerEmpresaPorId(@PathParam("id")Integer id){
        if(id<=0){
        throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            return EmpresaDAO.obtenerEmpresaId(id);
        }
    }
    
    
    @POST
    
    @Path("registrarEmpresa")
    
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarEmpresa(String json){
        Mensaje msj = new Mensaje();
        
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            DatosRegistroEmpresa datosEmpresa = gson.fromJson(json,DatosRegistroEmpresa.class);
            
            Empresa empresa = datosEmpresa.getEmpresa();
            Domicilio domicilio = datosEmpresa.getDomicilio();
            
            if(empresa !=null && domicilio !=null){
                return EmpresaDAO.registrarEmpresa(datosEmpresa);
               }
            
        }
        
        return msj;
        
    }
    
    //Editar Empresas
    
    @PUT
    @Path("editarEmpresa")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    
    public Mensaje editarEmpresa(String json){
        Mensaje msj = new Mensaje();
        
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            DatosRegistroEmpresa datosEmpresa = gson.fromJson(json,DatosRegistroEmpresa.class);
            
            Empresa empresa = datosEmpresa.getEmpresa();
            Domicilio domicilio = datosEmpresa.getDomicilio();
            
            if(empresa !=null && domicilio !=null){
                return EmpresaDAO.editarEmpresa(datosEmpresa);
               }
            
        }
        
        return msj;
        
    }
    
    
    
    //Eliminar empresas con restricción de sesion y sucursales
    
    @DELETE
    @Path("eliminarEmpresa/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarEmpleado(@PathParam("id")Integer id){
        
        if(id<=0){
        throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            return EmpresaDAO.eliminarEmpresa(id);
        }
        
    
    }
    
}

