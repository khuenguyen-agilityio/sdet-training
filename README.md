# Trello Testing Practice

## Overview

- This document provides the requirement for Trello Testing Practice
- Testcase : [Sdet Practice](https://shorturl.at/foNU4)

## Goals

- Continue working with XPath and using XPath to get elements
- Apply advanced knowledge of Cucumber, Gherkin, JUnit & Serenity BDD to a write test cases

## Timeline

- Estimate time: 7 days (Mar 8th, 2024 to Mar 18th, 2024)

## Technical Stack

- Framework & Libraries
    - Java [ver 21]
    - Maven [ver 3.9.6]
    - Cucumber [ver 7.15.0]
    - Serenity BDD [ver 4.1.0]
    - JUnit [ver 5]
- Editor: InteljIDEA

## Requirements

- **Scenario: User add labels to the card**
    - User add label to the card successfully
    - User add label to the card unsuccessfully in case user submit empty label and remove color
- **Scenario : User manage check list task in card**
    - User create check list items successfully
    - User can see percent of checklist task exactly
    - User can not add item to checklist in case leave empty input field
- **Scenario : User upload attachment**
    - User upload attachment successfully
    - User upload attachment successfully in case user input large file
- **Scenario : User move task between columns**
    - User can move card between columns successfully
    - User move card between columns unsuccessfully in case user doesn't move card
    - User move card between columns unsuccessfully in case user drag card into Trello logo

## Getting Started

| Command                                                           | Action                       |
|-------------------------------------------------------------------|------------------------------|
| `git clone git@github.com:khuenguyen-agilityio/sdet-training.git` | Clone repository from Github |
| `git checkout -b feat/practice-two origin/feat/practice-two`      | Checkout branch              |
| `cd trello-testing`                                               | Change directory             |
| `mvn clean verify`                                                | Run test suite               |

## Authors

- Khue Nguyen
- Email: [khue.nguyen@asnet.com.vn](khue.nguyen@asnet.com.vn)
