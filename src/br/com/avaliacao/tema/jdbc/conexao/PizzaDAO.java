package br.com.avaliacao.tema.jdbc.conexao;

import br.com.avaliacao.tema.jdbc.modelo.Pizza;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAO {
  private final Conexao connection;
  private PreparedStatement preparedStatement;

  public PizzaDAO() {
    connection = new Conexao();
  }

  public void inserePizza(Pizza pizza) {
    try {
      String query = "INSERT INTO pizzas (nomeCliente, valorPedido) VALUES (?, ?)";
      preparedStatement = connection.getConnection().prepareStatement(query);

      preparedStatement.setString(1, pizza.getNomeCliente());
      preparedStatement.setDouble(2, pizza.getValorPedido());

      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<Pizza> listarPizza() {
    ArrayList<Pizza> pizzas = new ArrayList<>();

    try {
      String query = "SELECT * FROM pizzas";
      preparedStatement = connection.getConnection().prepareStatement(query);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        pizzas.add(new Pizza(
                resultSet.getInt("id"),
                resultSet.getString("nomeCliente"),
                resultSet.getDouble("valorPedido")));
      }

      return pizzas;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return new ArrayList<>();
  }
}
