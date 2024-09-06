
package modelo;

import com.google.gson.Gson;
import modelo.pojo.RespuestaLoginUsuario;
import modelo.pojo.Usuario;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author lizet
 */
public class AutenticacionDAO {
    
    
    
    public static RespuestaLoginUsuario verificarSesionUsuario(Usuario usuario){
        RespuestaLoginUsuario respuesta = new RespuestaLoginUsuario();
        respuesta.setError(true);
        
        SqlSession conexionBD = MyBatisUtil.getSession();
        
        if(conexionBD != null){
            try{
                Gson gson = new Gson();
                usuario = conexionBD.selectOne("autenticacion.verificarCredencialesUsuario", usuario);
                
                if(usuario !=null){
                    respuesta.setError(false);
                    respuesta.setContenido("Bienvenid@,  " + usuario.getNombre() + " al sistema");
                    respuesta.setUsuario(usuario);
                }else{
                    respuesta.setContenido("Usuario y/o contraseña incorrectos, verificar de nuevo.");
                }
            }
            catch(Exception e){
                respuesta.setContenido("Error" + e.getMessage());
            
            }    
            finally{
                conexionBD.close();
                }
        }
        else{
            respuesta.setContenido("Por el momento no hubo conexión con la BD");
        }
        
        
        
        
        return respuesta;
        
    }
    
}
