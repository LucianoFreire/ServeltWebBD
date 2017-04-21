
package conexao;

import java.sql.*;

/**
 *
 * @author LucianoFreire
 */
public class ConexaoBD {
    
    protected Connection con;
    protected Statement stmt;
    //private String serverName = "187.45.190.93";
    private String serverName = "localhost";
    private String portNumber = "3306";
    private String dataBaseName = "u831468724_ifms";
    private String url = "jdbc:mysql://localhost:3306/" + dataBaseName;
    //private String userName = "u831468724_3213";
    private String userName = "root";
    //private String password = "I3F2M1S3";
    private String password = "";
    private String errString;
    
     public ConexaoBD(){
        
    }
    
    private String getConnectionUrl(){
        return url;
    }
    
    public Connection Conectar(){
        
        con=null;
        
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("org.gjt.mm.mysql.Driver");
            con = DriverManager.getConnection(getConnectionUrl(),userName,password);
            stmt=con.createStatement();
            System.out.println("Conectado com Sucesso!!!");
        } catch (Exception e) {
            errString = "Erro de conexão ao banco de dados";
            return null;
        }       
        return con;
    }
    
    public void Desconectar(){
        try {
            stmt.close();
            con.close();
        } catch (Exception e) {
            errString = "Conexão Encerrada";
        }
    }
    
    public Statement getStmt(){
        return this.stmt;
    }
    
}
