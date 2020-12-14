package com.company.Figure;

import com.company.GameObject;

public class BasePawn extends GameObject implements FigureI{

    private boolean color;
    public BasePawn(boolean colorIn)
    {
        super();
        this.color = colorIn;
    }

    public boolean getColor()
    {
        return color;
    }

    @Override
    public boolean move(int px, int py,int fx, int fy,Plane boardTable[][]) {
        return false;
    }
}
