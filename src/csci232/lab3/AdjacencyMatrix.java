/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci232.lab3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Mathew Gostnell
 * @author Robert Putnam
 */
public class AdjacencyMatrix {

    private final int[][] adjacency;
    private final Random rand = new Random();
    private final Scanner inWait = new Scanner(System.in);

    public AdjacencyMatrix(int n) {
        adjacency = new int[n][n];
        //set the initial array all to -1
        for (int i = 0; i < adjacency.length; i++) {
            Arrays.fill(adjacency[i], -1);
        }

    }

    public void printMatrix() {

        /*
        
         A   B   C   D   E   
         A   -   -   -   - etc.
         B
         C
         D
         E
        
        
         */
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < adjacency.length; i++) {
            System.out.printf("%5c", 65 + i);
        }
        System.out.println();
        for (int i = 0; i < adjacency.length; i++) {
            System.out.printf("=====");
        }
        System.out.println();
        for (int i = 0; i < adjacency.length; i++) {
            System.out.printf("%c", 65 + i);
            for (int j = 0; j < adjacency[i].length; j++) {
                if (adjacency[i][j] != -1) {
                    System.out.printf("%5d", adjacency[i][j]);
                } else {
                    System.out.printf("%5c", '-');
                }
            }
            System.out.println();
        }

        System.out.println();
    }

    public void addToMatrix(int value, int xpos, int ypos) {
        adjacency[ypos - 1][xpos - 1] = value;
    }

    //randomly fill our matrix with n connections.
    public void randFill() {
        int val, xpos, ypos;
        //not filling entire thing, but adding quite a few connections.
        for (int i = 0; i < adjacency.length; i++) {
            do {
                val = Math.abs(rand.nextInt(100) + 1);
                xpos = Math.abs(rand.nextInt() % adjacency.length);
                ypos = Math.abs(rand.nextInt() % adjacency.length);
            } while (xpos == ypos);
            adjacency[ypos][xpos] = val;
        }
    }

    public void floyd() {
        //our connections
        int connect1, connect2;

        //check each row at a time
        for (int row = 0; row < adjacency.length; row++) {
            //check each column
            for (int column = 0; column < adjacency.length; column++) {
                //if each node isnt itself and has a connection
                if (row != column && adjacency[row][column] >= 0) {
                    //set our first connection
                    connect1 = adjacency[row][column];
                    //check nodes that our connection hits
                    for (int search = 0; search < adjacency.length; search++) {
                        if (adjacency[search][row] >= 0 && search != column) {
                            //set second connection
                            connect2 = adjacency[search][row];
                            //if they connect and its a smaller connection
                            if (connect1 + connect2 < adjacency[search][column] || adjacency[search][column] == -1) {
                                //add the connection to the graph
                                adjacency[search][column] = connect1 + connect2;
                                //step by step printing
                                printMatrix();
                                System.out.print("Press enter to continue: ");
                                inWait.nextLine();
                            }
                        }
                    }
                }
            }//end inner loop
        }//end outer loop
    }
    
    public int getLength(){
        return adjacency.length;
    }
}
