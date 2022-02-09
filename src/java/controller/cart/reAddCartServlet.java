package controller.cart;

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
public class reAddCartServlet extends HttpServlet {

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
            String ordId = request.getParameter("ordId");
            
            String prdId = request.getParameter("prdId");
            String prdSize = request.getParameter("prdSize");
            out.print(ordId+" "+prdSize+" "+prdId);
            DAO dao = new DAO();
            
            dao.deleteOrderbyId(Integer.parseInt(ordId));
            
            HttpSession session = request.getSession();
            Account a  = (Account)session.getAttribute("account");
            
            if(a.getAccId()>0 && prdId!=null && !prdSize.equals("")){
                if(dao.checkOrder(a.getAccId(), prdId, Integer.parseInt(prdSize))!=null){
                    int oldAmount = dao.getOrderAmount(a.getAccId(), prdId, Integer.parseInt(prdSize));
                    dao.updateAmount(a.getAccId(), prdId, Integer.parseInt(prdSize), oldAmount+1);
                }else{
                    dao.addCart(a.getAccId(), prdId, Integer.parseInt(prdSize), 1);
                }
            }
            

            request.getRequestDispatcher("loadcart").forward(request, response);
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
