package dal;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Category;

import model.Collection;
import model.Order;
import model.Product;
import model.Size;

/**
 *
 * @author win
 */
public class DAO {
     Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> products = new ArrayList<>();
        String query = "select p.*, pi.Img_src\n" +
                        "from Product p ,Prd_img pi\n" +
                        "where p.prdId=pi.prdId and pi.prdImgOrder=1";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPrdId(rs.getString("PrdId"));
                p.setPrdName(rs.getString("PrdName"));
                p.setPrdForm(rs.getString("PrdForm"));
                p.setPrdCategoryId(rs.getString("PrdCategoryId"));
                p.setPrdDescription(rs.getString("prdDescription"));
                p.setPrdPrice(rs.getInt("prdPrice"));
                p.setPrdStatus(rs.getString("prdStatus"));
                p.setPrdImgv(rs.getString("Img_src"));
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }
    public ArrayList<Product> paging(int pageindex, int pagesize)
   {
       String query = "with r as(\n" +
                        "select p.*,pi.Img_src\n" +
                        "from Product p, Prd_img pi\n" +
                        "where p.prdId=pi.prdId and pi.prdImgOrder=1),\n" +
                        "t as(\n" +
            "SELECT ROW_NUMBER() OVER (ORDER BY r.prdId ASC ) as rownum, r.*\n" +
            "From r)\n" +
            "select *\n" +
            " from t\n" +
            "WHERE\n" +
                    "rownum >= ((?-1) * ?) + 1 AND rownum <= ? * ?";
       ArrayList<Product> products = new ArrayList<>();
   
       try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, pageindex);
            ps.setInt(2, pagesize);
            ps.setInt(3, pageindex);
            ps.setInt(4, pagesize);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPrdId(rs.getString("PrdId"));
                p.setPrdName(rs.getString("PrdName"));
                p.setPrdForm(rs.getString("PrdForm"));
                p.setPrdCategoryId(rs.getString("PrdCategoryId"));
                p.setPrdDescription(rs.getString("prdDescription"));
                p.setPrdPrice(rs.getInt("prdPrice"));
                p.setPrdStatus(rs.getString("prdStatus"));
                p.setPrdImgv(rs.getString("Img_src"));
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
   }
    public ArrayList<Size> getAllSize() {
        ArrayList<Size> sizes = new ArrayList<>();
        String query = "select *\n" +
                        "from Prd_Size";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Size s = new Size(
                        rs.getString("prdId"),
                        rs.getInt("prdSize"),
                        rs.getInt("prdAmount")
                );
                sizes.add(s);
            }
        } catch (Exception e) {
        }
        return sizes;
    }
    public ArrayList<Size> pagingSize(int pageindex, int pagesize)
   {
       String query = "with r as(\n" +
                    "select *\n" +
                    "from  Prd_Size\n" +
                    "),\n" +
                    "t as(\n" +
            "SELECT ROW_NUMBER() OVER (ORDER BY r.prdId ASC ) as rownum, r.*\n" +
            "From r)\n" +
            "select *\n" +
            "from t\n" +
            "WHERE t.rownum >= ((?-1) * ?) + 1 AND t.rownum <= ? * ?";
       ArrayList<Size> sizes = new ArrayList<>();
   
       try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, pageindex);
            ps.setInt(2, pagesize);
            ps.setInt(3, pageindex);
            ps.setInt(4, pagesize);
            rs = ps.executeQuery();
            while (rs.next()) {
                Size s = new Size(
                        rs.getString("prdId"),
                        rs.getInt("prdSize"),
                        rs.getInt("prdAmount")
                );
                sizes.add(s);
            }
        } catch (Exception e) {
        }
        return sizes;
   }
    public ArrayList<Account> pagingAccount(int pageindex, int pagesize)
   {
       String query = "with r as(\n" +
                    "select *\n" +
                    "from  Account\n" +
                    "),\n" +
                "t as(\n" +
                "SELECT ROW_NUMBER() OVER (ORDER BY r.accId ASC ) as rownum, r.*\n" +
                "From r)\n" +
                "select *\n" +
                "from t\n" +
                "WHERE t.rownum >= ((?-1) * ?) + 1 AND t.rownum <= ? * ?";
       ArrayList<Account> accounts = new ArrayList<>();
   
       try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, pageindex);
            ps.setInt(2, pagesize);
            ps.setInt(3, pageindex);
            ps.setInt(4, pagesize);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(
                        rs.getInt("accId"),
                        rs.getString("username"), 
                        rs.getString("password"), 
                        rs.getString("firstName"), 
                        rs.getString("lastName"), 
                        rs.getBoolean("role"));
                accounts.add(a);
            }
        } catch (Exception e) {
        }
        return accounts;
   }
    
    public ArrayList<Product> getNewArrivals() {
        ArrayList<Product> products = new ArrayList<>();
        String query = "select top 6 p.*, pi.Img_src\n" +
                        "from Product p ,Prd_img pi\n" +
                        "where p.prdId=pi.prdId and pi.prdImgOrder=1 and p.prdStatus = 'new Arrival'";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPrdId(rs.getString("PrdId"));
                p.setPrdName(rs.getString("PrdName"));
                p.setPrdForm(rs.getString("PrdForm"));
                p.setPrdCategoryId(rs.getString("PrdCategoryId"));
                p.setPrdDescription(rs.getString("prdDescription"));
                p.setPrdPrice(rs.getInt("prdPrice"));
                p.setPrdStatus(rs.getString("prdStatus"));
                p.setPrdImgv(rs.getString("Img_src"));
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }
    public ArrayList<Product> getBestSeller() {
        ArrayList<Product> products = new ArrayList<>();
        String query = "select top 6 p.*, pi.Img_src\n" +
                        "from Product p ,Prd_img pi\n" +
                        "where p.prdId=pi.prdId and pi.prdImgOrder=1 and p.prdStatus = 'best seller'";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPrdId(rs.getString("PrdId"));
                p.setPrdName(rs.getString("PrdName"));
                p.setPrdForm(rs.getString("PrdForm"));
                p.setPrdCategoryId(rs.getString("PrdCategoryId"));
                p.setPrdDescription(rs.getString("prdDescription"));
                p.setPrdPrice(rs.getInt("prdPrice"));
                p.setPrdStatus(rs.getString("prdStatus"));
                p.setPrdImgv(rs.getString("Img_src"));
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }
    
    public ArrayList<Product> getPtCollections() {
        ArrayList<Product> products = new ArrayList<>();
        String query = "select p.*, pi.Img_src\n" +
                        "from Product p ,Prd_img pi,[Collection] c, Clt_Product cp\n" +
                        "where p.prdId=pi.prdId and pi.prdImgOrder=1 and c.cltId = cp.cltId and cp.prdId=p.prdId and c.cltName = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "Pattas");
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPrdId(rs.getString("PrdId"));
                p.setPrdName(rs.getString("PrdName"));
                p.setPrdForm(rs.getString("PrdForm"));
                p.setPrdCategoryId(rs.getString("PrdCategoryId"));
                p.setPrdDescription(rs.getString("prdDescription"));
                p.setPrdStatus(rs.getString("prdStatus"));
                p.setPrdPrice(rs.getInt("prdPrice"));
                p.setPrdImgv(rs.getString("Img_src"));
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }
    
    public ArrayList<Product> getPrdbyCid(String cid) {
        ArrayList<Product> products = new ArrayList<>();
        String query = "select p.*,pi.Img_src\n" +
                    "from Product p,Prd_img pi\n" +
                    "where p.prdId=pi.prdId and pi.prdImgOrder=1 and p.prdCategoryId = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPrdId(rs.getString("PrdId"));
                p.setPrdName(rs.getString("PrdName"));
                p.setPrdForm(rs.getString("PrdForm"));
                p.setPrdCategoryId(rs.getString("PrdCategoryId"));
                p.setPrdDescription(rs.getString("prdDescription"));
                p.setPrdPrice(rs.getInt("prdPrice"));
                p.setPrdStatus(rs.getString("prdStatus"));
                p.setPrdImgv(rs.getString("Img_src"));
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }
    
    public ArrayList<Product> getPrdbyClid(String clid) {
        ArrayList<Product> products = new ArrayList<>();
        String query = "select p.*,pi.Img_src\n" +
                        "from Clt_Product c,Product p, Prd_img pi\n" +
                        "where pi.prdImgOrder=1 and  c.prdId = p.prdId and pi.prdId=c.prdId and c.cltId = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, clid);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPrdId(rs.getString("PrdId"));
                p.setPrdName(rs.getString("PrdName"));
                p.setPrdForm(rs.getString("PrdForm"));
                p.setPrdCategoryId(rs.getString("PrdCategoryId"));
                p.setPrdDescription(rs.getString("prdDescription"));
                p.setPrdPrice(rs.getInt("prdPrice"));
                p.setPrdStatus(rs.getString("prdStatus"));
                p.setPrdImgv(rs.getString("Img_src"));
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }
    
    public ArrayList<Product> getPrdbyPrice(String pid) {
        ArrayList<Product> products = new ArrayList<>();
        String query = "select p.*,pi.Img_src\n" +
                    "from Product p,Prd_img pi\n" +
                    "where p.prdId=pi.prdId and pi.prdImgOrder=1 and p.prdPrice > ? and p.prdPrice < ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            int max=10000000,min=0;
            if(pid.equals("1")){
                min=400000; max=499000;
            }
            else if(pid.equals("2")){
                min=500000; max=599000;
            }
            else if(pid.equals("3")){
                min=600000; max=10000000;
            }
            ps.setInt(1, min);
            ps.setInt(2, max);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPrdId(rs.getString("PrdId"));
                p.setPrdName(rs.getString("PrdName"));
                p.setPrdForm(rs.getString("PrdForm"));
                p.setPrdCategoryId(rs.getString("PrdCategoryId"));
                p.setPrdDescription(rs.getString("prdDescription"));
                p.setPrdStatus(rs.getString("prdStatus"));
                p.setPrdPrice(rs.getInt("prdPrice"));
                p.setPrdImgv(rs.getString("Img_src"));
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }
    public ArrayList<Product> getPrdbyForm(String fid) {
        ArrayList<Product> products = new ArrayList<>();

        String query = "select p.*,pi.Img_src\n" +
                    "from Product p,Prd_img pi\n" +
                    "where p.prdId=pi.prdId and pi.prdImgOrder=1 and p.prdForm = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, fid);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPrdId(rs.getString("PrdId"));
                p.setPrdName(rs.getString("PrdName"));
                p.setPrdForm(rs.getString("PrdForm"));
                p.setPrdCategoryId(rs.getString("PrdCategoryId"));
                p.setPrdDescription(rs.getString("prdDescription"));
                p.setPrdPrice(rs.getInt("prdPrice"));
                p.setPrdStatus(rs.getString("prdStatus"));
                p.setPrdImgv(rs.getString("Img_src"));
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }
     public ArrayList<Product> getPrdbyStatus(String status) {
        ArrayList<Product> products = new ArrayList<>();

        String query = "select p.*, pi.Img_src\n" +
                        "from Product p ,Prd_img pi\n" +
                        "where p.prdId=pi.prdId and pi.prdImgOrder=1 and p.prdStatus = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPrdId(rs.getString("PrdId"));
                p.setPrdName(rs.getString("PrdName"));
                p.setPrdForm(rs.getString("PrdForm"));
                p.setPrdCategoryId(rs.getString("PrdCategoryId"));
                p.setPrdDescription(rs.getString("prdDescription"));
                p.setPrdPrice(rs.getInt("prdPrice"));
                p.setPrdStatus(rs.getString("prdStatus"));
                p.setPrdImgv(rs.getString("Img_src"));
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }
     public ArrayList<Product> getCollections(String name) {
        ArrayList<Product> collections = new ArrayList<>();
        try {
            String query = "select p.*, pi.Img_src, c.cltName\n" +
                        "from Product p ,Prd_img pi,[Collection] c, Clt_Product cp\n" +
                        "where p.prdId=pi.prdId and pi.prdImgOrder=1 and c.cltId = cp.cltId and cp.prdId=p.prdId and c.cltName = ?";
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            

             while(rs.next())
            {   
                Product p = new Product();
                p.setPrdId(rs.getString("PrdId"));
                p.setPrdName(rs.getString("PrdName"));
                p.setPrdForm(rs.getString("PrdForm"));
                p.setPrdCategoryId(rs.getString("PrdCategoryId"));
                p.setPrdDescription(rs.getString("prdDescription"));
                p.setPrdPrice(rs.getInt("prdPrice"));
                p.setPrdImgv(rs.getString("Img_src"));
                collections.add(p);
            }
                
        } catch (Exception e) {
            
        }
        return collections;
    }
    public ArrayList<Collection> getAllCollection() {
        ArrayList<Collection> collections = new ArrayList<>();
        try {
            String query = "select *\n" +
                            "from Collection";
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();
            

             while(rs.next())
            {   
                Collection c = new Collection();
                c.setCltId(rs.getString("cltId"));
                c.setCltName(rs.getString("cltName"));
                
                collections.add(c);
            }
                
        } catch (Exception e) {
            
        }
        return collections;
    }
    
    
    public ArrayList<Category> getprdCategorys() {
        ArrayList<Category> prdCates = new ArrayList<>();

            String query = "select *\n" +
                         "from Category";
    try {    
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next())
            {
               Category c = new Category();
               c.setCtgId(rs.getString("ctgId"));
               c.setCtgName(rs.getString("ctgName"));
               prdCates.add(c);
            }
        } catch (Exception e) {
            
        }
        return prdCates;
    }
    
    public Product getPrdbyId(String id){
         try {
            String query = "select p.*, pi.Img_src\n" +
            "from Product p ,Prd_img pi\n" +
            "where p.prdId=pi.prdId and pi.prdImgOrder=1 and p.prdId = ?";
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPrdId(rs.getString("PrdId"));
                p.setPrdName(rs.getString("PrdName"));
                p.setPrdForm(rs.getString("PrdForm"));
                p.setPrdCategoryId(rs.getString("PrdCategoryId"));
                p.setPrdDescription(rs.getString("prdDescription"));
                p.setPrdStatus(rs.getString("prdStatus"));
                p.setPrdPrice(rs.getInt("prdPrice"));
                p.setPrdImgv(rs.getString("Img_src"));
            return p;

            }
        } catch (Exception e) {
           
        }
        return null;
        
    }
    public ArrayList<String> getprdImgs(String id) {
        ArrayList<String> prdImgs = new ArrayList<>();
        try {
            String query = "select pi.Img_src\n" +
                    "from Product p ,Prd_img pi\n" +
                    "where p.prdId=pi.prdId and  p.prdId = ?";
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next())
            {
                String s = "";
                s = rs.getString("Img_src");
                prdImgs.add(s);
            }
        } catch (Exception e) {
            
        }
        return prdImgs;
    }
    public ArrayList<String> getprdStatus() {
        ArrayList<String> statuses = new ArrayList<>();
        try {
            String query = "select distinct prdStatus\n" +
                        "from Product\n" +
                        "where prdStatus is not null";
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next())
            {
                String s = "";
                s = rs.getString("prdStatus");
                statuses.add(s);
            }
        } catch (Exception e) {
            
        }
        return statuses;
    }
    
    public String get2ndImgsrc(String prdId){
        String imgSrc = "";

        String query = "select pi.Img_src\n" +
                "from Product p ,Prd_img pi\n" +
                "where p.prdId=pi.prdId and pi.prdImgOrder=2 and p.prdId = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,prdId);
            
            rs = ps.executeQuery();
             while (rs.next()) {
                imgSrc = rs.getString("Img_src");
            }  
        } catch (Exception e) {
        }
        return imgSrc;
    }
    
    public ArrayList<Product> searchProduct(String text) {
        ArrayList<Product> products = new ArrayList<>();

        String query = "select p.*,pi.Img_src\n" +
                      "from Product p,Prd_img pi\n" +
                      "where p.prdId=pi.prdId and pi.prdImgOrder=1 and (p.prdId like ? or p.prdName like ?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,"%" +  text +"%");
            ps.setString(2,"%" +  text +"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPrdId(rs.getString("PrdId"));
                p.setPrdName(rs.getString("PrdName"));
                p.setPrdForm(rs.getString("PrdForm"));
                p.setPrdCategoryId(rs.getString("PrdCategoryId"));
                p.setPrdDescription(rs.getString("prdDescription"));
                p.setPrdPrice(rs.getInt("prdPrice"));
                p.setPrdStatus(rs.getString("prdStatus"));
                p.setPrdImgv(rs.getString("Img_src"));
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }
    public ArrayList<Size> searchSize(String text) {
        ArrayList<Size> sizes = new ArrayList<>();

        String query = "select *\n" +
                       "from Prd_Size\n" +
                       "where prdId like ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,"%" +  text +"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Size s = new Size(
                    rs.getString("prdId"),
                    rs.getInt("prdSize"),
                    rs.getInt("prdAmount")
                );
                sizes.add(s);
            }
        } catch (Exception e) {
        }
        return sizes;
    }
    public ArrayList<Account> searchAccount(String text) {
        ArrayList<Account> accounts = new ArrayList<>();

        String query = "select *\n" +
                       "from Account\n" +
                       "where username like ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,"%" +  text +"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(
                        rs.getInt("accId"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getBoolean("role"));
                accounts.add(a);
            }
        } catch (Exception e) {
        }
        return accounts;
    }
    
//    Account---------
    public Account getAccount(String uname, String pass){
         try {
            String query = "select *\n" +
            "from Account a\n" +
            "where a.username = ? and a.password = ?";
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, pass);

            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getInt("accId"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getBoolean("role")
                        );
                
            return a;

            }
        } catch (Exception e) {
           
        }
        return null;
        
    }
    
    public Account checkAccount(String uname){
         try {
            String query = "select *\n" +
            "from Account a\n" +
            "where a.username = ?";
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, uname);

            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getInt("accId"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("firstName"),
                        rs.getString("lastName")
                        );
                
            return a;

            }
        } catch (Exception e) {
           
        }
        return null;
        
    }
    public void signUp(String username, String password, String repassword, String firstName, String lastName){
        String query = "INSERT INTO Account(username, [password], firstName, lastName, [role])\n" +
                        "VALUES (?, ?, ?, ?, ?);";
        try {
           
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, firstName);
            ps.setString(4, lastName);
            ps.setBoolean(5, true);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    
    
    
    public int count()
   {
       String query = "SELECT COUNT(*) as totalrow FROM product";
       try {
           conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();
           if(rs.next())
           {
               return rs.getInt("totalrow");
           }
       } catch (Exception e) {
           
       }
       return 0;
   }
    public int countSize()
   {
       String query = "SELECT COUNT(*) as totalrow FROM Prd_Size";
       try {
           conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();
           if(rs.next())
           {
               return rs.getInt("totalrow");
           }
       } catch (Exception e) {
           
       }
       return 0;
   }
    public int countAccount()
   {
       String query = "SELECT COUNT(*) as totalrow FROM Account";
       try {
           conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();
           if(rs.next())
           {
               return rs.getInt("totalrow");
           }
       } catch (Exception e) {
           
       }
       return 0;
   }
    
//    BUY
//    get size
    public ArrayList<Integer> getSizes(String prdId){
        ArrayList<Integer> sizes = new ArrayList<>();

        String query = "select ps.prdSize\n" +
                        "from Product p ,Prd_Size ps\n" +
                        "where p.prdId=ps.prdId and p.prdId = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,prdId);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                int s = rs.getInt("prdSize");
                
                sizes.add(s);
            }
        } catch (Exception e) {
        }
        return sizes;
    }
//    get Quantity
     public int getAmount(String prdName, int prdSize){
        int amount = 0;

        String query = "select ps.prdAmount\n" +
                        "from Product p ,Prd_Size ps\n" +
                        "where p.prdId=ps.prdId and p.prdName = ? and prdSize = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,prdName);
            ps.setInt(2,prdSize);
            rs = ps.executeQuery();
             while (rs.next()) {
                amount = rs.getInt("prdAmount");
            }  
            
            
        } catch (Exception e) {
        }
        return amount;
    }
    
     public void addCart(int accId, String prdId, int prdSize, int prdAmount){
        String query = "insert into Orders(accId, prdId, prdSize, prdAmount, ordPay)\n" +
                        "VALUES (?, ?, ?, ?, ?);";
        try {
           
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, accId);
            ps.setString(2, prdId);
            ps.setInt(3, prdSize);
            ps.setInt(4, prdAmount);
            ps.setBoolean(5, false);

            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
     public void reAddCart(int ordId){
        String query = "UPDATE Orders SET ordPay = 'false' WHERE ordId = ? ;";
        try {
           
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, ordId);

            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    public ArrayList<Order> loadCart(int accId){
        ArrayList<Order> orders = new ArrayList<>();

        String query = "select o.*,p.prdName,p.prdPrice,pi.Img_src\n" +
                              "from Prd_img pi, Orders o,Product p\n" +
        "where pi.prdImgOrder=1 and  o.prdId=p.prdId and pi.prdId=o.prdId and ordPay='false' and o.accId=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1,accId);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order(
                        rs.getInt("ordId"),
                        rs.getString("prdId"),
                        rs.getString("prdName"),
                        rs.getInt("prdSize"),
                        rs.getInt("prdPrice"),
                        rs.getInt("prdAmount"),
                        rs.getInt("prdPrice")*rs.getInt("prdAmount"),
                        rs.getString("Img_src")
                        
                );
                
                orders.add(o);
            }
        } catch (Exception e) {
        }
        return orders;
    } 
    public ArrayList<Order> load4Cart(int accId){
        ArrayList<Order> orders = new ArrayList<>();

        String query = "select top 4 o.*,p.prdName,p.prdPrice,pi.Img_src\n" +
                              "from Prd_img pi, Orders o,Product p\n" +
        "where pi.prdImgOrder=1 and  o.prdId=p.prdId and pi.prdId=o.prdId and ordPay='false' and o.accId=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1,accId);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order(
                        rs.getInt("ordId"),
                        rs.getString("prdId"),
                        rs.getString("prdName"),
                        rs.getInt("prdSize"),
                        rs.getInt("prdPrice"),
                        rs.getInt("prdAmount"),
                        rs.getInt("prdPrice")*rs.getInt("prdAmount"),
                        rs.getString("Img_src")
                        
                );
                
                orders.add(o);
            }
        } catch (Exception e) {
        }
        return orders;
    } 
    public void checkOutCart(int accId){
        String query = "UPDATE Orders SET ordPay = 'true' WHERE accId = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, accId);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    public ArrayList<Order> loadHistoryCart(int accId){
        ArrayList<Order> orders = new ArrayList<>();

        String query = "select o.*,p.prdName,p.prdPrice,pi.Img_src\n" +
                              "from Prd_img pi, Orders o,Product p\n" +
        "where pi.prdImgOrder=1 and  o.prdId=p.prdId and pi.prdId=o.prdId and ordPay='true' and o.accId=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1,accId);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order(
                        rs.getInt("ordId"),
                        rs.getString("prdId"),
                        rs.getString("prdName"),
                        rs.getInt("prdSize"),
                        rs.getInt("prdPrice"),
                        rs.getInt("prdAmount"),
                        rs.getInt("prdPrice")*rs.getInt("prdAmount"),
                        rs.getString("Img_src")
                        
                );
                
                orders.add(o);
            }
        } catch (Exception e) {
        }
        return orders;
    } 
    public Order checkOrder(int accId,String prdId, int prdSize){
         try {
            String query = "select o.*,p.prdName,p.prdPrice,pi.Img_src\n" +
"from Prd_img pi, Orders o,Product p\n" +
"where pi.prdImgOrder=1 and  o.prdId=p.prdId and pi.prdId=o.prdId and o.accId=? "
                    + " and o.prdId = ? and o.prdSize = ? and ordPay ='false' ";
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, accId);
            ps.setString(2, prdId);
            ps.setInt(3, prdSize);

            rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order(
                        rs.getInt("ordId"),
                        rs.getString("prdId"),
                        rs.getString("prdName"),
                        rs.getInt("prdSize"),
                        rs.getInt("prdPrice"),
                        rs.getInt("prdAmount"),
                        rs.getInt("prdPrice")*rs.getInt("prdAmount"),
                        rs.getString("Img_src")
                        );
                
            return o;

            }
        } catch (Exception e) {
           
        }
        return null;
        
    }
    public void updateAmount(int accId, String prdId, int prdSize, int newAmount){
        String query = "UPDATE Orders SET prdAmount = ? WHERE accId = ? and prdId = ? and prdSize = ?;";
        try {
           
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, newAmount);
            ps.setInt(2, accId);
            ps.setString(3, prdId);
            ps.setInt(4, prdSize);
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    public int getOrderAmount(int accId, String prdName, int prdSize){
        int amount = 0;
        String query = "select prdAmount from Orders where accId = ? and prdId = ? "
                + "and prdSize = ? ";

        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, accId);
            ps.setString(2,prdName);
            ps.setInt(3,prdSize);
            rs = ps.executeQuery();
             while (rs.next()) {
                amount = rs.getInt("prdAmount");
            }  
            
            
        } catch (Exception e) {
        }
        return amount;
    }
    public void deleteAllOrder(int accId){
        String query = "DELETE FROM Orders WHERE accId = ? and ordPay = 'false';";
        try {
           
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
           
            ps.setInt(1, accId);
            
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
     public void deleteHisOrder(int accId){
        String query = "DELETE FROM Orders WHERE accId = ? and ordPay = 'true';";
        try {
           
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
           
            ps.setInt(1, accId);
            
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    public void deleteOrderbyId(int ordId){
        String query = "DELETE FROM Orders WHERE ordId = ?;";
        try {
           
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
           
            ps.setInt(1, ordId);
            
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
//    CRUD______________________________________________________________________
    
    public Category getCtgbyId(String ctgid){
         try {
            String query = "select *\n" +
            "from Category where ctgId = ?";
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, ctgid);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category c = new Category(ctgid, rs.getString("ctgName"));

            return c;

            }
        } catch (Exception e) {
           
        }
        return null;
        
    }
    public void insertCategory(String cateId, String cateName){
        String query = "insert into Category(ctgId,ctgName)\n" +
                    "values(?,?)";
        try {
           
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
           
            ps.setString(1, cateId);
            ps.setString(2, cateName);
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    public void updateCategory(String cateId, String newcateName){
        String query = "update Category set ctgName = ? where ctgId = ?";
        try {
           
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
           
            ps.setString(1, newcateName);
            ps.setString(2, cateId);
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    
    public void deleteCategory(String cateId){
        String query = "delete from Clt_Product\n" +
            "where prdId in (select prdId from Product where prdCategoryId = ?)\n" +
            "delete from Orders\n" +
            "where prdId in (select prdId from Product where prdCategoryId = ?)\n" +
            "delete from Prd_Size\n" +
            "where prdId in (select prdId from Product where prdCategoryId = ?)\n" +
            "delete from Prd_img\n" +
            "where prdId in (select prdId from Product where prdCategoryId = ?)\n" +
            "delete from Product\n" +
            "where prdId in (select prdId from Product where prdCategoryId = ?)\n" +
            "delete from Category where ctgId = ?";
        try {
           
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
           
            ps.setString(1, cateId);
            ps.setString(2, cateId);
            ps.setString(3, cateId);
            ps.setString(4, cateId);
            ps.setString(5, cateId);
            ps.setString(6, cateId);
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    
//    Product
    public void insertProduct(String prdId, String prdName, String prdForm, String prdCategoryId, String prdDescription,
        int prdPrice, String prdStatus, String prdImg1, String prdImg2, String prdImg3, String prdImg4){
        String query = "insert into Product(prdId,prdName,prdForm,prdCategoryId,prdDescription,prdPrice,prdStatus)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?);\n" +
                    "insert into Prd_img(prdId,prdImgOrder,Img_src)\n" +
                    "Values (? , ?, ?),\n" +
"                   (? , ?, ?),\n" +
"                   (? , ?, ?),\n" +
"                   (? , ?, ?)";
        try {
           
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
           
            ps.setString(1, prdId);
            ps.setString(2, prdName);
            ps.setString(3, prdForm);
            ps.setString(4, prdCategoryId);
            ps.setString(5, prdDescription);
            ps.setInt(6, prdPrice);
            ps.setString(7, prdStatus);
            
            ps.setString(8,prdId );
            ps.setInt(9, 1);
            ps.setString(10, prdImg1);
            
            ps.setString(11,prdId );
            ps.setInt(12, 2);
            ps.setString(13, prdImg2);
            
            ps.setString(14,prdId );
            ps.setInt(15, 3);
            ps.setString(16, prdImg3);
            
            ps.setString(17,prdId );
            ps.setInt(18, 4);
            ps.setString(19, prdImg4);
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    public void updateProduct(String prdId, String prdName, String prdForm, String prdCategoryId, String prdDescription,
        int prdPrice, String prdStatus, String prdImg1, String prdImg2, String prdImg3, String prdImg4){
        String query = "update Product set prdName= ?,prdForm= ? ,prdCategoryId = ? ,prdDescription= ?, "
                + "prdPrice= ?,prdStatus = ? \n" +
                        "where prdId = ?		\n" +

            "update Prd_img set Img_src = ? \n" +
            "where prdId = ? and prdImgOrder = ? \n" +
            "update Prd_img set Img_src = ? \n" +
            "where prdId = ? and prdImgOrder = ? 		\n" +
            "update Prd_img set Img_src = ? \n" +
            "where prdId = ? and prdImgOrder = ?		\n" +
            "update Prd_img set Img_src = ? \n" +
            "where prdId = ? and prdImgOrder = ?";
        try {
           
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            
            ps.setString(1, prdName);
            ps.setString(2, prdForm);
            ps.setString(3, prdCategoryId);
            ps.setString(4, prdDescription);
            ps.setInt(5, prdPrice);
            ps.setString(6, prdStatus);
            ps.setString(7, prdId);
            
            ps.setString(8, prdImg1);
            ps.setString(9, prdId);
            ps.setInt(10, 1);
            
            ps.setString(11, prdImg2);
            ps.setString(12, prdId);
            ps.setInt(13, 2);
            
            ps.setString(14, prdImg3);
            ps.setString(15, prdId);
            ps.setInt(16, 3);
            
            ps.setString(17, prdImg4);
            ps.setString(18, prdId);
            ps.setInt(19, 4);
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    
    public void deleteProduct(String prdId){
        String query = "delete from Clt_Product\n" +
            "where prdId = ? \n" +
            "delete from Orders\n" +
            "where prdId = ? \n" +
            "delete from Prd_Size\n" +
            "where prdId = ? \n" +
            "delete from Prd_img\n" +
            "where prdId = ? \n" +
            "delete from Product\n" +
            "where prdId = ? ";
        try {
           
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
           
            ps.setString(1, prdId);
            ps.setString(2, prdId);
            ps.setString(3, prdId);
            ps.setString(4, prdId);
            ps.setString(5, prdId);
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
//    ###Size
    public Category getSizebyId(String ctgid){
         try {
            String query = "select *\n" +
            "from Category where ctgId = ?";
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, ctgid);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category c = new Category(ctgid, rs.getString("ctgName"));

            return c;

            }
        } catch (Exception e) {
           
        }
        return null;
        
    }
    public void insertSize(String prdId, int prdSize, int prdAmount){
        String query = "insert into Prd_Size(prdId,prdSize,prdAmount)\n" +
                        "values(? , ? , ?)";
        try {
           
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
           
            ps.setString(1, prdId);
            ps.setInt(2, prdSize);
            ps.setInt(3, prdAmount);
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    
    
    public void deleteSize(String prdId, int prdSize, int prdAmount){
        String query = "delete from Prd_Size\n" +
                        "where prdId = ? and prdSize = ? and prdAmount = ? ";
        try {
           
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
           
            ps.setString(1, prdId);
            ps.setInt(2, prdSize);
            ps.setInt(3, prdAmount);
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    
//    Account
    public Account getAccount(int accId){
         try {
            String query = "select *\n" +
            "from Account a\n" +
            "where a.accId = ? ";
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, accId);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getInt("accId"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getBoolean("role")
                        );
            return a;

            }
        } catch (Exception e) {
           
        }
        return null;
        
    }
    
     public void updateAccount(int accid, String username, String password, String fname, String lname,String accrole){
        String query = "UPDATE Account SET username = ?, password = ?, firstName = ?, lastName = ?, role = ? \n" +
                    "WHERE accId = ? ";
        try {
           
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
           
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fname);
            ps.setString(4, lname);
            ps.setString(5, accrole);
            ps.setInt(6, accid);
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    public void deleteAccount(int accid){
        String query = "delete from Account where accId = ? ";
        try {
           
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
           
            ps.setInt(1, accid);
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
         DAO dao = new DAO();
//        ArrayList<String> getprdImgs = prdDao.getprdImgs("A61095");
//        ArrayList<Product> prds = prdDao.getPtCollections();
//        ArrayList<Category> getprdCategorys = dao.getprdCategorys();
//        System.out.println(products.size());
//        Product p = dao.getPrdbyId("a61030");
        
//        ArrayList<Collect> getCollections = dao.getCollections("pattas");
//        ArrayList<Collection> getCollections = dao.getAllCollection();
        ArrayList<Account> accs = dao.searchAccount("tinh");
        ArrayList<Order> orders = dao.loadCart(1);
        ArrayList<Product> products = dao.paging(1, 10);

//        for(String s : statuses){
//            System.out.println(s);
//        }
        dao.insertProduct("minh", "minh", "minh", "2", "minh", 77, "minh", "1", "2", "3", "4");
        for(Product p : products){
            System.out.println(p.toString());
        }
//         System.out.println(dao.checkOrder(1, "A6T004", 42));
//         System.out.println(dao.getOrderAmount(1, "A6T004", 42));
//        System.out.println(dao.count());
//            Account a = dao.getAccount("minhduc", "123f45");
//        System.out.println(dao.get2ndImgsrc("a61105"));
//            int amount = dao.getAmount("A61033",38);
//            dao.addCart(1, "A61095", 42, 1);
    }
}
