package com.company;

import com.company.Figure.Engine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Engine engine =new Engine();

//DO TESTOW
//board.setDefaultState();
//board.printBoard();


        Scanner scan = new Scanner(System.in);
        while(true)
        {
            System.out.println("Wybierz opcje");
            System.out.println("1 - Rozpoczni nowa gre");
            System.out.println("2 - Wczytaj z pliku ustawienie pionkow i rozpoczni gre");
            System.out.println("3 - Zakoncz program");
            int dec = scan.nextInt();
            if(dec == 1)
            {
                engine.initDefaultBoard();
                engine.runGame();
            }
            else if(dec == 2)
            {
                engine.initSavedBoard();
                engine.runGame();
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
