package aula07;

import java.lang.reflect.Method;

class Printer{
    /**
     * Adicionado na versão JavaSE 5, tem como objetivo possibilitar a tipagem de métodos e classes de forma
     * à assegurar a integridade da implementação.
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
        String[] stringArray = {"Hello", "World", "ou não"};
        
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        
        int count = 0;
        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();
            System.out.println("======"+name);
            if(name.equals("printArray"))
                count++;
        }

        if(count > 1) {
        	System.out.println("Método sobrecarregado não permitido!");
        }
    }
}