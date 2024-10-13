package bank;

import java.util.List;

public class BankService {
    private BankTransaction transaction;

    public BankService() {
        this.transaction = new BankTransaction();
    }

    public void deposit(double amount) {
        transaction.deposit(amount);
    }

    public void withdraw(double amount) {
        transaction.withdraw(amount);
    }

    public List<Transaction> getStatement() {
        return transaction.getTransactionHistory();
    }

    public double getBalance() {
        return transaction.getBalance();
    }
}
