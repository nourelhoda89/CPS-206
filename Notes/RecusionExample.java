public class RecusionExample{
   public static void main(String...args){
      RecusionExample recusion = new RecusionExample();
      System.out.println(recusion.doFactorial(5));
      System.out.println(recusion.doSum(10));
      System.out.println(recusion.sumRange(5,10));
   }
   public int doFactorial(int n){
      if (n==1){
         return 1;
      }
      else{
         return n* doFactorial(n-1);
      }
   }
   public int doSum(int n){ //sum from 10 to 1 
  return ( n*n+n)/2;
  }
   public int sumRange (int from, int to){// sum from from to to
   return doSum(to)- doSum(from);
   
   }
}