package test;

import datos.Conexion;
import datos.UsuarioDao;
import datos.UsuarioDaoJDBC;
import domain.PersonaDTO;
import domain.UsuarioDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestManejoUsuarios {

    public static void main(String[] args) {
        //la variable conexion debe estar declarada fuera del try para que podamos utilizarla al final(catch)
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            UsuarioDao usuarioDao = new UsuarioDaoJDBC(conexion);

            List<UsuarioDTO>usuarios=usuarioDao.listar();
            
            for (UsuarioDTO usuario : usuarios) {
                System.out.println("Usuarios DTO Son: " +usuario);
            }
//            //ELIMINANDO UN USUARIO
//            usuarioDao.eliminar(new UsuarioDTO(7));
//            
//            List<UsuarioDTO> usuarios = usuarioDao.listar();
//            usuarios.forEach((usuario) -> {
//                System.out.println("Usuario =" +usuario);
//            });

//            UsuarioDTO nuevoUsuario = new UsuarioDTO();
//            nuevoUsuario.setUsuario("mibuhito");
//            nuevoUsuario.setPassword("0303456");
//            usuarioDao.insertando(nuevoUsuario);
            
            
          

            //llamamos nuestro objeto conexxion y al metodo commit para que se realisen todos los cambios
            //por eso antes pusimos   conexion.setAutoCommit(false) para que no se haaga de forma automatica
            conexion.commit();
            System.out.println("se echo commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollBack");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }
}
