package AoC2024.Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AoC2024Day2a {
    public static void main(String[] args) {
        int answer = 0;
        try{
            File file = new File("src/AoC2024/Day2/input.txt");
            Scanner scanner = new Scanner(file);
            String level = scanner.nextLine();
            while(scanner.hasNextLine()){
                if(isLevelSafe(level)){
                    System.out.println(level + " Safe");
                    answer += 1;
                } else {
                    System.out.println(level + " Not Safe");
                }
                level = scanner.nextLine();
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found" + e.getMessage());
        }
        System.out.println(answer);
    }

    static boolean isLevelSafe(String level){
        boolean isAscending;
        Scanner scanner = new Scanner(level);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        isAscending = num1 < num2;

        while(scanner.hasNextInt()) {
            if (num1 == num2) return false;
            if ((num1 - num2 > 0) == isAscending) return false;
            if ((num1 - num2 < 0) == !isAscending) return false;
            if (Math.abs(num1 - num2) > 3) return false;
            num1 = num2;
            num2 = scanner.nextInt();
        }
        if (num1 == num2) return false;
        if ((num1 - num2 > 0) == isAscending) return false;
        if ((num1 - num2 < 0) == !isAscending) return false;
        if (Math.abs(num1 - num2) > 3) return false;

        return true;
    }
}
