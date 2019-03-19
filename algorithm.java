

package genetic_algorithm;

public class algorithm {

  
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

}