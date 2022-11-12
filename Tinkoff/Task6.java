package org.example;

import java.util.Scanner;

class Task6 {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.max_xor();
    }

    static class Node {
        public Node one, zero;
    }

    static class Tree {
        Node root;

        public Tree() {
            root = new Node();
        }

        public void max_xor() {
            Scanner scanner = new Scanner(System.in);
            int count = scanner.nextInt();

            int max_xor = 0;
            insert(scanner.nextInt());
            System.out.println(max_xor);

            for (int i = 1; i < count; i++) {
                int current = scanner.nextInt();
                max_xor = Math.max(calculate_xor(current), max_xor);
                insert(current);
                System.out.println(max_xor);
            }
        }

        public void insert(int n) {
            Node currentNode = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (n >> i) & 1;
                if (bit != 0) {
                    if (currentNode.one == null) {
                        currentNode.one = new Node();
                    }
                    currentNode = currentNode.one;
                } else {
                    if (currentNode.zero == null) {
                        currentNode.zero = new Node();
                    }
                    currentNode = currentNode.zero;
                }
            }
        }

        public int calculate_xor(int value) {
            Node currentNode = root;
            int answer = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (value >> i) & 1;
                if (bit != 0) {
                    if (currentNode.zero != null) {
                        currentNode = currentNode.zero;
                        answer += (1 << i);
                    } else {
                        currentNode = currentNode.one;
                    }
                } else {
                    if (currentNode.one != null) {
                        currentNode = currentNode.one;
                        answer += (1 << i);
                    } else {
                        currentNode = currentNode.zero;
                    }
                }
            }
            return answer;
        }
    }
}
