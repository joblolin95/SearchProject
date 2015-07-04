/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Blaine's Laptop
 */
import java.util.*;

public class Dijkstra extends Search {
   
    
    private boolean [] visited;
    private int [] dist;
    private int [] pre;
   
   
    public Dijkstra(int intersections){
        
        INTERSECTIONS = intersections;
        distance = new int [INTERSECTIONS][INTERSECTIONS];
        distanceSum = 0;
        
        visited = new boolean[INTERSECTIONS];
        dist = new int[INTERSECTIONS];
        pre = new int [INTERSECTIONS];
        
        
    }// end constructor
    
    public Dijkstra(String fileName, int intersections){
        
        INTERSECTIONS = intersections;
        distance = new int [INTERSECTIONS][INTERSECTIONS];
        distanceSum = 0;
        
        visited = new boolean[INTERSECTIONS];
        dist = new int[INTERSECTIONS];
        pre = new int [INTERSECTIONS];
        
        super.populateMatrix(fileName);
        
    }// end constructor
        
    public void dijkstra(int begin, int end){
        
        this.end = end;
        this.begin = begin;
        
        for(int i = 0; i < dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }// end for
        dist[begin] = 0;
        pre[begin] = -1;
        
        for(int j = 0; j < dist.length; j++){
            int next = minVertex();
            visited[next] = true;
            
            for(int k = 0; k < dist.length; k++){
                
                if(distance[next][k] != -1 && distance[next][k] != 0){
                    
                    int d = dist[next] + distance[next][k];
                    if(dist[k] > d){
                        dist[k] = d;
                        pre[k] = next;
                    }// end nested if
                    
                }// end if
                
            }// end for
            
        }// end for
        
        
    }// end dijkstra
        
    public int minVertex(){
        
        int x = Integer.MAX_VALUE;
        int y = -1;
        
        for(int i = 0; i < dist.length; i++){
            
            if(!visited[i] && dist[i] < x){
                x = dist[i];
                y = i;
            }// end if
            
        }// end for
        return y;
    }// end minVertex
    
    @Override
    public void displayList(){
        
        int i = pre[end];
        
        
        
        while(i != -1){
            
            shortestList.add(0, i);
            i = pre[i];
            
        }// end while
        
    
        
        super.displayList();
        
    }// end displayPath method
    
}// end class
