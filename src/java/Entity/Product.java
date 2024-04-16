package Entity;

public class Product {

    private int product_id;
    private String product_name;
    private int categoryID;
    private double price;
    private int quantity;
    private boolean status;

    public Product() {
    }

    public Product(int product_id, String product_name, int categoryID, double price, int quantity, boolean status) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.categoryID = categoryID;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public Product(String product_name, int categoryID, double price, int quantity, boolean status) {
        this.product_name = product_name;
        this.categoryID = categoryID;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
