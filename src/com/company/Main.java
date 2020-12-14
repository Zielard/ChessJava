package com.company;

public class Main {

    public static void main(String[] args) {
	Board board = new Board();
    board.setDefaultState();
	board.printBoard();
            //board.loadBoardFromFile();
    board.SelectAndMove(6,'B',4,'B');
    board.SelectAndMove(1,'C',3,'C');
    board.SelectAndMove(4,'B',3,'C');
//        board.SelectAndMove(6,'C',4,'C');
//        board.SelectAndMove(7,'D',4,'A');
//        board.SelectAndMove(4,'A',4,'B');
//        board.SelectAndMove(7,'A',5,'A');
//        board.SelectAndMove(6,'B',4,'B');
//        board.SelectAndMove(1,'B',3,'B');
//        board.SelectAndMove(7,'C',5,'A');
//        board.SelectAndMove(0,'C',2,'A');
//        board.SelectAndMove(0,'B',2,'A');
//        board.SelectAndMove(2,'A',4,'B');
//        board.SelectAndMove(4,'B',6,'C');
//        board.SelectAndMove(0,'G',2,'F');
//
//        board.SelectAndMove(7,'G',5,'F');
//        board.SelectAndMove(3,'B',4,'A');
//        board.SelectAndMove(4,'A',6,'A');

        //board.loadBoardFromFile();
        while(true)
        {
//            board.SelectAndMove(6,'A',4,'A');
        }
    }

}
