package AoC2024.Day1;

import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.io.File;
import java.util.Scanner;

public class AoC2024Day1a {
    public static void main(String[] args) {
        int answer = 0;
        PriorityQueue<Integer> pqLeft = new PriorityQueue<>();
        PriorityQueue<Integer> pqRight = new PriorityQueue<>();
        try{
            File file = new File("src/AoC2024/Day1/input.txt");
            Scanner scanner = new Scanner(file);
            int num;
            while(scanner.hasNextInt()){
                num = scanner.nextInt();
                pqLeft.add(num);
                num = scanner.nextInt();
                pqRight.add(num);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found" + e.getMessage());
        }
        int num1, num2, difference;
        while(!pqLeft.isEmpty() && !pqRight.isEmpty()){
            num1 = pqLeft.poll();
            num2 = pqRight.poll();
            difference = Math.abs(num1 - num2);
            System.out.println("|" +  num1 + "-" + num2 + "| = " + difference);
            answer += difference;

        }
        System.out.println(answer);
    }
}
