import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Transaction class to record each transaction
class Transaction {
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}

// ATM class to manage account operations
class ATM {
    private double balance;
    private List<Transaction> transactionHistory;

    public ATM(double balance) {
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public void transfer(double amount, ATM recipient) {
        if (balance >= amount) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.add(new Transaction("Transfer to " + recipient.hashCode(), amount));
            System.out.println("Transfer successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Transfer failed.");
        }
    }

    public void showBalance() {
        System.out.println("Current balance: " + balance);
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.getType() + ": " + transaction.getAmount());
        }
    }
}

// Main class to interact with the ATM interface
public class ATM_Interface {
    public static void main(String[] args) {
        ATM atm1 = new ATM(1000.0); // Starting balance for ATM 1
        ATM atm2 = new ATM(500.0);  // Starting balance for ATM 2

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Show Balance");
            System.out.println("5. Transaction History");
            System.out.println("6. Quit");

            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atm1.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm1.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    atm1.transfer(transferAmount, atm2);
                    break;
                case 4:
                    atm1.showBalance();
                    break;
                case 5:
                    atm1.displayTransactionHistory();
                    break;
                case 6:
                    System.out.println("Exiting ATM. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }

        scanner.close();
    }
}
