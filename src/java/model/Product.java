package model;

import dal.DAO;

/**
 *
 * @author win
 */
public class Product {
    private String prdId;
    private String prdName;
    private String prdForm;
    private String prdCategoryId;
    private String prdDescription;
    private int prdPrice;
    private String prdStatus;
    private String prdImgv;

    public Product() {
    }

    public Product(String prdId, String prdName, String prdForm, String prdCategoryId, String prdDescription, int prdPrice, String prdStatus, String prdImgv) {
        this.prdId = prdId;
        this.prdName = prdName;
        this.prdForm = prdForm;
        this.prdCategoryId = prdCategoryId;
        this.prdDescription = prdDescription;
        this.prdPrice = prdPrice;
        this.prdStatus = prdStatus;
        this.prdImgv = prdImgv;
    }

   
    

    public String getPrdId() {
        return prdId;
    }

    public void setPrdId(String prdId) {
        this.prdId = prdId;
    }

    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    public String getPrdForm() {
        return prdForm;
    }

    public void setPrdForm(String prdForm) {
        this.prdForm = prdForm;
    }

    public String getPrdCategoryId() {
        return prdCategoryId;
    }

    public void setPrdCategoryId(String prdCategoryId) {
        this.prdCategoryId = prdCategoryId;
    }

    public String getPrdDescription() {
        return prdDescription;
    }

    public void setPrdDescription(String prdDescription) {
        this.prdDescription = prdDescription;
    }

    public int getPrdPrice() {
        return prdPrice;
    }

    public void setPrdPrice(int prdPrice) {
        this.prdPrice = prdPrice;
    }

    public String getPrdImgv() {
        return prdImgv;
    }
    public String get2ndImgSrc(){
        DAO dao = new DAO();
        return dao.get2ndImgsrc(prdId);
    }
    public void setPrdImgv(String prdImgv) {
        this.prdImgv = prdImgv;
    }

    public String getPrdStatus() {
        return prdStatus;
    }

    public void setPrdStatus(String prdStatus) {
        this.prdStatus = prdStatus;
    }

    @Override
    public String toString() {
        return "Product{" + "prdId=" + prdId + ", prdName=" + prdName + ", prdForm=" + prdForm + ", prdCategoryId=" + prdCategoryId + ", prdDescription=" + prdDescription + ", prdPrice=" + prdPrice + ", prdStatus=" + prdStatus + ", prdImgv=" + prdImgv + '}';
    }
    
   
}
