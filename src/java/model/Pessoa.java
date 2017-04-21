package model;

/**
 *
 * @author LucianoFreire
 */
public class Pessoa {
    
    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    //private String idconjuge_pessoa;
    //private String id_endereco;
    private String id_aluno_responsavel;
    

    public Pessoa() {
        
    }

    public Pessoa(int id, String nome, String sobrenome, String email, String id_aluno_responsavel) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.id_aluno_responsavel = id_aluno_responsavel;
      
    }
    /*public Pessoa(int id, String nome, String sobrenome, String email, String idconjuge_pessoa, String id_endereco, String id_aluno_responsavel) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.idconjuge_pessoa = idconjuge_pessoa;
        this.id_endereco = id_endereco;
        this.id_aluno_responsavel = id_aluno_responsavel;
    }*/
    
    

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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   /* public String getIdconjuge_pessoa() {
        return idconjuge_pessoa;
    }

    public void setIdconjuge_pessoa(String idconjuge_pessoa) {
        this.idconjuge_pessoa = idconjuge_pessoa;
    }

    public String getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(String id_endereco) {
        this.id_endereco = id_endereco;
    }*/

    public String getId_aluno_responsavel() {
        return id_aluno_responsavel;
    }

    public void setId_aluno_responsavel(String id_aluno_responsavel) {
        this.id_aluno_responsavel = id_aluno_responsavel;
    }
    
    

}