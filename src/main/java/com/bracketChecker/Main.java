package com.bracketChecker;

import java.util.Scanner;
import java.util.HashMap;

    public class Main {
        public static void test(String ch) {
            HashMap<Integer, String> D1 = new HashMap<Integer, String>();
            HashMap<Integer, String> D2 = new HashMap<Integer, String>();

            for (int i = 0; i < ch.length(); i++) {
                if (ch.charAt(i) == '(' || ch.charAt(i) == '[' || ch.charAt(i) == '{') {
                    D1.put(i, String.valueOf(ch.charAt(i)));
                } else {
                    D2.put(i, String.valueOf(ch.charAt(i)));
                }
            }
            int d = D1.size();
            int nb = 0;
            boolean b = true;
            int k = Math.min(D1.size(), D2.size());
            for (int j = d - 1; j > d - 1 - k; j--) {
                if (b) {
                    switch (D1.get(j)) {
                        case "(":
                            b = D2.get(d + nb).equals(")");
                            break;
                        case "[":
                            b = D2.get(d + nb).equals("]");
                            break;
                        case "{":
                            b = D2.get(d + nb).equals("}");
                            break;
                    }
                    if (b) {
                        nb++;
                    }
                } else {
                    break;
                }
            }
            if (b) {
                if (D1.size() == D2.size()) {
                    System.out.println("Correct expression");
                } else if (D1.size() > D2.size()) {
                    System.out.println("Incorrect expression. Error at the position " + (d - 1 - k));
                } else {
                    System.out.println("Incorrect expression. Error at the position " + (d + k));
                }
            } else {
                System.out.println("Incorrect expression. Error at the position " + (d + nb));
            }
        }


        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of attempts : ");
            int e = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= e; i++) {
                System.out.print("Enter an expression : ");
                String ch = scanner.nextLine();
                test(ch);
            }

            scanner.close();
        }
    }

