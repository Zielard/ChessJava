package com.company.Figure;

import com.company.GameObject;

public class Plane extends GameObject
{
    private BasePawn figure = null;

    public Plane()
    {
        super();
    }

    public Plane(boolean flagColor)
    {
        super();
        if(flagColor == true)
        {
            this.setSymbol('⛞');
        }
        else
        {
            setSymbol('⛝');
        }
    }

    public char getPlaneSymbol()
    {
        if(figure!=null)
        {
            return figure.getSymbol();
        }
        return this.getSymbol();
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
