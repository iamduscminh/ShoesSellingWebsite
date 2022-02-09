package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Collection;
import model.Product;

/**
 *
 * @author win
 */
public class CategoryServlet extends HttpServlet {

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
            String stid = request.getParameter("stid");
            String cid = request.getParameter("cid");
            String fid = request.getParameter("fid");
            String clid = request.getParameter("cltid");
            String clname = request.getParameter("cltname");
        
            String pid = request.getParameter("pid");
            DAO dao = new DAO();
        ArrayList<Category> prdCategorys = dao.getprdCategorys();
        ArrayList<Collection> getCollections = dao.getAllCollection();
        ArrayList<String> statuses = dao.getprdStatus();
        request.setAttribute("prdCates", prdCategorys);
        request.setAttribute("collections", getCollections);
        request.setAttribute("statuses", statuses);
        
        if(stid!=null){
            ArrayList<Product> products = dao.getPrdbyStatus( statuses.get(Integer.parseInt(stid)));
            request.setAttribute("products", products);
            request.setAttribute("topNavSelect", statuses.get(Integer.parseInt(stid)));
        }
        else if(cid!=null){
            ArrayList<Product> products = dao.getPrdbyCid(cid);
            request.setAttribute("products", products);
            request.setAttribute("topNavSelect", prdCategorys.get(Integer.parseInt(cid)-1).getCtgName());
        
        }
        else if(fid!=null){
            ArrayList<Product> products = dao.getPrdbyForm(fid);
            request.setAttribute("products", products);
            String form = fid.toUpperCase();
            request.setAttribute("topNavSelect", form);
            
        }
        else if(clid!=null){
            ArrayList<Product> products = dao.getPrdbyClid(clid);
            request.setAttribute("products", products);
            request.setAttribute("topNavSelect", clname);
              
        }
        else if(pid!=null){
            ArrayList<Product> products = dao.getPrdbyPrice(pid);
            request.setAttribute("products", products);
            String price ="";
            if(pid.equals("1")){
                price = "400K - 499K";
            }
            else if(pid.equals("2")){
                price = "500K - 599K";
            }
            else if(pid.equals("3")){
                price = ">600K";
            }
            request.setAttribute("topNavSelect", price);
        }

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
