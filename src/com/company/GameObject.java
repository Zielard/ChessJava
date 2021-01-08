package com.company;

import com.company.Figure.FType;
import com.company.Figure.Plane;

public class GameObject
{
    public FType type;
    public char symbol = '⛞';

    public GameObject()
    {
        type = FType.PLANE;
    }

    public GameObject(char symbolIn)
    {
        this.symbol = symbolIn;
    }

    public void setSymbol(char newSymbol)
    {
        this.symbol =newSymbol;
    }

}
