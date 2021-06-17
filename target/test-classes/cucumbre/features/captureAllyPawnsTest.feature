Feature: Capture ally Pawns

  Scenario Outline: Test - King capturing ally pawns
    Given We have a pawn "<FigureF>" of the color "<ColorF>" at the position <fx>, "<fy>"
    When We have another pawn "<FigureE>" of the color "<ColorE>" at the position <ex>, "<ey>"
    Then We cant capture another pawn

    #1 - left
    #2 - up
    #3 - left_up
    #4 - right_up
    #5 - left_down

    #6 - right_down
    #7 - down
    #8 - right
    Examples:
      | FigureF | ColorF  | fx | fy | FigureE | ColorE | ex | ey |
      | King    | black   | 7  | B  | Pawn    | black  |  8 |  A |
      | King    | black   | 7  | B  | Pawn    | black  |  8 |  B |
      | King    | black   | 7  | B  | Pawn    | black  |  7 |  A |
      | King    | black   | 7  | G  | Pawn    | black  |  8 |  H |
      | King    | black   | 2  | B  | Pawn    | black  |  1 |  A |

      | King    | black   | 2  | G  | Pawn    | black  |  1 |  H |
      | King    | black   | 2  | G  | Pawn    | black  |  1 |  G |
      | King    | black   | 2  | G  | Pawn    | black  |  2 |  H |

  Scenario Outline: Test - Queen capturing ally pawns
    Given We have a pawn "<FigureF>" of the color "<ColorF>" at the position <fx>, "<fy>"
    When We have another pawn "<FigureE>" of the color "<ColorE>" at the position <ex>, "<ey>"
    Then We cant capture another pawn

    #1 - left_up
    #2 - right_down
    #3 - right_up
    #4 - left_down
    #5 - up
    #6 - down
    #7 - right
    #8 - left
    Examples:
      | FigureF  | ColorF  | fx | fy | FigureE | ColorE | ex | ey |
      | Queen    | black   | 5  | D  | Pawn    | black  |  8 |  A |
      | Queen    | black   | 5  | D  | Pawn    | black  |  1 |  H |
      | Queen    | black   | 5  | E  | Pawn    | black  |  8 |  H |
      | Queen    | black   | 5  | E  | Pawn    | black  |  1 |  A |
      | Queen    | black   | 5  | D  | Pawn    | black  |  8 |  D |
      | Queen    | black   | 5  | D  | Pawn    | black  |  1 |  D |
      | Queen    | black   | 5  | D  | Pawn    | black  |  5 |  H |
      | Queen    | black   | 5  | D  | Pawn    | black  |  5 |  A |

  Scenario Outline: Test - Tower capturing ally pawns
    Given We have a pawn "<FigureF>" of the color "<ColorF>" at the position <fx>, "<fy>"
    When We have another pawn "<FigureE>" of the color "<ColorE>" at the position <ex>, "<ey>"
    Then We cant capture another pawn

    #1 - up
    #2 - down
    #3 - right
    #4 - left

    #5 - left_up
    #6 - right_up
    #7 - right_down
    #8 - left_down
    Examples:
      | FigureF  | ColorF  | fx | fy | FigureE | ColorE | ex | ey |
      | Tower    | black   | 5  | D  | Pawn    | black  |  8 |  D |
      | Tower    | black   | 5  | D  | Pawn    | black  |  1 |  D |
      | Tower    | black   | 5  | D  | Pawn    | black  |  5 |  A |
      | Tower    | black   | 5  | D  | Pawn    | black  |  5 |  H |

      | Tower    | black   | 8  | D  | Pawn    | black  |  8 |  A |
      | Tower    | black   | 8  | D  | Pawn    | black  |  8 |  H |
      | Tower    | black   | 1  | D  | Pawn    | black  |  1 |  A |
      | Tower    | black   | 1  | D  | Pawn    | black  |  1 |  H |

  Scenario Outline: Test - Runner capturing ally pawns
    Given We have a pawn "<FigureF>" of the color "<ColorF>" at the position <fx>, "<fy>"
    When We have another pawn "<FigureE>" of the color "<ColorE>" at the position <ex>, "<ey>"
    Then We cant capture another pawn

    #1 - left_up
    #2 - right_down
    #3 - right_up
    #4 - left_down

    #1 - up
    #2 - right
    #3 - down
    #4 - left

    Examples:
      | FigureF  | ColorF  | fx | fy | FigureE | ColorE | ex | ey |
      | Runner    | black   | 5  | D  | Pawn    | black  |  8 |  A |
      | Runner    | black   | 5  | D  | Pawn    | black  |  1 |  H |
      | Runner    | black   | 5  | E  | Pawn    | black  |  8 |  H |
      | Runner    | black   | 5  | E  | Pawn    | black  |  1 |  A |

      | Runner    | black   | 7  | F  | Pawn    | black  |  8 |  G |
      | Runner    | black   | 7  | F  | Pawn    | black  |  5 |  H |
      | Runner    | black   | 2  | C  | Pawn    | black  |  1 |  B |
      | Runner    | black   | 2  | C  | Pawn    | black  |  4 |  A |

  Scenario Outline: Test - Horse capturing ally pawns
    Given We have a pawn "<FigureF>" of the color "<ColorF>" at the position <fx>, "<fy>"
    When We have another pawn "<FigureE>" of the color "<ColorE>" at the position <ex>, "<ey>"
    Then We cant capture another pawn
    #1 - left
    #2 - up
    #3 - left_up
    #4 - right_up
    #5 - right

    #6 - down
    #7 - left_down
    #8 - right_down

    Examples:
      | FigureF  | ColorF  | fx | fy | FigureE | ColorE | ex | ey |
      | Horse    | black   | 6  | C  | Pawn    | black  |  5 |  A |
      | Horse    | black   | 6  | C  | Pawn    | black  |  8 |  B |
      | Horse    | black   | 6  | B  | Pawn    | black  |  8 |  A |
      | Horse    | black   | 6  | G  | Pawn    | black  |  8 |  H |

      | Horse    | black   | 7  | F  | Pawn    | black  |  6 |  H |
      | Horse    | black   | 2  | C  | Pawn    | black  |  1 |  E |
      | Horse    | black   | 2  | C  | Pawn    | black  |  1 |  A |
      | Horse    | black   | 2  | F  | Pawn    | black  |  1 |  H |

  Scenario Outline: Test - Horse capturing ally pawns
    Given We have a pawn "<FigureF>" of the color "<ColorF>" at the position <fx>, "<fy>"
    When We have another pawn "<FigureE>" of the color "<ColorE>" at the position <ex>, "<ey>"
    Then We cant capture another pawn

    Examples:
      | FigureF  | ColorF  | fx | fy | FigureE | ColorE | ex | ey |
      | Pawn     | black   | 7  | D  | Pawn    | black  |  8 |  C |
      | Pawn     | black   | 7  | D  | Pawn    | black  |  8 |  E |
      | Pawn     | black   | 3  | D  | Pawn    | black  |  1 |  C |
      | Pawn     | black   | 3  | D  | Pawn    | black  |  1 |  E |

