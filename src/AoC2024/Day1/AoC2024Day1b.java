package AoC2024.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.HashMap;

public class AoC2024Day1b {
    public static void main(String[] args) {
        int answer = 0;
        PriorityQueue<Integer> pqLeft = new PriorityQueue<>();
        PriorityQueue<Integer> pqRight = new PriorityQueue<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        try{
            File file = new File("src/AoC2024/input.txt");
            Scanner scanner = new Scanner(file);
            int num;
            while(scanner.hasNextInt()){
                num = scanner.nextInt();
                pqLeft.add(num);
                num = scanner.nextInt();
                if(hm.containsKey(num)){
                    hm.put(num, hm.get(num) + 1);
                } else {
                    hm.put(num, 1);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found" + e.getMessage());
        }

        while(!pqLeft.isEmpty()){
            int num1 = pqLeft.poll();
            if(hm.containsKey(num1)){
                answer += num1 * hm.get(num1);
            }
        }
        System.out.println(answer);
    }
}
