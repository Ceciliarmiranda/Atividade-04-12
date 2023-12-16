import java.util.ArrayList;
import java.util.Scanner;

public class Loja {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<ItemDaLoja> inventarioDaLoja = new ArrayList<>();
        ArrayList<ItemDoCarrinho> listaDeCompra = new ArrayList<>();

        int opcaoDesejada;
        int produtoRemocao;
        int indexProdutoRemocao;
        double valorTotalCompra = 0;

        do {
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos no inventário");
            System.out.println("3 - Listar produtos no carrinho");
            System.out.println("4 - Remover produto do carrinho");
            System.out.println("5 - Calcular valor total da compra");
            System.out.println("6 - Fechar compra");
            System.out.println("7 - Sair");
            System.out.print("Digite a opção desejada: ");
            opcaoDesejada = entrada.nextInt();

            switch (opcaoDesejada) {
                case 1:
                    // Cadastrar produto no inventário
                    ItemDaLoja novoItem = new ItemDaLoja();
                    System.out.print("Informe o nome do produto: ");
                    novoItem.setNome(entrada.next());
                    System.out.print("Informe o valor do produto: ");
                    novoItem.setValor(entrada.nextDouble());
                    inventarioDaLoja.add(novoItem);
                    break;

                case 2:
                    // Listar produtos no inventário
                    System.out.println("Inventário da Loja:");
                    for (ItemDaLoja item : inventarioDaLoja) {
                        System.out.println("Nome: " + item.getNome());
                        System.out.println("Valor: " + item.getValor());
                        System.out.println("Código: " + item.getId());
                        System.out.println("=============================");
                    }
                    break;

                case 3:
                    // Listar produtos no carrinho
                    System.out.println("Carrinho de Compras:");
                    for (ItemDoCarrinho item : listaDeCompra) {
                        System.out.println("Nome: " + item.getNome());
                        System.out.println("Valor: " + item.getValor());
                        System.out.println("Código: " + item.getId());
                        System.out.println("Quantidade: " + item.getQuantEscolhida());
                        System.out.println("=============================");
                    }
                    break;

                case 4:
                    // Remover produto do carrinho
                    System.out.print("Digite o ID do produto que deseja remover: ");
                    produtoRemocao = entrada.nextInt();
                    listaDeCompra.removeIf(item -> item.getId() == produtoRemocao);
                    break;

                case 5:
                    // Calcular valor total da compra
                    valorTotalCompra = 0;
                    for (ItemDoCarrinho item : listaDeCompra) {
                        valorTotalCompra += item.getValor() * item.getQuantEscolhida();
                    }
                    System.out.println("Valor total da compra: R$" + valorTotalCompra);
                    break;

                case 6:
                    // Fechar compra
                    // Adicione aqui a lógica para finalizar a compra
                    break;

                case 7:
                    // Sair do programa
                    System.out.println("Obrigado, volte sempre!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcaoDesejada != 7);

        entrada.close();
    }
}
