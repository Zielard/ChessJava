package com.company.Figure;

import com.company.GameObject;

public abstract class BasePawn extends GameObject {

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

    public abstract boolean move(int px, int py,int fx, int fy,Plane boardTable[][]);
}
