package br.faculdade.gerenciamentolivros.business;

import java.util.List;

public interface IBus<T> {

    void inserir(T obj);

    void alterar(T obj);

    T buscar(int id);

    T buscar(String chave);

    void excluir(T obj);

    List<T> listar();
}

