
package genetic_algorithm;

import java.util.*;

public class create_route{
	
	// Initialize an array of all routes

	public static ArrayList<cities> visiting_cities = new ArrayList <cities>(); 
    public ArrayList<cities> routes = new ArrayList<cities>();
    public double fitness_value;
    public int distance_value;
   
    
    public create_route(ArrayList<cities> city_route){
        routes = city_route;
    }
    
    // Fill up array with empty routes
    
    public create_route(){
        for (int i = 0; i < visiting_cities.size(); i++) {
            routes.add(null);
        }
    }
    
    // Calculates the total distance of the route.
    
    public double distance(){
        
    	if (distance_value == 0) {
           int route_length = 0;
     
            for (int i=0; i < routes.size(); i++) {
               
                cities start_city = routes.get(i);
                cities end_city;
               
                // If the city is the last city on the route, then make it the initial city.
                
                if( i+1 < routes.size()){
                	end_city = routes.get(i+1);
                }
                else{
                	end_city = routes.get(0);
                }
                route_length =  (int) (route_length + start_city.calculate_distance_to(end_city));
            }
            
            distance_value = route_length;
        }
        return distance_value;
    }

    // Creates a route.
    
    public void make_a_route() {
        
    	for (int i = 0; i < visiting_cities.size(); i++) {
          routes.set(i, visiting_cities.get(i));
          fitness_value = 0;
          distance_value = 0;
        }
    }
    
    // This function gets the routes fitness value.

    public double get_fitness_value() {
        if (fitness_value == 0) {
            fitness_value = 
            1 / distance();
        }
        return fitness_value;
    }
    
    @Override
    
    // Print the coordinates
    
    public String toString() {
        String spacer = "\n";
        for (int i = 0; i < routes.size(); i++) {
            spacer += routes.get(i)+" ";
        }
        return spacer;
    }
}