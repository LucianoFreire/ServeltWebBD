package conexao;

import java.sql.*;

public class ConexaoBD {

    protected Connection con;
    protected Statement stmt;
    ResultSet rs;
    private String dataBaseName = "u831468724_ifms";
    String userName = "u831468724_3213";
    String password = "I3F2M1S3";
    private String url = "jdbc:mysql://187.45.190.93:3306/" + dataBaseName;
    private String errString;
    //String url = "jdbc:mysql://187.45.190.93:3306/u831468724_ifms";
    //private String userName = "u831468724_3213";
    //private String serverName = "localhost";
    //private String portNumber = "3306";

    public ConexaoBD() {

    }

    private String getConnectionUrl() {
        return url;
    }

    public Connection Conectar() {

        con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("org.gjt.mm.mysql.Driver");
            con = DriverManager.getConnection(url, userName, password);
            stmt = con.createStatement();
            System.out.println("Conectado com Sucesso!!!");
        } catch (Exception e) {
            errString = "Erro de conexão ao banco de dados";
            return null;
        }
        return con;
    }

    public void Desconectar() {
        try {
            stmt.close();
            con.close();
        } catch (Exception e) {
            errString = "Conexão Encerrada";
        }
    }

    public Statement getStmt() {
        return this.stmt;
    }
}
