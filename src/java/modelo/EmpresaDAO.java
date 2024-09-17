
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
    
  
    
    public static List <Empresa> obtenerEmpresas (){
    List<Empresa> empresas;
    SqlSession conexionBD = MyBatisUtil.getSession();
    empresas = conexionBD.selectList("empresa.obtenerEmpresas");
    
    return empresas;
    
    }
    
    public static DatosRegistroEmpresa obtenerEmpresaId(Integer id){
        
        DatosRegistroEmpresa empresaSolicitada = new DatosRegistroEmpresa();
        SqlSession conexionBD = MyBatisUtil.getSession();
        empresaSolicitada = conexionBD.selectOne("empresa.obtenerEmpresaPorId", id);
        
        return empresaSolicitada;
    
    }
    
    
    public static Mensaje eliminarEmpresa (Integer id){
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        
        if (conexionBD != null){
        
            
            try{
                    int filasAfectadas = conexionBD.delete("empresa.eliminarEmpresa", id);
                    conexionBD.commit();
                    
                    if(filasAfectadas>0){
                        msj.setError(false);
                        msj.setMensaje("Eliminacióin exitosa!!");
                        
                    }else{
                        msj.setMensaje("La eliminación ha fallado debido a que existen sucursales asociadas a la empresa.");
                        System.out.println("Filas afectadas " + filasAfectadas );
                    }
                
            }catch(Exception e){
                e.printStackTrace();
                
            }finally{
                conexionBD.close();
            }
        }else{
            msj.setMensaje("Por el momento no hay conexión con la BD.");
        
        }
        
        return msj;
        
        
        
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
