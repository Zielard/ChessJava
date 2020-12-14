package com.company.Figure;

import com.company.GameObject;

public class Runner extends BasePawn {

    public Runner(boolean flag)
    {
        super(flag);
        if(flag == true)
        {
            this.setSymbol('♗');
        }
        else
        {
            this.setSymbol('♝');
        }
        this.type = FType.RUNNER;
    }

    @Override
    public boolean move(int fx, int fy,int px, int py,Plane boardTable[][])
    {
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

        //left up
        for(int t = fx-1;t<8;t--)
        {
            if(t >= 0 && s >= 0)
            {
                // find no enemy figure
                if(boardTable[t][s].getFigure() != null) {
                    if (boardTable[t][s].getFigure().getColor() == !enemyColor) {
                        break;
                    }
                }
                if((t == px) && (s== py))
                {
                    if(boardTable[t][s].getFigure() == null)
                    {
                        return true;
                    }
                    else
                    {
                        if(boardTable[t][s].getFigure().getColor() == enemyColor)
                        {
                            return true;
                        }
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

        //right up
        s = fy;
        for(int t = fx-1;t<8;t--)
        {
            s+=1;
            if(t >= 0 && s <= 7)
            {
                // find no enemy figure
                if(boardTable[t][s].getFigure() != null) {
                    if (boardTable[t][s].getFigure().getColor() == !enemyColor) {
                        break;
                    }
                }
                if((t == px) && (s== py))
                {
                    if(boardTable[t][s].getFigure() == null)
                    {
                        return true;
                    }
                    else
                    {
                        if(boardTable[t][s].getFigure().getColor() == enemyColor)
                        {
                            return true;
                        }
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

        //right down
        s = fy;
        for(int t = fx+1;t<8;t++)
        {
            s+=1;
            if(t <= 7 && s <= 7)
            {
                // find no enemy figure
                if(boardTable[t][s].getFigure() != null) {
                    if (boardTable[t][s].getFigure().getColor() == !enemyColor) {
                        break;
                    }
                }
                if((t == px) && (s== py))
                {
                    if(boardTable[t][s].getFigure() == null)
                    {
                        return true;
                    }
                    else
                    {
                        if(boardTable[t][s].getFigure().getColor() == enemyColor)
                        {
                            return true;
                        }
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

        //left down
        s = fy;
        for(int t = fx+1;t<8;t++)
        {
            s-=1;
            if(t <= 7 && s >= 0)
            {
                // find no enemy figure
                if(boardTable[t][s].getFigure() != null) {
                    if (boardTable[t][s].getFigure().getColor() == !enemyColor) {
                        break;
                    }
                }
                if((t == px) && (s== py))
                {
                    if(boardTable[t][s].getFigure() == null)
                    {
                        return true;
                    }
                    else
                    {
                        if(boardTable[t][s].getFigure().getColor() == enemyColor)
                        {
                            return true;
                        }
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
        return false;
    };
}
