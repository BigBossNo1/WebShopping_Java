package Entity;

public class Customer {

    private int customer_id;
    private String customer_name;
    private String phonenumber;
    private String email;
    private String customeraddress;

    public Customer() {
    }

    public Customer(int customer_id, String customer_name, String phonenumber, String email, String customeraddress) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.customeraddress = customeraddress;
    }

    public Customer(String customer_name, String phonenumber, String email, String customeraddress) {
        this.customer_name = customer_name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.customeraddress = customeraddress;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomeraddress() {
        return customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }

}
