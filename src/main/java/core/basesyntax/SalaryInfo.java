package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryInfo {
    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        int salary = 0;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date1 = LocalDate.parse(dateFrom, formatter);
        LocalDate date2 = LocalDate.parse(dateTo, formatter);

        StringBuilder result = new StringBuilder();
        result.append("Report for period ").append(dateFrom).append("  - ").append(dateTo);

        for (int i = 0; i < names.length; i++) {
            salary = 0;
            for (int n = 0; n < data.length; n++) {
                String[] parts = data[n].split(" ");
                LocalDate dateToCheck = LocalDate.parse(parts[0], formatter);
                if (data[n].contains(names[i]) && !dateToCheck.isBefore(date1)
                        && !dateToCheck.isAfter(date2)) {
                    salary += Integer.parseInt(parts[2]) * Integer.parseInt(parts[3]);
                }
            }
            result.append("\n").append(names[i]).append(" - ").append(salary);
        }

        return result.toString();
    }
}
