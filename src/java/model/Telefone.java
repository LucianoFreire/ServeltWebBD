package model;

public class Telefone {
    
    private int id;
    private String dd;
    private String numero;
    private String id_pessoa;

    public Telefone() {
    }

    public Telefone(int id, String dd, String numero, String id_pessoa) {
        this.id = id;
        this.dd = dd;
        this.numero = numero;
        this.id_pessoa = id_pessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(String id_pessoa) {
        this.id_pessoa = id_pessoa;
    }  
}