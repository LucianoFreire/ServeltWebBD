package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ParametrosTelefone;
import model.Telefone;

public class ServletTelefone extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ParametrosTelefone acesso = new ParametrosTelefone();

        try {
            String html
                    = "<html>\n"
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
                    + "                    <a class=\"navbar-brand\" href=\"formulario.html\">ServletBD</a>\n"
                    + "                </div>\n"
                    + "                <ul class=\"nav navbar-nav\">\n"
                    + "                    <li class=\"active\"><a href=\"formulario.html\">FORMULARIO DE CADASTRO</a></li>\n"                 
                    + "                </ul>\n"
                    + "                <ul class=\"nav navbar-nav navbar-right\">\n"
                    + "                    <li><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li>\n"
                    + "                    <li><a href=\"#\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>\n"
                    + "                </ul>\n"
                    + "            </div>\n"
                    + "        </nav>"
                    + "<form align=\"center\">\n"
                    + "<div class=\"container\">\n"
                    + "                <h2><b>LISTAGEM DE TELEFONES<b></h2>\n"
                    + "                <table class=\"table table-striped\">\n"
                    + "                    <thead>\n"
                    + "                        <tr>\n"
                    + "                            <th>ID</th>\n"
                    + "                            <th>DDD</th>\n"
                    + "                            <th>NUMERO</th>\n"
                    + "                            <th>ID PESSOA</th>\n"
                    + "                        </tr>\n"
                    + "                    </thead>\n"
                    + acesso.ListarTelefone()
                    + "                </table>\n"
                    + "            </div>"
                    + "<br>"
                    + "                <table width=\"20%\" cellspacing=\"10\" align=center>\n"
                    + "\n"
                    + "                <tr>\n"
                    + "                    <td>\n"
                    + "                        <button type=\"submit\" class=\"btn btn-success\">"
                    + "                        <a href=\"formulario.html\">Voltar</a>"
                    + "                        </button>\n"
                    + "                    </td>\n"
                    + "                    <td>\n"
                    + "                        <button type=\"submit\" class=\"btn btn-info\">\n"
                    + "                        <a href=\"ServletTelefone\">Atualizar Tabela</a>"
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

            ParametrosTelefone acesso = new ParametrosTelefone();
            Telefone telefone = new Telefone();

            telefone.setDd(request.getParameter("dd"));
            telefone.setNumero(request.getParameter("numero"));
            telefone.setId_pessoa(request.getParameter("id_pessoa"));

            acesso.InserirTelefone(telefone);

        } catch (Exception ex) {

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
