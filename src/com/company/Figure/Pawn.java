package com.company.Figure;

import com.company.GameObject;

public class Pawn extends BasePawn
{
    public Pawn(boolean flag)
    {
        super(flag);
        if(flag == true)
        {
            this.setSymbol('♙');
        }
        else
        {
            this.setSymbol('♟');
        }
        this.type = FType.PAWN;
    }

    @Override
    public boolean move(int fx, int fy,int px, int py,Plane boardTable[][])
    {
        boolean enemyColor = false;
        if(this.getColor() == false)
        {
            enemyColor = true;
        }
        else if(this.getColor()  == true)
        {
            enemyColor = false;
        }
        //dla bialych
        if(this.getColor() == false)
        {
            if((fx <= 7) && (fy <= 7))
            {
                //bicie w prawo
                if( (fx-1 == px) && (fy-1 == py))
                {
                    if((boardTable[px][py].getFigure() != null) && (boardTable[px][py].getFigure().getColor() == enemyColor))
                    {
                        return true;
                    }
                }

            }
            if((fx <= 7) && (fy >= 0))
            {
                //bicie w lewo
                if( (fx-1 == px) && (fy+1 == py))
                {
                    if ((boardTable[px][py].getFigure() != null) && (boardTable[px][py].getFigure().getColor() == enemyColor))
                    {
                        return true;
                    }
                }
            }
            if((fx <= 7)) {
                if (boardTable[px][py].getFigure() == null) {
                    if (fx == 6) {
                        //jesli stoi na pierwszej lini sa dwie opcje ruchu
                        if ((fx - 1 == px) && (fy == py)) {
                            return true;
                        }
                        if ((fx - 2 == px) && (fy == py)) {
                            return true;
                        }

                    } else {
                        //jesli dalej to tylko jeden ruch
                        if ((fx - 1 == px) && (fy == py)) {
                            return true;
                        }
                    }
                }
            }
        }
        else
        {
            if((fx >= 1) && (fy <= 7))
            {
                //bicie w lewo
                if( (fx+1 == px) && (fy-1 == py))
                {
                    if ((boardTable[px][py].getFigure() != null) && (boardTable[px][py].getFigure().getColor() == enemyColor))
                    {
                        System.out.println("Bicie!");
                        return true;
                    }
                }
            }
            if((fx >= 1) && (fy >= 1))
            {
                //bicie w prawo
                if( (fx+1 == px) && (fy+1 == py))
                {
                    if ((boardTable[px][py].getFigure() != null) && (boardTable[px][py].getFigure().getColor() == enemyColor))
                    {
                        System.out.println("Bicie!");
                        return true;
                    }
                }
            }
            if((fx >= 1))
            {
                if(boardTable[px][py].getFigure() == null)
                {
                    if(fx==1)
                    {
                        //jesli stoi na pierwszej lini sa dwie opcje ruchu
                        if((fx+1 == px) && (fy == py))
                        {
                            return true;
                        }
                        if((fx+2 == px) && (fy == py))
                        {
                            return true;
                        }
                    }
                    else
                    {
                        //jesli dalej to tylko jeden ruch
                        if((fx+1 == px) && (fy == py))
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    };
}
