package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ParametrosPessoa;
import model.Pessoa;

/**
 *
 * @author luciano
 */
public class ServletPessoa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ParametrosPessoa acesso = new ParametrosPessoa();

        try {
            String html = "<html>\n"
                    + "    <head>\n"
                    + "        <title>Servlet Banco de Dados</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "    </head>\n"
                    + "    <link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n"
                    + "    <script src=\"bootstrap/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n"
                    + "    <body>\n"
                    + "\n"
                    + "        <nav class=\"navbar navbar-inverse\">\n"
                    + "            <div class=\"container-fluid\">\n"
                    + "                <div class=\"navbar-header\">\n"
                    + "                    <a class=\"navbar-brand\" href=\"#\">ServletBD</a>\n"
                    + "                </div>\n"
                    + "                <ul class=\"nav navbar-nav\">\n"
                    + "                    <li class=\"active\"><a href=\"aluno.html\">ALUNO</a></li>\n"
                    + "                    <li><a href=\"pessoa.html\">PESSOA</a></li>\n"
                    + "                </ul>\n"
                    + "                <ul class=\"nav navbar-nav navbar-right\">\n"
                    + "                    <li><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li>\n"
                    + "                    <li><a href=\"#\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>\n"
                    + "                </ul>\n"
                    + "            </div>\n"
                    + "        </nav>"
                    + "<form align=\"center\">\n"
                    + "<div class=\"container\">\n"
                    + "                <h2><b>LISTAGEM DE PESSOAS<b></h2>\n"
                    + "                <table class=\"table table-striped\">\n"
                    + "                    <thead>\n"
                    + "                        <tr>\n"
                    + "                            <th>ID</th>\n"
                    + "                            <th>NOME</th>\n"
                    + "                            <th>SOBRENOME</th>\n"
                    + "                            <td><b>EMAIL</b></td>\n"
                    //+                              "<td>Conjuge</td>\n"
                    // +                              "<td>Endereço</td>\n"
                    + "                            <td><b>ALUNO/RESPONSAVEL</b></td>\n"
                    + "                        </tr>\n"
                    + "                    </thead>\n"
                    + acesso.listarPessoa()
                    + "</div>"
                    + "<br>"
                    + "                <table width=\"20%\" cellspacing=\"10\" align=center>\n"
                    + "\n"
                    + "                <tr>\n"
                    + "                    <td>\n"
                    + "                        <button type=\"submit\" class=\"btn btn-success\">"
                    + "                        <a href=\"pessoa.html\">Voltar</a>"
                    + "                        </button>\n"
                    + "                    </td>\n"
                    + "                    <td>\n"
                    + "                        <button type=\"submit\" class=\"btn btn-info\">\n"
                    + "                        <a href=\"ServletPessoa\">Atualizar Tabela</a>"
                    + "                        </button>\n"
                    + "                    </td>\n"
                    + "                    </tr> \n"
                    + "            </table>"
                    + "</form>\n"
                    + "</body>\n"
                    + "</html>";

            out.print(html);

        } catch (Exception e) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            ParametrosPessoa acesso = new ParametrosPessoa();
            Pessoa pessoa = new Pessoa();

            pessoa.setNome(request.getParameter("nome"));
            pessoa.setSobrenome(request.getParameter("sobrenome"));
            pessoa.setEmail(request.getParameter("email"));
            //pessoa.setIdconjuge_pessoa(request.getParameter("idconjuge_pessoa"));
            //pessoa.setId_endereco(request.getParameter("id_endereco"));
            pessoa.setId_aluno_responsavel(request.getParameter("id_aluno_responsavel"));

            acesso.InserirPessoa(pessoa);

        } catch (Exception ex) {

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
