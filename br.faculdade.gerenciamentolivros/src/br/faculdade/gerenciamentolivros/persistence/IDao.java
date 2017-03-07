package br.faculdade.gerenciamentolivros.persistence;

import java.util.List;

public interface IDao<T> {
    void inserir(T obj);
    
    void alterar(T obj);
    
    T buscar(int id);
    
    T buscar(String chave);
    
    void excluir(T obj);
    
    List<T> listar();
}
