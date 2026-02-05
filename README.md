# QA Automation Project

## Project Overview
This project is created as part of a **QA BugAThon**.  
The objective is to identify and report bugs in an **AI-powered assessment platform** using **manual testing and Selenium automation**.

The project covers:
- Functional testing
- UI validation
- Positive & negative test scenarios
- Automation using Selenium WebDriver

---

## Tech Stack
- Programming Language: Java
- Automation Tool: Selenium WebDriver
- Testing Framework: TestNG
- Build Tool: Maven
- Browser: Google Chrome
- Reporting: Extent Reports
- IDE: IntelliJ IDEA

---

## Project Structure

hyrenet-qa-project
│
├── src/test/java
│ ├── tests
│ ├── pages
│ ├── utils
│
├── reports
├── screenshots
├── test-documents
│ └── Bug_Report_and_Test_Documents.xlsx
├── pom.xml
├── testng.xml
└── README.md



## How to Run the Tests
1. Clone the repository
git clone https://github.com/rajureddie/hyrenet-qa-project.git

2. Open the project in IntelliJ IDEA  
3. Install Maven dependencies  
4. Run tests using TestNG  
   - Right-click `testng.xml` → Run

---

## Reports & Screenshots
- Execution reports are generated using Extent Reports
- Screenshots are captured automatically on test failure

---

## Test Documentation
All identified bugs, test scenarios, test cases, and RTM are documented in an **Excel spreadsheet** available in the `test-documents` directory.

The Excel file includes:
- Bug description
- Steps to reproduce
- Expected vs Actual results
- Severity & Priority
- Requirement Traceability Matrix (RTM)

---

## Automation Scope
A **hybrid testing approach** was followed:
- Selenium automation was used for UI flow validation and navigation
- Manual testing was used for complex execution scenarios such as coding evaluation and backend validation

---

## Author
**Raju Reddie**


