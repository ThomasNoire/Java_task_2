//import org.example.Transaction;
//import org.example.TransactionCSVReader;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//import java.util.List;
//
//public class TransactionCSVReaderTest {
//
//    @Test
//    public void testReadTransactions() {
//        String filePath = "https://informer.com.ua/dut/java/pr2.csv";  // Зміни цей шлях на правильний
//        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);
//
//        assertNotNull(transactions);
//        assertTrue(transactions.size() > 0);
//    }
//
//    @Test
//    public void testTop10Expenses() {
//        String filePath = "https://informer.com.ua/dut/java/pr2.csv";  // Зміни цей шлях на правильний
//        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);
//
//        Object TransactionReportGenerator;
//        List<Transaction> top10Expenses = TransactionReportGenerator.getTop10Expenses(transactions);
//
//        assertEquals(10, top10Expenses.size());
//        assertTrue(top10Expenses.get(0).getAmount() < 0);  // Перевіряємо, що це витрати
//    }
//}
import org.example.Transaction;
import org.example.TransactionCSVReader;
import org.example.TransactionReportGenerator; // Додайте цей імпорт
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TransactionCSVReaderTest {

    @Test
    public void testReadTransactions() {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";
        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

        assertNotNull(transactions, "Список транзакцій не повинен бути null");
        assertFalse(transactions.isEmpty(), "Список транзакцій не повинен бути порожнім");
    }

    @Test
    public void testTop10Expenses() {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";
        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

        // Виклик статичного методу без створення екземпляру
        List<Transaction> top10Expenses = TransactionReportGenerator.getTop10Expenses(transactions);

        assertNotNull(top10Expenses, "Список топ 10 витрат не повинен бути null");
        assertEquals(10, top10Expenses.size(), "Список топ 10 витрат повинен містити 10 елементів");

        for (Transaction transaction : top10Expenses) {
            assertTrue(transaction.getAmount() < 0, "Транзакція повинна бути витратою (сума < 0)");
        }
    }
}
