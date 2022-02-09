package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author win
 */
public class SignUpServlet extends HttpServlet {

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
            request.setCharacterEncoding("UTF-8");
            /* TODO output your page here. You may use following sample code. */
            String username = request.getParameter("uname");
            String password = request.getParameter("pass");
            String repassword = request.getParameter("repass");
            String firstName = request.getParameter("fname");
            String lastName = request.getParameter("lname");
            
            if(username.length()==0 || password.length()==0 || repassword.length()==0 || 
              firstName.length()==0 || lastName.length()==0){
                request.setAttribute("side", "right-panel-active");
                request.setAttribute("messErr1", "Please enter full infomation to sign up!");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
            if(!password.equals(repassword)){
                request.setAttribute("messErr1", "Repeate password wrong!");
                request.setAttribute("vlFname", firstName);
                request.setAttribute("vlLname", lastName);
                request.setAttribute("vlUname", username);
                request.setAttribute("side", "right-panel-active");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
            else{
                DAO dao = new DAO();
                Account checkAcc = dao.checkAccount(username);
                if(checkAcc == null){
                    dao.signUp(username, password, repassword, firstName, lastName);
                    
                    Account a = dao.getAccount(username, password);
                    HttpSession session = request.getSession();
                    session.setAttribute("account", a);
                    response.sendRedirect("home");
                }else{
                    request.setAttribute("side", "right-panel-active");
                    request.setAttribute("messErr1", "This username has already exist!");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
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
        request.getRequestDispatcher("signup").forward(request, response);
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
