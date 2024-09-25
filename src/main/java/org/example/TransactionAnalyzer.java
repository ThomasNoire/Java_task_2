package org.example;

import java.util.List;

public abstract class TransactionAnalyzer {

    public static double calculateTotalBalance(List<Transaction> transactions) {
        return transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();

    }

public static int countTransactionsByMonth(List<Transaction> transactions, String monthYear) {
    return (int) transactions.stream()
            .filter(t -> {
                String[] dateParts = t.getDate().split("-");
                return dateParts[1].equals(monthYear.split("-")[1]) && dateParts[2].equals(monthYear.split("-")[0]);
            })
            .count();
}

}


