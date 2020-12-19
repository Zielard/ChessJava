package com.company;

public class Main {

    public static void main(String[] args) {
	Board board = new Board();
    board.setDefaultState();
	board.printBoard();

        board.SelectAndMove(6,'D',4,'D');
        board.SelectAndMove(1,'C',3,'C');
        board.SelectAndMove(6,'B',4,'B');
        board.SelectAndMove(0,'D',3,'A');
        board.SelectAndMove(4,'B',3,'B');
        board.SelectAndMove(1,'H',2,'H');
        board.SelectAndMove(6,'H',4,'H');
//    Partia testowa
//    board.SelectAndMove(6,'B',4,'B');
//    board.SelectAndMove(1,'C',3,'C');
//    board.SelectAndMove(6,'A',4,'A');
//    board.SelectAndMove(3,'C',4,'B');
//    board.SelectAndMove(6,'E',4,'E');
//    board.SelectAndMove(4,'B',5,'B');
//    board.SelectAndMove(7,'E',6,'E');


        while(true)
        {
//            board.SelectAndMove(6,'A',4,'A');
        }
    }

}
