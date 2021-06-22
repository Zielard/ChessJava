Feature: Figure moves

  Scenario Outline: Test - King move to every border
    Given We have a pawn "<Figure>" of the color "<Color>" at the position <x>, "<y>"
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
      | Figure | Color  | x | y | newX | newY |
      | King   | black  | 7 | B |    7 |    A |
      | King   | black  | 7 | B |    8 |    B |
      | King   | black  | 7 | B |    8 |    A |
      | King   | black  | 7 | G |    8 |    H |
      | King   | black  | 2 | B |    1 |    A |

      | King   | black  | 2 | G |    1 |    H |
      | King   | black  | 2 | G |    1 |    G |
      | King   | black  | 2 | G |    2 |    H |

      | King   | black  | 3 | B |    1 |    A |

  Scenario Outline: Test - Queen move to every border
    Given We have a pawn "<Figure>" of the color "<Color>" at the position <x>, "<y>"
    When We want go to <newX>, "<newY>"
    Then We can go there

    #1 - left_up
    #2 - right_down
    #3 - right_up
    #4 - left_down
    #5 - up
    #6 - down
    #7 - right
    #8 - left
    Examples:
      | Figure | Color  | x | y | newX | newY |
      | Queen  | black  | 5 | D |    8 |    A |
      | Queen  | black  | 5 | D |    1 |    H |
      | Queen  | black  | 5 | E |    8 |    H |
      | Queen  | black  | 5 | E |    1 |    A |
      | Queen  | black  | 5 | D |    8 |    D |
      | Queen  | black  | 5 | D |    1 |    D |
      | Queen  | black  | 5 | D |    5 |    H |
      | Queen  | black  | 5 | D |    5 |    A |

  Scenario Outline: Test - Tower move to every border
    Given We have a pawn "<Figure>" of the color "<Color>" at the position <x>, "<y>"
    When We want go to <newX>, "<newY>"
    Then We can go there

    #1 - up
    #2 - down
    #3 - right
    #4 - left

    #5 - left_up
    #6 - right_up
    #7 - right_down
    #8 - left_down
    Examples:
      | Figure | Color  | x | y | newX | newY |
      | Tower  | black  | 5 | D |    8 |    D |
      | Tower  | black  | 5 | D |    1 |    D |
      | Tower  | black  | 5 | D |    5 |    A |
      | Tower  | black  | 5 | D |    5 |    H |

      | Tower  | black  | 8 | D |    8 |    A |
      | Tower  | black  | 8 | D |    8 |    H |
      | Tower  | black  | 1 | D |    1 |    A |
      | Tower  | black  | 1 | D |    1 |    H |

  Scenario Outline: Test - Runner move to every border
    Given We have a pawn "<Figure>" of the color "<Color>" at the position <x>, "<y>"
    When We want go to <newX>, "<newY>"
    Then We can go there

    #1 - left_up
    #2 - right_down
    #3 - right_up
    #4 - left_down

    #1 - up
    #2 - right
    #3 - down
    #4 - left

    Examples:
      | Figure | Color  | x | y | newX | newY |
      | Runner  | black  | 5 | D |    8 |    A |
      | Runner  | black  | 5 | D |    1 |    H |
      | Runner  | black  | 5 | E |    8 |    H |
      | Runner  | black  | 5 | E |    1 |    A |

      | Runner  | black  | 7 | F |    8 |    G |
      | Runner  | black  | 7 | F |    5 |    H |
      | Runner  | black  | 2 | C |    1 |    B |
      | Runner  | black  | 2 | C |    4 |    A |

  Scenario Outline: Test - Horse move to every border
    Given We have a pawn "<Figure>" of the color "<Color>" at the position <x>, "<y>"
    When We want go to <newX>, "<newY>"
    Then We can go there

    #1 - left
    #2 - up
    #3 - left_up
    #4 - right_up
    #5 - right

    #6 - down
    #7 - left_down
    #8 - right_down

    Examples:
      | Figure | Color  | x | y | newX | newY |
      | Horse  | black  | 6 | C |    5 |    A |
      | Horse  | black  | 6 | C |    8 |    B |
      | Horse  | black  | 6 | B |    8 |    A |
      | Horse  | black  | 6 | G |    8 |    H |
      | Horse  | black  | 7 | F |    6 |    H |
      | Horse  | black  | 7 | F |    8 |    D |

      | Horse  | black  | 2 | C |    1 |    E |
      | Horse  | black  | 2 | C |    1 |    A |
      | Horse  | black  | 2 | F |    1 |    H |

  Scenario Outline: Test - Pawn move to border upper and down
    Given We have a pawn "<Figure>" of the color "<Color>" at the position <x>, "<y>"
    When We want go to <newX>, "<newY>"
    Then We can go there

    #1 - up
    #2 - down
    Examples:
      | Figure | Color  | x | y | newX | newY |
      | Pawn   | black  | 7 | D |    8 |    D |
      | Pawn   | white  | 2 | D |    1 |    D |

