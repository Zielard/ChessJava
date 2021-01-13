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

    private Plane boardTable[][];

    //ref for king pawns
    private King kingWhite, kingBlack;

    //start white player
    private Boolean switchTurn = false;

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

    public void setXYKingWhite(int x, int y) {
        kingWhite.setXY(x,y);
    }

    public void setXYKingBlack(int x, int y) {
        kingBlack.setXY(x,y);
    }

    public void setSwitchTurn(Boolean switchTurn) {
        this.switchTurn = switchTurn;
    }

    public Boolean getSwitchTurn() {
        return switchTurn;
    }

    public Plane[][] getBoardTable() {
        return boardTable;
    }

    public boolean checkMate(boolean color)
    {
        if(true == color)
        {
            return this.kingBlack.checkMateKing(this.boardTable);
        }
        else
        {
            return this.kingWhite.checkMateKing(this.boardTable);
        }
    }
    public void setDefaultState()
    {
        //clear board
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                boardTable[i][j].setGameObject(null);
            }
        }

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

        switchTurn = false;
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
            for(int j=0;j<8;j++)
            {
                line+= boardTable[i][j].getPlaneSymbol() + " ";
            }
            System.out.println(line);
            line= "";
        }
        System.out.println("");
    }

    public void saveBoardToFile()
    {

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
                        out+=this.boardTable[i][j].getFigure().getSymbol() + " ";
                    }
                    else
                    {
                        out+=this.boardTable[i][j].getPlaneSymbol() + " ";
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
