/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.ClienteDAO;
import modelo.UsuarioDAO;
import modelo.pojo.Cliente;
import modelo.pojo.DatosRegistroCliente;
import modelo.pojo.Domicilio;
import modelo.pojo.Mensaje;
import modelo.pojo.Usuario;

/**
 *
 * @author lizet
 */


@Path("cliente")
public class ClienteWS {
    
    
    @GET
    @Path("obtenerClientePorId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    
   public DatosRegistroCliente obtenerClienteId(@PathParam("id") Integer id){
       if(id<=0){
           throw new WebApplicationException(Response.Status.BAD_REQUEST);
       
       }
       else{
           return ClienteDAO.obtenerClientePorId(id);
       }
   }
   
   
   
   @POST
   @Path("registrarCliente")
   @Consumes(MediaType.APPLICATION_JSON)
   
   public Mensaje registrarCliente(String json){
       Mensaje mensaje = new Mensaje();
       
       if(json.isEmpty()){
           throw new WebApplicationException(Response.Status.BAD_REQUEST);
       }else{
           Gson gson = new Gson();
           DatosRegistroCliente datosCliente = gson.fromJson(json, DatosRegistroCliente.class);
           
           Cliente cliente = datosCliente.getCliente();
           Domicilio domicilio = datosCliente.getDomicilio();
           
           if(cliente != null && domicilio != null){
               return ClienteDAO.registrarCliente(datosCliente);
               
           }
       }
       
       return mensaje;
       
   }
   
   
  
    
}
