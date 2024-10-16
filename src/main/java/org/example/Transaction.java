package org.example;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//@AllArgsConstructor
//@Data
//
//public class Transaction {
//    private String date;
//    private double amount;
//    private String description;
//
//
//    @Override
//    public String toString() {
//        return "Transaction{" +
//                "date='" + date + '\'' +
//                ", amount=" + amount +
//                ", description='" + description + '\'' +
//                '}';
//    }
//}
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Data
public class Transaction {
    private String date;
    private double amount;
    private String description;

    // Метод для перетворення дати з рядка у LocalDate
    public LocalDate getParsedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // Формат DD-MM-YYYY
        return LocalDate.parse(date, formatter);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date='" + date + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}

