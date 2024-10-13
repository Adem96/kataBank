import java.util.List;

import bank.BankService;
import bank.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankServiceTest {
    private BankService bankService;

    @BeforeEach
    void setUp() {
        bankService = new BankService();
    }

    @Test
    void testDeposit() {
        bankService.deposit(1000.0);
        assertEquals(1000.0, bankService.getBalance());
    }

    @Test
    void testWithdraw() {
        bankService.deposit(1000.0);
        bankService.withdraw(250.0);
        assertEquals(750.0, bankService.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        bankService.deposit(1000.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bankService.withdraw(1100.0);
        });
        assertEquals("Insufficient Balance", exception.getMessage());
    }

    @Test
    void testTransactionHistory() {
        bankService.deposit(1000.0);
        bankService.withdraw(250.0);
        List<Transaction> transactions = bankService.getStatement();
        assertEquals(2, transactions.size());
        assertEquals(1000.0, transactions.get(0).getAmount());
        assertEquals(-250.0, transactions.get(1).getAmount());
    }
}
