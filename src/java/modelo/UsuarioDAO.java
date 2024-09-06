
package modelo;

import java.util.ArrayList;
import java.util.List;
import modelo.pojo.Mensaje;
import modelo.pojo.Usuario;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author lizet
 */
public class UsuarioDAO {
    
    public static List<Usuario> obtenerUsuarios() {

        List<Usuario> usuarios = new ArrayList<>();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                usuarios = conexionBD.selectList("usuario.obtenerUsuarios");
                for (Usuario usuario : usuarios) {
                System.out.println(usuario.getUsername());
            }
                
                
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        }
        return usuarios;
    }
    
    
    public static Mensaje registrarUsuario(Usuario usuario) {
    List<Usuario> usuariosRegistrados;
    SqlSession conexionBD = MyBatisUtil.getSession();
    Mensaje mensaje = new Mensaje();

    if (conexionBD != null) {
        try {
            // Obtener la lista de usuarios registrados
            usuariosRegistrados = obtenerUsuarios();

            // Validar si el username o el CURP ya existen
            boolean existeUsername = usuariosRegistrados.stream()
                .anyMatch(u -> u.getUsername().equals(usuario.getUsername()));

            boolean existeCurp = usuariosRegistrados.stream()
                .anyMatch(u -> u.getCurp().equals(usuario.getCurp()));

            if (existeUsername) {
                mensaje.setMensaje("El username ya existe. No se puede registrar el usuario.");
                mensaje.setError(true);
            } else if (existeCurp) {
                mensaje.setMensaje("El CURP ya existe. No se puede registrar el usuario.");
                mensaje.setError(true);
            } else {
                // Lógica para insertar el nuevo usuario
                int resultado = conexionBD.insert("usuario.registrarUsuario", usuario);
                conexionBD.commit();
                if (resultado > 0) {
                    mensaje.setMensaje("Usuario registrado exitosamente.");
                    mensaje.setError(false);
                } else {
                    mensaje.setMensaje("Error al registrar el usuario.");
                    mensaje.setError(true);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            mensaje.setMensaje("Ocurrió un error durante el registro del usuario.");
            mensaje.setError(false);
        } finally {
            conexionBD.close();
        }
    } else {
        mensaje.setMensaje("Error al conectar con la base de datos.");
        mensaje.setError(false);
    }

    return mensaje;
}

    
    
    public static Mensaje editarUsuario (Usuario usuario ){
        List<Usuario> usuariosRegistrados;
        SqlSession conexionBD = MyBatisUtil.getSession();
        Mensaje mensaje = new Mensaje();
        
        if(conexionBD != null){
            try{
                usuariosRegistrados = obtenerUsuarios();
                boolean existeUsername = usuariosRegistrados.stream()
                .anyMatch(u -> u.getUsername().equals(usuario.getUsername()));

                boolean existeCurp = usuariosRegistrados.stream()
                .anyMatch(u -> u.getCurp().equals(usuario.getCurp()));
                if (existeUsername) {
                mensaje.setMensaje("El nombre de usuario ya está asociado a otra cuenta. Intente otro.");
                mensaje.setError(true);
            } else if (existeCurp) {
                mensaje.setMensaje("El CURP ya está asociado a otra cuenta. Intente otro.");
                mensaje.setError(true);
            } else {
                // Lógica para insertar el nuevo usuario
                int resultado = conexionBD.insert("usuario.editarUsuario", usuario);
                conexionBD.commit();
                if (resultado > 0) {
                    mensaje.setMensaje("Usuario registrado exitosamente.");
                    mensaje.setError(false);
                } else {
                    mensaje.setMensaje("Error al registrar el usuario.");
                    mensaje.setError(true);
                }
            }
                
                
                
            }catch(Exception e){
                
            }finally{
                conexionBD.close();
            }
        }
        
        
        
        
        return mensaje;
    }


    
}
