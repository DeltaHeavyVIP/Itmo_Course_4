package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();

        ArrayList<ArrayList<Integer>> bg = new ArrayList<>(n);
        ArrayList<ArrayList<Integer>> rg = new ArrayList<>(n);

        int[] black_peak = new int[n], white_peak = new int[n], peak = new int[n], colors = new int[n];

        for (int i = 0; i < n; i++) {
            peak[i] = black_peak[i] = white_peak[i] = n;
            bg.add(new ArrayList<>());
            rg.add(new ArrayList<>());
        }
        peak[n - 1] = white_peak[n - 1] = black_peak[n - 1] = 0;

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1, t = scanner.nextInt();
            if (t == 0) {
                bg.get(v).add(u);
            } else {
                rg.get(v).add(u);
            }
        }

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(n - 1);

        while (!arrayDeque.isEmpty()) {
            int x = arrayDeque.pollFirst();

            for (int to : bg.get(x)) {
                if (black_peak[to] < n) continue;
                black_peak[to] = peak[x] + 1;
                int max = Math.max(black_peak[to], white_peak[to]);
                if (max < n) {
                    arrayDeque.addLast(to);
                    peak[to] = max;
                }
            }

            for (int to : rg.get(x)) {
                if (white_peak[to] < n) continue;
                white_peak[to] = peak[x] + 1;
                int max = Math.max(black_peak[to], white_peak[to]);
                if (max < n) {
                    arrayDeque.addLast(to);
                    peak[to] = max;
                }
            }
        }

        if (peak[0] == n) {
            System.out.println(-1);
        } else {
            System.out.println(peak[0]);
        }

        for (int i = 0; i < n; i++) {
            if (black_peak[i] > white_peak[i]) {
                colors[i] = 0;
            } else {
                colors[i] = 1;
            }
            System.out.print(colors[i]);
        }
    }
}
