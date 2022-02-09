package controller.manager;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;

/**
 *
 * @author win
 */
@WebServlet(name = "CreateProduct", urlPatterns = {"/createproduct"})
public class CreateProduct extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateProduct</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateProduct at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
               
            
            
        }
    }
//http://localhost:8084/PrjAssign/ProductCreate.jsp
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
        request.setCharacterEncoding("UTF-8");
        DAO dao = new DAO();
        ArrayList<Category> prdCategorys = dao.getprdCategorys();
        request.setAttribute("prdCates", prdCategorys);
        request.getRequestDispatcher("ProductCreate.jsp").forward(request, response);
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
    request.setCharacterEncoding("UTF-8");
    PrintWriter out = response.getWriter();

    String prdId = request.getParameter("prdid");
    String prdName = request.getParameter("prdname");
    String prdForm = request.getParameter("prdform");
    String prdCategoryId = request.getParameter("prdcateid");
    String prdDescription = request.getParameter("prddes");
    int prdPrice = Integer.parseInt(request.getParameter("prdprice"));
    String prdStatus = request.getParameter("prdstatus");
    String prdImg1 = request.getParameter("prdimg1");
    String prdImg2 = request.getParameter("prdimg2");
    String prdImg3 = request.getParameter("prdimg3");
    String prdImg4 = request.getParameter("prdimg4");
    out.print(prdId+" "+prdName+" "+ prdForm+" "+prdCategoryId+" "+prdDescription +" "+ prdPrice+" "+ prdStatus+" "+prdImg1+
    " "+ prdImg2 + prdImg3 + prdImg4);
    
//    DAO dao = new DAO();
//    dao.insertProduct(prdId, prdName, prdForm, prdCategoryId, prdDescription, prdPrice, prdStatus, prdImg1, prdImg2, prdImg3, prdImg4);
    
//    response.sendRedirect("manageproduct");
//processRequest(request, response);
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
