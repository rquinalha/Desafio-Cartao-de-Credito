import java.util.ArrayList;
import java.util.List;

//Classe CartaoDeCredito
public class CartaoDeCredito {
    private double saldo;
    private double limite;
    private List<Compra> compras;
    
    //Construtor
    public CartaoDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    //Getters e Setters
    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    //Metodos
    public List<Compra> getCompras() {
        return compras;
    }

    public boolean lancaCompra(Compra compra) {
        if (saldo - compra.getValor() >= 0) {
            saldo -= compra.getValor();
            compras.add(compra);
            return true;
        }
        return false;
    }

    


}
