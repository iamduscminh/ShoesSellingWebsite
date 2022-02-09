package model;

/**
 *
 * @author win
 */
public class Size {
    private String prdId;
    private int prdSize;
    private int prdAmount;

    public Size() {
    }

    public Size(String prdId, int prdSize, int prdAmount) {
        this.prdId = prdId;
        this.prdSize = prdSize;
        this.prdAmount = prdAmount;
    }

    public String getPrdId() {
        return prdId;
    }

    public void setPrdId(String prdId) {
        this.prdId = prdId;
    }

    public int getPrdSize() {
        return prdSize;
    }

    public void setPrdSize(int prdSize) {
        this.prdSize = prdSize;
    }

    public int getPrdAmount() {
        return prdAmount;
    }

    public void setPrdAmount(int prdAmount) {
        this.prdAmount = prdAmount;
    }

    @Override
    public String toString() {
        return "Size{" + "prdId=" + prdId + ", prdSize=" + prdSize + ", prdAmount=" + prdAmount + '}';
    }
    
    
}
