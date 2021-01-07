package com.company;

import com.company.Figure.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Board {
    Plane boardTable[][];

    private King kingWhite, kingBlack;

    //start white player
    Boolean switchTurn = false;
    public Board()
    {
        boardTable = new Plane[8][8];
        boolean colorFlag = true;
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                boardTable[i][j] = new Plane(colorFlag);
                colorFlag = !colorFlag;
            }
            colorFlag = !colorFlag;
        }
    }

    public void runGame()
    {
        while(true) {
            System.out.println();

            this.printBoard();
            Scanner scan = new Scanner(System.in);
            String color = "";
            if (switchTurn == false) {
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
                this.saveBoardToFile();
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
    public void setDefaultState()
    {

        boardTable[0][0].setGameObject(new Tower(true));
        boardTable[0][1].setGameObject(new Horse(true));
        boardTable[0][2].setGameObject(new Runner(true));
        boardTable[0][3].setGameObject(new Queen(true));
        boardTable[0][4].setGameObject(new King(true));
        boardTable[0][5].setGameObject(new Runner(true));
        boardTable[0][6].setGameObject(new Horse(true));
        boardTable[0][7].setGameObject(new Tower(true));

        boardTable[7][0].setGameObject(new Tower(false));
        boardTable[7][1].setGameObject(new Horse(false));
        boardTable[7][2].setGameObject(new Runner(false));
        boardTable[7][3].setGameObject(new Queen(false));
        boardTable[7][4].setGameObject(new King(false));
        boardTable[7][5].setGameObject(new Runner(false));
        boardTable[7][6].setGameObject(new Horse(false));
        boardTable[7][7].setGameObject(new Tower(false));

        for(int i=0;i<8;i++)
        {
            boardTable[1][i].setGameObject(new Pawn(true));
            boardTable[6][i].setGameObject(new Pawn(false));
        }

        kingWhite = (King)boardTable[7][4].getFigure();
        kingWhite.setXY(7,4);

        kingBlack = (King)boardTable[0][4].getFigure();
        kingBlack.setXY(0,4);
    }

    public void printBoard()
    {

        // view letters
        int startLetter = 65;
        String lineL = "  ";
        for(int i=0;i<8;i++) {
            lineL+= (char)startLetter + " ";
            startLetter++;
        }
        System.out.println(lineL);

        // view number and board
        String line = "";
        for(int i=0;i<8;i++)
        {
            line+=(8- i) + " ";
            //line+=i+ " ";
            for(int j=0;j<8;j++)
            {
                line+= boardTable[i][j].getSymbol() + " ";
            }
            System.out.println(line);
            line= "";
        }
        System.out.println("");
    }

    public boolean checkMate(boolean color)
    {
        if(true == color)
        {
            return kingBlack.checkMateKing(this.boardTable);
        }
        else
        {
            return kingWhite.checkMateKing(this.boardTable);
        }
    }

    public void SelectAndMove(int fx, char fy, int px, char py)
    {
        int startLetter = 65;
        int fyInt = (int)fy - startLetter;
        int pyInt = (int)py - startLetter;
        BasePawn figure = boardTable[fx][fyInt].getFigure();

        if(figure != null)
        {
            if(figure.getColor() == this.switchTurn)
            {
                if(figure.move(fx,fyInt,px,pyInt,this.boardTable))
                {
                    BasePawn copy_figure = boardTable[fx][fyInt].getFigure();
                    BasePawn copy_figureEnemy =boardTable[px][pyInt].getFigure();

                    boardTable[fx][fyInt].setGameObject(null);
                    boardTable[px][pyInt].setGameObject(figure);

                    if(false == checkMate(figure.getColor()) )
                    {
                        System.out.println("Poprawny ruch");
                        switchTurn = !switchTurn;
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
        this.printBoard();
    };

    public void saveBoardToFile() {

        //Create File
        String fileName = "SavedGame";
        try {
            File myObj = new File(fileName + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("GameSave to file : " + myObj.getName());
            } else {
                System.out.println("Taki plik juz istnieje zostanie nadpisany.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //Write to file
        try {
            String out = new String();
            FileWriter myWriter = new FileWriter(fileName + ".txt");
            for(int i=0;i<8;i++)
            {
                for(int j=0;j<8;j++)
                {
                    if(this.boardTable[i][j].getFigure() != null)
                    {
                        out+=this.boardTable[i][j].getFigure().symbol + " ";
                    }
                    else
                    {
                        out+=this.boardTable[i][j].symbol + " ";
                    }
                }
                out+='\n';
            }
            // with player have move?
            out+=this.switchTurn;

            myWriter.write(out);
            myWriter.close();
            System.out.println("Stan gry zostal zapisany.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void loadBoardFromFile() {
        try {
            File myObj = new File("SavedGame.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                for(int i=0;i<8;i++)
                {
                    String data = myReader.nextLine();
                    String[] arrOfStr = data.split(" ");
                    for(int j=0;j<8;j++)
                    {
                        if(arrOfStr[j] != "⛝" && arrOfStr[j] != "⛞")
                        {
                            BasePawn pawn = null;
                            //Black
                            if(arrOfStr[j].equals("♙"))
                            {
                                pawn = new Pawn(true);
                            }
                            else if(arrOfStr[j].equals("♘"))
                            {
                                pawn = new Horse(true);
                            }
                            else if(arrOfStr[j].equals("♗"))
                            {
                                pawn = new Runner(true);
                            }
                            else if(arrOfStr[j].equals("♖"))
                            {
                                pawn = new Tower(true);
                            }
                            else if(arrOfStr[j].equals("♕"))
                            {
                                pawn = new Queen(true);
                            }
                            else if(arrOfStr[j].equals("♔"))
                            {
                                pawn = new King(true);
                                kingBlack = (King)pawn;
                                kingBlack.setXY(i,j);
                            }

                            //White
                            if(arrOfStr[j].equals("♟"))
                            {
                                pawn = new Pawn(false);
                            }
                            else if(arrOfStr[j].equals("♞"))
                            {
                                pawn = new Horse(false);
                            }
                            else if(arrOfStr[j].equals("♝"))
                            {
                                pawn = new Runner(false);
                            }
                            else if(arrOfStr[j].equals("♜"))
                            {
                                pawn = new Tower(false);
                            }
                            else if(arrOfStr[j].equals("♛"))
                            {
                                pawn = new Queen(false);
                            }
                            else if(arrOfStr[j].equals("♚"))
                            {
                                pawn = new King(false);
                                kingWhite = (King)pawn;
                                kingWhite.setXY(i,j);
                            }
                            boardTable[i][j].setGameObject(pawn);
                        }
                        else
                        {
                            boardTable[i][j].setGameObject(null);
                        }
                    }
                }
                String data = myReader.nextLine();
                if(data.equals("false")) // maja ruch biale
                {
                    this.switchTurn = false;
                }
                else if(data.equals("true"))  // maja ruch czarne
                {
                    this.switchTurn = true;
                }
                System.out.println("Stan gry zostal wczytany.");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
