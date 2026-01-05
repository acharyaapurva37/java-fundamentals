# 🏧 ATM Simulation System (Core Java)

A console-based **ATM Simulation System** built using **Core Java**, designed to demonstrate object-oriented programming concepts such as classes, objects, encapsulation, and method interaction.

---

## 📌 Features

- User authentication using ATM PIN
- Check account balance
- Deposit money
- Withdraw money
- Menu-driven console interaction
- Continuous operations until user exits

---


---

## 🧠 Design Overview

### 1️⃣ Account
**Responsibility:**  
Represents a bank account.

**Attributes:**
- `accountNumber`
- `balance`

**Methods:**
- `getBalance()`
- `deposit(amount)`
- `withdraw(amount)`

---

### 2️⃣ User
**Responsibility:**  
Represents an ATM card holder.

**Attributes:**
- `userName`
- `atmPin`
- `Account account` (HAS-A relationship)

---

### 3️⃣ ATM
**Responsibility:**  
Acts as the ATM machine.

**Functions:**
- Validates PIN
- Displays menu
- Processes user choices
- Interacts with `Account` through `User`

---

### 4️⃣ Main
**Responsibility:**  
Application entry point.

**Functions:**
- Creates `Account` and `User`
- Initializes `ATM`
- Controls application flow

---

## ▶️ How to Run

1. Open the project in any Java IDE (IntelliJ / Eclipse / VS Code)
2. Compile all `.java` files
3. Run `Main.java`
4. Follow on-screen instructions in the console

---

## 🛠 Technologies Used

- Java (Core Java)
- OOP Concepts
- Console I/O (`Scanner`)

---

## 🎯 Learning Outcomes

Through this project, I practiced and reinforced:
- Object-Oriented Design
- Class responsibilities and relationships
- Encapsulation and method usage
- Console-based application flow
- Basic input validation and control structures

---

## 📌 Future Enhancements

- Multiple users support
- PIN retry limit
- Transaction history
- File or database persistence
- Better input validation

---

