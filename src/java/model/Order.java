package model;

import dal.DAO;

/**
 *
 * @author win
 */
public class Order {
    private int ordId;
    private String prdId;
    private String prdName;
    private int prdSize;
    private int prdPrice;
    private int prdQuantity;
    private int prdTotal;
    private String prdImg;

    public Order() {
    }

    public Order(int ordId, String prdId, String prdName, int prdSize, int prdPrice, int prdQuantity, int prdTotal, String prdImg) {
        this.ordId = ordId;
        this.prdId = prdId;
        this.prdName = prdName;
        this.prdSize = prdSize;
        this.prdPrice = prdPrice;
        this.prdQuantity = prdQuantity;
        this.prdTotal = prdTotal;
        this.prdImg = prdImg;
    }

    public int getOrdId() {
        return ordId;
    }

    public void setOrdId(int ordId) {
        this.ordId = ordId;
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

    public int getPrdSize() {
        return prdSize;
    }

    public void setPrdSize(int prdSize) {
        this.prdSize = prdSize;
    }

    public int getPrdPrice() {
        return prdPrice;
    }

    public void setPrdPrice(int prdPrice) {
        this.prdPrice = prdPrice;
    }

    public int getPrdQuantity() {
        return prdQuantity;
    }

    public void setPrdQuantity(int prdQuantity) {
        this.prdQuantity = prdQuantity;
    }

    public int getPrdTotal() {
        return prdTotal;
    }

    public void setPrdTotal(int prdTotal) {
        this.prdTotal = prdTotal;
    }

    public String getPrdImg() {
        return prdImg;
    }

    public void setPrdImg(String prdImg) {
        this.prdImg = prdImg;
    }

    
    public int getMaxQuantity(){
      DAO dao = new DAO();
        return dao.getAmount(prdName, prdSize);
    }
  

    @Override
    public String toString() {
        return "Order{" + "ordId=" + ordId + ", prdName=" + prdName + ", prdSize=" + prdSize + ", prdPrice=" + prdPrice + ", prdQuantity=" + prdQuantity + ", prdTotal=" + prdTotal + ", prdImg=" + prdImg + '}';
    }

    
    
}
