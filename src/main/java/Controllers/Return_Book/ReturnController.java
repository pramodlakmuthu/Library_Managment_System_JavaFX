package Controllers.Return_Book;

import Model.IssueBook;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ReturnController {
    // For demonstration, you can link this to your IssueController data list
    private static List<String> returnedBooksList = new ArrayList<>();

    public long calculateOverdueDays(LocalDate dueDate, LocalDate returnDate) {
        if (returnDate.isAfter(dueDate)) {
            return ChronoUnit.DAYS.between(dueDate, returnDate);
        }
        return 0; // Not overdue
    }

    public boolean returnBook(String issueId) {
        if (issueId != null && !issueId.isEmpty()) {
            returnedBooksList.add(issueId);
            return true;
        }
        return false;
    }
}