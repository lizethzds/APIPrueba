
package modelo;

import java.util.List;
import modelo.pojo.DatosRegistroSucursal;
import modelo.pojo.Mensaje;
import modelo.pojo.Sucursal;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author lizet
 */
public class SucursalDAO {
    
    public static List<Sucursal> obtenerSucursales (){
        List<Sucursal> sucursales;
        
        SqlSession conexionBD = MyBatisUtil.getSession();
        sucursales = conexionBD.selectList("sucursal.obtenerSucursales", conexionBD);
        
        return sucursales;
        
    }
    
    public static List<Sucursal> obtenerSucursalesEmpresa(Integer id){
        List<Sucursal> sucursalesEmpresa;
        
        SqlSession conexionBD = MyBatisUtil.getSession();
        sucursalesEmpresa = conexionBD.selectList("sucursal.obtenerSucursalesEmpresa", id);
        
        return sucursalesEmpresa;
    }
    
    public static Mensaje registrarSucursal (DatosRegistroSucursal registroSucursal){
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        
        if (conexionBD !=null ){
            try{
                conexionBD.insert("sucursal.registrarSucursal", registroSucursal);
                conexionBD.commit();
                
                if(registroSucursal.getFilasAfectadas() >0){
                    msj.setError(false);
                    msj.setMensaje("Registro de sucursal exitoso");
                }else{
                    msj.setMensaje(registroSucursal.getError());
                }
                
            }catch(Exception e){
                msj.setMensaje("Por el momento no se puede realizar la operación");
                e.printStackTrace();
                
            }
            finally{
                conexionBD.close();
            }
        }else{
            msj.setMensaje("Por el momento no hay conexión con la base de datos.");
        }
    
    return msj;
    
    }
    
}
