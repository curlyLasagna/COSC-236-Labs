/*
Coder: Luis G.
Driver: Abdalla A. 
*/
import java.util.*;
class Main {
  static Scanner in = new Scanner(System.in);
  public static void main(String[] args) {
    program1();
    program2();
    program3();
    program4();
    program5();
  }

  public static void program1 () {
    double totalPrice, tax, itemPrice;
    final double SALES_TAX_RATE = 0.06;
    System.out.print("Enter item price: $");
    itemPrice = in.nextDouble();
    tax = itemPrice * SALES_TAX_RATE;
    totalPrice = tax + itemPrice; 
    System.out.printf("Total price is $%.2f\n", totalPrice);
  }

  public static void program2 () {
    String name;
    System.out.println("Who are you?");
    name = in.next();
    System.out.println("Hello " + name + "! Hope you have a nice day!");
  }

  public static void program3() {
    double
      price1,
      price2,
      price3,
      price4,
      price5,
      subTotal,
      tax,
      total;
    
    final double SALES_TAX_RATE = 0.06;
    // price1 = price2 = price3 = price4 = price5 = in.nextDouble();

    System.out.println("Input price for item 1");
    price1 = in.nextDouble();
    System.out.println("Input price for item 2");
    price2 = in.nextDouble();
    System.out.println("Input price for item 3");
    price3 = in.nextDouble();
    System.out.println("Input price for item 4");
    price4 = in.nextDouble();
    System.out.println("Input price for item 5");
    price5 = in.nextDouble();
    subTotal = price1 + price2 + price3 + price4 + price5;
    tax = subTotal * SALES_TAX_RATE;
    total = tax + subTotal;
    System.out.printf("Subtotal is %.2f\nTotal is %.2f%n", subTotal, total);
  }

  public static void program4() {
    double score1, score2, score3, sum, avg;

    System.out.println("Enter score 1");
    score1 = in.nextDouble();
    System.out.println("Enter score 2");
    score2 = in.nextDouble();
    System.out.println("Enter score 3");
    score3 = in.nextDouble();

    sum = score1 + score2 + score3;
    avg = sum / 3;
    System.out.printf("The average is: %.2f%n", avg);
  }
  public static void program5 () {
    int num1, num2;
    System.out.println("Enter first number");
    num1 = in.nextInt();
    System.out.println("Enter  number");
    num2 = in.nextInt();
    System.out.println("Sum is = " + (num1 + num2));
    System.out.println("Difference is = " + (num1 - num2));
    System.out.println("Product is = " + (num1 * num2));
    System.out.println("Qoutient is = " + (num1 / num2));
    System.out.println("Remainder is = " + (num1 % num2));
  }
}
