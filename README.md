# Automated Tests fot Saucedemo E-Shop
This repository contains automated tests designed to evaluate the main functionalities of [Saucedemo E-Shop](https://www.saucedemo.com/). The tests aim to ensure the main features of the website work correctly.

## Features
- Login test
- Happy path test (*login*, *products in cart* and *checkout*)

## Requirements
- JDK (version 21)
- Maven (version 3.9.7)

## Instalation
```bash
git clone https://github.com/ttejeda02/saucedemo-automation-testing.git
cd saucedemo-automation-testing
mvn clean install
```
## Usage
To run the test, use the following command:
```bash
mvn test
```

## Acknowledgments
Thanks to [Boni Garcia](https://bonigarcia.dev/) for creating the WebDriverManager, which simplifies the management of browser drivers for automated testing. You can find the project here: [WebDriveManager](https://github.com/bonigarcia/webdrivermanager).
