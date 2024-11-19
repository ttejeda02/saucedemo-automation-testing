# Automated Tests for Saucedemo E-Shop
This repository contains automated tests designed to evaluate the main functionalities of [Saucedemo E-Shop](https://www.saucedemo.com/). The tests aim to ensure the main features of the website work correctly.

## Features
- **Smoke tests**: Basic checks for price calculation, products in cart, and the entire happy path (from login to checkout).
- **Positive tests**: Tests covering expected functionality such as successful login, product addition to cart, and checkout process.
- **Negative tests**: Tests for invalid scenarios such as incorrect login and trying to checkout with an empty cart.

## Requirements
- JDK (version 21)
- Maven (version 3.9.7)

## Installation
```bash
git clone https://github.com/ttejeda02/saucedemo-automation-testing.git
cd saucedemo-automation-testing
mvn clean install
```
## Usage
To run the **smoke test** suite:
```bash
mvn -Dbrowser=chrome -Denvironment=positive -Dsurefire.suiteXmlFiles=src/test/resources/smoke-tests.xml clean test
```
To run the **positive test** suite:
```bash
mvn -Dbrowser=chrome -Denvironment=positive -Dsurefire.suiteXmlFiles=src/test/resources/positive-tests.xml clean test
```
To run the **negative test** suite:
```bash
mvn -Dbrowser=chrome -Denvironment=negative -Dsurefire.suiteXmlFiles=src/test/resources/negative-tests.xml clean test
```

## Acknowledgments
Thanks to [Boni Garcia](https://bonigarcia.dev/) for creating the WebDriverManager, which simplifies the management of browser drivers for automated testing. You can find the project here: [WebDriveManager](https://github.com/bonigarcia/webdrivermanager).
