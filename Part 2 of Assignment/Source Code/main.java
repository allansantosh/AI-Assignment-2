

package genetic_algorithm;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class main {
	
	public static ArrayList<Integer>numbers = new ArrayList<Integer>();
	public static ArrayList<Integer>numbers2 = new ArrayList<Integer>();
	public static double distance_check_number = 1000;

	
	public static double [][] cities_inter_distances = {
			
	// Everything same as the Part 1 of the assignment but this time we have distances instead of coordinates.
	
	{  0, 172, 145, 607, 329,  72, 312, 120},
	{172,   0, 192, 494, 209, 158, 216, 92},
	{145, 192,   0, 490, 237,  75, 205, 100},
	{607, 494, 490,   0, 286, 545, 296, 489},
	{329, 209, 237, 286,   0, 421,  49, 208},
	{ 72, 158,  75, 545, 421,   0, 249,  75},
	{312, 216, 205, 296,  49, 249,   0, 194},
	{120,  92, 100, 489, 208,  75, 194,   0}	
	};
	
	public static String [] city_names = {"Brighton","Bristol",
			"Cambridge","Glasgow","Liverpool",
		"London","Manchester","Oxford"};
	
	
	
	public static cities [] all_cities = new cities[20];
	public static int num_routes = 50;
	public static int status = 1;
	public static int multiplier = 100;
	
	  public static all_routes evaluation(all_routes route) {
	    	
	    	all_routes all_routes = new all_routes(route.routes.length, 0);
	    	int offset_value = 1;
	    	all_routes.routes[0]= route.get_best_route();
	   
	        for (int i = offset_value; i < all_routes.routes.length; i++) {
	            create_route route_a = selection(route);
	            create_route route_b = selection(route);
	            create_route route_ab = crossover(route_a, route_b);
	            all_routes.routes[i]= route_ab;
	        }

	        for (int i = offset_value; i < all_routes.routes.length; i++) {
	            mutation(all_routes.routes[i]);
	        }

	        return all_routes;
	    }
	    
	   
	    public static create_route selection(all_routes route) {
	        
	        all_routes all_routes = new all_routes(5, 0);

	        for (int i = 0; i < 5; i++) {
	            int length = (int) (Math.random() * route.routes.length);
	            all_routes.routes[i] = route.routes[length];
	        }
	        
	        create_route best_route = all_routes.get_best_route();
	        return best_route;
	    }

	 
	    public static create_route crossover(create_route route_a, create_route route_b) {
	 
	        int initial = (int) (Math.random() * route_a.routes.size());
	        int end = (int) (Math.random() * route_b.routes.size());
	    	create_route route_ab = new create_route();
	 
	        for (int i = 0; i < route_ab.routes.size(); i++) {
	        	
	            if (initial < end && i > initial && i < end) {
	            	route_ab.routes.set(i, route_a.routes.get(i));
	            	route_ab.fitness_value = 0;
	            	route_ab.distance_value = 0;
	            } 
	            
	            else if (initial > end) {
	                if (!(i < initial && i > end)) {
	                	route_ab.routes.set(i, route_a.routes.get(i));
	                	route_ab.fitness_value = 0;
	                	route_ab.distance_value = 0;
	                }
	            }
	        }

	        for (int i = 0; i < route_b.routes.size(); i++) {
	            if (!route_ab.routes.contains(route_b.routes.get(i))) {
	                for (int j = 0; j < route_ab.routes.size(); j++) {
	                    if (route_ab.routes.get(j) == null) {
	                    	route_ab.routes.set(j, route_b.routes.get(i));
	                    	route_ab.fitness_value = 0;
	                    	route_ab.distance_value = 0;
	                        break;
	                    }
	                }
	            }
	        }
	        return route_ab;
	    }

	   
	    public static void mutation(create_route route) {

	        for(int i=0; i < route.routes.size(); i++){

	            if(Math.random() < 0.015){

	                int j = (int) (route.routes.size() * Math.random());

	                cities first = route.routes.get(i);
	                cities second = route.routes.get(j);

	                route.routes.set(j, first);
	                route.fitness_value = 0;
	                route.distance_value = 0;
	                route.routes.set(i, second);
	                route.fitness_value = 0;
	                route.distance_value = 0;
	            }
	        }
	    }

	
	
    public static void main(String[] args) {
    	
    	main assignment2 = new main();
 
    	for (int i = 0, x = 0; i < 8; i++) {
    		all_cities[i] = new cities(i,city_names[i]);
    		create_route.visiting_cities.add(all_cities[i]);
    	}
    
        all_routes all_routes = new all_routes(num_routes, status);
     
        all_routes = evaluation(all_routes);
        for (int i = 0; i < multiplier; i++) {
        	all_routes = evaluation(all_routes);
        }

        System.out.println("Order the sales man should travel -->");
        	
        	numbers2.clear();
        	distance_check_number = all_routes.get_best_route().distance();
        	System.out.print(all_routes.get_best_route());
        	
        	System.out.println("\n\nThe total distance travelled is: " + distance_check_number);
      
    }
    
}

