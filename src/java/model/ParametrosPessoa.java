package model;

import conexao.ConexaoBD;
import java.sql.*;
import javax.swing.JOptionPane;

public class ParametrosPessoa extends ConexaoBD {

    public ParametrosPessoa() {

        Conectar();
    }

    public void InserirPessoa(Pessoa dts) {

        String sSQL = "insert into pessoa (id, nome, sobrenome, email, idconjuge_pessoa, id_endereco, "
                + "id_aluno_responsavel)"
                + "values (default,?,?,?,?,?,?)";

        try {

            PreparedStatement pst = con.prepareStatement(sSQL);

            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getSobrenome());
            pst.setString(3, dts.getEmail());
            pst.setString(4, dts.getIdconjuge_pessoa());
            pst.setString(5, dts.getId_endereco());
            pst.setString(6, dts.getId_aluno_responsavel());

            pst.execute();

            Desconectar();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        }
    }

    public String ListarPessoa() {

        String html = "";

        try {
            java.sql.Statement st = con.createStatement();
            st.executeQuery("select * from pessoa");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                html = html
                        + "<tr>\n"
                        + "<td><input type=\"text\" name=\"id\" value=\"" + rs.getString("id") + "\"></td>\n"
                        + "<td><input type=\"text\" name=\"nome\" value=\"" + rs.getString("nome") + "\"></td>\n"
                        + "<td><input type=\"text\" name=\"sobrenome\" value=\"" + rs.getString("sobrenome") + "\"></td>\n"
                        + "<td><input type=\"text\" name=\"email\" value=\"" + rs.getString("email") + "\"></td>\n"
                        + "<td><input type=\"text\" name=\"idconjuge_pessoa\" value=\""+rs.getString("idconjuge_pessoa")+"\"></td>\n"
                        + "<td><input type=\"text\" name=\"id_endereco\" value=\""+rs.getString("id_endereco")+"\"></td>\n"
                        + "<td><input type=\"text\" name=\"id_aluno_responsavel\" value=\"" + rs.getString("id_aluno_responsavel") + "\"></td>\n"
                        + "</tr>\n";
            }

        } catch (Exception e) {

        }//Fim try
        return html;
    }

}
