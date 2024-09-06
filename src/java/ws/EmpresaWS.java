
package ws;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
    
    //Obtener empresas
    /*
    @GET
    
    @Path("obtenerEmpresas")
    
    @Produces(MediaType.APPLICATION_JSON)
    
    public List<DatosRegistroEmpresa> obtenerEmpresas(String json){
        
        
    }
    */
    
    
    
    //Obtener Empresas por Id junto a su dirección.
    
    
    @POST
    
    @Path("registrarEmpresa")
    
    @Produces(MediaType.APPLICATION_JSON)
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
    
    
    //Eliminar empresas con restricción.
    
    
}

