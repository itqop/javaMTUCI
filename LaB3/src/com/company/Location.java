package com.company;

import java.awt.*;

public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

    public boolean equals(Location loc) {
        if (this.xCoord == loc.xCoord && this.yCoord == loc.yCoord){
            return true;
        }
        return false;
    }

    public int hashcode(){
        Object object = new Object();
        int hCode;
        hCode = object.hashCode();
        return hCode;
    }
}