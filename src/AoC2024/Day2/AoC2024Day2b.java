package AoC2024.Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AoC2024Day2b {
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
        Scanner scanner = new Scanner(level);
        ArrayList<Integer> nums = new ArrayList<>();

        while(scanner.hasNextInt()){
            nums.add(scanner.nextInt());
        }
        return isLevelSafe(nums, -1);
    }
    static boolean isLevelSafe(ArrayList<Integer> nums, int badIndex){
        boolean badLevel = false;
        boolean isAscending;

        int num1 = nums.get(0);
        int num2 = nums.get(1);
        if(badIndex == 0){
            num1 = nums.get(1);
            num2 = nums.get(2);
        }
        if(badIndex == 1){
            num1 = nums.get(0);
            num2 = nums.get(2);
        }
        if(num1 > num2) isAscending = false;
        else isAscending = true;
        for(int i = 0; i < nums.size(); i++){
            if(i == badIndex) continue;
            num1 = nums.get(i);
            if(i+1 == badIndex) {
                if(i+2 >= nums.size()) return true;
                num2 = nums.get(i + 2);
            }
            else{
                if(i+1 >= nums.size()) return true;
                num2 = nums.get(i+1);
            }
            if(num1 == num2) badLevel = true;
            if(Math.abs(num1 - num2) > 3) badLevel = true;
            if(num1 < num2 == !isAscending) badLevel = true;
            if(num1 > num2 == isAscending) badLevel = true;
            if(badLevel && badIndex > i+1 ) return false;
            if(badLevel) return isLevelSafe(nums, badIndex+1);
        }
        return true;
    }

}
