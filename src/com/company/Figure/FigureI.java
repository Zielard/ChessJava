package com.company.Figure;


import com.company.GameObject;

public interface FigureI {
    public abstract boolean move(int px, int py,int fx, int fy,Plane boardTable[][]);
}
