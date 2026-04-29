import java.time.LocalDate;

public class Transactions {
    private int id;
    private String Type;
    private double amount;
    private LocalDate date;
    private String description;

    public Transactions(int id, String type, double amount, LocalDate date, String description) {
        this.id = id;
        Type = type;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Transaction{" +
                "id=" + id +
                ", Type='" + Type + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}