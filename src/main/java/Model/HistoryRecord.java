package Model;

import java.time.LocalDate;

public class HistoryRecord {
    private String memberId;
    private String bookTitle;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private String status;

    public HistoryRecord(String memberId, String bookTitle, LocalDate issueDate, LocalDate dueDate, LocalDate returnDate, String status) {
        this.memberId = memberId;
        this.bookTitle = bookTitle;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public String getMemberId() { return memberId; }
    public String getBookTitle() { return bookTitle; }
    public LocalDate getIssueDate() { return issueDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public String getStatus() { return status; }
}