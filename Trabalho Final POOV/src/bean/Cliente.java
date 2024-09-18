
package bean;

public class Cliente {
    private String CPF;
    private String nome;
    private String tel;
    private String end;
    private String insta;
    
    public Cliente(){
        this.CPF = "Sem CPF";
        this.nome = "Sem nome";
        this.tel = "Sem telefone";
        this.end = "Sem endereço";
        this.insta = "sem intagram";
    }
    public Cliente(String CPF, String nome, String tel, String end, String insta){
        this.CPF = CPF;
        this.nome = nome;
        this.tel = tel;
        this.end = end;
        this.insta = insta;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getInsta() {
        return insta;
    }

    public void setInsta(String insta) {
        this.insta = insta;
    }

    @Override
    public String toString() {
        return getCPF(); 
    }
    
}
