//**************************************************************
//Program:  Maze
//Date:1/19/2017
//Author: Nourelhoda Farhat 
//Purpose: A program that simulate a simple maze
//**************************************************************


import java.io.*;
import java.util.*;
 
public class maze{
   final static int NUM_ROW = 7,
                    NUM_COL = 31;
   static char player = 'p',
                clear = ' ',
                wall = 'x',  
                finalPoint = 'f'; 
   static int xLoc = 1, 
              yLoc = 1;         
   public static void main(String[] args)throws Exception{
      
      char[][] mazeArray = new char[NUM_ROW][NUM_COL];
       
      char again = 'Y';
      if(args.length < 1) {
         System.err.println("Usage: java maze <file name>");
         System.exit(1);
      }
      String fileName = args[0]; 
   
      Scanner keyboard = new Scanner(System.in);
   
      do{
      
      //Prompt user
         System.out.println("\n\n Welcome to The Maze!!!\n\n");
                            
         readFile(mazeArray, fileName);
         placePlayer(mazeArray);
       
        /* 
      //test to see maze
         for (int row = 0; row < NUM_ROW; row++){
            System.out.println();
           
            for (int col = 0; col < NUM_COL; col++) {
               System.out.print(mazeArray[row][col]);
               while (col == NUM_COL )
                  System.out.println();
            }
         }
         */
         
         play(mazeArray);
       
         System.out.println("\n Would you like to play again?(Y/N)");
         again = keyboard.nextLine().charAt(0);
         again = Character.toUpperCase(again);
             
      } while (again == 'Y'); //end of do while loop
   }//end of main method
  
   public static void readFile(char[][] mazeArray, String fileName) throws Exception {
   
      String line;   
      File charactersFile = new File(fileName); 
         
      try{    
      //Open the file
         Scanner inputFile = new Scanner(charactersFile); 
      
      //Read all of the characters from the file and store 
      //in the array 
         for (int row = 0; row < mazeArray.length; row++) {
            if (inputFile.hasNext()) {
               line = inputFile.nextLine();
               for (int col = 0; col < mazeArray[row].length; col++) 
                  mazeArray[row][col] = line.charAt(col); 
            }
         }
         inputFile.close();
      } 
      catch(FileNotFoundException exception){
         throw exception;
      } 
   }//end read file
      
   public static void placePlayer(char[][] mazeArray) throws IOException{
   
      Random randomNumbers = new Random();
      xLoc = randomNumbers.nextInt(NUM_ROW);
      yLoc = randomNumbers.nextInt(NUM_COL);
   
      while (mazeArray[xLoc][yLoc]== wall || mazeArray[xLoc][yLoc] == finalPoint){
         xLoc = randomNumbers.nextInt(NUM_ROW);
         yLoc = randomNumbers.nextInt(NUM_COL);   
      }
      //assign letter p to a random location in the array
      mazeArray[xLoc][yLoc]= player;
   }//end of placePlayer method
   
   public static void play(char[][] mazeArray) throws IOException{
      Scanner keyboard = new Scanner(System.in);
      boolean finish = false;
      int  numberOfSteps = 0;
      String history = "\nHere is your history:  ";
      do{
                  
         System.out.println(" \nWhat is your next move? \nyou can enter history to see your previous steps.");
      //check for open tiles
        
         if (mazeArray[xLoc][yLoc +1]== clear || mazeArray[xLoc][yLoc +1]== finalPoint ){
            System.out.println("right   "); 
         }
         if (mazeArray[xLoc][yLoc -1]== clear || mazeArray[xLoc][yLoc -1]== finalPoint ){
            System.out.println("left  ");
         }
         if (mazeArray[xLoc - 1][yLoc]== clear || mazeArray[xLoc -1][yLoc]== finalPoint ){
            System.out.println("up   ");
         }
         if (mazeArray[xLoc + 1][yLoc]== clear || mazeArray[xLoc+1][yLoc]== finalPoint ){
            System.out.println("down  ");
         }
         String move = keyboard.nextLine();
         move.toLowerCase();
        
         switch (move){
         
            case  ("right"):
               if (mazeArray[xLoc][yLoc+1]== finalPoint){
                  numberOfSteps ++;
                  System.out.println("\n Congratulation! you solved the maze in " +numberOfSteps+" steps.");
                  finish=true ;
               }
               else {
                  yLoc++;
                  player = mazeArray[xLoc][yLoc];
                  numberOfSteps ++;
                  history += "right,";
               }
               break;
            case ( "left"):
               if (mazeArray[xLoc][yLoc-1]== finalPoint){
                  numberOfSteps ++;
                  System.out.println("\n Congratulation! you solved the maze in " +numberOfSteps+" steps.");
                  finish=true ;
               }
               else {
                  yLoc--;
                  player = mazeArray[xLoc][yLoc];
                  numberOfSteps ++;
                  history += " left, ";
               }
               break;
            case  ("up"):
               if (mazeArray[xLoc -1][yLoc]== finalPoint){
                  numberOfSteps ++;
                  System.out.println("\n Congratulation! you solved the maze in " +numberOfSteps+" steps.");
                  finish=true ;
               }
               else {
                  xLoc--;
                  player = mazeArray[xLoc][yLoc];
                  numberOfSteps ++;
                  history += "up,";
               }
               break;
            case ("down"):
               if (mazeArray[xLoc+ 1][yLoc]== finalPoint){
                  numberOfSteps ++;
                  System.out.println("\n Congratulation! you solved the maze in " +numberOfSteps+ " steps.");
                  finish = true ;
               }
               else {
                  xLoc++;
                  player = mazeArray[xLoc][yLoc];
                  numberOfSteps ++;
                  history += "down, ";
               }
               break;
            case ("history"):
               System.out.println(history);
               break;
            default :
            
               System.out.println("\n Invalid data");
         }
        
      }while( !finish );
   }//end play method    
}
