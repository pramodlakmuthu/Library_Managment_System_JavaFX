package Controllers.Issue_Book;

import Model.IssueBook;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;

public class IssueController {
    private static List<IssueBook> issueList = new ArrayList<>();

    public boolean issueBook(IssueBook record) {
        if (record != null) {
            issueList.add(record);
            return true;
        }
        return false;
    }

    public List<IssueBook> getAllActiveIssues() {
        return issueList;
    }

    public IssueBook getIssueById(String issueId) {
        for (IssueBook record : issueList) {
            if (record.getIssueId().equals(issueId)) {
                return record;
            }
        }
        return null;
    }

    public boolean returnBook(String issueId) {
        return issueList.removeIf(record -> record.getIssueId().equals(issueId));
    }

    public int getIssuedBooksCount() {
        return issueList.size();
    }

    public void btnOnActionIssueBook(ActionEvent actionEvent) {
    }

    public void btnOnActionClear(ActionEvent actionEvent) {
    }
}