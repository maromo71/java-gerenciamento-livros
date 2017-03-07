package br.faculdade.gerenciamentolivros.persistence;

import br.faculdade.gerenciamentolivros.entities.Editora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditoraDAO implements IDao<Editora> {

    private final Connection con;

    public EditoraDAO() throws ClassNotFoundException {
        this.con = new MySqlConexao().getConnection();
    }

    @Override
    public void inserir(Editora obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Editora obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Editora buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Editora buscar(String chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Editora obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Editora> listar() {
        List<Editora> lista = new ArrayList<>();
        ResultSet rs;
        String sql = "Select * from editoras ";
        PreparedStatement stmt;
        try {
            stmt = this.con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Editora editora = new Editora();
                editora.idEditora = rs.getInt("idEditora");
                editora.nomeEditora = rs.getString("nomeEditora");
                editora.email = rs.getString("email");
                editora.foneContato = rs.getString("foneContato");
                lista.add(editora);
            }
            rs.close();
            this.con.close();
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
