import java.util.Scanner;

public class Tracker {
  Scanner scanner = new Scanner(System.in);
  Manager manager = new Manager();

  public void start() {
    while (true) {
      System.out.println("---------------------------------------------");
      System.out.println(" $$$$    My Personal Finance Tracker    $$$$");
      System.out.println("---------------------------------------------");
      System.out.println("1. Add Income");
      System.out.println("2. Add Expense");
      System.out.println("3. View History");
      System.out.println("4. View Summary");
      System.out.println("5. View My Habits");
      System.out.println("6. Edit Transactions");
      System.out.println("7. Exit");
      System.out.println("---------------------------------------------");
      int choice = scanner.nextInt();
      scanner.nextLine();
      System.out.println("---------------------------------------------");

      switch (choice) {
        case 1 -> {
          System.out.println("Enter the income amount: ");
          double amount = scanner.nextDouble();
          scanner.nextLine();
          if (amount < 0) {
            System.out.println("Income cannot be < 0.");
            return;
          }
          System.out.println("Enter the income payer: ");
          String payer = scanner.nextLine();
          if (payer.isBlank()) {
            System.out.println("Payer cannot be blank.");
            return;
          }
          System.out.println("Enter the income description: ");
          String description = scanner.nextLine();
          if (description.isBlank()) {
            System.out.println("Description cannot be blank.");
            return;
          }
          manager.addTransaction("Income", payer, amount, description);
        }
        case 2 -> {
          System.out.println("Enter the expense amount: ");
          double amount = scanner.nextDouble();
          scanner.nextLine();
          if (amount < 0) {
            System.out.println("Expense cannot be < 0.");
            return;
          }
          System.out.println("Enter the expense payee: ");
          String payee = scanner.nextLine();
          if (payee.isBlank()) {
            System.out.println("Payee cannot be blank.");
            return;
          }
          System.out.println("Enter the expense description: ");
          String description = scanner.nextLine();
          if (description.isBlank()) {
            System.out.println("Description cannot be blank.");
            return;
          }
          manager.addTransaction("Expense", payee, amount, description);
        }
        case 3 -> manager.viewTransactions();

        case 4 -> manager.viewSummary();

        case 5 -> manager.viewHabits();

        case 6 -> manager.editTransactions(scanner);

        case 7 -> {
          System.out.println("Exiting...");
          scanner.close();
          return;
        }

        default -> System.out.println("Invalid choice. Try again");
      }
    }
  }
}
