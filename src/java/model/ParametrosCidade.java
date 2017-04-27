package model;

import conexao.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ParametrosCidade extends ConexaoBD {

    public ParametrosCidade() {

        Conectar();
    }

    public void InserirCidade(Cidade cidade) {
        String sql = "insert into cidade  (id, nome, id_estado)"
                + "values(default,?,?)";

        try {

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, cidade.getNome());
            pst.setString(2, cidade.getId_estado());

            pst.execute();

            Desconectar();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }

    }

    public String ListarCidade() {

        String html = "";

        try {
            java.sql.Statement st = con.createStatement();
            st.executeQuery("select * from cidade");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                html = html + "<tr>\n"
                        + "<td><input type=\"text\" class=\"form-control\"name=\"id\" value=\"" + rs.getString("id") + "\"></td>\n"
                        + "<td><input type=\"text\" class=\"form-control\name=\"nome\" value=\"" + rs.getString("nome") + "\"></td>\n"
                        + "<td><input type=\"text\" class=\"form-control\name=\"id_estado\" value=\"" + rs.getString("id_estado") + "\"></td>\n"
                        + "</tr>\n";
            }

        } catch (Exception e) {

        }//Fim try
        return html;
    }

}
