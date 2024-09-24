
public class Compra {
    private String descricao;
    private double valor;

    //Construtor
    public Compra(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    //Getters e Setters
    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Compra [descricao=" + descricao + ", valor=" + valor + "]";
    }


}
