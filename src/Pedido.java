import java.util.PriorityQueue;
import java.util.Iterator;

public class Pedido implements Comparable<Pedido> {
    private String cliente;
    private boolean Vip;
    private int ordemDeChegada;
    private static int contador = 0;

    public Pedido(String cliente, boolean isVip) {
        this.cliente = cliente;
        this.Vip = Vip;
        this.ordemDeChegada = contador++;
    }

    public String getCliente() {
        return cliente;
    }

    public boolean Vip() {
        return Vip;
    }

    @Override
    public int compareTo(Pedido outroPedido) {
        if (this.Vip && outroPedido.Vip) {
            return 1;
        } else if (!this.Vip && outroPedido.Vip) {
            return 1;
        } else {
            return Integer.compare(this.ordemDeChegada, outroPedido.ordemDeChegada);
        }
    }

    @Override
    public String toString() {
        return String.format("Pedido{cliente='%s', Vip=%b, ordemDeChegada=%d}", cliente, Vip, ordemDeChegada);
    }
}

class SistemaGerenciamentoPedidos {
    private PriorityQueue<Pedido> filaPedidos;

    public SistemaGerenciamentoPedidos() {
        filaPedidos = new PriorityQueue<>();
    }

    public void adicionarPedido(String cliente, boolean Vip) {
        Pedido novoPedido = new Pedido(cliente, Vip);
        filaPedidos.add(novoPedido);
        System.out.println("Pedido adicionado: " + novoPedido);
    }

    public void processarProximoPedido() {
        if (!filaPedidos.isEmpty()) {
            Pedido pedido = filaPedidos.poll();
            System.out.println("Processando Pedido: " + pedido);
        } else {
            System.out.println("Nenhum pedido pendente.");
        }
    }
    public void visualizarPedidos() {
        if(!filaPedidos.isEmpty()) {
            System.out.println("Pedidos na fila:");
            for (Pedido pedido : filaPedidos) {
                System.out.println(pedido);
            }
        } else {
            System.out.println("Nenhum pedido pendente.");
        }
    }
    public void removerPedido (String cliente) {
        Iterator<Pedido> iterator  = filaPedidos.iterator();
        boolean encontrado = false;
        while (iterator.hasNext()) {
            Pedido pedido = iterator.next();
            if (pedido.getCliente().equals(cliente)) {
                iterator.remove();
                System.out.println("Pedido removido: " + pedido);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("pedido não encontrado.");
        }
    }
}
