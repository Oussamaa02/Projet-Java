package com.tourDeHanoi;

import java.util.Scanner;

public class Main {
    static void towerOfHanoi(int n, char from_rod, char to_rod, char helper_rod)
    {
        if (n == 1)
        {
            System.out.println("Take disk 1 from rod " +  from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n-1, from_rod, helper_rod, to_rod);
        System.out.println("Take disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        towerOfHanoi(n-1, helper_rod, to_rod, from_rod);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of disks: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        towerOfHanoi(n,'A','C', 'B');
    }}