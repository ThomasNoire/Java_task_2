//package org.example;
//
//import java.util.List;
//
//public abstract class TransactionAnalyzer {
//
//    public static double calculateTotalBalance(List<Transaction> transactions) {
//        return transactions.stream()
//                .mapToDouble(Transaction::getAmount)
//                .sum();
//
//    }
//
//public static int countTransactionsByMonth(List<Transaction> transactions, String monthYear) {
//    return (int) transactions.stream()
//            .filter(t -> {
//                String[] dateParts = t.getDate().split("-");
//                return dateParts[1].equals(monthYear.split("-")[1]) && dateParts[2].equals(monthYear.split("-")[0]);
//            })
//            .count();
//}
//
//}
//
//


package org.example;

import java.util.List;
import java.util.Optional;

public final class TransactionAnalyzer {

    // Приватний конструктор для запобігання створенню екземплярів
    private TransactionAnalyzer() {
    }

    // Підрахунок кількості транзакцій за певний місяць
    public static int countTransactionsByMonth(List<Transaction> transactions, String monthYear) {
        return (int) transactions.stream()
                .filter(t -> t.getDate().startsWith(monthYear))
                .count();
    }

    // Пошук найбільшої витрати за певний період
    public static Optional<Transaction> findLargestExpense(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .min((t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()));
    }

    // Пошук найменшої витрати за певний період
    public static Optional<Transaction> findSmallestExpense(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .max((t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()));
    }

    // Додано метод для розрахунку загального балансу
    public static double calculateTotalBalance(List<Transaction> transactions) {
        return transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
}
