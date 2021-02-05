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
 * @author CARLOS POUSA
 */
public class Graph {

    private List<Town> towns;

    /**
     * Adds a new town to the graph
     *
     * @param town adds a town
     */
    public void addTown(Town town) {

        if (towns == null) {
            towns = new ArrayList();
        }

        towns.add(town);
    }

    /**
     * Gets towns from the graph
     *
     * @return gets all the nodes from the graph
     */
    public List<Town> getTowns() {
        return towns;
    }

}
