//Date:1/31/2017
//Author: Nourelhoda Farhat
//Purpose: A program that simulate a simple maze
//**************************************************************


import java.io.*;
import java.util.*;

public class Maze{
   final static int NUM_ROW =5, //still need to handel size for diff files
                    NUM_COL =10 ;
   static char player = 'p',
                clear = ' ',
                wall = 'x',
                finalPoint = 'f';
   static int yLoc = 1,
              xLoc = 1;
   static boolean finish = false;
   static int  numberOfSteps = 0;
   static ArrayList<String> history = new ArrayList<>();
   public static void main(String... args)throws Exception{
      String fileName;
   
   // ArrayList<char[]> mazeArray = new ArrayList<char>();
      char[][] mazeArray = new char[NUM_ROW][NUM_COL];
   
      if(args.length == 0){
         fileName= "maze.txt";
      }
      else { fileName = args[0];
      }
   
      readFile(mazeArray, fileName);
      placePlayer(mazeArray);
   
      //test to see maze
      for (int row = 0; row < NUM_ROW; row++){
         System.out.println();
      
         for (int col = 0; col < NUM_COL; col++) {
            System.out.print(mazeArray[row][col]);
            //while (col == mazeArray.size() )
               //System.out.println();
         }
      }
      play(mazeArray);
   
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
      System.out.println("\n\n Welcome to The Maze!!!\n\n");
   }//end read file

   public static void placePlayer(char[][] mazeArray) throws IOException{
      int counter = 0;//to insure this is not an infinit loop,in case there were no free areas in the maze.
      do{
         counter++;
         Random randomNumbers = new Random();
         yLoc = randomNumbers.nextInt(NUM_ROW);
         xLoc = randomNumbers.nextInt(NUM_COL);
      }while (mazeArray[yLoc][xLoc]== wall || mazeArray[yLoc][xLoc]== finalPoint || counter < 1000);
      //assign letter p to a random location in the array
      mazeArray[yLoc][xLoc]= player;
   }//end of placePlayer method

   public static void play(char[][] mazeArray) throws IOException{
      Scanner keyboard = new Scanner(System.in);
     while (!finish){ 
     checkForOpenTiles(mazeArray);
     String move = keyboard.nextLine();
     move.toLowerCase();
     
         switch (move){
          case  ("right"):
               if (mazeArray[yLoc][xLoc+1]!= wall){
                  if (mazeArray[yLoc][xLoc+1]== finalPoint){
                      ifFinished ();
                  }
                  else {
                     xLoc = right(mazeArray); 
                  }
               }
               else{
                  System.out.println("This direction is not available");
               }
               break;
               
            case ( "left"):
               if (mazeArray[yLoc][xLoc-1]!= wall){
               
                  if (mazeArray[yLoc][xLoc-1]== finalPoint){
                     ifFinished ();
                  }
                  else {
                     xLoc = left(mazeArray);
                  }
               }
               else
               {System.out.println("This direction is not available");}
               break;
               
            case  ("up"):
               if (mazeArray[yLoc-1][xLoc]!= wall){
                  if (mazeArray[yLoc -1][xLoc]== finalPoint){
                      ifFinished ();
                  }
                  else {
                     yLoc = up(mazeArray);
                  }
               }
               else{
               
                  System.out.println("This direction is not available");}
               break;
               
            case ("down"):
               if (mazeArray[yLoc+1][xLoc]!= wall){
                  if (mazeArray[yLoc+ 1][xLoc]== finalPoint){
                      ifFinished ();
                  }
                  else {
                     yLoc = down( mazeArray);
                  }
               }
               else{
                  System.out.println("This direction is not available");}
               break;
             
            case ("history"):
               System.out.println(history);
               break;
               
            default :
               System.out.println("\n please choose one of the options above");
               }
      }
   }//end play method
   public static void checkForOpenTiles(char[][] mazeArray){
     ArrayList<String> availableDirections = new ArrayList<>();
    
         availableDirections.clear();
         System.out.println(" \n\nWhat is your next move? \n(you can enter history to see your previous steps).");
     
         if (mazeArray[yLoc][xLoc +1]!= wall){
           availableDirections.add("right");
         }
         if (mazeArray[yLoc][xLoc -1] != wall){
           availableDirections.add("left");
         }
         if (mazeArray[yLoc - 1][xLoc]!= wall ){
           availableDirections.add("up");
         }
         if (mazeArray[yLoc + 1][xLoc]!= wall ){
            availableDirections.add("down");
         }
         System.out.println(availableDirections);
      }
   
   public static int right(char[][] mazeArray){
      
      mazeArray[yLoc][xLoc]= clear ;
      player = mazeArray[yLoc][xLoc+1];
      numberOfSteps ++;
      history.add("right");
      xLoc++;
      return xLoc;
      
   }
   public static int left(char[][] mazeArray){
     
      mazeArray[yLoc][xLoc]=clear;
      player = mazeArray[yLoc][xLoc-1];
      numberOfSteps++;
      history.add( "left");
      xLoc--;
      return xLoc;
      
   }
   public static int up (char[][] mazeArray){
      
      mazeArray[yLoc][xLoc]=clear;
      player = mazeArray[yLoc-1][xLoc];
      numberOfSteps++;
      history.add( "up ");
      yLoc--;
      return yLoc;
     
   }
   public static  int down(char[][] mazeArray){
      
      player = mazeArray[yLoc+1][xLoc];
      numberOfSteps++;
      mazeArray[yLoc][xLoc]=clear;
      history.add("down");
      yLoc++;
      return yLoc;
      
   }
   public static void  ifFinished (){
      numberOfSteps++;
      System.out.println("\n Congratulation! you solved the maze in " +numberOfSteps+" steps.");
      System.exit(0);
   }
}
