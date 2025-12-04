
#                 <img src="https://github.com/user-attachments/assets/fb320ea0-0b1c-49c7-bac1-203125de2bab" width="1000">

<div align="center">

# 🚗 Carwash Management System 💨💨

A console-based Java application to manage vehicle transactions, daily summaries,  
and service pricing for a carwash business.

</div>

---

## 🔅Description / Overview
This project is a **Java-based Carwash Management System** designed to help carwash businesses track customer vehicles, manage daily transactions, and calculate revenues efficiently.  
Key features include:

- Add and edit customer vehicle transactions.
- View all daily transactions and summary reports.
- Supports multiple vehicle types: Car, Motorcycle, Van, and Custom vehicles.
- Pricing information and service options.
- Saves transactions and summaries to text files for persistence.

It solves the problem of **manual record-keeping** and helps automate reporting and pricing calculations.

<div align="center">
    
## 🧑‍💻Program Structure

</div>

`Main` – Entry point of the program, handles user input, menu navigation, and calls relevant classes/methods.
```
📂BSU/
│
├── 📖README.md
│
├── 📂DATA_store/
│   ├── 💬dataSummary.txt
│   └── 💬transactions.txt
│
├── 📂Main/
│   │
│   ├── 📂src/
│   │   ├── ☕Car.java
│   │   ├── ☕Custom.java
│   │   ├── ☕FileHandler.java
│   │   ├── ☕Main.java
│   │   ├── ☕Motorcycle.java
│   │   ├── ☕PriceInfo.java
│   │   ├── ☕Van.java
│   │   └── ☕Vehicle.java
│   │
│   ├── 📂MainAndClasses/       (compiled .class files)
│   │   ├── 🚗Car.class
│   │   ├── ❓Custom.class
│   │   ├── 🗃️FileHandler.class
│   │   ├── ⛑️Main.class
│   │   ├── 🛵Motorcycle.class
│   │   ├── 🪙PriceInfo.class
│   │   ├── 🚐Van.class
│   │   └── 🛞Vehicle.class
│   │
│   └── 📂CarwashRecords/       (generated daily records)
│       ├── 📋2025-11-28_summary.txt
│       ├── 📋2025-11-28_transactions.txt
│       └── 📋(future generated files)
```
### 🔅Helper Classes
| Class | Role |
|-------|------|
| `Vehicle` | Base class for all vehicle types. |
| `Car` | Represents a car, calculates pricing and displays summary. |
| `Motorcycle` | Represents motorcycles/tricycles, includes sidecar option. |
| `Van` | Represents vans, handles pricing and summary. |
| `Custom` | Represents unique/custom vehicles with negotiated price. |
| `FileHandler` | Handles saving and loading transactions and summaries. |
| `PriceInfo` | Displays pricing tables for services. |


<div align="center">
    
## 🗝️Key Features

</div> 

### ➕1. Add Customer Vehicle
Register a new vehicle with customizable details. Supported types:

    Car (SML / MED / LRGE)
    Motorcycle / Tricycle (with optional sidecar)
    Van
    Custom Vehicle (unique name + user-defined price)
    Available services:
    
    Regular Carwash
    Carwash w/ Buffing Wax
    Engine Wash (not available for motorcycles)

### 🔎2. Edit Existing Transactions

Modify any saved transaction:

    Update brand
    Update color
    Change service (auto recalculates price)
    The system provides a live preview of all updated information.

### 🌱3. Show All Transactions

Displays all transactions for the current day in a formatted table showing:

    Vehicle
    Brand
    Color
    Service
    Price

    Automatically saved to:
    transactions.txt

### 🗒️4. Daily Summary & Report

Generates a complete daily performance summary:

    Vehicle counts (Car, Motorcycle, Van, Custom)
    Service counts (Carwash, Buffing Wax, Engine Wash)
    Total Revenue
    Total Transactions
    Saved automatically to:
    dataSummary.txt

### 💰5. Price Information

Provides the full pricing breakdown for:

    Cars (size-based pricing)
    Motorcycles / Tricycles
    Vans

    Custom vehicles
    Includes all service-based price adjustments.

### 🗃️6. File Handling Integration

The system automatically:

    Loads today’s previous transactions
    Saves every update instantly
    Generates and stores daily summaries for record-keeping
---


<div align="center">
    
## 🔭3. OOP Concepts Applied

The project applies **Object-Oriented Programming (OOP)** principles as follows:

</div>

```
                                            ┌───────────────────┐
                                            │    Vehicle        │  ← Abstract Class (Abstraction)
                                            │-------------------│ 
                                            │ - brand           │  ← Encapsulation
                                            │ - color           │  ← Encapsulation
                                            │ - serviceChoices  │  ← Encapsulation
                                            │-------------------│
                                            │ + getBrand()      │
                                            │ + setBrand()      │
                                            │ + getColor()      │
                                            │ + setColor()      │
                                            │ + getService()    │
                                            │ + setService()    │
                                            │ + displaySummary()│  ← Abstract Method
                                            └─────────┬─────────┘
                                                      │         
             ─────────────────────────────────────────┼───────────────────────────────────────────────┐ 
             |                                        |                                               |
    ┌───────────────────────┐              ┌─────────────────────┐                         ┌────────────────────┐    
    │      Car              │              │     Motorcycle      │                         │        Van         │    
    │-----------------------│              │---------------------│                         │--------------------│   
    │ + size (SML/MED/LRGE) |              │ + hasSideCars       │                         │                    │    
    │ + price               │              │ + price             │                         │ + price            │   
    │-----------------------|              │---------------------│                         │--------------------│    
    │ + displaySummary()    │              | + displaySummary()  |                         │ + displaySummary() │    
    └───────────────────────┘              └─────────────────────┘                         └────────────────────┘ 
          |                                            |                                               |
          |────────────────────────────────────────────┼───────────────────────────────────────────────|
                                                       |
                                            ┌─────────────────────┐ 
                                            |       Custom        |
                                            |---------------------|
                                            |  + size             |
                                            |  + price            |
                                            |---------------------|
                                            | +  displaySummary() |
                                            └─────────────────────┘   
      
```
### 🔅3.1 Inheritance
- `Car`, `Motorcycle`, `Van`, and `Custom` classes inherit from the **`Vehicle`** base class.
- Shared properties like `brand`, `color`, and `service` are defined in `Vehicle`.
```
public class Car extends Vehicle { ... }
public class Motorcycle extends Vehicle { ... }
public class Van extends Vehicle { ... }
public class Custom extends Vehicle { ... }
```

### 🔅3.2 Polymorphism
- **Runtime Polymorphism**: `Vehicle vehicles = new Car(...)` allows different types of vehicles to be handled uniformly.
- Methods like `displaySummary()` are overridden in subclasses for vehicle-specific behavior.
```
Vehicle vehicles;

switch(vehicleChoice){
    case "1" -> vehicles = new Car(brand, color, size, serviceChoices);
    case "2" -> vehicles = new Motorcycle(brand, color, hasSideCars, serviceChoices);
    case "3" -> vehicles = new Van(brand, color, serviceChoices);
    case "4" -> vehicles = new Custom(brand, color, price, uniqueVehicle, serviceChoices);
}

dailyRecords.get(today).add(vehicles);
vehicles.displaySummary(); // METHOD OVERRIDING – different output for Car, Motorcycle, Van, Custom

```
### 🔅3.3 Encapsulation
- Fields such as `brand`, `color`, and `price` are private with public getter and setter methods.
- Ensures proper control over how data is accessed and modified.
```
protected String brand;
protected String color;
protected String serviceChoices;

String getBrand() { return this.brand; }
void setBrand(String brand) { this.brand = brand; }

String getColor() { return this.color; }
void setColor(String color) { this.color = color; }

void setService(String serviceChoices) { this.serviceChoices = serviceChoices; }

```

### 🔅3.4 Abstraction
- The `Vehicle` class serves as an abstract blueprint for different vehicle types.
- Users interact with higher-level methods without worrying about subclass implementations.
```
public abstract class Vehicle {
    protected String brand;
    protected String color;
    protected String serviceChoices;

    Vehicle(String brand, String color, String serviceChoices) { ... }

    abstract void displaySummary(); // abstract method
}

```
---

<div align="center">
    
# 💦Sample Output

</div>

```
******************************************************************************
                CARWASH MANAGEMENT SYSTEM
******************************************************************************
        1 - Add Customer Vehicle
        2 - Edit Customer Vehicle
        3 - Show Transactions
        4 - Daily Data and Summary
        5 - Prices Info
        6 - Exit
Enter Choice: 1

******************************************************************************
             WHAT VEHICLE?
               1 - Car
               2 - Motorcycle
               3 - Van
               4 - Custom
Enter choice: 1

******************************************************************************
        CHOOSE SERVICES:
        1 - Regular CarWash
        2 - w/ Buffing Wax
        3 - Engine Wash
Enter choice: 2

Enter Car's Brand: Toyota
Enter Car's Color: Red
Enter Car's Size (SML/MED/LRGE): MED

----------------------------------------------------------------------------------------
| Car (MED)    | TOYOTA         | RED            | CARWASH W/ BUFFING WAX   | $300.00 |
----------------------------------------------------------------------------------------

Transaction Successfully Saved!
```
---

<div align="center">
    
## 🏆Acknowledgements

</div>

### 👩‍🏫Instructor
We would like to extend our sincere gratitude to our instructor Ms. Christiana Grace Alib for providing invaluable guidance, mentorship, and support throughout the development of this project. Their expertise in Object-Oriented Programming principles, coding best practices, and problem-solving strategies greatly contributed to the success of our work.

### 👨‍🎓Group Members
This project was developed collaboratively by our team. We appreciate the dedication and effort of all group members in areas including system design, coding, testing, debugging, and documentation. The teamwork, communication, and creativity of each member were essential in bringing this project to completion.

### 🔨Future Enhancements
While the current system provides core functionalities for managing vehicle transactions efficiently, there are several potential improvements that could be implemented in future versions:

- **Graphical User Interface (GUI):** Transition from a console-based system to a user-friendly GUI to enhance usability and accessibility.
- **Database Integration:** Replace text file storage with a robust database system to improve data management, scalability, and query efficiency.
- **Advanced Reporting:** Include dynamic reports, charts, and statistics for better insights into daily, weekly, and monthly transactions.
- **Online Booking and Payment:** Integrate online booking and payment functionalities to streamline customer experience.
---

<div align="center">
    
## 🫧 **"BubbleBytes Members"** 🫧

</div>

| Name | Avatar | Role | GitHub |
|------|--------|-------|--------|
| **Anaviso, Justin Mark T.** | <img width="200" height="200" src="https://github.com/user-attachments/assets/fc1131d8-8e37-46c0-9a79-2aaa01f2cd87" /> | Assistant Programmer / Logic & Calculations | <a href="https://github.com/KKKKcyberpunk23"><img src="https://img.shields.io/badge/GitHub-Profile-black?logo=github" /></a> |
| **Borillo, Emman** | <img width="200" height="200" src="https://github.com/user-attachments/assets/d242bdc6-61b9-4a9c-8b82-8392012d7b3f" /> | Lead Programmer / Logic & Calculations | <a href="https://github.com/Emman-21"><img src="https://img.shields.io/badge/GitHub-Profile-black?logo=github" /></a> |
| **Magnaye, Mark Ian** | <img width="200" height="200" src="https://github.com/user-attachments/assets/c654bc31-ecef-4fe7-88f6-9197db5810f1" /> | Project Presenter | <a href="https://github.com/MarkIan-01"><img src="https://img.shields.io/badge/GitHub-Profile-black?logo=github" /></a> |




