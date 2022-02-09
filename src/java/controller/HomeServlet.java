package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Order;
import model.Product;

/**
 *
 * @author win
 */
public class HomeServlet extends HttpServlet {

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

            DAO dao = new DAO();
            ArrayList<Product> productsNewArrival = dao.getNewArrivals();
            ArrayList<Product> productsBestSeller = dao.getBestSeller();
            ArrayList<Product> Collections = dao.getCollections("pattas");
            ArrayList<Order> orders = new ArrayList<>();
            request.setAttribute("pattasclt", Collections); 
            request.setAttribute("productsNewArr", productsNewArrival);
            request.setAttribute("productsBestSe", productsBestSeller);
//            ---------------------------------------------------------------->>

        HttpSession session = request.getSession();
        Account account =(Account) session.getAttribute("account");
        if(account != null){
            orders = dao.load4Cart(account.getAccId());
        }        
        if(account == null){
            Cookie[] cookies = request.getCookies();
            if(cookies!=null){
           
                String usernameRe = "";
                String passwordRe = "";
                for(Cookie cook: cookies){
                    if(cook.getName().equals("username")){
                        usernameRe = cook.getValue();
                    }
                    if(cook.getName().equals("password")){
                        passwordRe = cook.getValue();
                    }
                }
                
            account = dao.getAccount(usernameRe, passwordRe);
                if(account!=null){
                    session.setAttribute("account", account);
                    orders = dao.load4Cart(account.getAccId());
                }
            }
        }
        session.setAttribute("orders", orders);
        session.setAttribute("sizeCart", orders.size());
        
        request.getRequestDispatcher("Home.jsp").forward(request, response);
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
