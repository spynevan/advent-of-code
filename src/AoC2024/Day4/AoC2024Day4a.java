package AoC2024.Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class AoC2024Day4a {
    public static void main(String[] args) {
        File file = new File("src/AoC2024/Day4/input.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        }
        catch(FileNotFoundException e){
            System.out.println("Error: File not found" + e.getMessage());
        }
        int answer = 0;
        var wordSearch = new ArrayList<String>();
        while (scanner.hasNext()) {
            wordSearch.add(scanner.nextLine());
        }

        for(int i = 0; i < wordSearch.size(); i++){
            for(int j = 0; j < wordSearch.get(i).length(); j++){
                answer += testLocation(i, j, wordSearch);
            }
        }
        scanner.close();

        System.out.println(answer);

    }

    static int testLocation(int x, int y, ArrayList<String> wordSearch){
        int answer = 0;
        boolean goRight = wordSearch.size() - y > 3;
        boolean goDown = wordSearch.get(0).length() - x > 3;
        boolean goLeft = y >= 3;
        boolean goUp = x >= 3;
        String temp = "";
        // Down Left
        if(goDown && goLeft){
            temp = "" + wordSearch.get(x).charAt(y) + wordSearch.get(x + 1).charAt(y - 1) + wordSearch.get(x + 2).charAt(y - 2) + wordSearch.get(x + 3).charAt(y - 3);
            if(temp.equals("XMAS") || temp.equals("SAMX")){
                answer++;
            }
        }

        // Down
        if(goDown){
            temp = "" + wordSearch.get(x).charAt(y) + wordSearch.get(x + 1).charAt(y) + wordSearch.get(x + 2).charAt(y) + wordSearch.get(x + 3).charAt(y);
            if(temp.equals("XMAS") || temp.equals("SAMX")){
                answer++;
            }
        }
        // Down Right
        if(goDown && goRight){
            temp = "" + wordSearch.get(x).charAt(y) + wordSearch.get(x + 1).charAt(y + 1) + wordSearch.get(x + 2).charAt(y + 2) + wordSearch.get(x + 3).charAt(y + 3);
            if(temp.equals("XMAS") || temp.equals("SAMX")){
                answer++;
            }
        }
        // Right
        if(goRight){
            temp = wordSearch.get(x).substring(y, y + 4);
            if(temp.equals("XMAS") || temp.equals("SAMX")){
                answer++;
            }
        }
        return answer;
    }
}
