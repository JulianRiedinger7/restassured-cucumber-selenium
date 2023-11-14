Feature: SWapi API & Wikipedia UI Tests
  The user should be able to request information through the SW API and validate that information using the UI of Wikipedia

  Scenario Outline: Check wikipedia article displayed for Star Wars Characters
    Given the user is in SW API requesting character number <number>
    When the user searchs the character's name "<name>" in Wikipedia
    Then the user should be able to see the article page with "<name>" as title

    Examples:
      | number | name           |
      | 1      | Luke Skywalker |
      | 2      | C-3PO          |
      | 3      | R2-D2          |
      | 4      | Darth Vader    |
      | 5      | Leia Organa    |


  Scenario: Check edit page displayed for random Star Wars movie
    Given the user is in SW API requesting a random movie
    When the user searches the movie in Wikipedia
    And the user clicks on edit article
    Then the user should be able to see the edit page with the correct title
