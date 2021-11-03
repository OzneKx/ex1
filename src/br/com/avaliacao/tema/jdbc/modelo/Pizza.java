package br.com.avaliacao.tema.jdbc.modelo;

public class Pizza {
  private int id;
  private String nomeCliente;
  private Double valorPedido;

  public Pizza() {

  }

  public Pizza(int id, String nomeCliente, Double valorPedido) {
    this.id = id;
    this.nomeCliente = nomeCliente;
    this.valorPedido = valorPedido;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNomeCliente() {
    return nomeCliente;
  }

  public void setNomeCliente(String nomeCliente) {
    this.nomeCliente = nomeCliente;
  }

  public Double getValorPedido() {
    return valorPedido;
  }

  public void setValorPedido(Double valorPedido) {
    this.valorPedido = valorPedido;
  }
}
