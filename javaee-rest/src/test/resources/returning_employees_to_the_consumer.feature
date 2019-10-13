Feature: returning employees to the consumer

  all employees should be returned to the consumer following specific rules

  rules:
    - country of employee should always be UPPER CASE

  @runme
  Scenario: country is displayed in upper-case
    When the employees are returned to the consumer
    Then the country of each employee is in upper-case


