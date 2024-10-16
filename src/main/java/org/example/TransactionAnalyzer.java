//package org.example;
//
//import java.util.List;
//import java.util.Optional;
//
//public final class TransactionAnalyzer {
//
//    // Приватний конструктор для запобігання створенню екземплярів
//    private TransactionAnalyzer() {
//    }
//
//    // Підрахунок кількості транзакцій за певний місяць
//    public static int countTransactionsByMonth(List<Transaction> transactions, String monthYear) {
//        return (int) transactions.stream()
//                .filter(t -> t.getDate().startsWith(monthYear))
//                .count();
//    }
//
//    public static Optional<Transaction> findLargestExpense(List<Transaction> transactions) {
//        return transactions.stream()
//                .filter(t -> t.getAmount() < 0)
//                .min((t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()));
//    }
//
//    // Пошук найменшої витрати за певний період
//    public static Optional<Transaction> findSmallestExpense(List<Transaction> transactions) {
//        return transactions.stream()
//                .filter(t -> t.getAmount() < 0)
//                .max((t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()));
//    }
//
//    // Додано метод для розрахунку загального балансу
//    public static double calculateTotalBalance(List<Transaction> transactions) {
//        return transactions.stream()
//                .mapToDouble(Transaction::getAmount)
//                .sum();
//    }
//}


package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public final class TransactionAnalyzer {

    // Приватний конструктор для запобігання створенню екземплярів
    private TransactionAnalyzer() {
    }

    // Підрахунок кількості транзакцій за певний місяць
    public static int countTransactionsByMonth(List<Transaction> transactions, String monthYear) {
        // Створення LocalDate без використання "-01"
        LocalDate targetMonth = LocalDate.parse(monthYear + "-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return (int) transactions.stream()
                .filter(t -> {
                    LocalDate transactionDate = LocalDate.parse(t.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    return transactionDate.getYear() == targetMonth.getYear() &&
                            transactionDate.getMonthValue() == targetMonth.getMonthValue();
                })
                .count();
    }


    public static Optional<Transaction> findLargestExpense(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .min((t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()));
    }

    public static Optional<Transaction> findSmallestExpense(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .max((t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()));
    }

    public static double calculateTotalBalance(List<Transaction> transactions) {
        return transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
}
