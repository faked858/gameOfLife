/**
 * Author: Parker Rogers
 * version: 15/05/2023
 */

import java.util.Scanner; //keyboard input
import java.lang.IndexOutOfBoundsException;//Array bounds checking
import java.lang.NumberFormatException;//user input checking

public class Main {
    static final int B_SIZE = 20;//dont have seperate rows or cols becaues i want my board to be same length for x and y
    Scanner keyboard = new Scanner(System.in);//keyboard input
    int[][] boardArr = new int[B_SIZE][B_SIZE];//2d array
    String dCell=". ";//dead cell
    String lCell="0 ";//living cell
    public Main(){
        displayBoard();
        menu();
    }

    void instructions(){
        System.out.println("Welcome to game of life. The game of life has simple rules");
        System.out.println("Any living cell with less than two live neighbours dies, as if by underpopulation");
        System.out.println("Any living cell with two or three live neighbours stays alive");
        System.out.println("Any living cell with more than three neighbours dies, as if by overpopulation");
        System.out.println("Any dead cell with exacty three living neighbours becomes a living cell, as if by repopulation");
        System.out.println("Here are the actions you can take");
        System.out.println("c - changes cell state '"+dCell+"' is off and '"+lCell+"' is on");
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
        for (int y = 0; y < B_SIZE; y++){//x axis
            for(int x = 0; x < B_SIZE; x++){//y axis
                if(boardArr[x][y]==0){
                    System.out.print(dCell);//dead cell
                }else{//if cell isnt dead, print living cell
                    System.out.print(lCell);//alive cell
                }
            }
            System.out.println("");//new line
        }
        instructions();
    }

    public void coords(){
        boolean coordCheck=true;
        int farCell = B_SIZE-1;
        System.out.println("you have selected c");
        System.out.println("select which cell you would like change state by using coordinates in this form: (x,y)");
        System.out.println("The board size is "+B_SIZE+"x"+B_SIZE);
        System.out.println("however because computers count from 0, "+farCell+" is the furthest you can enter coordinates for");
        String[] cellCoords = keyboard.nextLine().split(",");//user input for coordinates into array
        while(cellCoords.length !=2||!coordsCheck(cellCoords)){//checks use input is correct
            System.out.println("sorry wrong input, please try again");
            cellCoords = keyboard.nextLine().split(",");//user input again
        }
        int x=Integer.parseInt(cellCoords[0]);//once its verified user input, set the cell coords to user input 
        int y=Integer.parseInt(cellCoords[1]);
        boardArr[x][y]=1;//set cell to alive
        displayBoard();//refresh board to display new cell
        neghbourCheck(x,y);
        System.out.println("you have set cell "+x+","+y+" to alive");
        System.out.println("to set the state of another cell, press c again");
        menu();
    }

    boolean coordsCheck(String[] integers)
    {
        try{
            //trys to parseInt user input
            int coordX=Integer.parseInt(integers[0]);
            int coordY=Integer.parseInt(integers[1]);
            try{
                System.out.println(boardArr[coordX][coordY]);//trys to print user input
                return true;
            } catch (IndexOutOfBoundsException e){//if user input is out of bounds of array, then it cant print it so it returns false
                System.out.println("IndexOutOfBoundsException");//for debugging
                return false;
            }
        } catch(NumberFormatException e){//if an error accurs while trying to parseInt user input, returns false
            System.out.println("NumberFormatException");//for debugging
            return false;
        }
    }
    
    public int neghbourCheck(int cellX, int cellY){
        int count=0;
        if(boardArr[cellX-1][cellY]==1)count++;
        if(boardArr[cellX-1][cellY-1]==1)count++;
        if(boardArr[cellX-1][cellY+1]==1)count++;
        if(boardArr[cellX+1][cellY]==1)count++;
        if(boardArr[cellX][cellY-1]==1)count++;
        if(boardArr[cellX][cellY+1]==1)count++;
        if(boardArr[cellX+1][cellY+1]==1)count++;
        if(boardArr[cellX+1][cellY-1]==1)count++;
        System.out.println("cell neghbours is "+count);
        return count;
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