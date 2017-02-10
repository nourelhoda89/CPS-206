//Date:2/8/2017
//Author: Nourelhoda Farhat
//Purpose: A program that simulate a simple maze
//**************************************************************
import java.io.*;
import java.util.*;

public class Maze{

   
   public static char player = 'p', clear = ' ', wall = 'x', finalPoint = 'f';
   public static int yLoc = 0, xLoc = 0;
   public static boolean finish = false;
   public static int  numberOfSteps = 0;
   public static ArrayList<String> history = new ArrayList<>();
   
   public static void main(String... args)throws Exception{
   
      int width =0, length=0;
      String fileName;
      
      if(args.length == 0){
         fileName= "maze.txt";
      }
      else { fileName = args[0];
      }
      
      width= preProcessArrayWidth(fileName,width);
      length= preProcessArrayLength (fileName,length);
      char[][] mazeArray = new char[width][length];
      readFile(fileName,mazeArray);
      placePlayer(mazeArray);
      
    
      //test to see maze with first player position
      for (int row = 0; row < width; row++){
         System.out.println();

         for (int col = 0; col < length; col++) {
            System.out.print(mazeArray[row][col]);
         }
         }
         
      play(mazeArray);
   
   }//end of main method
   
   public static  int preProcessArrayWidth ( String fileName,int width)throws Exception {
    
      String  line = null;
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      while ((line = br.readLine()) != null) {
         width++;//working
      }
      return width;
   }
   
   public static  int preProcessArrayLength ( String fileName,int length)throws Exception {
    
      String  line = null;
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      while ((line = br.readLine()) != null) {
         length =line.length();//working
      }
      return length;
   }

   public static void readFile( String fileName, char[][] mazeArray) throws Exception {
   
      String line;
      File charactersFile = new File(fileName);
   
      try{
      
         Scanner inputFile = new Scanner(charactersFile);
         for (int row = 0; row< mazeArray.length; row++) {
         
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

   public static void placePlayer(char[][] mazeArray){
   
      int counter = 0;//to insure this is not an infinit loop,in case there were no free areas in the maze.
      
      while(mazeArray[yLoc][xLoc]== wall || mazeArray[yLoc][xLoc]== finalPoint || counter <1000){
         counter++;
         
         Random randomNumbers = new Random();
        
         yLoc =(int)(Math.random() * mazeArray.length);
         xLoc =(int)(Math.random() * mazeArray[0].length);
      
      }
      mazeArray[yLoc][xLoc]=player;
   }//end of placePlayer method

   public static void play(char[][] mazeArray){
   
      Scanner keyboard = new Scanner(System.in);
      while (!finish){
      
         System.out.println(" \n\nWhat is your next move?"
                         +"\n(you can enter history to see your previous steps).");
         System.out.println(checkForOpenTiles( mazeArray));
         String move = keyboard.nextLine();
         move = move.toLowerCase();
         boolean legal = isMoveLegal(move,mazeArray);
      
         if (legal){
         
            switch (move){
            
               case  ("right"):
                  xLoc = right(mazeArray);
                  break;
            
               case ( "left"):
                  xLoc = left(mazeArray);
               
                  break;
            
               case  ("up"):
                  yLoc = up(mazeArray);
                  break;
            
               case ("down"):
                  yLoc = down(mazeArray);
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

   public static ArrayList<String> checkForOpenTiles(char[][] mazeArray){
   
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

   public static boolean isMoveLegal (String move,char[][] mazeArray){
      boolean legal =false;
   
      if ( checkForOpenTiles(mazeArray).contains(move)|| move.equals("history")){
         legal =true;
      }
      else {
         legal=false;
      }
      return legal;
   }

   public static int right(char[][] mazeArray){
   
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
   public static int left(char[][] mazeArray){
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
   public static int up (char[][] mazeArray){
   
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
   public static  int down(char[][] mazeArray){
   
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
