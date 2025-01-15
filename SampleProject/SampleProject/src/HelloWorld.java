import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");

        System.out.println("Enter Your Name: ");

        Scanner inputScanner = new Scanner(System.in);

        String name = inputScanner.nextLine();

        System.out.println("Hello " + name + "!");
    }
}
