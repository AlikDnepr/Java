# Selenium WebDriver Browser Tests

This repository contains a collection of browser automation scripts using **Java** and **Selenium WebDriver**.
The scripts are organized under the `Browser` package and demonstrate browser-based testing across multiple platforms
such as Chrome, Firefox, Edge, Safari, and various websites like Herokuapp, Rozetka, Google, BrowserStack, 
and Example.com.

## Features

- Cross-browser testing with `WebDriverManager`
- Automated login test scenarios
- Navigation between pages using WebDriver
- Page element assertions and validations
- Measurement of page load and interaction time
- Structured test methods using JUnit

---

## File Descriptions

### `BrowserSwitchTest.java`
Runs the same set of tests across multiple browsers:
- Chrome
- Firefox
- Edge
- Safari

**Tested sites:**
- `https://the-internet.herokuapp.com/login` — login test with assertions
- `https://rozetka.com.ua` — basic content and title validation
- `https://www.google.com` — check for logo presence and title content

### `BrowserTest.java`
Demonstrates:
- Page navigation methods: `get()`, `navigate().to()`, `navigate().back()`, `navigate().forward()`
- Difference between `get()` and `navigate()`
- Usage of `Thread.sleep()` for waiting between navigation steps (for demo purposes only)

### `FirstTest.java`
A simple test that:
- Opens Rozetka homepage
- Validates the page title
- Uses navigation: back, forward, refresh
- Quits the browser session cleanly

### `LoginTest.java`
Performs a full login scenario on:
- `https://the-internet.herokuapp.com/login`

Includes:
- Locating input fields and login button
- Sending keys and clicking
- Verifying post-login success messages with assertions

### `SimpleScript.java`
Validates:
- Domain and URL of `https://example.com`
- Main header content (`<h1>`)
- Page title matching "Example Domain"

---

## Requirements

- Java 17+
- Maven or Gradle project structure (optional)
- Google Chrome, Firefox, Edge, or Safari installed
- IntelliJ IDEA, VS Code, or any preferred Java IDE

## Dependencies

- **Selenium WebDriver**
- **JUnit 5**
- **WebDriverManager** (automatically manages browser drivers)

Add these dependencies via Maven or Gradle if using a build system.

---

## How to Run

You can run the tests in several ways:

### From Command Line (if using plain Java):
```bash
javac -cp ".:path/to/selenium/jars/*" Browser/BrowserSwitchTest.java
java -cp ".:path/to/selenium/jars/*" Browser.BrowserSwitchTest
