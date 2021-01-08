package com.company.Figure;

import com.company.Board;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Engine {

    private Board board;

    public Engine()
    {
        board = new Board();
    }
    public void initDefaultBoard()
    {
        board.setDefaultState();
    }

    public void initSavedBoard()
    {
        board.loadBoardFromFile();
    }

    public void runGame()
    {
        while(true) {

            System.out.println();
            this.board.printBoard();
            Scanner scan = new Scanner(System.in);
            String color = "";
            if (this.board.getSwitchTurn() == false) {
                color = "biale";
            } else {
                color = "czarne";
            }
            System.out.println("Ruch maja " + color);
            System.out.println("1 - zapisz partie do piku");
            System.out.println("2 - Zakoncz gre");
            System.out.println("Wykonaj ruch w nasteoujacym formacie : ABCD (np. B2B3 )");
            String dec = scan.next();

            if (dec.equals("1"))
            {
                this.board.saveBoardToFile();
            }
            else if (dec.equals("2"))
            {
                break;
            }
            else
            {
                if(dec.length() == 4)
                {
                    int fx = 8-(dec.charAt(1) - '0');
                    char fy = dec.charAt(0);

                    int px = 8-(dec.charAt(3) - '0');
                    char py = dec.charAt(2);

                    //walidacja kordynatow
                    if((fx>=0 && fx<=8) && (px>=0 && px<=8))
                    {
                        int startLetter = 65;
                        int fyInt = (int)fy - startLetter;
                        int pyInt = (int)py - startLetter;
                        if((fyInt>=0 && fyInt<=8) && (pyInt>=0 && pyInt<=8))
                        {
                            this.SelectAndMove(fx, fy, px, py);
                        }
                        else
                        {
                            System.out.println("zle wpisane kordynaty");
                        }
                    }
                    else
                    {
                        System.out.println("zle wpisane kordynaty");
                    }
                }
                else
                {
                    System.out.println("zle wpisane kordynaty");
                }
            }
        }
    }

    public void SelectAndMove(int fx, char fy, int px, char py)
    {
        Plane[][] boardTable = this.board.getBoardTable();
        int startLetter = 65;
        int fyInt = (int)fy - startLetter;
        int pyInt = (int)py - startLetter;
        BasePawn figure = boardTable[fx][fyInt].getFigure();

        if(figure != null)
        {
            if(figure.getColor() ==  this.board.getSwitchTurn())
            {
                if(figure.move(fx,fyInt,px,pyInt,boardTable))
                {
                    BasePawn copy_figure = boardTable[fx][fyInt].getFigure();
                    BasePawn copy_figureEnemy =boardTable[px][pyInt].getFigure();

                    boardTable[fx][fyInt].setGameObject(null);
                    boardTable[px][pyInt].setGameObject(figure);

                    if(false == this.board.checkMate(figure.getColor()) )
                    {
                        if(figure.symbol == '♔' )
                        {
                            this.board.setXYKingWhite(fx,fyInt);
                        }

                        if(figure.symbol == '♚')
                        {
                            this.board.setXYKingBlack(fx,fyInt);
                        }
                        System.out.println("Poprawny ruch");
                        boolean flag = this.board.getSwitchTurn();
                        this.board.setSwitchTurn(!flag);
                    }
                    else
                    {
                        boardTable[fx][fyInt].setGameObject(copy_figure);
                        boardTable[px][pyInt].setGameObject(copy_figureEnemy);
                        System.out.println("Blad : Nie mozna wykonac ruchu przez szach krola");
                    }
                }
                else
                {
                    System.out.println("Blad : Nie dozwolony ruch");
                }
            }
            else
            {
                String color = "";
                if(figure.getColor())
                {
                    color = "bialego";
                }
                else
                {
                    color = "czarnego";
                }
                System.out.println("Blad : Ruch ma gracz koloru "+color);
            }
        }
        else
        {
            System.out.println("Blad : Na polu nieznajduje sie zaden pionek");
        }
    };
}
