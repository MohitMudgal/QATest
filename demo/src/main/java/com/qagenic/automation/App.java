package com.qagenic.automation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
    }


    public int getSumOfNumbers(int number1, int number2){
        return number1 + number2;
    }


    public int getDivision(int numerator, int denominator){

        int result;
        if (denominator == 0){
            return 0;
        }        
        result = numerator / denominator;
        return result;
    }
}
