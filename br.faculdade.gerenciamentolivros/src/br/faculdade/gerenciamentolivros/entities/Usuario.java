package br.faculdade.gerenciamentolivros.entities;

import br.faculdade.gerenciamentolivros.persistence.UsuarioDAO;
import java.sql.SQLException;

public class Usuario {
    public String login;
    public String senha;
    
    public Usuario(String login, String senha) throws Exception{
        this.login = login;
        this.senha = senha;
        try {
            //Única classe que fará acesso direto a camada de persistência para
            //poder registrar as credenciais
            if(!EPermitidoAcesso()){
                throw new IllegalArgumentException("Acesso não permitido, "
                        + "verifique as credenciais.");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    private boolean EPermitidoAcesso() throws ClassNotFoundException, SQLException{
        boolean acesso;
        UsuarioDAO usu = new UsuarioDAO();
        try {
            acesso = usu.checarPermissao(this);
            return acesso;
        } catch (SQLException e) {
            throw e;
        }
    }
}
