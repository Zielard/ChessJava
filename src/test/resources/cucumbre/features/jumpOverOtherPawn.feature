Feature: Figure jump over another Pawn

  Scenario Outline: Test - Queen move to every border
    Given We have a pawn "<FigureF>" of the color "<ColorF>" at the position <fx>, "<fy>"
    When We have another pawn "<FigureE>" of the color "<ColorE>" at the position <ex>, "<ey>"
    When We want go to <newX>, "<newY>"
    Then We can't go there

    #1 - left
    #2 - up
    #3 - left_up
    #4 - right_up
    #5 - left_down

    #6 - right_down
    #7 - down
    #8 - right
    Examples:
      | FigureF  | ColorF  | fx | fy | FigureE | ColorE | ex | ey | newX | newY |
      | Queen    | black   | 5  | D  | Pawn    | black  |  6 |  D | 7    | D    |
      | Queen    | black   | 5  | D  | Pawn    | black  |  6 |  E | 7    | F    |
      | Queen    | black   | 5  | D  | Pawn    | black  |  6 |  C | 7    | B    |
      | Queen    | black   | 5  | D  | Pawn    | black  |  5 |  C | 5    | B    |
      | Queen    | black   | 5  | D  | Pawn    | black  |  4 |  C | 3    | B    |

      | Queen    | black   | 5  | D  | Pawn    | black  |  4 |  C | 3    | B    |
      | Queen    | black   | 5  | D  | Pawn    | black  |  4 |  E | 3    | F    |
      | Queen    | black   | 5  | D  | Pawn    | black  |  5 |  E | 5    | F    |

  Scenario Outline: Test - Tower move to every border
    Given We have a pawn "<FigureF>" of the color "<ColorF>" at the position <fx>, "<fy>"
    When We have another pawn "<FigureE>" of the color "<ColorE>" at the position <ex>, "<ey>"
    When We want go to <newX>, "<newY>"
    Then We can't go there

    #1 - left
    #2 - up
    #3 - left_up
    #4 - right_up
    #5 - left_down

    #6 - right_down
    #7 - down
    #8 - right
    Examples:
      | FigureF  | ColorF  | fx | fy | FigureE | ColorE | ex | ey | newX | newY |
      | Tower    | black   | 5  | D  | Pawn    | black  |  6 |  D | 7    | D    |
      | Tower    | black   | 5  | D  | Pawn    | black  |  5 |  E | 5    | F    |
      | Tower    | black   | 5  | D  | Pawn    | black  |  4 |  C | 3    | B    |
      | Tower    | black   | 5  | D  | Pawn    | black  |  4 |  D | 3    | D    |

  Scenario Outline: Test - Runner move to every border
    Given We have a pawn "<FigureF>" of the color "<ColorF>" at the position <fx>, "<fy>"
    When We have another pawn "<FigureE>" of the color "<ColorE>" at the position <ex>, "<ey>"
    When We want go to <newX>, "<newY>"
    Then We can't go there

    #1 - left
    #2 - up
    #3 - left_up
    #4 - right_up
    #5 - left_down

    #6 - right_down
    #7 - down
    #8 - right
    Examples:
      | FigureF   | ColorF  | fx | fy | FigureE | ColorE | ex | ey | newX | newY |
      | Runner    | black   | 5  | D  | Pawn    | black  |  4 |  E | 3    | F    |
      | Runner    | black   | 5  | D  | Pawn    | black  |  6 |  E | 7    | F    |
      | Runner    | black   | 5  | D  | Pawn    | black  |  6 |  C | 7    | B    |
      | Runner    | black   | 5  | D  | Pawn    | black  |  4 |  C | 3    | B    |

  Scenario Outline: Test - Runner move to every border
    Given We have a pawn "<FigureF>" of the color "<ColorF>" at the position <fx>, "<fy>"
    When We have another pawn "<FigureE>" of the color "<ColorE>" at the position <ex>, "<ey>"
    When We want go to <newX>, "<newY>"
    Then We can go there

    #1 - left
    #2 - up
    #3 - left_up
    #4 - right_up
    #5 - left_down

    #6 - right_down
    #7 - down
    #8 - right
    Examples:
      | FigureF   | ColorF  | fx | fy | FigureE | ColorE | ex | ey | newX | newY |
      | Horse     | black   | 5  | D  | Pawn    | black  |  5 |  C | 6    | B    |
      | Horse     | black   | 5  | D  | Pawn    | black  |  5 |  E | 6    | F    |
      | Horse     | black   | 5  | D  | Pawn    | black  |  6 |  D | 7    | C    |
      | Horse     | black   | 5  | D  | Pawn    | black  |  6 |  D | 7    | E    |

      | Horse     | black   | 5  | D  | Pawn    | black  |  5 |  C | 4    | B    |
      | Horse     | black   | 5  | D  | Pawn    | black  |  5 |  E | 4    | F    |
      | Horse     | black   | 5  | D  | Pawn    | black  |  4 |  C | 3    | c    |
      | Horse     | black   | 5  | D  | Pawn    | black  |  4 |  C | 3    | E    |
