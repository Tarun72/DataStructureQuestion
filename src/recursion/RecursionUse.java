package recursion;

import java.util.Arrays;

public class RecursionUse {
    public static void main(String[] args) {
//       int result =  NthOfFibonacciNumber(5);
//        System.out.println("result of fabonacci is "+result);
//        int digits = 123;
//        System.out.println("count digits "+countDigits(digits));
//        int number =  9;
//        print(9);
//
//        int power =  3;
//        System.out.println("power of "+number +" and power "+power+ "is ==> "+power(number,power));

//        int unsortedArray[] = new int[]{222,512,11,424,13,55,122,551,767,88,943,56,78};
//        System.out.println(" is array sorted "+checkSorted(unsortedArray));
//        Arrays.sort(unsortedArray);
//        System.out.println(" is array sorted "+checkSorted(unsortedArray));
                int unsortedArray[] = new int[]{1,2,3,4,5,6};
//        System.out.println("sorted array "+sum(unsortedArray));
        System.out.println("is number present "+checkNumber(unsortedArray,4));
    }
    public static boolean checkNumber(int input[], int x) {
      if(input.length == 1){
          return  input[0] == x;
      }else{
          int smallArray[] = new int[input.length - 1];
          for (int i = 1; i < input.length; i++) {
              smallArray[i -1] = input[i];
          }
          if(checkNumber(smallArray,x)){
              return true;
          }
          return smallArray[0] == x;
      }
    }


    public static int sum(int input[]) {
        if(input.length == 1){
            return input[0];
        }else{

            int smallArray[] = new int[input.length - 1];
            for (int i = 1; i < input.length; i++) {
                smallArray[i -1] = input[i];
            }
            return input[0] + sum(smallArray);
        }
    }

   public static boolean checkSorted(int[] input){
        if(input.length <=1){
            return true;
        }
        // create smaller array
       int smallArray[] = new int[input.length-1];
       for (int i = 1; i <= smallArray.length; i++) {
           smallArray[i-1] = input[i];
       }
       boolean isSmallArraySorted =  checkSorted(smallArray);
       if(!isSmallArraySorted){
           return false;
       }else{
           if(input[0] <= input[1]){
               return true;
           }else{
               return  false;
           }
       }

   }


// 0 1 1 2 3 5 8
    public static int NthOfFibonacciNumber  (int n){
        if(n == 1){
            return  1 ;
        }else
        if(n == 0){
            return 0;
        }else
       return  NthOfFibonacciNumber(n -1) + NthOfFibonacciNumber(n-2) ;
    }


    public static int countDigits(int n){
        if(n < 10){
            return 1;
        }
        int result =  countDigits( n/10);
        return result + 1;
    }

    public static int power(int x, int n) {
        /**
         * Base case
         */
        if(n == 0){
            return 1;
        }
        int smallAnswers =  power(x , n-1);
        return x * smallAnswers;
    }
    public static void print(int n){
        if(n == 0){
            return;
        }
        print(n-1);
        System.out.print(n+" ");
    }
}
