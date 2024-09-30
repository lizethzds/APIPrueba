
package modelo;

import java.util.List;
import modelo.pojo.Cliente;
import modelo.pojo.DatosRegistroCliente;
import modelo.pojo.Mensaje;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author lizet
 */
public class ClienteDAO {
    
    
    
    public static List<Cliente> obtenerClientes(){
        List<Cliente> clientes;
        SqlSession conexionBD = MyBatisUtil.getSession();
        clientes = conexionBD.selectList("cliente.obtenerClientes");
        
        return clientes;
    }
    
    
    public static DatosRegistroCliente obtenerClientePorId(Integer id)
    {
        DatosRegistroCliente clienteSolicitado;
        SqlSession conexionBD = MyBatisUtil.getSession();
        clienteSolicitado = conexionBD.selectOne("cliente.obtenerClientePorId",  id);
     
        return clienteSolicitado;
        
    }
    
    
   public static Mensaje registrarCliente(DatosRegistroCliente registroCliente){
       Mensaje msj = new Mensaje();
       msj.setError(true);
       SqlSession conexionBD = MyBatisUtil.getSession();
       
       if(conexionBD !=null){
           try{
               conexionBD.insert("cliente.registrarCliente", registroCliente);
               conexionBD.commit();
               
               if(registroCliente.getFilasAfectadas()>0 && registroCliente.getError().isEmpty()){
                   msj.setError(false);
                   msj.setMensaje("Registro exitoso!");
               }else{
                   msj.setMensaje(registroCliente.getError());
                   
               }
           }catch(Exception e){
               msj.setMensaje("Por el momento no se pudo realizar el registro, intente después.");
               e.printStackTrace();
           
           }finally{
               conexionBD.close();
           }
       }else{
           msj.setMensaje("Por el momento no hay conexión con la base de datos.");
       }
       
       return msj;
       
   }
    
}
