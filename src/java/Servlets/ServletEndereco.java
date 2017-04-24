package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Endereco;
import model.ParametrosEndereco;

public class ServletEndereco extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ParametrosEndereco acesso = new ParametrosEndereco();

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
                    + "                <h2><b>LISTAGEM DE ENDEREÇOS<b></h2>\n"
                    + "                <table class=\"table table-striped\">\n"
                    + "                    <thead>\n"
                    + "                        <tr>\n"
                    + "                            <th>ID</th>\n"
                    + "                            <th>RUA</th>\n"
                    + "                            <th>BAIRRO</th>\n"
                    + "                            <th>NUMERO</th>\n"
                    + "                            <th>COMPLEMENTO</th>\n"
                    + "                            <th>CEP</th>\n"
                    + "                            <th>ID CIDADE</th>\n"
                    + "                        </tr>\n"
                    + "                    </thead>\n"
                    + acesso.ListarEndereco()
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
                    + "                        <a href=\"ServletEndereco\">Atualizar Tabela</a>"
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

            ParametrosEndereco acesso = new ParametrosEndereco();

            Endereco endereco = new Endereco();

            endereco.setRua(request.getParameter("rua"));
            endereco.setBairro(request.getParameter("bairro"));
            endereco.setNumero(request.getParameter("numero"));
            endereco.setComplemento(request.getParameter("complemento"));
            endereco.setCep(request.getParameter("cep"));
            endereco.setId_cidade(request.getParameter("id_cidade"));

            acesso.InserirEndereco(endereco);

        } catch (Exception ex) {

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
