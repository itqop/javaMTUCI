package com.company;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class AStarState
{
    public int po = 0;
     /** This is a reference to the map that the A* algorithm is navigating. **/
    private Map2D map;
    HashMap<Location, Waypoint> open = new HashMap<>();
    HashMap<Location, Waypoint> clos = new HashMap<>();
    public Location fon = null;
    public boolean cont(Location locc) {
        for (Location key : this.open.keySet()) {
            if (this.open.get(key).loc.equals(locc)){
                fon = key;
                return true;
            }
        }
        return false;
    }
    public boolean contA(Location locc) {
        for (Location key : this.clos.keySet()) {
            if (this.clos.get(key).loc.equals(locc)){
                return true;
            }
        }
        return false;
    }


    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

     /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap()
    {
        return map;
    }

     /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost.  If there are no open waypoints, this method
     * returns <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint()
    {
        Waypoint point = null;
        float total = Float.MAX_VALUE;
        for (Location key: this.open.keySet()){
            if(this.open.get(key).getTotalCost()<total){
                total = this.open.get(key).getTotalCost();
                point = this.open.get(key);
            }
        }
        return point;
    }

     /**
     * This method adds a waypoint to (or potentially updates a waypoint already
     * in) the "open waypoints" collection.  If there is not already an open
     * waypoint at the new waypoint's location then the new waypoint is simply
     * added to the collection.  However, if there is already a waypoint at the
     * new waypoint's location, the new waypoint replaces the old one <em>only
     * if</em> the new waypoint's "previous cost" value is less than the current
     * waypoint's "previous cost" value.
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        if (this.open.keySet().isEmpty()){
            this.open.put(newWP.loc, newWP);
            return true;
        }
        //System.out.print(this.open.keySet());
        boolean a = this.cont(newWP.loc);
        if (!(a)){
            this.open.put(newWP.loc, newWP);
            /*
            System.out.print(po++);
            System.out.print(" ");
            System.out.print(newWP.loc.xCoord);
            System.out.print(" ");
            System.out.println(newWP.loc.yCoord);

             */
            return true;
        }else {
            Waypoint point = this.open.get(fon);
            if(point.getPreviousCost()>newWP.getPreviousCost()){
                this.open.put(newWP.loc, newWP);
                return true;
            }
        }
        return false;
    }

    /** Returns the current number of open waypoints. **/
    public int numOpenWaypoints()
    {
        return this.open.size();
    }

        /**
         * Location q = (this.open.get(newWP.loc).loc);
         *         Location w = newWP.loc;
         *         boolean a =  q.equals(w);
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/

    public void closeWaypoint(Location loc)
    {
        Waypoint wer = this.open.get(loc);
        this.open.remove(loc);
        this.clos.put(loc, wer);
    }

     /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/

    public boolean isLocationClosed(Location loc)
    {
        if (this.contA(loc)){
            return true;
        }

        return false;
    }

}
