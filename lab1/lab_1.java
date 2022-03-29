// Coder: Abdalla A.
// Driver: Luis G.

import java.util.*;
public class lab_1 {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {  
        //program1();
        //program2();
        program3();

    }

    public static void program1(){
        double itemPrice, total, tax;
        final double SALES_TAX_RATE = 0.06;

        System.out.println("Enter item price");
        itemPrice = in.nextDouble();
        tax = itemPrice * SALES_TAX_RATE;
        total= itemPrice + tax;

        System.out.println("The total is $" + total);
    }

    public static void program2(){
        String name;

        System.out.println("Enter your name");
        name= in.nextLine();
        System.out.println("Hello " + name + "! We hope you have a nice day!");

    }

    public static void program3(){
        double price1, price2, price3, price4, price5, tax, sum, total;
        final double SALES_TAX_RATE = 0.06;

        System.out.println("Enter price of item 1");
        price1 = in.nextDouble();
        System.out.println("Enter price of item 2");
        price2
         = in.nextDouble();
        System.out.println("Enter price of item 3");
        price3 = in.nextDouble();
        System.out.println("Enter price of item 4");
        price4 = in.nextDouble();
        System.out.println("Enter price of item 5");
        price5 = in.nextDouble();

        sum = price1+price2+price3+price4+price5;
        tax = sum * SALES_TAX_RATE;
        total = sum + tax;

        System.out.println("The subtotal is: $" + sum);
        System.out.println("The total is $" + total);

    }
}