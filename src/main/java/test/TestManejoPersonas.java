package test;

import datos.Conexion;
import datos.PersonaDao;
import datos.PersonaDaoJDBC;
import domain.PersonaDTO;
import java.sql.Connection;
import java.sql.*;
import java.util.List;

public class TestManejoPersonas {

    public static void main(String[] args) {

        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            
            PersonaDao personaDao= new PersonaDaoJDBC(conexion);
            
            List<PersonaDTO>personas =personaDao.seleccionar();
            
            for (PersonaDTO persona : personas) {
                System.out.println(" persona DTO "+persona);
            }
         
            
            conexion.commit();
            System.out.println("se ha echo commit de la transaccion");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            //al hacer rollback significa que si hay un error al pasarle los datos no se van a guardar en la bdd
            System.out.println("Entramos al rollBack");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }

        }

    }
}
