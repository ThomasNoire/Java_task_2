package dut.pd3.practics.practic_2.FinanceAnalyzer;
import org.example.Transaction;
import org.example.TransactionAnalyzer;
import org.example.TransactionCSVReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";

        // Виклик статичного методу без створення екземпляру класу
        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

        // Виклик статичного методу без створення екземпляру класу
        double totalBalance = TransactionAnalyzer.calculateTotalBalance(transactions);

        System.out.println("Загальний баланс: " + totalBalance);
    }
}
