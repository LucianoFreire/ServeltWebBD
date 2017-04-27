package model;

import conexao.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ParametrosAluno extends ConexaoBD {

    public ParametrosAluno() {

        Conectar();
    }

    public void InserirAluno(Aluno dts) {

        String sSQL = "insert into aluno_responsavel (id, nome, sobrenome, matricula)"
                + "values (default,?,?,?)";

        try {

            PreparedStatement pst = con.prepareStatement(sSQL);

            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getSobrenome());
            pst.setString(3, dts.getMatricula());

            pst.execute();

            Desconectar();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        }
    }

    public String listarAluno() {

        String html = "";

        try {
            java.sql.Statement st = con.createStatement();
            st.executeQuery("select * from aluno_responsavel");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                html = html
                        + "<tr>\n"
                        + "<td><input type=\"text\" class=\"form-control\"name=\"id\" value=\"" + rs.getString("id") + "\"></td>\n"
                        + "<td><input type=\"text\" class=\"form-control\"name=\"nome\" value=\"" + rs.getString("nome") + "\"></td>\n"
                        + "<td><input type=\"text\" class=\"form-control\"name=\"sobrenome\" value=\"" + rs.getString("sobrenome") + "\"></td>\n"
                        + "<td><input type=\"text\" class=\"form-control\"name=\"matricula\" value=\"" + rs.getString("matricula") + "\"></td>\n"
                        + "</tr>\n";
            }

        } catch (Exception e) {

        }//Fim try
        return html;
    }

}
