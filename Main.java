/**
 * Author: Parker Rogers
 * version: 15/05/2023
 */
//my game of life project
import java.util.Scanner; //keyboard input
import java.lang.IndexOutOfBoundsException;//Array bounds checking
import java.lang.NumberFormatException;//user input checking

public class Main {
    static final int B_SIZE = 45;//dont have seperate rows or cols becaues i want my board to be same length for x and y
    Scanner keyboard = new Scanner(System.in);//keyboard input
    int[][] boardArr = new int[B_SIZE][B_SIZE];//2d array
    String dCell=". ";//dead cell
    String lCell="0 ";//living cell
    int farCell = B_SIZE-1;//used in mutliple methods
    public Main(){
        displayBoard();
        menu();
    }

    void instructions(){
        System.out.println("Any living cell with less than two live neighbours dies, as if by underpopulation");
        System.out.println("Any living cell with two or three live neighbours stays alive");
        System.out.println("Any living cell with more than three neighbours dies, as if by overpopulation");
        System.out.println("Any dead cell with exacty three living neighbours becomes a living cell, as if by repopulation");
    }

    public void menu(){
        //which function needs to be run
        boolean quitGame = false;
        while(!quitGame){
            switch(keyboard.nextLine().toLowerCase()){//waits for user input and all inputs to lower case
                case "e": instructions();
                    break;
                case "c": coords();
                    break;
                case "d": genAdvance();
                    break;
                case "a": loopAdvance();
                    break;
                case "q": quitGame = true;
                    break;
                default: System.out.println("Sorry wrong input, please try again");
                    break;
            }//runs user specified function based on their input
        }
    }

    public void displayBoard(){
        System.out.print('\u000c');//clears screen
        for (int y = 0; y < B_SIZE; y++){//y axis
            for(int x = 0; x < B_SIZE; x++){//x axis
                if(boardArr[x][y]==0){
                    System.out.print(dCell);//dead cell
                }else{//if cell isnt dead, print living cell
                    System.out.print(lCell);//alive cell
                }
            }
            System.out.println("");//new line
        }
        System.out.println("Welcome to the game of life");
        System.out.println("e - rules and instructions");
        System.out.println("c - changes cell state '"+dCell+"' is dead and '"+lCell+"' is alive");
        System.out.println("d - advances a generation");
        System.out.println("a - advances a set amount generations");
        System.out.println("q - quit");
    }

    public void coords(){//checks if user inputed coordinates are legitimate, if so turns on user selected cell
        boolean coordCheck=true;
        System.out.println("you have selected c");
        System.out.println("select which cell you would like change state by using coordinates in this form: (x,y)");
        System.out.println("The board size is "+B_SIZE+"x"+B_SIZE);
        System.out.println("however because computers count from 0, "+farCell+" is the furthest you can enter coordinates for");
        //helps the user understand how to set cell state
        String[] cellCoords = keyboard.nextLine().split(",");//user input for coordinates into array
        while(cellCoords.length !=2||!coordsCheck(cellCoords)){//checks user input is correct
            System.out.println("sorry wrong input, please try again");
            cellCoords = keyboard.nextLine().split(",");//user input again
        }
        int x=Integer.parseInt(cellCoords[0]); 
        int y=Integer.parseInt(cellCoords[1]);
        //once its verified user input, set the cell coords to user input
        boardArr[x][y]=1;//set cell to alive
        displayBoard();//refresh board to display new cell
        System.out.println("you have set cell "+x+","+y+" to alive");
        System.out.println("to set the state of another cell, press c again");
    }

    boolean coordsCheck(String[] integers)
    {
        try{
            //trys to parseInt user input
            int coordX=Integer.parseInt(integers[0]);
            int coordY=Integer.parseInt(integers[1]);
            /*
            try{
            System.out.println(boardArr[coordX][coordY]);//trys to print user input
            return true;
            } catch (IndexOutOfBoundsException e){//if user input is out of bounds of array, then it cant print it so it returns false
            System.out.println("IndexOutOfBoundsException");//for debugging
            return false;
            }
             */
            if(getCell(coordX,coordY)==-1){
                return false;  
            }else{
               return true; 
            }

            
        } catch(NumberFormatException e){//if an error accurs while trying to parseInt user input, returns false
            System.out.println("NumberFormatException");//for debugging
            return false;
        }
    }

    public int neghbourCheck(int cellX, int cellY){//checks for living cell neghbours
        int count=0;
        if(getCell(cellX-1,cellY)==1)count++;
        if(getCell(cellX-1,cellY-1)==1)count++;
        if(getCell(cellX-1,cellY+1)==1)count++;
        if(getCell(cellX+1,cellY)==1)count++;
        if(getCell(cellX,cellY-1)==1)count++;
        if(getCell(cellX,cellY+1)==1)count++;
        if(getCell(cellX+1,cellY+1)==1)count++;
        if(getCell(cellX+1,cellY-1)==1)count++;
        //System.out.println("cell neghbours is "+count);//debugging
        return count;
    }

    public int getCell(int cellX, int cellY){
        if(boardArr[cellX][cellY] < farCell){
            return boardArr[cellX][cellY];
        }else{
            return -1;
        }
    }

    public void genAdvance(){//advances a ganeration and does cell neghbour logic
        //System.out.println("genAdvance has been run");//debugging
        int[][] futureB = new int[B_SIZE][B_SIZE];//new 2D array to put cell changes on
        for (int y = 0; y < B_SIZE; y++){
            for(int x = 0; x < B_SIZE; x++){//run through array
                if((neghbourCheck(x,y) < 2 || neghbourCheck(x,y) > 3) && getCell(x,y)==1){//check cell logic
                    futureB[x][y]=0;//if a living cell has less than 2 neghbours more than 3 neghbours, it dies 
                }else if(neghbourCheck(x,y) == 3 && getCell(x,y)==0){//more cell logic
                    futureB[x][y]=1;//if a dead cell has 3 nehgbours, it becomes alive
                }else{
                    futureB[x][y]=getCell(x,y);//else, cell stays the same
                }
            }
        }
        for(int i = 0; i < B_SIZE; i++){
            for(int j = 0; j < B_SIZE; j++){//run through array
                boardArr[j][i]=futureB[j][i];//set changes to board
            }
        }
        displayBoard();//display new changes
    }

    public Boolean loopAdvance(){//nullable
        System.out.println("You selected a, please type an intager of how many generations you would like to advance");
        String userInput= keyboard.nextLine();
        int loopAmount = 0;
        try{
            loopAmount = Integer.parseInt(userInput);//checks user input
        }catch(NumberFormatException e){
            System.out.println("sorry wrong input, please select a and try again");
            return false;
        }
        for(int i=0; i < loopAmount; i++){
            genAdvance();
            //System.out.println("loopAdvance");//debugging
        }
        return null;//returns null
    }
}