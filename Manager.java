import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Manager {
  private final List<Transactions> transactions = new ArrayList<>();
  private int nextId = 1;

  public void addTransaction(String type, String payType, double amount, String description) {
    Transactions transaction = new Transactions(nextId++, type, payType, amount, LocalDate.now(), description);
    transactions.add(transaction);
    System.out.println("*************************** Transaction Added");
  }

  public void viewTransactions() {
    if (transactions.isEmpty()) {
      System.out.println("View History ******** No Transaction(s) Found");
      return;
    }
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("My History:");
    for (Transactions t : transactions) {
      System.out.println(t);
    }
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }

  public void viewSummary() {
    double totalIncome = 0;
    double totalExpense = 0;
    if (transactions.isEmpty()) {
      System.out.println("View Summary ******** No Transaction(s) Found");
      return;
    } else {
      for (Transactions t : transactions) {
        if (t.getType().equals("Income")) {
          totalIncome += t.getAmount();
        } else {
          totalExpense += t.getAmount();
        }
      }
    }
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("Summary: ");
    System.out.println("Total Income: " + totalIncome);
    System.out.println("Total Expense: " + totalExpense);
    System.out.println("Remaining Balance: " + (totalIncome - totalExpense));
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }

  public void viewHabits() {
    Map<String, Double> habitTotals = new HashMap<>();
    if (transactions.isEmpty()) {
      System.out.println("View Habits ********* No Transaction(s) Found");
      return;
    } else {
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("Habit Analysis: ");
      for (Transactions t : transactions) {
        if (t.getType().equals("Expense")) {
          habitTotals.put(t.getPayType().toLowerCase(),
              habitTotals.getOrDefault(t.getPayType().toLowerCase(), 0.0) + t.getAmount());
        }
      }
      habitTotals.entrySet().stream()
          .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
          .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }

  @SuppressWarnings("null")
  public void editTransactions(Scanner scanner) {
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("Enter ID of the transaction to edit: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    Transactions transactionToEdit = null;
    if (id <= 0) {
      System.out.println("Invalid ID.");
      return;
    } else {
      boolean found = false;
      for (Transactions t : transactions) {
        if (t.getId() == id) {
          transactionToEdit = t;
          found = true;
          break;
        }
      }
      if (!found) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("---------------------------------------------");
        System.out.println("************* Transaction with ID " + id + " not found");
        return;
      }
    }

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("What do you want to edit?");
    System.out.println("1. Type, 2. PayType, 3. Amount, 4. Description");

    switch (scanner.nextInt()) {
      case 1 -> {
        System.out.println("Enter new type (Income/Expense): ");
        String newType = scanner.nextLine();
        scanner.nextLine();
        if (newType.equalsIgnoreCase("Income") || newType.equalsIgnoreCase("Expense")) {
          transactionToEdit.setType(newType);
          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
          System.out.println("************ Transaction updated successfully");
          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } else {
          System.out.println("Invalid type.");
        }
      }
      case 2 -> {
        System.out.println("Enter new payer/payee: ");
        String newPayType = scanner.nextLine();
        scanner.nextLine();
        if (newPayType.isBlank()) {
          System.out.println("Invalid payer/payee.");
        } else {
          transactionToEdit.setPayType(newPayType);
          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
          System.out.println("************ Transaction updated successfully");
          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
      }
      case 3 -> {
        System.out.println("Enter new amount: ");
        double newAmount = scanner.nextDouble();
        scanner.nextLine();
        if (newAmount < 0) {
          System.out.println("Invalid amount.");
        } else {
          transactionToEdit.setAmount(newAmount);
          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
          System.out.println("************ Transaction updated successfully");
          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
      }
      case 4 -> {
        System.out.println("Enter new description: ");
        String newDescription = scanner.nextLine();
        scanner.nextLine();
        if (newDescription.isBlank()) {
          System.out.println("Invalid description.");
        } else {
          transactionToEdit.setDescription(newDescription);
          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
          System.out.println("************ Transaction updated successfully");
          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
      }
      default -> System.out.println("Invalid choice.");
    }
    /*
     * System.out.println("Enter new type (Income/Expense): ");
     * String newType = scanner.nextLine();
     * transactionToEdit.setType(newType);
     *
     * System.out.println("Enter new payer/payee: ");
     * String newPayType = scanner.nextLine();
     * transactionToEdit.setPayType(newPayType);
     *
     * System.out.println("Enter new amount: ");
     * double newAmount = scanner.nextDouble();
     * scanner.nextLine();
     * transactionToEdit.setAmount(newAmount);
     *
     * System.out.println("Enter new description: ");
     * String newDescription = scanner.nextLine();
     * transactionToEdit.setDescription(newDescription);
     */
  }
}
