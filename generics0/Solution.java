package generics0;

import java.io.IOException;
import java.lang.reflect.Method;

class Printer
{
    /**
     * Adicionado na vers�o JavaSE 5, tem como objetivo possibilitar a tipagem de m�todos e classes de forma
     * � assegurar a integridade da implementa��o.
     */
    public <T> void printArray(T[] array ) {
        for(T t : array) {
            System.out.println(t);
        }
    }
 
}

public class Solution {


    public static void main( String args[] ) {
        Printer myPrinter = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if(name.equals("printArray")) {
            	count++;
            }
        }

        if(count > 1) {
        	System.out.println("Method overloading is not allowed!");
        }
      
    }
}