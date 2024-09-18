
package bean;

public class Cerveja {
    private String idBeer;
    private String descricao;
    private float valor;
    
    public Cerveja(){
        this.idBeer = "Sem ID";
        this.descricao = "Sem descricao";
        this.valor = 0000;
    }
    public Cerveja(String idBeer, String descricao, float valor){
        this.idBeer = idBeer;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getIdBeer() {
        return idBeer;
    }

    public void setIdBeer(String idBeer) {
        this.idBeer = idBeer;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return getIdBeer();
    }
    
   
    
}
