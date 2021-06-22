Feature: Checkmate

  Scenario Outline: Test - Check mate by template
    Given We have a board temp for check by number <TempNumber>
    When We have checkmate, "<Color>" King
    Then We have checkmate


    Examples:
      | TempNumber  | Color     |
      | 0           | Black     |
      | 1           | Black     |
      | 2           | White     |

  Scenario Outline: Test - Check by King (King cant go to another place)
    Given We have a board temp for check by number <TempNumber>
    When We want go to <xF>, "<yF>", by <xP>, "<yP>"
    When We have checkmate, "<Color>" King
    Then We havent checkmate


    Examples:
      | TempNumber  | Color    | xF | yF | xP | yP |
      | 3           | Black    |  8 | E  |  8 | D  |
      | 4           | Black    |  6 | G  |  6 | H  |
      | 5           | Black    |  6 | D  |  7 | D  |