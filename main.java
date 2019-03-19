

package genetic_algorithm;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class main extends JPanel {
	
	public static ArrayList<Integer>numbers = new ArrayList<Integer>();
	public static ArrayList<Integer>numbers2 = new ArrayList<Integer>();
	public static double distance_check_number = 1000;
	public static int [] coordinates = 
	{ 60, 200, 180, 200, 80, 180, 140, 180, 20, 160, 100, 160, 200, 160,
	  140, 140, 40, 120, 100, 120, 180, 100, 60, 80, 120, 80, 180, 60, 20,
	  40, 100, 40, 200, 40, 20, 20, 60, 20, 160, 20
	};
	public static cities [] all_cities = new cities[20];
	public static int num_routes = 50;
	public static int status = 1;
	public static int multiplier = 100;
	
	
    public static void main(String[] args) {
    	
    	main assignment2 = new main();
 
    	for (int i = 0, x = 0; i < 20; i++) {
    		all_cities[i] = new cities(coordinates[x],coordinates[x+1]);
    		x = x + 2;
    		create_route.visiting_cities.add(all_cities[i]);
    	}
    
        all_routes all_routes = new all_routes(num_routes, status);
     
        all_routes = algorithm.evaluation(all_routes);
        for (int i = 0; i < multiplier; i++) {
        	all_routes = algorithm.evaluation(all_routes);
        }
        	
        while (distance_check_number > 999) {
        	
        	
        	numbers2.clear();
        	distance_check_number = all_routes.get_best_route().distance();
        	System.out.print(all_routes.get_best_route());
        	
        	
  }
        
		JFrame window = new JFrame("Assignment 2");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setSize(800,800);
        window.add(assignment2);
      
    }
    
    public void paint (Graphics g) {
    	
		g.setFont(new Font("Courier", Font.BOLD,20));
		g.setColor(Color.black);
		g.drawString("Solution",100,50);
		g.drawString("Total Distance of Route: ", 400, 50);
		g.drawString(Double.toString(distance_check_number),400,80);
		g.setColor(Color.green);
    	
		for(int i=0; i<11; i++) {
		g.drawLine(100,100+i*50,100+550,100+i*50);
		}
		for(int i=0; i<12; i++) {
		g.drawLine(100+i*50,100,100+i*50,100+500);
		}
		
		g.setColor(Color.red);
		for (int i=0; i<numbers.size(); i++) {
			g.drawOval(numbers.get(i)/20*50-5+100, 650-(numbers.get(i+1)/20*50)-5-50, 10, 10);
			g.fillOval(numbers.get(i)/20*50-5+100, 650-(numbers.get(i+1)/20*50)-5-50, 10, 10);
			i++;
		}
		
		g.setColor(Color.blue);
		
		for (int i=0; i<numbers2.size()-2; i++) {
			g.drawLine(numbers2.get(i)/20*50+100,
					650-numbers2.get(i+1)/20*50-50,
					numbers2.get(i+2)/20*50+100,
					650-numbers2.get(i+3)/20*50-50);
			i++;
		}
		
		

		g.drawLine(numbers2.get(numbers2.size()-2)/20*50+100,
				650-numbers2.get(numbers2.size()-1)/20*50-50,
				numbers2.get(0)/20*50+100,
				650-numbers2.get(1)/20*50-50);

    }}

