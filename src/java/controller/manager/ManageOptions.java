package controller.manager;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author win
 */
@WebServlet(name = "ManageOptions", urlPatterns = {"/manage"})
public class ManageOptions extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            Account account =(Account) session.getAttribute("account");
          
        if(account == null){
            response.sendRedirect("home");
        }else{
            
            if(account.isRole()){
                response.sendRedirect("home");
            }else{
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Manage</title>");            
            out.println("</head>");
            out.println(" <style>\n" +
                "    table,\n" +
                "    th,\n" +
                "    td {\n" +
                "      border: 1px solid black;\n" +
                "    }\n" +
                "    a {\n" +
                "      text-decoration: none;\n" +
                "      font-size: 20px;\n" +
                "      line-height: 1.8;\n" +
                "      color: black;\n" +
                "    }\n" +
                "    a:hover {\n" +
                "      color: rgb(253, 63, 63);\n" +
                "    }\n" +
                "  </style>");
            out.println("<body>");
            out.println("<h1>Data Menu</h1>");
            out.println("<table class=\"table table-responsive\">\n" +
                        "      <tbody>\n" +
                        "        <tr>\n" +
                        "          <td><strong>Option</strong></td>\n" +
                        "          <td><a href=\"managecategory\">Category</a></td>\n" +
                        "          <td><a href=\"manageproduct\">Product</a></td>\n" +
                        "          <td><a href=\"managesize\">Size</a></td>\n" +
                        "          <td><a href=\"manageaccount\">Account</a></td>\n" +
                        "        </tr>\n" +
                        "      </tbody>\n" +
                        "    </table>");
            
            out.println("</body>");
            out.println("</html>");
            }
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
