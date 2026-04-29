import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {
    private final List<Transactions> transactions = new ArrayList<>();
    private int nextId = 1;

    public void addTransaction(String type, double amount, String description){
        Transactions transaction = new Transactions(nextId++, type, amount, LocalDate.now(), description);
        transactions.add(transaction);
        System.out.println("Transaction added sucessfully.");
    }

    public void viewTransactions(){
        if(transactions.isEmpty()){
            System.out.println("No transaction found");
            return;
        }
        System.out.println("Transaction History:");
        for(Transactions t : transactions){
            System.out.println(t);
        }
    }

    public void viewSummary(){
        double totalIncome = 0;
        double totalExpense = 0;
        Map<String, Double> categoryTotals = new HashMap<>();

        for(Transactions t : transactions){
            if(t.getType().equals("Income")){
                totalIncome += t.getAmount();
            }else{
                totalExpense += t.getAmount();
            }
        }

        System.out.println("\nSummary: ");
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expense: " + totalExpense);
        System.out.println("Remaing Balance: " + (totalIncome-totalExpense));
        }
}