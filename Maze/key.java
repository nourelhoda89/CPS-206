import java.io.*;
import java.util.*;
import java.awt.event.KeyEvent;
public class key {
public static void main(String[] args)throws IOException{

}
   public static void  keyPressed(KeyEvent e) {
      int keyCode = e.getKeyCode();
      
      switch( keyCode ) {
         case KeyEvent.VK_UP:
            System.out.println("up");
            break;
         case KeyEvent.VK_DOWN:
                // handle down
            break;
         case KeyEvent.VK_LEFT:
                // handle left
            break;
         case KeyEvent.VK_RIGHT :
                // handle right
            break;
      }
   }  
   public static void keyReleased(KeyEvent e) {
      int keyCode = e.getKeyCode();
   }
   public static void keyTyped(KeyEvent e) {
      int keyCode = e.getKeyCode();
   }}