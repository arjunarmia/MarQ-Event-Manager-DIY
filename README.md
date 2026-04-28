# MarQ Event Manager DIY (Katalon Studio)
An automated testing suite designed for the **MarQ Event Manager** application. This project utilizes **Katalon Studio** to validate end-to-end event management workflows, including user authentication, seat reservations, and RSVP processing.

## 🚀 Project Overview
The goal of this project is to ensure the stability and reliability of the DIY Event Manager platform through automated regression and functional testing.

### Key Test Scenarios Covered:
* **Authentication & User Profile:** Validating login, logout, and profile management.
* **Seat Booking Flow:** Testing the logic for choosing and reserving specific seats.
* **Non-Seat Booking Flow:** Validating workflows for general admission or open-seating events.
* **Registration-based Booking:** Testing events that require custom data collection during signup.
* **Token-based Booking:** Validating entry via unique tokens or invitation codes.
* **RSVP Flow:** Testing the response system for invited guests.

---

## 🛠️ Prerequisites
* **Katalon Studio:** Version 8.x or 11.x (as seen in your build).
* **Java JRE/JDK:** Required by Katalon Studio.
* **Chrome/Firefox/Edge:** Ensure your web drivers are updated within Katalon (`Tools > Update WebDrivers`).

---

## 📂 Project Structure
```
├── Test Cases          # Individual test steps and logic
├── Object Repository   # UI elements (buttons, inputs, labels)
├── Test Suites         # Grouped test cases for specific flows
│   ├── 1. Authentication and User Profile
│   ├── 2. Seat Booking Flow
│   └── ... [7. Other Flows]
├── Data Files          # External data (Excel/CSV) for data-driven testing
└── Reports             # Local execution logs and results
```

---
## ⚙️ Setup and Execution
1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/arjunarmia/MarQ-Event-Manager-DIY.git
    ```
2.  **Open in Katalon:**
    * Open Katalon Studio.
    * Go to `File > Open Project` and select the cloned directory.
3.  **Configure Environment:**
    * Update the `Global Variables` (Profiles) with your specific test environment URL and credentials.
4.  **Run Tests:**
    * Open the **Test Suites** folder in the Tests Explorer.
    * Select a suite (e.g., `Authentication and User Profile`).
    * Click the **Run** button (Chrome/Headless) in the top toolbar.
---

## 📧 Contact
**Arjun** - (https://github.com/arjunarmia)  
Project Link: [https://github.com/arjunarmia/MarQ-Event-Manager-DIY](https://github.com/arjunarmia/MarQ-Event-Manager-DIY)
---
