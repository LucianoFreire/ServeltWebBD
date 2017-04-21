package model;

public class cidade {
    
    private int id;
    private String nome;
    private String id_estado;

    public cidade() {
    }

    public cidade(int id, String nome, String id_estado) {
        this.id = id;
        this.nome = nome;
        this.id_estado = id_estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId_estado() {
        return id_estado;
    }

    public void setId_estado(String id_estado) {
        this.id_estado = id_estado;
    }    
}
