package com.company;

import com.company.Figure.FType;
import com.company.Figure.Plane;

public class GameObject
{
    private FType type;
    private char symbol = '⛞';

    public FType getType() {
        return type;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setType(FType type) {
        this.type = type;
    }

    public void setSymbol(char newSymbol)
    {
        this.symbol =newSymbol;
    }

    public GameObject()
    {
        type = FType.PLANE;
    }

}
