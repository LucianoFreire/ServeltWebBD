package model;

import conexao.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ParametrosEndereco extends ConexaoBD {

    public ParametrosEndereco() {

        Conectar();
    }

    public void InserirEndereco(Endereco endereco) {

        String sql = "insert into endereco (id, rua, bairro, numero, complemento, cep, id_cidade)"
                + "values(default,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, endereco.getRua());
            pst.setString(2, endereco.getBairro());
            pst.setString(3, endereco.getNumero());
            pst.setString(4, endereco.getComplemento());
            pst.setString(5, endereco.getCep());
            pst.setString(6, endereco.getId_cidade());

            pst.execute();

            Desconectar();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

    public String ListarEndereco() {

        String html = "";

        try {
            java.sql.Statement st = con.createStatement();
            st.executeQuery("select * from endereco");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                html = html + "<tr>\n"
                        + "<td><input type=\"text\" name=\"id\" value=\"" + rs.getString("id") + "\"></td>\n"
                        + "<td><input type=\"text\" name=\"rua\" value=\"" + rs.getString("rua") + "\"></td>\n"
                        + "<td><input type=\"text\" name=\"bairro\" value=\"" + rs.getString("bairro") + "\"></td>\n"
                        + "<td><input type=\"text\" name=\"numero\" value=\"" + rs.getString("numero") + "\"></td>\n"
                        + "<td><input type=\"text\" name=\"complemento\" value=\"" + rs.getString("complemento") + "\"></td>\n"
                        + "<td><input type=\"text\" name=\"cep\" value=\"" + rs.getString("cep") + "\"></td>\n"
                        + "<td><input type=\"text\" name=\"id_cidade\" value=\"" + rs.getString("id_cidade") + "\"></td>\n"
                        + "</tr>\n";
            }

        } catch (Exception e) {

        }
        return html;

    }

}
