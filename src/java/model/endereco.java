package model;

public class endereco {
    
    private int id;
    private String rua;
    private String bairro;
    private String numero;
    private String complemento;
    private String cep;
    private String id_cidade;

    public endereco() {
    }

    public endereco(int id, String rua, String bairro, String numero, String complemento, String cep, String id_cidade) {
        this.id = id;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.id_cidade = id_cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(String id_cidade) {
        this.id_cidade = id_cidade;
    }      
}
