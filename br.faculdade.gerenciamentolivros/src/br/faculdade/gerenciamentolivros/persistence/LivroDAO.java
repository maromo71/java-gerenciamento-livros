package br.faculdade.gerenciamentolivros.persistence;

import br.faculdade.gerenciamentolivros.entities.Livro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO implements IDao<Livro> {

    private final Connection con;

    public LivroDAO() throws ClassNotFoundException {
        this.con = new MySqlConexao().getConnection();
    }

    @Override
    public void inserir(Livro obj) {
        try {

            String sql = "insert into Livros"
                    + " (idLivro,tituloLivro,idEditora_Livro, dataPublicacao, autor, observacoes) "
                    + " values (?,?,?,?,?,?)";

            PreparedStatement stmt = this.con.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, obj.idLivro);
            stmt.setString(2, obj.tituloLivro);
            stmt.setInt(3, obj.editora.idEditora);
            stmt.setDate(4, Date.valueOf(obj.dataPublicacao));
            stmt.setString(5, obj.autor);
            stmt.setString(6, obj.observacoes);
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alterar(Livro obj) {
         try {

            String sql = "update Livros "
                    + " set tituloLivro=?,idEditora_Livro=?, dataPublicacao=?, autor=?, observacoes=? "
                    + " where idLivro=?";

            PreparedStatement stmt = this.con.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, obj.tituloLivro);
            stmt.setInt(2, obj.editora.idEditora);
            stmt.setDate(3, Date.valueOf(obj.dataPublicacao));
            stmt.setString(4, obj.autor);
            stmt.setString(5, obj.observacoes);
            stmt.setInt(6, obj.idLivro);
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Livro buscar(int id) {
        Livro livro = new Livro();
        String sql = "Select * from livros where idLivro = ?; ";
        PreparedStatement stmt = null;
        try {
            stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                livro.idLivro = rs.getInt("idLivro");
                livro.tituloLivro = rs.getString("tituloLivro");
                livro.editora.idEditora = rs.getInt("idEditora_Livro");
                livro.dataPublicacao = rs.getDate("dataPublicacao").toLocalDate();
                livro.autor = rs.getString("autor");
                livro.observacoes = rs.getString("observacoes");
            }
            rs.close();
            this.con.close();
            return livro;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Livro buscar(String chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Livro obj) {
        try {

            String sql = "delete * from Livros "
                    + " where idLivro=?";
            PreparedStatement stmt = this.con.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, obj.idLivro);
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Livro> listar() {
        List<Livro> lista = new ArrayList<>();
        ResultSet rs;
        String sql = "Select * from livros ";
        PreparedStatement stmt;
        try {
            stmt = this.con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Livro livro = new Livro();
                livro.idLivro = rs.getInt("idLivro");
                livro.tituloLivro = rs.getString("tituloLivro");
                livro.editora.idEditora = rs.getInt("idEditora_Livro");
                livro.dataPublicacao = rs.getDate("dataPublicacao").toLocalDate();
                livro.autor = rs.getString("autor");
                livro.observacoes = rs.getString("observacoes");
                lista.add(livro);
            }
            rs.close();
            this.con.close();
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
