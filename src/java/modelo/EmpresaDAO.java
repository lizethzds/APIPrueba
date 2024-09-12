
package modelo;

import java.util.List;
import modelo.pojo.DatosRegistroEmpresa;
import modelo.pojo.Empresa;
import modelo.pojo.Mensaje;
import modelo.pojo.Sucursal;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author lizet
 */
public class EmpresaDAO {
    
    public static List<Sucursal> obtenerSucursalesEmpresa(Integer id){
        List<Sucursal> sucursales;
        SqlSession conexionBD = MyBatisUtil.getSession();
        sucursales = conexionBD.selectList("empresa.obtenerSucursalesEmpresa", id);
        
        return sucursales;
    
    }
    
    
   
    
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
    
    
    
    
    public static Mensaje editarEmpresa(DatosRegistroEmpresa edicionEmpresa){
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        
        if(conexionBD !=null){
            try{
                conexionBD.update("empresa.editarEmpresa", edicionEmpresa);
                conexionBD.commit();
                if(edicionEmpresa.getFilasAfectadas()> 0 && edicionEmpresa.getError().isEmpty()){
                    msj.setError(false);
                    msj.setMensaje("Actualización de empresa exitosa.");
                } else{
                    msj.setMensaje(edicionEmpresa.getError());
                }
            
            }catch(Exception e){
                msj.setMensaje("Por el momento no pudo realizarse la operación, por favor intentalo más tarde.");
                e.printStackTrace();
            }
            
            finally{
                conexionBD.close();
            }
        
        }
        else{
                    msj.setMensaje("No hubo conexión con la BD.");
                    }
        
        
         return msj;
        }
    
    
    
    /*
    public static DatosRegistroEmpresa obtenerEmpresaID (DatosRegistroEmpresa empresa){
        DatosRegistroEmpresa empresaSolicitada = new DatosRegistroEmpresa();
        
    }
    
    */
   
}
