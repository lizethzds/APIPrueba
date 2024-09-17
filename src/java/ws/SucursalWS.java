
package ws;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import modelo.SucursalDAO;
import modelo.pojo.DatosRegistroSucursal;
import modelo.pojo.Domicilio;
import modelo.pojo.Mensaje;
import modelo.pojo.Sucursal;

/**
 *
 * @author lizet
 */

@Path("sucursal")
public class SucursalWS {
    
    @Context 
    
    private UriInfo context;
    
    public SucursalWS(){
    
    }
    
    
    @GET
    @Path("obtenerSucursales")
    @Produces(MediaType.APPLICATION_JSON)
    
    public List<Sucursal> obtenerSucursales (String json){
    
        return SucursalDAO.obtenerSucursales();
    }
    
     @GET
    @Path("obtenerSucursalesEmpresa/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public List<Sucursal> obtenerSucursalesEmpresa (@PathParam("id") Integer id){
    
        return SucursalDAO.obtenerSucursalesEmpresa(id);
    }
    
    
    @POST
    @Path("registrarSucursal")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    
    public Mensaje registrarSucursal(String json){
        Mensaje msj = new Mensaje();
        
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
            
        }else{
            Gson gson = new Gson();
            DatosRegistroSucursal datosSucursal = gson.fromJson(json, DatosRegistroSucursal.class);
            
            Sucursal sucursal = datosSucursal.getSucursal();
            Domicilio domicilio = datosSucursal.getDomicilio();
            
            if(sucursal !=null && domicilio !=null){
                return SucursalDAO.registrarSucursal(datosSucursal);
            }
        }
        return msj;
    }
}
