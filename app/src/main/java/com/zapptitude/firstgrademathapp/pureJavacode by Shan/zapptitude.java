import java.util.Scanner;

public class zapptitude {

    public static void main (String[] args) {

      System.out.println ("What is the 3+3=?");

      // allow user to input integer
      Scanner reader = new Scanner(System.in);
      int i = reader.nextInt();

      if(i == 3){
        System.out.println("Yay!! Correct!");
        // next step is going to difficult questions with zapptitude API backend

      } else if (i != 3){
      System.out.println("Wrong. Try again!");
      // give user to easy (same level questions) with zapptitude API backend
      }

    }
}
