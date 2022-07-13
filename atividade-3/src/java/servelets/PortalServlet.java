/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import jdbc.conexao.conexaoDAO;
import jdbc.persistencia.mysql.MySqlUserDAO;

import model.User;

/**
 *
 * @author User
 */
@WebServlet(name = "PortalServlet", urlPatterns = {"/PortalServlet"})
public class PortalServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
         
          if(request.getSession(false)!=null){
              User user =(User) request.getSession(false).getAttribute("user");
                List<User> usuarios = new MySqlUserDAO(new conexaoDAO().conectaDB()).listaTodos();
                
                 out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PortalServlet</title>");
            out.println(" <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">");

            out.println("</head>");
            out.println("<body>");
            out.println(" <div class=\"d-flex p-5\"><form class=\"form-inline\"  method = \"post\"  action = \"CadastrarUsuarioServlet\">\n"
                    + "  <div class=\"form-group mx-sm-3 mb-2\">\n"
                    + "    <label for=\"inputPassword2\" class=\"sr-only\">Nome</label>\n"
                    + "    <input type=\"text\" class=\"form-control\" id=\"inputPassword2\" placeholder=\"Nome\" name=\"nome\">\n"
                    + "  </div>\n"
                    + "  <div class=\"form-group mx-sm-3 mb-2\">\n"
                    + "    <label for=\"inputPassword2\" class=\"sr-only\">Login</label>\n"
                    + "    <input type=\"text\" class=\"form-control\" id=\"inputPassword2\" placeholder=\"Login\" name=\"login\">\n"
                    + "  </div>\n"
                    + "  <div class=\"form-group mx-sm-3 mb-2\">\n"
                    + "    <label for=\"inputPassword2\" class=\"sr-only\">Senha</label>\n"
                    + "    <input type=\"text\" class=\"form-control\" id=\"inputPassword2\" placeholder=\"Senha\" name=\"senha\">\n"
                    + "  </div>\n"
                    + "  <button type=\"submit\" class=\"btn btn-primary mb-2\">SALVAR</button>\n"
                    + "</form></div>");
            out.println("<table class=\"table\">");
            out.println(" <thead>\n"
                    + "    <tr>\n"
                    + "      <th scope=\"col\">#</th>\n"
                    + "      <th scope=\"col\">Nome</th>\n"
                    + "      <th scope=\"col\">Login</th>\n"
                    + "      <th scope=\"col\">Senha</th>\n"
                    + "    </tr>\n"
                    + "  </thead>");
            out.println("<tbody>");
            for (int i = 0; i < usuarios.size(); i++) {
                out.println("<tr>");
                out.println("<th scope=\"row\">" + usuarios.get(i).getId()+ "</th>");
                out.println("<td scope=\"row\">" + usuarios.get(i).getNome() + "</td>");
                out.println("<td scope=\"row\">" + usuarios.get(i).getLogin() + "</td>");
                out.println("<td scope=\"row\">" + usuarios.get(i).getSenha() + "</td>");
                out.println("</tr>");
            }
            out.println("</tbody></table>");
out.println("<a href=\"LogoutServlet\">Logout</a>");
            out.println("</body>");
            out.println("</html>");
            
              
          }else{
              request.setAttribute("msg", "Para acessar o portal você precisa estar logado!");
                request.setAttribute("page", "index.html");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ErroServlet");
                
                rd.forward(request, response);
                return;
          }

                  
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
