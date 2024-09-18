
package bean;

import java.time.LocalDate;



public class Pedido {
    private String id_cerveja_pedido;
    private String id_pedido;
    private String fk_cpf_cliente;
    private String fk_id_cerveja;
    private int quantidade;
    private String data_pedido;

    public Pedido(String id_cerveja_pedido, String id_pedido, String fk_id_cerveja, String fk_cpf_cliente,int quantidade, String data) {
        this.id_cerveja_pedido = id_cerveja_pedido;
        this.id_pedido = id_pedido;
        this.fk_cpf_cliente = fk_cpf_cliente;
        this.fk_id_cerveja = fk_id_cerveja;
        this.quantidade = quantidade;
        this.data_pedido = data;
    }
    
    public Pedido()
    {
        this.id_cerveja_pedido = "";
        this.id_pedido = "";
        this.fk_cpf_cliente = "";
        this.fk_id_cerveja = "";
        this.quantidade = 00;
        this.data_pedido = "";
    }

    public String getId_cerveja_pedido() {
        return id_cerveja_pedido;
    }

    public void setId_cerveja_pedido(String id_cerveja_pedido) {
        this.id_cerveja_pedido = id_cerveja_pedido;
    }

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getFk_cpf_cliente() {
        return fk_cpf_cliente;
    }

    public void setFk_cpf_cliente(String fk_cpf_cliente) {
        this.fk_cpf_cliente = fk_cpf_cliente;
    }

    public String getFk_id_cerveja() {
        return fk_id_cerveja;
    }

    public void setFk_id_cerveja(String fk_id_cerveja) {
        this.fk_id_cerveja = fk_id_cerveja;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(String data_pedido) {
        this.data_pedido = data_pedido;
    }
}

