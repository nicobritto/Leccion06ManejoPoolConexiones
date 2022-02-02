package datos;

import domain.UsuarioDTO;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDao {

    List<UsuarioDTO>listar()throws SQLException;

    public int insertando(UsuarioDTO usuario)throws SQLException;

    public int eliminar(UsuarioDTO usuario)throws SQLException;

    public int actualizar(UsuarioDTO usuario)throws SQLException;
}
