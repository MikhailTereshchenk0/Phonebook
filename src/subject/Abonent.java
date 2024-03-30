package subject;

public class Abonent extends Entity{
    private String name;
    private String phone;

    public Abonent(int id, String name, String phone) {
        super(id);
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
