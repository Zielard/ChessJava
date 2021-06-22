Feature: Check turn of players

    Scenario Outline: Test - Run game
    Given We init default board
    When We want go to <xF>, "<yF>", by <xP>, "<yP>"
    When We want go to <xFF>, "<yFF>", by <xPP>, "<yPP>"
    Then White player have turn


    Examples:
      | xF | yF | xP | yP | xFF | yFF | xPP | yPP |
      | 2  | B  |  3 | B  | 7   | B   |  6  | B   |
      | 2  | D  |  3 | D  | 7   | D   |  6  | D   |
      | 2  | H  |  3 | H  | 7   | G   |  5  | G   |