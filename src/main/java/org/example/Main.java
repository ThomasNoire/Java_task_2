
package dut.pd3.practics.practic_2.FinanceAnalyzer;

import org.example.Transaction;
import org.example.TransactionAnalyzer;
import org.example.TransactionCSVReader;
import org.example.TransactionReportGenerator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";

        // Читаємо транзакції з CSV файлу
        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

        // Підрахунок загального балансу
        double totalBalance = TransactionAnalyzer.calculateTotalBalance(transactions);
        TransactionReportGenerator.printBalanceReport(totalBalance);

        // Підрахунок кількості транзакцій за січень 2024
        String monthYear = "2024-01"; // формат YYYY-MM
        int count = TransactionAnalyzer.countTransactionsByMonth(transactions, monthYear);
        TransactionReportGenerator.printTransactionsCountByMonth(monthYear, count);

        // Виведення 10 найбільших витрат
        TransactionReportGenerator.printTopExpenses(transactions, 10);
    }
}
