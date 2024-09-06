
package modelo;

import modelo.pojo.DatosRegistroEmpresa;
import modelo.pojo.Empresa;
import modelo.pojo.Mensaje;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author lizet
 */
public class EmpresaDAO {
    
    
    
    
    /*
    public static Mensaje registrarEmpresa(DatosRegistroEmpresa datosEmpresa){
       Mensaje msj = new Mensaje();
       msj.setError(true);
       SqlSession conexionBD = MyBatisUtil.getSession();
       
       if(conexionBD != null){
           try{
               int filasAfectadas = conexionBD.insert("empresa.agregarEmpresa", datosEmpresa);
               conexionBD.commit();
               if (filasAfectadas > 0 ){
                msj.setError(false);
                msj.setMensaje("Se agregó la empresa con éxito.");
               }
               else{
                   msj.setMensaje(datosEmpresa.getError());
                 
               }
               
           }catch(Exception e){
               msj.setMensaje("Error" + e.getMessage());
           }
           finally{
           }
           conexionBD.close();
           
            }
       
        return msj;
    }

*/
    
    public static Mensaje registrarEmpresa(DatosRegistroEmpresa registroEmpresa) {
        Mensaje mensaje = new Mensaje();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {

                conexionBD.insert("empresa.agregarEmpresa", registroEmpresa);
                conexionBD.commit();

                if (registroEmpresa.getFilasAfectadas() > 0 && registroEmpresa.getError().isEmpty()) {
                    mensaje.setError(false);
                    mensaje.setMensaje("Registro de empresa éxitoso");
                } else {
                    mensaje.setMensaje(registroEmpresa.getError());
                }

            } catch (Exception e) {
                mensaje.setMensaje("Por el momento no puede realizarse la operación, favor de intentarlo mas tarde.");
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        } else {
            mensaje.setMensaje("Por el momento no hay conexión con la base de datos.");
        }

        return mensaje;
    }
    
    
    
    
    public static Mensaje editarEmpresa(Empresa empresa){
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        
        if(conexionBD !=null){
            try{
            
            }catch(Exception e){
            }
            
            finally{
            }
        
        }
        
        
         return msj;
        }
    
    
   
}
