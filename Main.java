/**
 * Author: Parker Rogers
 * version: 15/05/2023
 */

import java.util.Scanner; //keyboard input

public class Main {
    //static final int BOARDSIZE = 20;
    static int rows = 20;
    static int cols = 40;
    Scanner keyboard = new Scanner(System.in);
    int[][] boardArr = new int[rows][cols];
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
        System.out.println('\u000c');//clears screen
        for (int i = 0; i < rows; i++){//x axis
            for(int j = 0; j < cols; j++){//y axis
                //System.out.print("*"+i);Scanner keyboard = new Scanner(System.in);
                System.out.print(boardArr[i][j] + "");//print array
            }
            System.out.println("");//new line
        }

    }

    public void coords(){
        boolean coordCheck=true;
        System.out.println("you have selected c");
        System.out.println("select which cell you would like change state by using coordinates in this form: (x,y)");
        String cellCoords = keyboard.nextLine();//user input for coordinates
        String coordValues[];
        int x;
        int y;
           if(cellCoords.length()>5 || cellCoords.length()<3){//check if user inputed string is at least the right length, will check other factors later
            System.out.println("Sorry wrong input, please  select c and try again. If you are using brackets try removing them");
            menu();
        }else{//if the use input is correct length
            coordValues=cellCoords.split(",");
            x=Integer.parseInt(coordValues[0]);
            y=Integer.parseInt(coordValues[1]);
            System.out.println(String.format("Your coordinates are %d,%d",x,y));
            System.out.println("coords has been run");
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