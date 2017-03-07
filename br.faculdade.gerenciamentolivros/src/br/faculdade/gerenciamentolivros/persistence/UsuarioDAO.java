package br.faculdade.gerenciamentolivros.persistence;
import br.faculdade.gerenciamentolivros.entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private boolean acesso;
    private final Connection con;

    public UsuarioDAO() throws ClassNotFoundException {
        this.acesso = false;
        this.con = new MySqlConexao().getConnection();
    }

    public boolean checarPermissao(Usuario obj) throws SQLException {
        ResultSet rs = null;
        String sql = "Select * from usuarios where login=? and senha=?;";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        stmt.setString(1, obj.login);
        stmt.setString(2, obj.senha);
        try {
            rs = stmt.executeQuery();
            if (rs.next()) {
                this.acesso = true;
            }
        }catch(SQLException e){
            throw e;
        }catch(Exception e){
            throw e;
        }finally{
            rs.close();
            this.con.close();
            return acesso;
        }
    }
}
