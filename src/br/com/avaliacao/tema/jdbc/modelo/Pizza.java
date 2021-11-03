package br.com.avaliacao.tema.jdbc.modelo;

public class Pizza {
  private int id;
  private String nomeCliente;
  private Double valorPedido;
  private String sabor;

  public Pizza() {

  }

  public Pizza(int id, String nomeCliente, Double valorPedido, String sabor) {
    this.id = id;
    this.nomeCliente = nomeCliente;
    this.valorPedido = valorPedido;
    this.sabor = sabor;
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

  public String getSabor() {
    return sabor;
  }

  public void setSabor(String sabor) {
    this.sabor = sabor;
  }
}
