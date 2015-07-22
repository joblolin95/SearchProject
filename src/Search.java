/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Blaine's Laptop
 */

import java.io.*;
import java.util.*;

public class Search {
        
        protected int INTERSECTIONS;
        protected int [][] distance;
        protected int distanceSum;
        protected int begin;
        protected int end;
        protected ArrayList<Integer> shortestList;
        
        protected final String [] KEY = {"135 - 337", "135 - 62", "135 - 64", "135 - Quarry Rd", "Quarry Rd - Corydon Ramsey Rd",
            "Corydon Ramsey Rd - 62", "337 - 62", "62 - 64", "Crandall Lanesville Rd - 62","Crandall Lanesville Rd - 64", 
            "64 - 265", "265 - 65", "265 - Grant Line Rd", "265 - Charlestown Rd","Grant Line Rd - Klerner Ln", 
            "Grant Line Rd - Mt Tabor Rd", "Klerner Ln - Mt Tabor Rd", "Mt Tabor Rd - Charlestown Rd",
            "Charlestown Rd - Blackiston Mill Rd", "Charlestown Rd - 60", "Charlestown Rd - 31","60 - 31", 
            "Blackiston Mill Rd - 31", "Veterans Parkway - 31", "65 - 60", "65 - Veterans Parkway","65 - 31", "62 - 11"};

        
        public Search(){
            INTERSECTIONS = 0;
            distanceSum = 0;
            shortestList = new ArrayList<>();
        }// end constructor
        
        public Search(int intersections){
            distanceSum = Integer.MAX_VALUE;
            INTERSECTIONS = intersections;
            distance = new int[INTERSECTIONS][INTERSECTIONS];
            

        }// end constructor
        
        public Search(String fileName, int intersections){
            
            
            distanceSum = Integer.MAX_VALUE;
            INTERSECTIONS = intersections;
            distance = new int[INTERSECTIONS][INTERSECTIONS];
            populateMatrix(fileName);
        }// end constructor
    
        public void populateMatrix(String fileName){
            
            try {
                File file = new File(fileName);
                Scanner inf = new Scanner(file);
                for(int i = 0; i < INTERSECTIONS; i++){
                    for(int j = i; j < INTERSECTIONS; j++){
                        int num = inf.nextInt();
                        if(i != j && num == 0){
                            distance[i][j] = -1;
                        }// end if
                        else{
                            distance[i][j] = num;
                        }// end else
                        
                        distance [j][i] = num;
                        
                    }// end for
                }// end for
                
                
            } // end populateMatrix method
            catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }// end catch
        }// end populateMatrix
        
        public void DFS(int start, int finish){
            begin = start;
            end = finish;
            
            int sum = 0;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(begin);
            boolean[] visited = new boolean [INTERSECTIONS];
            visited[begin] = true;
            DFSHelper(list, sum, visited);
            
            
        }// end DFS method
        
        
        public void DFSHelper(ArrayList<Integer> list, int sum, boolean[] visited){
            
            if(sum < distanceSum && list.get(list.size() - 1) == end){
//                System.out.println(list);
//                System.out.println("Distance: " + sum);
                shortestList = list;
                distanceSum = sum;
                
            }// end if
            else if(sum < distanceSum){
                
                for(int i = 0; i < distance.length; i++){
                    
                    int lastInt = list.get(list.size() - 1);
                    
                    if(distance[lastInt][i] != -1 && distance[lastInt][i] != 0 && !visited[i]){
                        boolean [] v2 = new boolean[visited.length];
                        System.arraycopy(visited, 0, v2, 0, visited.length);
                        v2[i] = true;
                        
                        ArrayList<Integer> list2 = new ArrayList<>(list);
                        
                        
                        list2.add(i);
                        int sum2 = distance[lastInt][i];
                        int sum3 = sum2 + sum;
//                        System.out.println(list2);
//                        System.out.println("Distance: " + (sum3));
                        
                        DFSHelper(list2, sum3, v2);
                        
                    }// end if
                }// end for
                
            }// end else if
            
        }// end DFSHelper
        
        public int calcCost(ArrayList<Integer> list){
            int cost = 0;
            for(int i = 0; i < list.size() - 1; i++){
                int vertice1 = list.get(i);
                int vertice2 = list.get(i + 1);
                if(distance[vertice1][vertice2] != 0)
                    cost += distance[vertice1][vertice2];
            }// end for
            
            return cost;
            
        }// end calcCost method
        
        public void displayMatrix(){
            
            for(int i = 0; i < INTERSECTIONS; i++){
                for(int j = 0; j < INTERSECTIONS; j++){
                    System.out.print(distance[i][j] + " ");
                }// end for
                System.out.println();
            }// end for
            
        }// end method
        
        public void displayList(){
            System.out.println("Go");

            for(int i = 0; i < shortestList.size() - 1; i++){
                
                System.out.println(KEY[shortestList.get(i)] + " to " + KEY[shortestList.get(i + 1)]);
            }// end for
            
            System.out.println("Stop --- Arrived at destination");
            
        }// end displayList method
        
        public void displayKey(){
            System.out.println("\tKey");
            for(int i = 0; i < KEY.length; i++){
                System.out.println(i + ". " + KEY[i]);
            }// end for
            
        }// end displayKey method
        
}// end class
