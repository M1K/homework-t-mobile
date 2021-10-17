package cz.tmobile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.SneakyThrows;

class Solution {

    public String solution(String location) {
        List<Transaction> transactions = readTransactions(location);
        Map<String, Integer> numberMap = addNumbers(transactions);
        List<String> lines = formatTransactions(transactions, numberMap);
        return String.join("\n", lines);
    }

    @SneakyThrows
    List<Transaction> readTransactions(String location) {
        List<Transaction> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(location))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                Transaction transaction = new Transaction();
                transaction.setCompany(values[1].split("/")[0].trim());
                transaction.setFrequency(values[0].replaceAll("\"", "").trim());
                transaction.setDateTime(LocalDateTime.parse(values[2]
                        .replaceAll("\\s+", " ")
                        .trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

                transactions.add(transaction);
            }
        }

        return transactions;
    }

    Map<String, Integer> addNumbers(List<Transaction> transactions) {
        Map<String, Integer> numberMap = new HashMap<>();
        List<Transaction> transactionsSorted = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getDateTime))
                .collect(Collectors.toList());

        for (Transaction transaction : transactionsSorted) {
            int number = numberMap.getOrDefault(transaction.getCompany(), 0) + 1;
            transaction.setNumber(number);
            numberMap.put(transaction.getCompany(), number);
        }
        return numberMap;
    }

    List<String> formatTransactions(List<Transaction> transactions, Map<String, Integer> numberMap) {
        List<String> lines = new ArrayList<>(transactions.size());
        String prefix = "000";

        for (Transaction transaction : transactions) {
            int numberLength = String.valueOf(numberMap.get(transaction.getCompany())).length();
            String number = prefix + transaction.getNumber();
            number = number.substring(number.length() - numberLength);

            String line = transaction.getCompany() + "|" + number + "|" + transaction.getFrequency();
            lines.add(line);
        }

        return lines;
    }
}
