package br.com.avaliacao.tema.jdbc.teste;

import br.com.avaliacao.tema.jdbc.conexao.PizzaDAO;
import br.com.avaliacao.tema.jdbc.modelo.Pizza;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
  private Menu() {

  }

  public static void telaDeMenu(){
    Scanner scanner = new Scanner(System.in);
    int breakpoint;
    int start = 0;
    int escolha;

    System.out.println("Informe quantas operações gostaria de fazer: ");
    breakpoint = scanner.nextInt();

    if (breakpoint == 0) {
      return;
    }

    do {
      System.out.println("\n\n[1] Cadastrar um novo pedido");
      System.out.println("[2] Calcular valor total do pedido");
      System.out.println("[3] Mostrar todos os pedidos");
      System.out.println("[0] Sair\n");
      System.out.print("Informe o que deseja: ");

      escolha = scanner.nextInt();

      if (escolha == 1) {
        cadastrarPedido();
      }

      if (escolha == 2) {
        calcularValorPedido();
      }

      if (escolha == 3) {
        mostrarPedidos();
      }

      if (escolha == 0) {
        break;
      }

      start++;
    } while (start < breakpoint);
  }

  public static void cadastrarPedido(){
    Scanner scanner = new Scanner(System.in);
    Pizza pizza = new Pizza();

    System.out.println("\nCADASTRAR PEDIDO");
    System.out.print("NOME CLIENTE: ");
    pizza.setNomeCliente(scanner.next());
    System.out.print("VALOR PEDIDO: ");
    pizza.setValorPedido(scanner.nextDouble());
    System.out.print("SABOR DA PIZZA: ");
    pizza.setSabor(scanner.next());

    PizzaDAO pizzaDAO = new PizzaDAO();
    pizzaDAO.inserePizza(pizza);
  }

  public static void calcularValorPedido(){
    PizzaDAO pizzaDAO = new PizzaDAO();
    System.out.println("\nCALCULAR VALOR DO PEDIDO");

    ArrayList<Pizza> pizzas = (ArrayList<Pizza>) pizzaDAO.listarPizza();
    pizzas.forEach(item -> System.out.println("N° de pedidos: " + item.getId()));
    System.out.println("Valor total do pedido é de R$" + pizzas.size() * 50);
  }

  public static void mostrarPedidos(){
    System.out.println("\nMOSTRAR TODOS OS PEDIDOS");
    PizzaDAO pizzaDAO = new PizzaDAO();

    ArrayList<Pizza> pizzas = (ArrayList<Pizza>) pizzaDAO.listarPizza();
    pizzas.forEach(item -> System.out.println("\nN° pedido: " + item.getId() +
                                              "\nNome do cliente: " + item.getNomeCliente() +
                                              "\nValor do Pedido: " + item.getValorPedido() +
                                              "\nSabor da pizza: " + item.getSabor()));
  }
}
