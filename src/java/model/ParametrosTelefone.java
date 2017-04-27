package model;

import conexao.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ParametrosTelefone extends ConexaoBD {

    public ParametrosTelefone() {
        
        Conectar();
    }
    
     public void InserirTelefone(Telefone telefone) {

        String sql = "insert into telefone (id, dd, numero, id_pessoa)"
                + "values (default,?,?,?)";

        try {

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, telefone.getDd());
            pst.setString(2, telefone.getNumero());
            pst.setString(3, telefone.getId_pessoa());

            pst.execute();

            Desconectar();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        }

    }
    
    public String ListarTelefone() {

        String html = "";

        try {
            java.sql.Statement st = con.createStatement();
            st.executeQuery("select * from telefone");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                html = html + "<tr>\n"
                        + "<td><input type=\"text\" class=\"form-control\name=\"id\" value=\"" + rs.getString("id") + "\"></td>\n"
                        + "<td><input type=\"text\" class=\"form-control\name=\"dd\" value=\"" + rs.getString("dd") + "\"></td>\n"
                        + "<td><input type=\"text\" class=\"form-control\name=\"numero\" value=\"" + rs.getString("numero") + "\"></td>\n"                       
                        + "<td><input type=\"text\" class=\"form-control\name=\"id_pessoa\" value=\"" + rs.getString("id_pessoa") + "\"></td>\n"                       
                        + "</tr>\n";
            }

        } catch (Exception e) {

        }//Fim try
        return html;
    }
    
}
