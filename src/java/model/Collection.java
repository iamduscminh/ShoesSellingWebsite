package model;

/**
 *
 * @author win
 */
public class Collection {
    private String cltId;
    private String cltName;

    public Collection() {
    }

    
    public Collection(String cltId, String cltName) {
        this.cltId = cltId;
        this.cltName = cltName;
    }

    public String getCltId() {
        return cltId;
    }

    public void setCltId(String cltId) {
        this.cltId = cltId;
    }

    public String getCltName() {
        return cltName;
    }

    public void setCltName(String cltName) {
        this.cltName = cltName;
    }

    @Override
    public String toString() {
        return "Collection{" + "cltId=" + cltId + ", cltName=" + cltName + '}';
    }
    
    
}
