# Java-Servlet-Student-Regestration-App
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white)

A simple, robust Java Web Application that allows users to register students and view a list of records. This project demonstrates the implementation of Java Servlets, JSP, JDBC, and MySQL architecture with a Bootstrap frontend.

---

## 📋 Table of Contents
- Features
- Tech Stack
- Database Schema
- Project Structure
- Getting Started
- Configuration
- Screenshots

---

## ✨ Features
*   Student Registration: Input form for Name, Email, and Year.
*   Data Validation: Server-side validation to ensure data integrity.
*   Read Records: Retrieve and display all students in a formatted table.
*   Database Integration: Persistent storage using MySQL.
*   Responsive UI: Clean interface built with Bootstrap 5.

---

## 🛠 Tech Stack
*   Backend: Java (JDK 8+), Java Servlets, JSP
*   Database: MySQL Server
*   Build Tool: Apache Maven
*   Server: Apache Tomcat (v9.0+)
*   Frontend: HTML5, CSS3, Bootstrap 5

---

## 🗄 Database Schema

Execute the following SQL script in your MySQL Workbench or CLI to initialize the database:

CREATE DATABASE IF NOT EXISTS student_db;
USE student_db;

CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    year INT NOT NULL
);
## 📂 Project Structure

``` StudentApp
├── pom.xml                   # Maven dependencies and build config
└── src
    └── main
        ├── java
        │   └── com
        │       └── studentapp
        │           ├── DBConnection.java  # JDBC Connection Logic
        │           ├── Student.java       # POJO Model
        │           └── StudentServlet.java# Controller (Handles GET/POST)
        └── webapp
            ├── index.jsp              # Registration Form (Home)
            ├── list.jsp               # Student List View
            └── WEB-INF
                └── web.xml            # Deployment Descriptor
```
## 🚀 Getting Started
# Prerequisites
1.  Ensure you have the following installed:
2.  Java JDK 8+
3.  Apache Maven
4.  MySQL Server
5.  Apache Tomcat
# Installation
1. Clone the Repository
```Bash
git clone https://github.com/your-username/student-registration-app.git
cd student-registration-app
```
2. Configure Database
Open src/main/java/com/studentapp/DBConnection.java and update the credentials:
``` Java
private static final String USER = "root";       // Your MySQL Username
private static final String PASSWORD = "your_password"; // Your MySQL Password
```
3. Build the Project
Run the following command to generate the WAR file:
``` Bash
mvn clean install
```
4. Deploy
* Copy the generated .war file from the target/ folder.
* Paste it into the webapps/ folder of your Apache Tomcat installation.
* Start the Tomcat server (bin/startup.bat or bin/startup.sh).
5. Run
Open your browser and navigate to:
http://localhost:8080/StudentApp/
## 📷 Screenshots
1. Registration Page
(Place a screenshot here, e.g., ![Registration](screenshots/register.png))
Users can enter student details here.
2. Student List
(Place a screenshot here, e.g., ![List](screenshots/list.png))
Displays a table of all registered students fetched from the database.
## 🤝 Contributing
1. Fork the repository.
2. Create a new feature branch (git checkout -b feature-name).
3. Commit your changes (git commit -m 'Add some feature').
4. Push to the branch (git push origin feature-name).
5. Open a Pull Request.
