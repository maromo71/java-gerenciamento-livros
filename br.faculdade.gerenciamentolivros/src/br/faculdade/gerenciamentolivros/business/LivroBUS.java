package br.faculdade.gerenciamentolivros.business;

import br.faculdade.gerenciamentolivros.entities.Livro;
import br.faculdade.gerenciamentolivros.persistence.LivroDAO;
import java.util.List;

public class LivroBUS implements IBus<Livro> {

    
    @Override
    public void inserir(Livro obj) {
        try {
            LivroDAO dao = new LivroDAO();
            dao.inserir(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alterar(Livro obj) {
        try {
            LivroDAO dao = new LivroDAO();
            dao.alterar(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Livro buscar(int id) {
        try {
            if (id <= 0) {
                throw new IllegalArgumentException("Código deve ser maior que ZERO");
            }
            LivroDAO dao = new LivroDAO();
            Livro livro = dao.buscar(id);
            return livro;
        } catch (IllegalArgumentException e) {
            throw e;
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
            LivroDAO dao = new LivroDAO();
            dao.excluir(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Livro> listar() {
        try {
            LivroDAO dao = new LivroDAO();
            return dao.listar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
