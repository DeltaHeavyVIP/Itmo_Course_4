package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<String> words = new ArrayList<>();
        int counter = 0;

        while (counter < n) {
            String w = scanner.next();
            counter += w.length();
            words.add(w);
        }
        counter = 0;

        String colours = scanner.next();
        int answer = 0;

        for (String word : words) {
            int size = word.length();
            String wordColours = colours.substring(counter, counter + size);
            counter += size;
            for (int j = 1; j < wordColours.length(); j++) {
                //use substring() because it faster than charAt()
                if (wordColours.substring(j - 1, j).equals(wordColours.substring(j, j + 1))) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}