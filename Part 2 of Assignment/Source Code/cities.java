

package genetic_algorithm;


public class cities {
	
	int index;
	String name;
	
	// no need for coordinates anymore compared to before
	
    public cities(int num, String text){
    	index = num;
    	name = text;

    	main.numbers.add(index);
    }
    
    // Calculate distance between cities from the table
	
    public double calculate_distance_to(cities city){

    	return	main.cities_inter_distances[index][city.index];
    }
    
    @Override
    public String toString(){
    return name;
    }
   
}
