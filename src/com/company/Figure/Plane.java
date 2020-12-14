package com.company.Figure;

import com.company.GameObject;

public class Plane extends GameObject
{
    BasePawn figure = null;
    public Plane()
    {
        super();
    }

    public Plane(boolean flagColor)
    {
        super();
        if(flagColor == true)
        {
            setSymbol('⛞');
        }
        else
        {
            setSymbol('⛝');
        }
    }

    public char getSymbol()
    {
        if(figure!=null)
        {
            return figure.symbol;
        }
        return this.symbol;
    }

    public void setGameObject(BasePawn figureIn)
    {
        figure = figureIn;
    }

    public BasePawn getFigure()
    {
        return figure;
    }
}
