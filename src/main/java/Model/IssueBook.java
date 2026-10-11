package Model;
import java.time.LocalDate;
public class IssueBook {
    private String issueId;
    private String memberId;
    private String isbn;
    private LocalDate issueDate;
    private LocalDate dueDate;

    public IssueBook(String issueId, String memberId, String isbn, LocalDate issueDate, LocalDate dueDate) {
        this.issueId = issueId;
        this.memberId = memberId;
        this.isbn = isbn;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
