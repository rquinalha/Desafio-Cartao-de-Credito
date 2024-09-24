import java.util.Scanner;

public class LeituraESaida {
    public void lerDados() {
        Scanner leitura = new Scanner(System.in);
        System.out.println("\n**************************");
        System.out.println("Digite o limite do cartão: ");
        System.out.print("R$: ");
        double limite = leitura.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        leitura.nextLine();
        while (sair != 0) {
            System.out.println("Digite a descrição da compra: ");
            System.out.print("Descrição: ");
            String descricao = leitura.nextLine();

            System.out.println("Digite o valor da compra: ");
            System.out.print("R$: ");
            double valor = leitura.nextDouble();
            leitura.nextLine();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (!compraRealizada) {
                System.out.println("Saldo insuficiente para realizar a compra!");
                System.out.println("Compras realizadas com saldo positivo:");
                cartao.getCompras().forEach(c -> System.out.printf("%s - R$ %.2f%n", c.getDescricao(), c.getValor()));
                System.out.printf("Saldo restante: R$ %.2f%n", cartao.getSaldo());
            }

            System.out.println("Deseja continuar? Digite 0 para encerrar ou 1 para continuar: ");
            System.out.print("Digite aqui (0 ou 1): ");
            sair = leitura.nextInt();
            System.out.println("\n***********************");
            leitura.nextLine();
        }

        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS: \n");

        cartao.getCompras().stream()
                .sorted((c1, c2) -> Double.compare(c1.getValor(), c2.getValor()))
                .forEach(c -> System.out.printf("%s - R$ %.2f%n", c.getDescricao(), c.getValor()));

        System.out.println("\n***********************");
        System.out.printf("Saldo do cartão: R$ %.2f%n\n", cartao.getSaldo());
        leitura.close();
    }
}
