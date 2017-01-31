
## Class Notes 1/30/2017

e.printstack

command line - github

go to your new repository

clone, download

copy HTPPS url

go to command line 

paste url 

open readme from atom when done editing you must save it 

open repository

git add . 

git commit-am  " message " 

git push.


## Markdown Practice

italics *asterisks* .
bold: double **asterisks** or __underscores__ .
Strikethrough uses two tildes ~~Scratch this~~ .

Block of code

throw exeption whenever you are not in the driver
```java 
class Example{
     public String methodName(String string){
       if(string == null) throw new NullPointerException();
     }
  }
  
```
```java
import java.util.*;
public class GenericClass{
   public static void main(String...args){
      ArrayList<String>list =new ArrayList<>();
      System.out.println(list.size());
      list.add("Nour ");// list arg[0] = "nour"
      System.out.println(list.size());
      list.add(0,"Farhat");
       System.out.println(list);// will printfirst and last name not the address
       System.out.println(list.contains(" Kulis"));//  false
       System.out.println(list.contains("Farhat "));//false
       System.out.println(list.contains("Nour "));//true

   }
}
```
