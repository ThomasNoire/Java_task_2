package org.example;

import java.util.List;
import java.util.stream.Collectors;

public final class TransactionReportGenerator {

    // Приватний конструктор для запобігання створенню екземплярів
    private TransactionReportGenerator() {
    }

    // Статичний метод для виведення загального балансу
    public static void printBalanceReport(double totalBalance) {
        System.out.println("Загальний баланс: " + totalBalance);
    }

    // Статичний метод для виведення кількості транзакцій за певний місяць
    public static void printTransactionsCountByMonth(String monthYear, int count) {
        System.out.println("Кількість транзакцій за " + monthYear + ": " + count);
    }

    // Статичний метод для виведення 10 найбільших витрат
    public static void printTopExpenses(List<Transaction> transactions, int topN) {
        System.out.println("10 найбільших витрат:");
        transactions.stream()
                .filter(t -> t.getAmount() < 0) // Фільтруємо лише витрати (негативні значення)
                .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount())) // Сортуємо по спаданню
                .limit(topN) // Беремо перші topN витрат
                .forEach(t -> System.out.println(t.getDescription() + ": " + t.getAmount()));
    }

    // Доданий статичний метод для отримання топ 10 витрат
    public static List<Transaction> getTop10Expenses(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))
                .limit(10)
                .collect(Collectors.toList()); // Використовуйте .toList() для Java 16+
    }

    // Доданий статичний метод для виведення звіту витрат по категоріях та місяцях
    public static void printExpenseSummaryByCategoryAndMonth(List<Transaction> transactions) {
        System.out.println("Звіт витрат по категоріях та місяцях:");
        transactions.stream()
                .filter(t -> t.getAmount() < 0) // Тільки витрати
                .collect(Collectors.groupingBy(
                        t -> t.getDate().substring(0, 7), // Групування по місяцю (формат YYYY-MM)
                        Collectors.groupingBy(Transaction::getDescription, Collectors.summingDouble(Transaction::getAmount))
                ))
                .forEach((month, categoryMap) -> {
                    System.out.println("Місяць: " + month);
                    categoryMap.forEach((category, total) -> {
                        int symbols = (int) Math.abs(total / 1000); // Кількість символів залежить від суми витрат
                        System.out.println(category + ": " + "*".repeat(symbols) + " (" + total + ")");
                    });
                    System.out.println();
                });
    }
}
