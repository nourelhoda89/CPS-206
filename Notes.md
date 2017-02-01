
#Class Notes 
## 1/30/2017

e.printstack

command line - github

go to your new repository

clone, download

copy HTPPS url

go to command line 

paste url 

open readme from atom when done editing you must save it 

open repository from command line 

git add . 

git commit -am  " message " 

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
##1/31/2017

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
       
       
       
      Iterator <string> iterator =list.iterator();
     while(iterator.hasNext()){
     System.out.println(iterator.next());
      }


      ArrayList <Arraylist<String>> list = new ArrayList<>();//2 dim array list not really good
      list.add(new ArrayList<>());
      ArrayList<String> listZero.list.get(0);
      //create array of arraylist
      ArrayList<String>[] lists= new ArrayList[100000];
      list[999].size();// 0
      list.size(); //error
      list.lenght();//100000



   }
}
```
##2/1/2017

git clone https:....
(copy repository url)
cd (your rep)
git checkout-b class notes
open editor make sure to do your work in your repository path 
git add .
git commit -am "..."
git checkout master
git merge class-notes
git push

Topics: 
ITERATORS
2d ARRAYlIST
Hashing
Mapping
HashMap
