package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Board board = new Board();


//DO TESTOW
board.setDefaultState();
board.printBoard();

//    Partia testowa
//    board.SelectAndMove(6,'B',4,'B');
//    board.SelectAndMove(1,'C',3,'C');
//    board.SelectAndMove(6,'A',4,'A');
//    board.SelectAndMove(3,'C',4,'B');
//    board.SelectAndMove(6,'E',4,'E');
//    board.SelectAndMove(4,'B',5,'B');
//    board.SelectAndMove(7,'E',6,'E');

//  Partia z Szachem krolowej - Dla czarnych
//        board.SelectAndMove(6,'D',4,'D');
//        board.SelectAndMove(1,'C',3,'C');
//        board.SelectAndMove(6,'B',4,'B');
//        board.SelectAndMove(0,'D',3,'A');
//        board.SelectAndMove(4,'B',3,'B');
//        board.SelectAndMove(4,'B',3,'A');
//        board.SelectAndMove(3,'C',4,'D');
//        board.SelectAndMove(7,'D',4,'D');
//        board.SelectAndMove(1,'D',2,'D');
//        board.SelectAndMove(4,'D',2,'D');
//        board.SelectAndMove(1,'E',2,'E');
//        board.SelectAndMove(2,'D',0,'D');
//        board.SelectAndMove(2,'E',3,'E');

// Partia z szachem wiezy - Dla czarnych
//        board.SelectAndMove(6,'A',4,'A');
//        board.SelectAndMove(1,'A',3,'A');
//        board.SelectAndMove(7,'A',5,'A');
//        board.SelectAndMove(1,'H',2,'H');
//        board.SelectAndMove(5,'A',5,'E');
//        board.SelectAndMove(1,'E',3,'E');
//        board.SelectAndMove(5,'E',3,'E');
//        board.SelectAndMove(2,'H',3,'H');

// Partia z szachem konia - Dla czarnych
//        board.SelectAndMove(7,'B',5,'C');
//        board.SelectAndMove(1,'A',3,'A');
//        board.SelectAndMove(5,'C',3,'D');
//        board.SelectAndMove(3,'A',4,'A');
//        board.SelectAndMove(3,'D',2,'F');
//        board.SelectAndMove(4,'A',5,'A');


        Scanner scan = new Scanner(System.in);
        while(true)
        {
            System.out.println("Wybierz opcje");
            System.out.println("1 - Rozpoczni nowa gre");
            System.out.println("2 - Wczytaj z pliku ustawienie pionkow");
            System.out.println("3 - Zakoncz program");
            int dec = scan.nextInt();
            if(dec == 1)
            {
                board.setDefaultState();
                board.runGame();
            }
            else if(dec == 2)
            {
                board.loadBoardFromFile();
                board.runGame();
            }
            else if(dec == 3)
            {
                break;
            }
            else
            {
                System.out.println("Nie rozpoznana opcja");
            }
        }
    }

}
