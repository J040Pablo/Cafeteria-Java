public class Main {
    public static void main(String[] args) {
        SistemaGerenciamentoPedidos sistema = new SistemaGerenciamentoPedidos();

        sistema.adicionarPedido("Cliente1", false);
        sistema.adicionarPedido("Cliente2", true);
        sistema.adicionarPedido("Cliente3", false);
        sistema.adicionarPedido("Cliente4", true);

        sistema.visualizarPedidos();

        sistema.processarProximoPedido();
        sistema.processarProximoPedido();

        sistema.removerPedido("Cliente3");

        sistema.visualizarPedidos();
    }
}