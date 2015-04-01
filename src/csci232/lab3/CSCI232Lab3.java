/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci232.lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author thech_000
 */
public class CSCI232Lab3 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException{
        //stole ui from lab2
        int n = 0;
        do{
            System.out.print("Please enter a size greater than 3 for the adjacency matrix: ");
            n = getInt();
        }while(n < 3);
        System.out.print("Do you want to create the matrix yourself?   ([y]es / [n]o)");
        char a = getChar();
        AdjacencyMatrix ourMatrix = new AdjacencyMatrix(n);

        do {
            System.out.println("************xX_MENU_Xx************");
            System.out.println("Please enter the first letter of [S]how, [R]un Floyd's, [N]ew matrix , or e[X]it.");
            char choice = getChar();

            switch (choice) {
                case 's':
                case 'S':
                    ourMatrix.printMatrix();
                    break;
                case 'r':
                case 'R':
                    ourMatrix.floyd();
                    break;
                case 'n':
                case 'N':
                    do{
                        System.out.print("Please enter a size greater than 3 for the adjacency matrix: ");
                        n = getInt();
                    }while(n < 3);
                    System.out.print("Do you want to create the matrix yourself?   ([y]es / [n]o)");
                    a = getChar();
                    ourMatrix = new AdjacencyMatrix(n);
                    break;
                case 'x':
                case 'X':
                    System.out.println("Now exiting Floyd's sim!  Good bye!");
                    System.exit(0);
                    break;
            }
        } while (true);
    }
    
    public static String getStringMessage() throws IOException {        
        InputStreamReader isr = new InputStreamReader(System.in);
        StringBuilder returnString = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(isr);
        while ((line = br.readLine()) != null) {                   
           if(line.endsWith("$")){               
                break;
            }
           returnString.append(line);
           //returnString.append('\r');
           returnString.append('\n');
        }
        return returnString.toString();
    }
     
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    
    public static char getChar() throws IOException {        
        String s = getString();
        return s.charAt(0);
    }
    
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
    
}
