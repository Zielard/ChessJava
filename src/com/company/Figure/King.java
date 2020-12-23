package com.company.Figure;

import com.company.GameObject;

public class King extends BasePawn {

    private int x,y;

    public void setXY(int x,int y) {
        this.x = x;
        this.y =y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

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
                if ((boardTable[px][py].getFigure() == null) || ((boardTable[px][py].getFigure() != null) &&
                        (boardTable[px][py].getFigure().getColor() == enemyColor))) {
                    return true;
                }
            }
        }

        if(fx >= 1)
        {
            if( (fx-1 == px) && (fy == py)) {
                if ((boardTable[px][py].getFigure() == null) || ((boardTable[px][py].getFigure() != null) &&
                        (boardTable[px][py].getFigure().getColor() == enemyColor))) {
                    return true;
                }
            }
        }

        if(fy <= 6)
        {
            if( (fx == px) && (fy+1 == py)) {
                if ((boardTable[px][py].getFigure() == null) || ((boardTable[px][py].getFigure() != null) &&
                        (boardTable[px][py].getFigure().getColor() == enemyColor))) {
                    return true;
                }
            }
        }

        if(fy >= 1)
        {
            if( (fx == px) && (fy-1 == py)) {
                if ((boardTable[px][py].getFigure() == null) || ((boardTable[px][py].getFigure() != null) &&
                        (boardTable[px][py].getFigure().getColor() == enemyColor))) {
                    return true;
                }
            }
        }

        if((fx >= 1) && (fy <= 6))
        {
            if( (fx-1 == px) && (fy+1 == py)) {
                if ((boardTable[px][py].getFigure() == null) || ((boardTable[px][py].getFigure() != null) &&
                        (boardTable[px][py].getFigure().getColor() == enemyColor))) {
                    return true;
                }
            }
        }

        if((fx <= 6) && (fy >= 1))
        {
            if( (fx+1 == px) && (fy-1 == py)) {
                if ((boardTable[px][py].getFigure() == null) || ((boardTable[px][py].getFigure() != null) &&
                        (boardTable[px][py].getFigure().getColor() == enemyColor))) {
                    return true;
                }
            }
        }

        if((fx <= 6) && (fy <= 6))
        {
            if( (fx+1 == px) && (fy+1 == py)) {
                if ((boardTable[px][py].getFigure() == null) || ((boardTable[px][py].getFigure() != null) &&
                        (boardTable[px][py].getFigure().getColor() == enemyColor))) {
                    return true;
                }
            }
        }

        if((fx >= 1) && (fy >= 1))
        {
            if( (fx-1 == px) && (fy-1 == py)) {
                if ((boardTable[px][py].getFigure() == null) || ((boardTable[px][py].getFigure() != null) &&
                        (boardTable[px][py].getFigure().getColor() == enemyColor))) {
                    return true;
                }
            }
        }
        return false;
    };

    public boolean checkMateKing(Plane boardTable[][])
    {
        int fx = this.x;
        int fy = this.y;

        int s = fy-1;
        boolean enemyColor = false;
        if(this.getColor() == false)
        {
            enemyColor = true;
        }
        else if(this.getColor()  == true)
        {
            enemyColor = false;
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////
        //FOR RUNNER AND QUEEN
        //left up
        for(int t = fx-1;t<8;t--)
        {
            if(t >= 0 && s >= 0)
            {
                // find figure
                if(boardTable[t][s].getFigure() != null)
                {
                    if (boardTable[t][s].getFigure().getColor() == enemyColor) {
                        //mate runnner and queen
                        if(boardTable[t][s].getFigure().type == FType.RUNNER || boardTable[t][s].getFigure().type == FType.QUEEN)
                        {
                            return true;
                        }
                        break;
                    }
                    if(boardTable[t][s].getFigure().getColor() == !enemyColor)
                    {
                        break;
                    }
                }
                s-=1;
            }
            else
            {
                //out of range
                break;
            }
        }

//        //right up
        s = fy;
        for(int t = fx-1;t<8;t--)
        {
            s+=1;
            if(t >= 0 && s <= 7)
            {
                // find figure
                if(boardTable[t][s].getFigure() != null)
                {
                    if (boardTable[t][s].getFigure().getColor() == enemyColor) {
                        //mate runnner and queen
                        if(boardTable[t][s].getFigure().type == FType.RUNNER || boardTable[t][s].getFigure().type == FType.QUEEN)
                        {
                            return true;
                        }
                        break;
                    }
                    if(boardTable[t][s].getFigure().getColor() == !enemyColor)
                    {
                        break;
                    }
                }
            }
            else
            {
                //out of range
                break;
            }
        }
//
//        //right down
        s = fy;
        for(int t = fx+1;t<8;t++)
        {
            s+=1;
            if(t <= 7 && s <= 7)
            {
                // find figure
                if(boardTable[t][s].getFigure() != null)
                {
                    if (boardTable[t][s].getFigure().getColor() == enemyColor) {
                        //mate runnner and queen
                        if(boardTable[t][s].getFigure().type == FType.RUNNER || boardTable[t][s].getFigure().type == FType.QUEEN)
                        {
                            return true;
                        }
                        break;
                    }
                    if(boardTable[t][s].getFigure().getColor() == !enemyColor)
                    {
                        break;
                    }
                }
            }
            else
            {
                //out of range
                break;
            }
        }
//
//        //left down
        s = fy;
        for(int t = fx+1;t<8;t++)
        {
            s-=1;
            if(t <= 8 && s >= 0)
            {
                // find figure
                if(boardTable[t][s].getFigure() != null)
                {
                    if (boardTable[t][s].getFigure().getColor() == enemyColor) {
                        //mate runnner and queen
                        if(boardTable[t][s].getFigure().type == FType.RUNNER || boardTable[t][s].getFigure().type == FType.QUEEN)
                        {
                            return true;
                        }
                        break;
                    }
                    if(boardTable[t][s].getFigure().getColor() == !enemyColor)
                    {
                        break;
                    }
                }
            }
            else
            {
                //out of range
                break;
            }
        }
//
//        ///////////////////////////////////////////////////////////////////////////////////////////////
//        //FOR TOWER AND QUEEN
//        //Down
//        for(int t = fx+1;t<8;t++) {
//
//            // find figure
//            if(boardTable[t][fy].getFigure() != null)
//            {
//                if(boardTable[t][fy].getFigure().getColor() == enemyColor)
//                {
//                    //mate runnner and queen
//                    if(boardTable[t][fy].getFigure().type == FType.TOWER || boardTable[t][s].getFigure().type == FType.QUEEN)
//                    {
//                        return true;
//                    }
//                }
//                if(boardTable[t][fy].getFigure().getColor() == !enemyColor)
//                {
//                    break;
//                }
//            }
//        }
//
//        //up
//        for(int t = fx-1;t<8;t--) {
//            if(t >= 0) {
//                // find figure
//                if(boardTable[t][fy].getFigure() != null)
//                {
//                    if(boardTable[t][fy].getFigure().getColor() == enemyColor)
//                    {
//                        //mate runnner and queen
//                        if(boardTable[t][fy].getFigure().type == FType.TOWER || boardTable[t][s].getFigure().type == FType.QUEEN)
//                        {
//                            return true;
//                        }
//                    }
//                    if(boardTable[t][fy].getFigure().getColor() == !enemyColor)
//                    {
//                        break;
//                    }
//                }
//            }
//        }
//
//        //right
//        for(int t = fy+1;t<8;t++) {
//            // find figure
//            if(boardTable[fx][t].getFigure() != null)
//            {
//                if(boardTable[fx][t].getFigure().getColor() == enemyColor)
//                {
//                    //mate runnner and queen
//                    if(boardTable[fx][t].getFigure().type == FType.TOWER || boardTable[t][s].getFigure().type == FType.QUEEN)
//                    {
//                        return true;
//                    }
//                }
//                if(boardTable[fx][t].getFigure().getColor() == !enemyColor)
//                {
//                    break;
//                }
//            }
//        }
//
//        //left
//        for(int t = fy;t<8;t--) {
//            if(t >= 0) {
//                // find figure
//                if(boardTable[fx][t].getFigure() != null)
//                {
//                    if(boardTable[fx][t].getFigure().getColor() == enemyColor)
//                    {
//                        //mate runnner and queen
//                        if(boardTable[fx][t].getFigure().type == FType.TOWER || boardTable[t][s].getFigure().type == FType.QUEEN)
//                        {
//                            return true;
//                        }
//                    }
//                    if(boardTable[fx][t].getFigure().getColor() == !enemyColor)
//                    {
//                        break;
//                    }
//                }
//            }
//        }
//
/////////////////////////////////////////////////////////////////////////////////////////////////
////FOR HORSE
//        if((fx >= 2) && (fy >= 1))
//        {
//                if ((boardTable[fx - 2][fy - 1].getFigure() != null))
//                {
//                    if (boardTable[fx - 2][fy - 1].getFigure().getColor() == enemyColor) {
//                        if(boardTable[fx - 2][fy - 1].getFigure().type == FType.HORSE)
//                        {
//                            return true;
//                        }
//                    }
//                }
//        }
//
//        if((fx >= 2) && (fy <= 6))
//        {
//            if ((boardTable[fx - 2][fy + 1].getFigure() != null))
//            {
//                if (boardTable[fx - 2][fy + 1].getFigure().getColor() == enemyColor) {
//                    if(boardTable[fx - 2][fy + 1].getFigure().type == FType.HORSE)
//                    {
//                        return true;
//                    }
//                }
//            }
//        }
//
//        if((fx >= 1) && (fy <= 5))
//        {
//            if ((boardTable[fx - 1][fy + 2].getFigure() != null))
//            {
//                if (boardTable[fx - 1][fy + 2].getFigure().getColor() == enemyColor) {
//                    if(boardTable[fx - 1][fy + 2].getFigure().type == FType.HORSE)
//                    {
//                        return true;
//                    }
//                }
//            }
//        }
//        if((fx >= 1) && (fy >= 2))
//        {
//            if ((boardTable[fx - 1][fy - 2].getFigure() != null))
//            {
//                if (boardTable[fx - 1][fy - 2].getFigure().getColor() == enemyColor) {
//                    if(boardTable[fx - 1][fy - 2].getFigure().type == FType.HORSE)
//                    {
//                        return true;
//                    }
//                }
//            }
//        }
//
//        if((fx <= 6) && (fy >= 2))
//        {
//            if ((boardTable[fx + 1][fy - 2].getFigure() != null))
//            {
//                if (boardTable[fx + 1][fy - 2].getFigure().getColor() == enemyColor) {
//                    if(boardTable[fx + 1][fy - 2].getFigure().type == FType.HORSE)
//                    {
//                        return true;
//                    }
//                }
//            }
//        }
//
//        if((fx <= 5) && (fy >= 1))
//        {
//            if ((boardTable[fx + 2][fy - 1].getFigure() != null))
//            {
//                if (boardTable[fx + 2][fy - 1].getFigure().getColor() == enemyColor) {
//                    if(boardTable[fx + 2][fy - 1].getFigure().type == FType.HORSE)
//                    {
//                        return true;
//                    }
//                }
//            }
//        }
//
//        if((fx <= 6) && (fy <= 5))
//        {
//            if ((boardTable[fx + 1][fy + 2].getFigure() != null))
//            {
//                if (boardTable[fx + 1][fy + 2].getFigure().getColor() == enemyColor) {
//                    if(boardTable[fx + 1][fy + 2].getFigure().type == FType.HORSE)
//                    {
//                        return true;
//                    }
//                }
//            }
//        }
//        if((fx <= 5) && (fy <= 6))
//        {
//            if ((boardTable[fx + 2][fy + 1].getFigure() != null))
//            {
//                if (boardTable[fx + 2][fy + 1].getFigure().getColor() == enemyColor) {
//                    if(boardTable[fx + 2][fy + 1].getFigure().type == FType.HORSE)
//                    {
//                        return true;
//                    }
//                }
//            }
//        }
        return false;
    }
}
