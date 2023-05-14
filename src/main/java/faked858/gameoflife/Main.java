/**
 * Author: Parker Rogers
 * version: 15/05/2023
 */
package faked858.gameoflife;
import java.util.Scanner; //keyboard input


public class Main {
    static final int BOARDSIZE = 20;
   static int rows = BOARDSIZE;
   static int cols = BOARDSIZE;
    Scanner keyboard = new Scanner(System.in);
    public static void main(String ars[]){
        int[][] boardArr = new int[rows][cols];

        for (int i = 0; i < cols; i++){//x axis
            for(int j = 0; j < rows; j++){//y axis
               //System.out.print("*"+i);Scanner keyboard = new Scanner(System.in);
               System.out.print(boardArr[i][j] + "");//print array
            }
            System.out.println("");//new line
        }
    }

}