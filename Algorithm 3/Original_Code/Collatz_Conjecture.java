/*
- Programmer: Kai Schenkel
- Class: CS-240 Computer Architecture
- Data: 1/23/2024
- Algorithms HW 3 : Recursion vs Iteration 
- Sources: Veritasium 3n+1 Video on YouTube and Geeks for Geeks webpage plus the wiki on Prime Numbers
- Description: This program will take a number and run it through the 3n+1 equation until it reaches 1
*/
public class Collatz_Conjecture {
    public void Colat (long n) {
        //This will run the 3n+1 equation where 'n' is the number given an arbitrary positive integer
        boolean isLooped = true;
        int steps = 0;

        long equation = n;
        while (isLooped != false) {

            if (equation % 2 == 0) {
                equation = equation / 2;
                System.out.println("If Number above is even divide by two this = " + equation);
            } else {
                equation = 3 * equation + 1;
                System.out.println("If Number above is odd use 3n+1 this = " + equation);
            }
            if (equation == 1 || equation < -1 || equation == 2) {
                isLooped = false;
            }
            steps++;
        }
        System.out.println("The Equation is now is a '4' '2' '1' loop");
        System.out.println("It took this many steps to reach the loop:" + steps);
    }

}