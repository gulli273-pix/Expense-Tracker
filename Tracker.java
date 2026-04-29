import java.util.Scanner;

public class Tracker {
    Scanner scanner = new Scanner(System.in);
    Manager manager = new Manager();

        public void start() {
            while (true) {
                System.out.println("\n Welcome to Personal Finance Tracker!");
                System.out.println("1. Add Income");
                System.out.println("2. Add Expense");
                System.out.println("3. View Transaction History");
                System.out.println("4. View Summary");
                System.out.println("5. Exit");
                System.out.println("Select an option");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter the income amount: ");
                        double incomeAmount = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Enter the income description: ");
                        String incomeDescription = scanner.nextLine();
                        manager.addTransaction("Income", incomeAmount, incomeDescription);
                    }
                    case 2 -> {
                        System.out.println("Enter the expense amount: ");
                        double expenseAmount = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Enter the expense description: ");
                        String expenseDescription = scanner.nextLine();
                        manager.addTransaction("Expense", expenseAmount, expenseDescription);
                    }
                    case 3 -> manager.viewTransactions();

                    case 4 -> manager.viewSummary();

                    case 5 -> {
                        System.out.println("Exiting... Goodbye");
                        scanner.close();
                        return;
                    }

                    default -> System.out.println("Invalid choice. Please try again");
                }
            }
        }
}