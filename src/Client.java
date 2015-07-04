/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Blaine's Laptop
 */
import java.util.Scanner;
public class Client {
    
    public static void main(String [] args){
        
        
        
        Search s = new Search("distanceMatrix.txt", 28);
        s.displayKey();
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the start intersection number: ");
        int begin = input.nextInt();
        
        System.out.print("\nEnter the end intersection number: ");
        int end = input.nextInt();
        System.out.println();
      
        long startTime = System.nanoTime();
        s.DFS(begin, end);
        
        
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("\tDFS");
        s.displayList();
        
        System.out.printf("Time elapsed (in seconds): %3.5f\n",((double)elapsedTime)/Math.pow(10,9));  
        
        System.out.println();
       
        Dijkstra d = new Dijkstra("distanceMatrix.txt", 28);
         startTime = System.nanoTime();
        d.dijkstra(begin, end);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime; 
        System.out.println("\tDijkstra's Algorithm");
        d.displayList();
        
        System.out.printf("Time elapsed (in seconds): %3.5f\n",((double)elapsedTime)/Math.pow(10,9));
        
    }// end main
    
}// end Client
