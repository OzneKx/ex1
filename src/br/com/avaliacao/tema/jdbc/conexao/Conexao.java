package br.com.avaliacao.tema.jdbc.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
  private Connection connection;

  public Conexao() {
    String user = "root";
    String password = "batata123";
    String conn = "jdbc:mysql://127.0.0.1:3306/db_pizza?useSSL=false";

    try {
      connection = DriverManager.getConnection(conn, user, password);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public Connection getConnection() {
    return this.connection;
  }
}
