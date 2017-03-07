package br.faculdade.gerenciamentolivros.entities;

import java.time.LocalDate;

public class Livro {
    public int idLivro;
    public String tituloLivro;
    public Editora editora;
    public LocalDate dataPublicacao;
    public String autor;
    public String observacoes;
    
    public Livro(){
        this.editora = new Editora();
    }
}
