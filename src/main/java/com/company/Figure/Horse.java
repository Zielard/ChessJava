package com.company.Figure;

public class Horse extends BasePawn {
    public Horse(boolean flag)
    {
        super(flag);
        if(flag == true)
        {
            this.setSymbol('♘');
        }
        else
        {
            this.setSymbol('♞');
        }
        this.setType(FType.HORSE);
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

        if((fx >= 2) && (fy >= 1))
        {
            if(((fx - 2) == px) && ((fy - 1) == py))
            {
                if ((boardTable[px][py].getFigure() == null)) {
                    return true;
                } else {
                    if (boardTable[px][py].getFigure().getColor() == enemyColor) {
                        return true;
                    }
                }
            }
        }

        if((fx >= 2) && (fy <= 6))
        {
            if(((fx - 2) == px) && ((fy + 1) == py))
            {
                if ((boardTable[px][py].getFigure() == null)) {
                    return true;
                } else {
                    if (boardTable[px][py].getFigure().getColor() == enemyColor) {
                        return true;
                    }
                }
            }
        }

        if((fx >= 1) && (fy <= 5))
        {
            if(((fx - 1) == px) && ((fy + 2) == py))
            {
                if ((boardTable[px][py].getFigure() == null)) {
                    return true;
                } else {
                    if (boardTable[px][py].getFigure().getColor() == enemyColor) {
                        return true;
                    }
                }
            }
        }
        if((fx >= 1) && (fy >= 2))
        {
            if(((fx - 1) == px) && ((fy - 2) == py))
            {
                if ((boardTable[px][py].getFigure() == null)) {
                    return true;
                } else {
                    if (boardTable[px][py].getFigure().getColor() == enemyColor) {
                        return true;
                    }
                }
            }
        }

        if((fx <= 6) && (fy >= 2))
        {
            if(((fx + 1) == px) && ((fy - 2) == py))
            {
                if ((boardTable[px][py].getFigure() == null)) {
                    return true;
                } else {
                    if (boardTable[px][py].getFigure().getColor() == enemyColor) {
                        return true;
                    }
                }
            }
        }

        if((fx <= 5) && (fy >= 1))
        {
            if(((fx + 2) == px) && ((fy - 1) == py))
            {
                if ((boardTable[px][py].getFigure() == null)) {
                    return true;
                } else {
                    if (boardTable[px][py].getFigure().getColor() == enemyColor) {
                        return true;
                    }
                }
            }
        }

        if((fx <= 6) && (fy <= 5))
        {
            if(((fx + 1) == px) && ((fy + 2) == py))
            {
                if ((boardTable[px][py].getFigure() == null)) {
                    return true;
                } else {
                    if (boardTable[px][py].getFigure().getColor() == enemyColor) {
                        return true;
                    }
                }
            }
        }
        if((fx <= 5) && (fy <= 6))
        {
            if(((fx + 2) == px) && ((fy + 1) == py))
            {
                if ((boardTable[px][py].getFigure() == null)) {
                    return true;
                } else {
                    if ((boardTable[px][py].getFigure().getColor() == enemyColor)) {
                        return true;
                    }
                }
            }
        }
        return false;
    };
}
