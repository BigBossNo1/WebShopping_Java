package Entity;

public class Staff {

    private int staff_id;
    private String staff_name;
    private String email;
    private String phonenumber;

    public Staff() {
    }

    public Staff(int staff_id, String staff_name, String email, String phonenumber) {
        this.staff_id = staff_id;
        this.staff_name = staff_name;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    public Staff(String staff_name, String email, String phonenumber) {
        this.staff_name = staff_name;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

}
