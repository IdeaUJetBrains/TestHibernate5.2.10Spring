package notentity;

public class Bus {
    private int id;
    private String number;

    public Bus() {
    }

    public Bus(Integer id, String number) {
        this.id= id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}