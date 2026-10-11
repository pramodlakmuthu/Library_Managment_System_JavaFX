package Controllers.History;

import Model.HistoryRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class History_Page_Controller implements Initializable {

    @FXML private TableView<HistoryRecord> tblHistory;
    @FXML private TableColumn<HistoryRecord, String> colMemberId;
    @FXML private TableColumn<HistoryRecord, String> colBookTitle;
    @FXML private TableColumn<HistoryRecord, LocalDate> colIssueDate;
    @FXML private TableColumn<HistoryRecord, LocalDate> colDueDate;
    @FXML private TableColumn<HistoryRecord, LocalDate> colReturnDate;
    @FXML private TableColumn<HistoryRecord, String> colStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Map table columns to HistoryRecord properties
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colBookTitle.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        colIssueDate.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadHistoryData();
    }

    private void loadHistoryData() {
        // Sample data for demonstration - you can load records dynamically from your transaction controllers
        ObservableList<HistoryRecord> historyList = FXCollections.observableArrayList(
                new HistoryRecord("M001", "Java Programming", LocalDate.now().minusDays(10), LocalDate.now().plusDays(4), null, "Borrowed"),
                new HistoryRecord("M002", "Data Structures", LocalDate.now().minusDays(20), LocalDate.now().minusDays(6), LocalDate.now().minusDays(5), "Returned"),
                new HistoryRecord("M003", "Database Systems", LocalDate.now().minusDays(25), LocalDate.now().minusDays(11), null, "Overdue")
        );

        tblHistory.setItems(historyList);
    }
}