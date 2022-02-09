package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Category;
import model.Collection;
import model.Order;
import model.Product;

/**
 *
 * @author win
 */
public class ProductListServlet extends HttpServlet {

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
        HttpSession session = request.getSession();   
        Account account =(Account) session.getAttribute("account");
        if(account!=null){
            session.setAttribute("sizeCart", dao.loadCart(account.getAccId()).size());
            ArrayList<Order> orders = dao.load4Cart(account.getAccId());
            session.setAttribute("orders", orders);
        }
        String page = request.getParameter("page");
         if(page == null || page.length() == 0)
             page = "1";
         int pageindex = Integer.parseInt(page);
         int pagesize = 12;
         int totalrow = dao.count();
         int totalpage = (totalrow%pagesize==0)?totalrow/pagesize:totalrow/pagesize + 1  ;
        ArrayList<Product> products = dao.paging(pageindex, pagesize);
       
     
        request.setAttribute("totalpage", totalpage);
        request.setAttribute("pageindex", pageindex);    
        
        ArrayList<Category> prdCategorys = dao.getprdCategorys();
        ArrayList<Collection> getCollections = dao.getAllCollection();
        ArrayList<String> statuses = dao.getprdStatus();
        
        if(products.size()==0){
            request.setAttribute("mess", "Empty");
        }
        request.setAttribute("statuses", statuses);
        request.setAttribute("products", products);
        request.setAttribute("prdCates", prdCategorys);
        request.setAttribute("collections", getCollections);    

        
        request.getRequestDispatcher("Category.jsp").forward(request, response);
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
