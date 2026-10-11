# 📚 Library Management System (JavaFX)

A modern, desktop-based **Library Management System** built using **JavaFX**, **FXML**, and the **MVC (Model-View-Controller)** architecture. Designed with a clean, single-window dynamic navigation setup and styled with a centralized CSS theme.

---

## 🚀 Features & Modules

- **📊 Central Dashboard**: View real-time system metrics, including Total Books, Total Members, Borrowed Books, and Overdue Statuses.
- **📖 Book Management**: Add new books, track ISBN, author, category, published year, and available copies.
- **👤 Member Management**: Register new members, update existing member profiles, search, and delete records seamlessly.
- **🔄 Issue & Return System**: 
  - Issue books with dynamic member and book selection.
  - Return books with automatic overdue date calculation and status warnings.
- **📜 Borrowing History & Logs**: Complete tracking log showing Member ID, Book Title, Issue Date, Due Date, Return Date, and borrowing statuses (*Borrowed*, *Returned*, *Overdue*).

---

## 🛠️ Tech Stack & Architecture

- **Language**: Java 17+
- **GUI Framework**: JavaFX 26 / FXML
- **Architecture**: Model-View-Controller (MVC)
- **Navigation**: Single-Window Dynamic `StackPane` switching (`loadUI`)
- **Styling**: Centralized CSS (`style.css`) with responsive form layouts and styled `TableView` headers

---

## 📂 Project Structure

```text
Library-Management-System/
├── src/
│   ├── Controllers/
│   │   ├── AddBook/
│   │   │   └── Add_Book_Page_Controller.java
│   │   ├── AddMember/
│   │   │   └── Add_Member_Page_Controller.java
│   │   ├── ViewPage/
│   │   │   └── View_page_Controller.java
│   │   ├── Issue_Book/
│   │   │   └── IssueController.java
│   │   ├── Return_Book/
│   │   │   └── Return_Book_Page_Controller.java
│   │   ├── History/
│   │   │   └── History_Page_Controller.java
│   │   └── Main_DashBoard_page_Controller.java
│   │
│   ├── Model/
│   │   ├── Book.java
│   │   ├── Member.java
│   │   └── HistoryRecord.java
│   │
│   └── main/
│       └── resources/
│           ├── View/
│           │   ├── Main_DashBoard.fxml
│           │   ├── Add_Book.fxml
│           │   ├── Add_Member_Page.fxml
│           │   ├── View_Page.fxml
│           │   ├── Issue_Book_page.fxml
│           │   ├── Return_Book_Page.fxml
│           │   └── History_Page.fxml
│           └── CSS/
│               └── style.css
└── README.md
