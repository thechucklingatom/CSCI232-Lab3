/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci232.lab3;

import java.util.Random;
/**
 * @author Mathew Gostnell
 * @author Robert Putnam
 */
public class AdjacencyMatrix {
    private final int[][] adjacency;
    private final Random rand = new Random();
    
    public AdjacencyMatrix(int n){
        adjacency = new int[n][n];
    }
    
    public void printMatrix(){
        
    }
    
    public void addToMatrix(int value, int xpos, int ypos){
        adjacency[xpos][ypos] = value;
    }
    
    public void randFill(){
        int val, xpos, ypos;
        //not filling entire thing, but adding quite a few connections.
        for(int i = 0; i < adjacency.length / 3; i++){
            val = rand.nextInt();
            xpos = rand.nextInt() % adjacency.length;
            ypos = rand.nextInt() % adjacency.length;
            adjacency[xpos][ypos] = val;
        }
    }
    
    public void floyd(){
        
    }
}
