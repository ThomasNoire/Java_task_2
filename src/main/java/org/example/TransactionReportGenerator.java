package org.example;

import java.util.List;

public abstract class TransactionReportGenerator {

    // Статичний метод для виведення загального балансу
    public static void printBalanceReport(double totalBalance) {
        System.out.println("Загальний баланс: " + totalBalance);
    }

    // Статичний метод для виведення кількості транзакцій за певний місяць
    public static void printTransactionsCountByMonth(String monthYear, int count) {
        System.out.println("Кількість транзакцій за " + monthYear + ": " + count);
    }

    // Новий статичний метод для виведення 10 найбільших витрат
    public static void printTopExpenses(List<Transaction> transactions, int topN) {
        System.out.println("10 найбільших витрат:");

        transactions.stream()
                .filter(t -> t.getAmount() < 0) // фільтруємо лише витрати (негативні значення)
                .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount())) // сортуємо по спаданню
                .limit(topN) // беремо перші topN витрат
                .forEach(t -> System.out.println(t.getDescription() + ": " + t.getAmount()));
    }
}
