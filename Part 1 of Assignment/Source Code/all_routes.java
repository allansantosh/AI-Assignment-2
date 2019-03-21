
package genetic_algorithm;


public class all_routes {

    create_route[] routes;

    public create_route get_best_route() {
        
    	create_route best_route = routes[0];

        for (int i = 1; i < routes.length; i++) {
            if (best_route.get_fitness_value() <= routes[i].get_fitness_value()) {
            	best_route = routes[i];
            }
        }
        return best_route;
    }


    public all_routes(int num_of_routes, int value) {
        routes = new create_route[num_of_routes];

        if (value == 1) {

            for (int i = 0; i < routes.length; i++) {
                create_route new_route = new create_route();
                new_route.make_a_route();
                routes[i]= new_route;
            }
        }
    }
}
