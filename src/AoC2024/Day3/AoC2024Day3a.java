package AoC2024.Day3;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2024Day3a {
    public static void main(String[] args) {
        try{
            File file = new File("src/AoC2024/Day3/input.txt");
            Scanner scanner = new Scanner(file);
            String line;
            long answer = 0;
            while(scanner.hasNextLine()){
                line = scanner.nextLine();
                Pattern p = Pattern.compile("mul\\([0-9]{1,3},[0-9]{1,3}\\)");
                Matcher matcher = p.matcher(line);
                String temp;
                while(matcher.find()){
                    temp = matcher.group();
                    System.out.print(temp + " ");
                    answer += evauluate(temp);
                }
            }
            System.out.println("Answer: " + answer);

            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found" + e.getMessage());
        }
    }
    static int evauluate(String exp){
        exp = exp.substring(4, exp.length() - 1);
        String[] nums = exp.split(",");
        int answer = Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]);
        System.out.println(nums[0] + "*" + nums[1] + "=" + answer);
        return answer;
    }
}
