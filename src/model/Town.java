/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author CARLOS
 */
public class Town {

    private String name;
    private List<Route> routes;

    //Getters and setters
    public Town(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    /**
     * Add a route to the town
     * 
     * @param route route to add
     */
    public void addRoute(Route route) {
        if (routes == null) {
            routes = new ArrayList();
        }

        routes.add(route);
    }
}
