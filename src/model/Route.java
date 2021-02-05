/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author CARLOS
 */
public class Route {

    //A route has two towns
    //Start is the first town and is the same town than the object Town to which it belongs)
    private Town start;
    //Destination is the second town, shows the town to which the town of the route is destinated
    private Town destination;
    //the distance (edge wight) between two towns
    private int distance;

    public Route(Town start, Town destination, int distance) {
        this.start = start;
        this.destination = destination;
        this.distance = distance;
    }

    //Getters and setters
    public Town getStart() {
        return start;
    }

    public void setStart(Town start) {
        this.start = start;
    }

    public Town getDestination() {
        return destination;
    }

    public void setDestination(Town destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

}
