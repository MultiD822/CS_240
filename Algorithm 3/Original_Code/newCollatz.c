/*
- Programmer: Kai Schenkel
- Class: CS-240 Computer Architecture
- Data: 1/23/2024
- Algorithms HW 3 : Recursion vs Iteration 
- Sources: Veritasium 3n+1 Video on YouTube and Geeks for Geeks webpage plus the wiki on Prime Numbers
- Description: This program will take a number and run it through the 3n+1 equation until it reaches 1
*/
#include <stdio.h>
void collatz(long n, int steps);
int main() {
    
    int n; // Replace with your number
    printf("Enter a number to run through the 3n+1 equation: ");
    scanf("%d", &n);
    collatz(n, 0);
    return 0;
}

void collatz(long n, int steps) {
    // Base case: if n is 1, 2 or less than -1, print the number of steps and return
    if (n == 1 || n < -1 || n == 2) {
        printf("The Equation is now in a '4' '2' '1' loop\n");
        printf("It took this many steps to reach the loop: %d\n", steps);
        return;
    }

    // Recursive case: if n is even, divide it by 2; if n is odd, multiply it by 3 and add 1
    if (n % 2 == 0) {
        printf("If Number above is even divide by two this = %ld\n", n / 2);
        collatz(n / 2, steps + 1);
    } else {
        printf("If Number above is odd use 3n+1 this = %ld\n", 3 * n + 1);
        collatz(3 * n + 1, steps + 1);
    }
}

