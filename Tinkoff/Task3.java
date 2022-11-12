package org.example;

import java.util.Scanner;

public class Task3 {
    public static int answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (isPrime(n)) {
            System.out.println(1 + " " + (n - 1));
        } else {
            System.out.println((n / answer) + " " + (n / answer * (answer - 1)));
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                answer = i;
                return false;
            }
        }
        return true;
    }

}
