import java.time.LocalDate;

public class Transactions {
  private int id;
  private String Type;
  private double amount;
  private LocalDate date;
  private String description;
  private String payType;

  public Transactions(int id, String type, String payType, double amount, LocalDate date, String description) {
    this.id = id;
    Type = type;
    this.payType = payType;
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

  public String getPayType() {
    return payType;
  }

  public void setPayType(String payType) {
    this.payType = payType;
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
    return "Transaction:\n" +
        "  ID = " + id + "\n" +
        "  Type = '" + Type + "'\n" +
        "  Payer/Payee = '" + payType + "'\n" +
        "  Amount = " + amount + "\n" +
        "  Date = " + date + "\n" +
        "  Description = '" + description + "'";
  }
}
