Feature: Load board by many way

  Scenario Outline: Test - Load
    Given We have a board temp number <TempNumber>
    When We have <n1>, "<Figure_1>" on board
    When We have <n2>, "<Figure_2>" on board
    When We have <n3>, "<Figure_3>" on board
    When We have <n4>, "<Figure_4>" on board
    When We have <n5>, "<Figure_5>" on board
    When We have <n6>, "<Figure_6>" on board
    Then This is true


    Examples:
      | TempNumber  | Figure_1 | n1 | Figure_2 | n2 | Figure_3 | n3 | Figure_4 | n4 | Figure_5 | n5 | Figure_6 | n6 |
      | 0           | King     |  2 | Queen    | 2  | Tower    | 4  | Runner   | 4  | Horse    | 4  | Pawn     | 16 |
      | 1           | King     |  2 | Queen    | 0  | Tower    | 2  | Runner   | 0  | Horse    | 1  | Pawn     | 2  |
      | 2           | King     |  2 | Queen    | 1  | Tower    | 0  | Runner   | 2  | Horse    | 0  | Pawn     | 1  |

  Scenario Outline: Test - Save board from file
    Given We have a board temp number <TempNumber>
    When We save this board to file
    When We set default state to board
    When We load saved board form file
    When We have <n1>, "<Figure_1>" on board
    When We have <n2>, "<Figure_2>" on board
    When We have <n3>, "<Figure_3>" on board
    When We have <n4>, "<Figure_4>" on board
    When We have <n5>, "<Figure_5>" on board
    When We have <n6>, "<Figure_6>" on board
    Then This is true


    Examples:
      | TempNumber  | Figure_1 | n1 | Figure_2 | n2 | Figure_3 | n3 | Figure_4 | n4 | Figure_5 | n5 | Figure_6 | n6 |
      | 0           | King     |  2 | Queen    | 2  | Tower    | 4  | Runner   | 4  | Horse    | 4  | Pawn     | 16 |
      | 1           | King     |  2 | Queen    | 0  | Tower    | 2  | Runner   | 0  | Horse    | 1  | Pawn     | 2  |
      | 2           | King     |  2 | Queen    | 1  | Tower    | 0  | Runner   | 2  | Horse    | 0  | Pawn     | 1  |

  Scenario: Test - Chcek init board
    Given We init default board
    When We have 16, "Pawn" on board
    When We have 4, "Horse" on board
    When We have 4, "Runner" on board
    When We have 4, "Tower" on board
    When We have 2, "Queen" on board
    When We have 2, "King" on board
    Then This is true

  Scenario: Test - Chcek load temp board and set default state
    Given We have a board temp number 1
    When We set default state to board
    When We have 16, "Pawn" on board
    When We have 4, "Horse" on board
    When We have 4, "Runner" on board
    When We have 4, "Tower" on board
    When We have 2, "Queen" on board
    When We have 2, "King" on board
    Then This is true