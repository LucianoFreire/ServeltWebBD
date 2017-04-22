package model;

import conexao.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ParametrosEstado extends ConexaoBD {

    public ParametrosEstado() {

        Conectar();
    }

    public void InserirEstado(Estado dts) {

        String sSQL = "insert into estado (id, nome, sigla)"
                + "values (default,?,?)";

        try {

            PreparedStatement pst = con.prepareStatement(sSQL);

            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getSigla());

            pst.execute();

            Desconectar();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        }
    }

    public String listarEstado() {

        String html = "";

        try {
            java.sql.Statement st = con.createStatement();
            st.executeQuery("select * from estado");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                html = html
                        + "<tr>\n"
                        + "<td><input type=\"text\" name=\"id\" value=\"" + rs.getString("id") + "\"></td>\n"
                        + "<td><input type=\"text\" name=\"nome\" value=\"" + rs.getString("nome") + "\"></td>\n"
                        + "<td><input type=\"text\" name=\"sigla\" value=\"" + rs.getString("sigla") + "\"></td>\n"
                        + "</tr>\n";
            }

        } catch (Exception e) {

        }//Fim try
        return html;
    }

}
