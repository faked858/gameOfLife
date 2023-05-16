/**
 * Author: Parker Rogers
 * version: 15/05/2023
 */
package faked858.gameoflife;
import java.util.Scanner; //keyboard input

import static faked858.gameoflife.Main.instructions;


public class Main {
    //static final int BOARDSIZE = 20;
   static int rows = 20;
   static int cols = 40;
    Scanner keyboard = new Scanner(System.in);
    public static void main(String ars[]){
        int[][] boardArr = new int[rows][cols];

        for (int i = 0; i < rows; i++){//x axis
            for(int j = 0; j < cols; j++){//y axis
               //System.out.print("*"+i);Scanner keyboard = new Scanner(System.in);
               System.out.print(boardArr[i][j] + "");//print array
            }
            System.out.println("");//new line
        }
        instructions();
    }
    void static instructions(){
        System.out.println("Welcome to game of life. The game of life has simple rules");
        System.out.println();
    }

}