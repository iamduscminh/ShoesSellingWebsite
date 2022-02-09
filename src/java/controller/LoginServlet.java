package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author win
 */
public class LoginServlet extends HttpServlet {

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

        String username = request.getParameter("uname");
        String password = request.getParameter("pass");
        
        
            DAO dao = new DAO();
            Account a = dao.getAccount(username, password);
            
            if(a == null ){
                request.setAttribute("messErr", "Wrong username and password,Please reEnter");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
            else {
                String remember = request.getParameter("remember");
                if(remember !=null)
            {
                Cookie c_user = new Cookie("username", username);
                Cookie c_pass = new Cookie("password", password);
                c_user.setMaxAge(10*30);
                c_pass.setMaxAge(10*30);
                response.addCookie(c_pass);
                response.addCookie(c_user);
            }
                HttpSession session = request.getSession();
                session.setAttribute("account", a);
                response.sendRedirect("home");
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
        request.getRequestDispatcher("Login.jsp").forward(request, response);
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
//        String username = request.getParameter("uname");
//        String password = request.getParameter("pass");
//        
//        
//            DAO dao = new DAO();
//            Account a = dao.getAccount(username, password);
//            
//            if(a == null ){
//                request.setAttribute("messErr", "Wrong username and password,Please reEnter");
//                request.getRequestDispatcher("Login.jsp").forward(request, response);
//            }
//            else {
//                String remember = request.getParameter("remember");
//                if(remember !=null)
//            {
//                Cookie c_user = new Cookie("username", username);
//                Cookie c_pass = new Cookie("password", password);
//                c_user.setMaxAge(10*30);
//                c_pass.setMaxAge(10*30);
//                response.addCookie(c_pass);
//                response.addCookie(c_user);
//            }
//                HttpSession session = request.getSession();
//                session.setAttribute("account", a);
//                response.sendRedirect("home");
//            }
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
