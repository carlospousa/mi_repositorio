/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import model.Graph;
import model.Route;
import model.Town;

/**
 *
 * @author CARLOS
 */
public class Controller {

    /**
     * Creates a new graph with his nodes and edges
     *
     * @return gets the graph
     */
    public static Graph generateGraph() {

        //create all the towns (nodes)
        Town a = new Town("A");
        Town b = new Town("B");
        Town c = new Town("C");
        Town d = new Town("D");
        Town e = new Town("E");

        /*
        Add to the towns their different routes.
        First parameter is town origin(node), second town destination(node), and third the distance between both of them (edge weight)
         */
        a.addRoute(new Route(a, b, 5));
        a.addRoute(new Route(a, d, 5));
        a.addRoute(new Route(a, e, 7));
        b.addRoute(new Route(b, c, 4));
        c.addRoute(new Route(c, d, 8));
        c.addRoute(new Route(c, e, 2));
        d.addRoute(new Route(d, c, 8));
        d.addRoute(new Route(d, e, 6));
        e.addRoute(new Route(e, b, 3));

        /*
        Create the graph and add the towns
         */
        Graph graph = new Graph();
        graph.addTown(a);
        graph.addTown(b);
        graph.addTown(c);
        graph.addTown(d);
        graph.addTown(e);

        return graph;
    }

    /**
     * This method checks that the town introduced by the user exists. If
     * exists, pass the String to a Town object and then introduce that object
     * in a List. That list will be returned.
     *
     * @param towns A list of Strings with the name of the towns introduced by
     * the user
     * @param graph The generated graph
     * @return A list of Towns with the towns introduced by the user
     */
    public static List<Town> convertToTown(List<String> towns, Graph graph) {

        //get all the towns in the original graph
        List<Town> allTowns = graph.getTowns();

        //create a new ArrayList where the towns selected by the user will be added
        List<Town> pathTowns = new ArrayList();

        //check what towns in the graph are selected by the user and adds them to an array which will be returned
        for (int i = 0; i < towns.size(); i++) {
            for (int j = 0; j < allTowns.size(); j++) {
                if (allTowns.get(j).getName().equalsIgnoreCase(towns.get(i))) {
                    pathTowns.add(allTowns.get(j));
                }
            }
        }

        return pathTowns;
    }

    /**
     *
     * @param towns List of Town. Contains the towns introduced by the user
     * @return String with the whole distance between first town until the last.
     * If one of the towns is not connected with the next, returns a String with
     * "NO SUCH ROUTE"
     */
    public static String shortestRoute(List<Town> towns) {

        //add to distance the weight of the route between two towns 
        int distance = 0;

        //as a counter, if there is a complete route (node+edge+node), add +1. Using this counter, later it can be checked that every town are connected
        int routes = 0;

        /*
        This double loop iterate the towns and then, the routes of each town. If the name of the town of the route destination coincides with the name of the next town,
        we add the distance of that route and +1 to the routes counter. Finally use this counter to check every towns are connected and return the distance.
        If the routes are less than (towns-1), it means that there is at least one town not completely connected, so the return will be "NO SUCH ROUTE"
         */
        for (int i = 0; i < towns.size(); i++) {
            System.out.println();
            System.out.println(towns.get(i).getName());
            for (int j = 0; j < towns.get(i).getRoutes().size(); j++) {
                if (i + 1 == towns.size()) {
                    break;
                } else if (towns.get(i).getRoutes().get(j).getDestination().getName().equalsIgnoreCase(towns.get(i + 1).getName())) {
                    distance += towns.get(i).getRoutes().get(j).getDistance();
                    routes++;
                    System.out.println(routes);
                }
            }
        }

        if (routes == towns.size() - 1) {
            return Integer.toString(distance);
        } else {
            return "NO SUCH ROUTE";
        }
    }
}
