import org.example.Transaction;
import org.example.TransactionCSVReader;
import org.example.TransactionReportGenerator; // Додайте цей імпорт
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TransactionCSVReaderTest {

    @Test
    // перевіряє, чи список транзакцій не null і не пустий.
    public void testReadTransactions() {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";
        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

        assertNotNull(transactions, "Список транзакцій не повинен бути null");
        assertFalse(transactions.isEmpty(), "Список транзакцій не повинен бути порожнім");
    }

    @Test
// перевіряє, що список топ 10 витрат не null, містить 10 елементів і всі транзакції мають від'ємну суму
    public void testTop10Expenses() {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";
        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

        List<Transaction> top10Expenses = TransactionReportGenerator.getTop10Expenses(transactions);

        assertNotNull(top10Expenses, "Список топ 10 витрат не повинен бути null");
        assertEquals(10, top10Expenses.size(), "Список топ 10 витрат повинен містити 10 елементів");

        for (Transaction transaction : top10Expenses) {
            assertTrue(transaction.getAmount() < 0, "Транзакція повинна бути витратою (сума < 0)");
        }
    }
}
