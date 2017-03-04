package Exceptions;

import Other.Memory;

import java.util.ArrayList;
import java.util.List;

public class TestException {
    static int a;
    public static void main(String[] args) {




        System.out.println(System.getProperty("os.name") + " " +  System.getProperty("sun.arch.data.model") + "bit" + " " +  "ver" + System.getProperty("os.version"));

        //throw new MyException("Мій власний Exception");

        int i = 589;

        System.out.println(Integer.toBinaryString(i));

        String binary = "";
        while (i > 0) {
            int rem = i % 2;
            binary = rem + binary;
            i = i / 2;
        }
        System.out.print(binary);


        while (true) {
            System.out.println(new TestException().hashCode());
        }



    }


public static class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
}
