/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Blaine's Laptop
 */
public class Client {
    
    public static void main(String [] args){
        
        Search s = new Search("distanceMatrix.txt", 28);
        s.DFS(3, 18);
        s.displayList();
    }// end main
    
}// end Client
