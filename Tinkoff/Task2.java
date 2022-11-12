package org.example;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
        int x = scanner.nextInt(), y = scanner.nextInt(), z = scanner.nextInt();

        if (b < a) {
            a = a + b;
            b = a - b;
            a = a - b;

            x = x + y;
            y = x - y;
            x = x - y;
        }

        if (c < a) {
            a = a + c;
            c = a - c;
            a = a - c;

            x = x + z;
            z = x - z;
            x = x - z;
        }

        x += y / b + z / c;

        long answer = 0;
        for (int i = x + 1; i >= 1; i--) {
            answer += i;
        }

        System.out.println(answer);
    }
}
