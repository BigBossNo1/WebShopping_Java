package Entity;

public class Orders {

    private int order_id;
    private int customer_id;
    private String customer_name;
    private String customeraddress;
    private String customer_phone;
    private String create_date;
    private int status;

    public Orders() {
    }

    public Orders(int order_id, int customer_id, String customer_name, String customeraddress, String customer_phone, String create_date, int status) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customeraddress = customeraddress;
        this.customer_phone = customer_phone;
        this.create_date = create_date;
        this.status = status;
    }

    public Orders(int customer_id, String customer_name, String customeraddress, String customer_phone, String create_date, int status) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customeraddress = customeraddress;
        this.customer_phone = customer_phone;
        this.create_date = create_date;
        this.status = status;
    }
    

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomeraddress() {
        return customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
