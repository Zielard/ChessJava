package com.company.Figure;

import com.company.GameObject;

public class King extends BasePawn {
    public King(boolean flag)
    {
        super(flag);
        if(flag == true)
        {
            this.setSymbol('♔');
        }
        else
        {
            this.setSymbol('♚');
        }
        this.type = FType.KING;
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
        if(fx <= 6)
        {
            if( (fx+1 == px) && (fy == py)) {
                if ((boardTable[px][py].figure == null) || ((boardTable[px][py].figure != null) && (boardTable[px][py].figure.getColor() == enemyColor))) {
                    return true;
                }
            }
        }

        if(fx >= 1)
        {
            if( (fx-1 == px) && (fy == py)) {
                if ((boardTable[px][py].figure == null) || ((boardTable[px][py].figure != null) && (boardTable[px][py].figure.getColor() == enemyColor))) {
                    return true;
                }
            }
        }

        if(fy <= 6)
        {
            if( (fx == px) && (fy+1 == py)) {
                if ((boardTable[px][py].figure == null) || ((boardTable[px][py].figure != null) && (boardTable[px][py].figure.getColor() == enemyColor))) {
                    return true;
                }
            }
        }

        if(fy >= 1)
        {
            if( (fx == px) && (fy-1 == py)) {
                if ((boardTable[px][py].figure == null) || ((boardTable[px][py].figure != null) && (boardTable[px][py].figure.getColor() == enemyColor))) {
                    return true;
                }
            }
        }

        if((fx >= 1) && (fy <= 6))
        {
            if( (fx-1 == px) && (fy+1 == py)) {
                if ((boardTable[px][py].figure == null) || ((boardTable[px][py].figure != null) && (boardTable[px][py].figure.getColor() == enemyColor))) {
                    return true;
                }
            }
        }

        if((fx <= 6) && (fy >= 1))
        {
            if( (fx+1 == px) && (fy-1 == py)) {
                if ((boardTable[px][py].figure == null) || ((boardTable[px][py].figure != null) && (boardTable[px][py].figure.getColor() == enemyColor))) {
                    return true;
                }
            }
        }

        if((fx <= 6) && (fy <= 6))
        {
            if( (fx+1 == px) && (fy+1 == py)) {
                if ((boardTable[px][py].figure == null) || ((boardTable[px][py].figure != null) && (boardTable[px][py].figure.getColor() == enemyColor))) {
                    return true;
                }
            }
        }

        if((fx >= 1) && (fy >= 1))
        {
            if( (fx-1 == px) && (fy-1 == py)) {
                if ((boardTable[px][py].figure == null) || ((boardTable[px][py].figure != null) && (boardTable[px][py].figure.getColor() == enemyColor))) {
                    return true;
                }
            }
        }
        return false;
    };
}
