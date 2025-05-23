
# Simple Library Management System (Java)

This project is a basic simulation of a Library Management System built in Java. It supports operations like adding books, registering users, borrowing and returning books with borrowing limits.

## 📂 Project Structure

```
LibraryManagement/
├── src/
│   └── SRPLibrary.java
├── README.md
```

## ✅ Features

- 📚 Add new books to the library
- 👥 Register new users
- 📖 Borrow books (with a 3-book limit per user)
- 🔁 Return borrowed books
- ❌ Handle invalid users or incorrect book names
- ✔️ Validation for book availability

## 🧠 Design Highlights

- **SRP (Single Responsibility Principle)** is followed:
  - `Book`: Handles book details and availability
  - `User`: Manages user information
  - `UserRegister`: Validates and registers users
  - `BorrowManager`: Manages borrow counts and limits
  - `Librarian`: Handles library's book collection
  - `LibrarryManagement`: Coordinates all operations

## 🚀 How to Run

1. Compile:
    ```bash
    javac SRPLibrary.java
    ```

2. Run:
    ```bash
    java SRPLibrary
    ```

## 📌 Sample Output

```text
1/3 is borrowed
The Book named: HarryPotter is borrowed by Kalaiselvam Successfully
Limit updated: 0/3
No Book Found.Please check for the correct book name.
```

## 🔧 Future Improvements

- Track which user has borrowed which book
- Store borrow history
- Support for due dates and fines
- GUI or web-based front-end

## 📄 License

This project is for educational purposes. Feel free to use and modify.
