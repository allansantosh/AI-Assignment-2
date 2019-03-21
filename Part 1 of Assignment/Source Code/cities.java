

package genetic_algorithm;

// Cities class deals with cities.

public class cities {
	
	
	int x_coordinate, y_coordinate;
	
    public cities(int x, int y){
    	x_coordinate = x;
    	y_coordinate = y;
    	main.numbers.add(x);
    	main.numbers.add(y);
    }
	
    // Calculates distances between 2 cities.
    
    public double calculate_distance_to(cities city){

    	return	 Math.sqrt	(
        		(x_coordinate - city.x_coordinate)*(x_coordinate - city.x_coordinate) + 
        		(y_coordinate - city.y_coordinate)*(y_coordinate - city.y_coordinate)
        				 	);   
    }
    @Override
    
    
    // Print the coordinates
    
    public String toString(){
    	main.numbers2.add(x_coordinate);
    	main.numbers2.add(y_coordinate);
        return x_coordinate + ", " + y_coordinate;
    }
   
}
