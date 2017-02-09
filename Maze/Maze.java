//Date:2/8/2017
//Author: Nourelhoda Farhat
//Purpose: A program that simulate a simple maze
//**************************************************************
import java.io.*;
import java.util.*;

public class Maze{

   final static int NUM_ROW =7,NUM_COL =31 ;
   static char player = 'p', clear = ' ', wall = 'x', finalPoint = 'f';
   static int yLoc = 1, xLoc = 1;
   static boolean finish = false;
   static int  numberOfSteps = 0;
   static ArrayList<String> history = new ArrayList<>();
   static  char[][] mazeArray = new char[NUM_ROW][NUM_COL];
    
   public static void main(String... args)throws Exception{
   
      String fileName;
      if(args.length == 0){
         fileName= "maze.txt";
      }
      else { fileName = args[0];
      }
      readFile(fileName);
      placePlayer();
   
      /*
      //will delete later
      for (int row = 0; row < NUM_ROW; row++){
         System.out.println();
      
         for (int col = 0; col < NUM_COL; col++) {
            System.out.print(mazeArray[row][col]);
         }
         }
         */
      
      play();
   
   }//end of main method

   public static void readFile( String fileName) throws Exception {
   
      String line;
      File charactersFile = new File(fileName);
   
      try{
      
         Scanner inputFile = new Scanner(charactersFile);
         for (int row = 0;row< mazeArray.length; row++) {
              
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

   public static void placePlayer(){
      int counter = 0;//to insure this is not an infinit loop,in case there were no free areas in the maze.
      do{
         counter++;
         Random randomNumbers = new Random();
         yLoc = randomNumbers.nextInt(NUM_ROW);
         xLoc = randomNumbers.nextInt(NUM_COL);
      }while (mazeArray[yLoc][xLoc]== wall || mazeArray[yLoc][xLoc]== finalPoint || counter < 1000);
      mazeArray[yLoc][xLoc]= player;
   }//end of placePlayer method

   public static void play(){
   
      Scanner keyboard = new Scanner(System.in);
      while (!finish){ 
      
         System.out.println(" \n\nWhat is your next move?" 
                         +"\n(you can enter history to see your previous steps).");
         System.out.println(checkForOpenTiles());
         String move = keyboard.nextLine();
         move = move.toLowerCase(); 
         boolean legal = isMoveLegal(move);
            
         if (legal){
         
            switch (move){
            
               case  ("right"):
                  xLoc = right(); 
                  break;
               
               case ( "left"):
                  xLoc = left();
               
                  break;
               
               case  ("up"):
                  yLoc = up();
                  break;
               
               case ("down"):
                  yLoc = down();
                  break;
             
               case ("history"):
                  System.out.println(history);
                  break;
            }
         } 
         else{
            System.out.println("\n please choose one of the options above");}
      }
   }//end play method
   
   public static ArrayList<String> checkForOpenTiles(){
   
      ArrayList<String> availableDirections = new ArrayList<>();
      
       
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
      return availableDirections;
   }
   
   public static boolean isMoveLegal (String move){
      boolean legal =false;
     
      if ( checkForOpenTiles().contains(move)|| move.equals("history")){
         legal =true;
      }
      else {
         legal=false;
      }
      return legal;
   }
   
   public static int right(){
   
      if (mazeArray[yLoc][xLoc+1]==finalPoint){
         complete();
      }
      else{
         mazeArray[yLoc][xLoc]= clear ;
         player = mazeArray[yLoc][xLoc+1];
         numberOfSteps ++;
         history.add("right");
         xLoc++;
      }
      return xLoc;
      
   }
   public static int left(){
      if (mazeArray[yLoc][xLoc-1]==finalPoint){
         complete();
      }
      else{
      
         mazeArray[yLoc][xLoc-1]=clear;
         player = mazeArray[yLoc][xLoc-1];
         numberOfSteps++;
         history.add( "left");
         xLoc--;
      }
      return xLoc;
      
   }
   public static int up (){
      
      if (mazeArray[yLoc-1][xLoc]==finalPoint){
         complete();
      }
      else{
         mazeArray[yLoc][xLoc]=clear;
         player = mazeArray[yLoc-1][xLoc];
         numberOfSteps++;
         history.add( "up ");
         yLoc--;
      }
      return yLoc;
     
   }
   public static  int down(){
      
      if (mazeArray[yLoc+1][xLoc]==finalPoint){
         complete();
      }
      else{
         player = mazeArray[yLoc+1][xLoc];
         numberOfSteps++;
         mazeArray[yLoc][xLoc]=clear;
         history.add("down");
         yLoc++;
      }
      return yLoc;
      
   }
   public static void complete(){
      numberOfSteps++;
      System.out.println("\n Oh WOW your not a loser after all!"
                        +"\n You solved the maze in " +numberOfSteps+" steps.");
      finish= true; //could work without it 
      System.exit(0);
   }
}
