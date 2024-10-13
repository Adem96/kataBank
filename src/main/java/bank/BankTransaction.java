package bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankTransaction {
    private double balance;
    private List<Transaction> transactions;

    public BankTransaction() {
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        transactions.add(new Transaction(+amount, balance, LocalDate.now()));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
        transactions.add(new Transaction(-amount, balance, LocalDate.now()));
    }

    public List<Transaction> getTransactionHistory() {
        return transactions;
    }

    public double getBalance() {
        return balance;
    }
}
