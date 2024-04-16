package Entity;

public class ProductCategory {

    private int categoryID;
    private String categoryname;
    private boolean status;

    public ProductCategory() {
    }

    public ProductCategory(int categoryID, String categoryname, boolean status) {
        this.categoryID = categoryID;
        this.categoryname = categoryname;
        this.status = status;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
