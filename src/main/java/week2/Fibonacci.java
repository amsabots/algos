package week2;

import java.util.Random;
import java.util.Scanner;

public class Fibonacci {

    private static long fib(int n){
       long[] f = new long[n+2];
       int i;

       f[0] = 0;
       f[1] = 1;
        for (i = 2; i <=n ; i++) {
            f[i] = f[i-1]+f[i-2];
        }
        System.out.println("Fib number for loop case is "+ f[n]);
        return f[n];
    }

    private static long testCase(int n){
        if(n <= 1) return n;
        return testCase(n-1)+ testCase(n-2);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(getLastInt(fib(n)));
    }

    private static  void stressTest(int low, int high){
      while (true){
          Random random = new Random();
          int number = random.nextInt(high-low)+low;
          System.out.println("Test number is "+ number);

          if(fib(number) != testCase(number)){
              System.out.println("Test for number "+number+" failed. Expected: "+ testCase(number)+" Found: "+ fib(number));
              break;
          }else System.out.println("Test passed");
      }
    }

    private static int getLastInt(long fibnum){
        String nums = String.valueOf(fibnum);
        return  Character.digit(nums.charAt(nums.length()-1),10);
    }
}
