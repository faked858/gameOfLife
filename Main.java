/**
 * Author: Parker Rogers
 * version: 15/05/2023
 */

import java.util.Scanner; //keyboard input
import java.lang.IndexOutOfBoundsException;//Array bounds checking
import java.lang.NumberFormatException;//user input checking

public class Main {
    static final int BOARDSIZE = 20;
    static int rows = BOARDSIZE;
    static int cols = BOARDSIZE;
    Scanner keyboard = new Scanner(System.in);
    String[][] boardArr = new String[rows][cols];
    int x;
    int y;
    public Main(){
        displayBoard();
        instructions();
        menu();
    }

    void instructions(){
        System.out.println("Welcome to game of life. The game of life has simple rules");
        System.out.println("Any living cell with less than two live neighbours dies, as if by underpopulation");
        System.out.println("Any living cell with two or three live neighbours stays alive");
        System.out.println("Any living cell with more than three neighbours dies, as if by overpopulation");
        System.out.println("Any dead cell with exacty three living neighbours becomes a living cell, as if by repopulation");
        System.out.println("Here are the actions you can take");
        System.out.println("c - changes cell state '0' is off and '*' is on");
        System.out.println("d - advances a generation");
        System.out.println("a - advances 10 generations");
        System.out.println("q - quit");
    }

    public void menu(){
        //which function needs to be run
        String input = keyboard.nextLine().toLowerCase();//all inputs to lower case
        switch(input){
            case "c": coords();
            break;
            case "d": genAdvance();
            break;
            case "a": loopAdvance();
            break;
            case "q": quit();
            break;
            default: System.out.println("Sorry wrong input, please try again");
            break;
        }
    }

    public void displayBoard(){
        System.out.print('\u000c');//clears screen
        for (int i = 0; i < rows; i++){//x axis
            for(int j = 0; j < cols; j++){//y axis
                boardArr[i][j]="0";//what dead cells look like
                //System.out.print("*"+i);Scanner keyboard = new Scanner(System.in);//was used for debugging
                System.out.print(boardArr[i][j] + " ");//print array
            }
            System.out.println("");//new line
        }
    }

    public void coords(){
        boolean coordCheck=true;
        System.out.println("you have selected c");
        System.out.println("select which cell you would like change state by using coordinates in this form: (x,y)");
        String[] cellCoords = keyboard.nextLine().split(",");//user input for coordinates
        while(cellCoords.length !=2||!coordsCheck(cellCoords)){//checks use input is correct
            System.out.println("sorry wrong input, please try again");
            cellCoords = keyboard.nextLine().split(",");//user input again
        }
        x=Integer.parseInt(cellCoords[0]);//once its verified user input, set the cell coords to user input 
        y=Integer.parseInt(cellCoords[1]);
    }

    boolean coordsCheck(String[] integers)
    {
    try{
        //trys to parseInt user input
        int coordX=Integer.parseInt(integers[0]);
        int coordY=Integer.parseInt(integers[1]);
        try{
            System.out.println(boardArr[coordX-1][coordY-1]);//trys to print user input
            return true;
        } catch (IndexOutOfBoundsException e){//if user input is out of bounds of array, then it cant print it so it returns false
            return false;
        }
     } catch(NumberFormatException e){//if an error accurs while trying to parseInt user input, returns false
        return false;
     }
    }

    public void genAdvance(){
        System.out.println("genAdvance has been run");
    }

    public void loopAdvance(){
        System.out.println("loopAdvance");
    }

    public void quit(){
        System.out.println("quit");
    }
}