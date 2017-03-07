package br.faculdade.gerenciamentolivros.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConexao {

    public Connection getConnection() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/livraria", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
