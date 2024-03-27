# AG Grid Testing Practice

## Overview

- This document provides the requirement for AG Grid Testing Practice
- Testcase : [AG Grid Practice](https://shorturl.at/lsEFR)

## Target

- Improve using XPath to get elements
- Get familiar with actions : Scroll, Grid, Dropdown
- Apply Screenplay Pattern
- Upgrade skill working with file (.xlsx)
- Run test case on multi browser (Firefox, Chrome)

## Timeline

- Estimate time: 8 days (Mar 22nd, 2024 to Apr 2nd, 2024)

## Technical Stack

- Framework & Libraries
    - Java [ver 21]
    - Maven [ver 3.9.6]
    - Serenity BDD [ver 4.0.15]
    - JUnit5 [ver 5.10.0]
- IDE: IntelliJIDEA

## Requirements

- **User update value of field in row**
    - User can change the value successfully with valid number data
    - User can change the value successfully with number data have "00000" in the front
    - User can change the value unsuccessfully with number data have alphabet characters
- **Scenario : User can filter data by bank balance field**
    - User can see the data filter by Bank Balance column with value greater than 50000 and smaller than 70000
    - User can see no data filter by Bank Balance column with value greater than 70000 and smaller than 50000
- **Scenario : User can export data to excel**
    - User can see the data export in excel equal display data

## Getting Started

| Command                                                           | Action                       |
|-------------------------------------------------------------------|------------------------------|
| `git clone git@github.com:khuenguyen-agilityio/sdet-training.git` | Clone repository from Github |
| `git checkout -b feat/practice-three`                             | Checkout branch              |
| `mvn clean verify`                                                | Run test suite               |

## Authors

- Khue Nguyen
- Email: [khue.nguyen@asnet.com.vn](khue.nguyen@asnet.com.vn)
