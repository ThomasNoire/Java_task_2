

package org.example;

import java.util.List;

public abstract class TransactionAnalyzer {

    public static double calculateTotalBalance(List<Transaction> transactions) {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    public static int countTransactionsByMonth(List<Transaction> transactions, String monthYear) {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getDate().contains(monthYear)) {
                count++;
            }
        }
        return count;
    }
}







